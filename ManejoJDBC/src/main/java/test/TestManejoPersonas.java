package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();

        //Insertado objetos a la base de datos
        var persona2 = new Persona("Luisa", "Vallejo", "luisavallejo@email.com", "4779544");
        personaDao.insertar(persona2);

        //Actulizando objetos a la base de datos
        //var persona3 = new Persona(6, "Fernanda", "Ramirez", "ferDAM@gmail.com", "479666542");
        //personaDao.actualizar(persona3);

        //Borrar objetos de la base de datos
        //var persona4 = new Persona(8);
        //personaDao.delete(persona4);

        List<Persona> personas = personaDao.seleccionar();
        for(Persona persona: personas){
            System.out.println(persona);
        }
        
    }
}
