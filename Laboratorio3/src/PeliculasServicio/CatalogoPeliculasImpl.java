package PeliculasServicio;

import Excepciones.AccesoDatosEx;
import Excepciones.LecturaDatosExcpcion;
import peliculas.Pelicula;
import peliculasDatos.AccesoDatosImpl;
import peliculasDatos.IAccesoDatos;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl(){
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombre) {
        Pelicula pelicula = new Pelicula(nombre);
        boolean anexar = false;
        
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx e) {
            e.printStackTrace(System.out);
            System.out.println("error de acceso a datos");
        }

    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);

            for (var pelicula : peliculas) {
                System.out.println(pelicula);
            }

        } catch (AccesoDatosEx e) {
            System.out.println("eror de acceso datos");
            e.printStackTrace(System.out);
        }
        
    }

    @Override
    public void buscarPeliculas(String nombre) {
        String resultado = null;
       try {
        resultado = this.datos.buscar(NOMBRE_RECURSO, nombre);
       } catch (LecturaDatosExcpcion e) {
        System.out.println("error de acceso a datos");
        e.printStackTrace(System.out);
       }
        

       System.out.println(resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                this.datos.borrar(NOMBRE_RECURSO);
            }else{
                this.datos.crear(NOMBRE_RECURSO);
            }
            System.out.println("se ha creado el catalogo de peliculas");
        } catch (AccesoDatosEx e) {
            System.out.println("error la iniciar catalogo de peliculas");
            e.printStackTrace(System.out);
        }
        
    }
    
}
