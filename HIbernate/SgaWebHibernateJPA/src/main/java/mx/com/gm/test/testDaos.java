package mx.com.gm.test;

import java.util.List;
import mx.com.gm.dao.AlumnoDAO;
import mx.com.gm.dao.AsignacionDAO;
import mx.com.gm.dao.ContactoDAO;
import mx.com.gm.dao.CursoDAO;
import mx.com.gm.dao.DomicilioDAO;

public class testDaos {
    public static void main(String[] args) {
        AlumnoDAO alumnoDao = new AlumnoDAO();
        System.out.println("Alumnos");
        //imprimir(alumnoDao.listar());
        
        System.out.println("domicilios");
        DomicilioDAO domicilios = new DomicilioDAO();
        //imprimir(domicilios.listar());
        
        System.out.println("contactos");
        ContactoDAO contantos = new ContactoDAO();
        //imprimir(contantos.listar());
        
        System.out.println("cursos");
        CursoDAO cursos = new CursoDAO();
        //imprimir(cursos.listar());
        
        System.out.println("asignaciones");
        AsignacionDAO asignaciones = new AsignacionDAO();
        imprimir(asignaciones.listar());
    }
    
    private static void imprimir(List colection){
        for (Object object : colection) {
            System.out.println("valor= " + object);
        }
    }
}
