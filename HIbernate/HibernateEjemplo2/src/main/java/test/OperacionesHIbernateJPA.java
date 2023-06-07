package test;

import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class OperacionesHIbernateJPA {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        personaDao.listar();
        
        Persona persona = new Persona();
        persona.setIdPersona(10);
        
        persona = personaDao.buscarPersonaPorId(persona);
        System.out.println("persona encontrada: " + persona);
        
        //persona.setNombre("Carlos");
        //persona.setApellido("Esparza");
        //persona.setEmail("cesparza@mail.com");
        //persona.setTelefono("45896532");
        
        //personaDao.insertar(persona);
        //personaDao.modificar(persona);
        
        //eliminar
        personaDao.eliminar(persona);
        personaDao.listar();
    }
}
