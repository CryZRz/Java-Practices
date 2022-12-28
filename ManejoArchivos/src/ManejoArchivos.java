import java.io.*;

public class ManejoArchivos {
    public static void crearArchivo(String nombre){
        File archivo = new File(nombre);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("se ha creado el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void escribirArchivo(String nombre, String contenido){
        File archivo = new File(nombre);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenido);
            salida.close();
            System.out.println("se ha escrito al archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void anexarArchivo(String nombre, String contenido){
        File archivo = new File(nombre);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(contenido);
            salida.close();
            System.out.println("se ha anexado informacion al archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }catch(IOException e){
            e.printStackTrace(System.out);
        }
    }

    public static void leerArchivo(String nombre){
        var archivo = new File(nombre);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null) {
                System.out.println(lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }catch(IOException e){
            e.printStackTrace(System.out);
        }
    }

}
