package PeliculasServicio;

public interface ICatalogoPeliculas {

    String NOMBRE_RECURSO = "peliculas.txt";

    void agregarPelicula(String nombre);

    void listarPeliculas();

    void buscarPeliculas(String nombre);

    void iniciarCatalogoPeliculas();

}
