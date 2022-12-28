package test;

import accesodatos.IAccesoDatos;
import accesodatos.ImplementacionMysql;
import accesodatos.ImplementacionOracle;

public class App {
    public static void main(String[] args)  {
        IAccesoDatos datos = new ImplementacionMysql();
        imprimir(datos);
        
        datos = new ImplementacionOracle();
        //datos.listar();
        imprimir(datos);        
    }

    public static void imprimir(IAccesoDatos datos){
        datos.listar();
    }

}
