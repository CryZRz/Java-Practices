package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(req, res);
                    break;
                case "eliminar":
                    this.eliminarCliente(req, res);
                    break;
                default:
                    this.accionDefault(req, res);
            }
        } else {
            this.accionDefault(req, res);
        }
    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }

        return saldoTotal;
    }

    private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("Clientes" + clientes);
        HttpSession session = req.getSession();
        session.setAttribute("clientes", clientes);
        session.setAttribute("totalClientes", clientes.size());
        session.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        //req.getRequestDispatcher("clientes.jsp").forward(req, res);
        res.sendRedirect("clientes.jsp");
    }
    
    private void editarCliente(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //recuperar el id cliente
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
        req.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(req, res);
                    break;
                case "modificar":
                    this.modificarCliente(req, res);
                    break;
                default:
                    this.accionDefault(req, res);
            }
        } else {
            this.accionDefault(req, res);
        }

    }

    private void insertarCliente(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //recuperamos los valores del formulario
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        double saldo = 0;
        String saldoString = req.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        //Creamos el objeto cliente (modelo)
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        //Insertar el nuevo objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("registros modificados" + registrosModificados);

        this.accionDefault(req, res);
    }
    
    private void modificarCliente(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //recuperamos los valores del formulario
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        double saldo = 0;
        String saldoString = req.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        //Creamos el objeto cliente (modelo)
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
        //modificamos el nuevo objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("registros modificados" + registrosModificados);

        this.accionDefault(req, res);
    }
    
    private void eliminarCliente(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //recuperamos los valores del formulario
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));

        //Creamos el objeto cliente (modelo)
        Cliente cliente = new Cliente(idCliente);
        //eliminamos el nuevo objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().eliminar(cliente);
        System.out.println("registros modificados" + registrosModificados);

        this.accionDefault(req, res);
    }

}
