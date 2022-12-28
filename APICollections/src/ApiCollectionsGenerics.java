import java.util.*;

public class ApiCollectionsGenerics {
    public static void main(String[] args) throws Exception {

        List<String> miLista = new ArrayList<>(); //mantiene orden se puede agregar elementos duplicados
        miLista.add("Lunes");
        miLista.add("martes");
        miLista.add("miercoles");
        miLista.add("jueves");
        miLista.add("viernes");
        miLista.add("sabado");
        miLista.add("domingo");

        String elementoUno = miLista.get(4);

        /*for (Object elemnto : miLista) {
            System.out.println(elemnto);
        }

        miLista.forEach(elemento -> {
            System.out.println(elemento);
        });*/

        Set<String> miSet = new HashSet<>(); //no mantiene el orden no se puede agregar elemento duplicados 
        miSet.add("Lunes");
        miSet.add("martes");
        miSet.add("miercoles");
        miSet.add("jueves");
        miSet.add("viernes");
        miSet.add("viernes");

        //imprimir(miSet);

        Map<String, String> miMapa = new HashMap<>();
        miMapa.put("hermosa", "Jimena");
        miMapa.put("valo1", "Chris");
        miMapa.put("valo2", "travis");

        String elemento = miMapa.get("hermosa");
        System.out.println(elemento);

        imprimir(miMapa.keySet() /*devulve un hasset*/);
        imprimir(miMapa.values());

    }

    public static void imprimir(Collection<String> coleccion){
        coleccion.forEach(e -> {
            System.out.println(e.toUpperCase());
        });
    }

}