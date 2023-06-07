package test;

import domain.Persona;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

public class TestPersonaServiceRs {
    
    //variables a utitlizar
    private static final String url_base = "http://localhost:8080/sga-jee-web-11/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    
    public static void main(String[] args) {
        cliente = ClientBuilder.newClient();
        
        //leer uan persona (metodo get)
        webTarget = cliente.target(url_base).path("/personas");
        //proporcionas un id persona valido
        persona = webTarget.path("/2").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("persona recuperada: " + persona);
        
        //leer todas las personas metodo get con readEntity de tipo list<>
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>(){});
        System.out.println("Personas recuperadas");
        imprimirPersonas(personas);
        
        //agregar una persona metodo post
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Jimena");
        nuevaPersona.setApellido("navarro");
        nuevaPersona.setEmail("jimenanavramirez@mail.com");
        nuevaPersona.setTelefono("45455656");
        
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println(response.getStatus());
        //recuperamos la persona recien agregada para despues modificarla y al final eliminarla
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("persona agregada: " + personaRecuperada);
        
        //modificar la persona modificada meotodo put
        //persona recuperada anteriormente
        Persona personaModificar = personaRecuperada;
        personaModificar.setApellido("ramos");
        String pathId = "/"+personaModificar.getIdPersona();
        invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML));
        
        System.out.println("");
        System.out.println("response: " + response.getStatus());
        System.out.println("persona modificada" + response.readEntity(Persona.class));
        
        //eliminar una persona
        //la persona recuperada anteriormente
        Persona personaEliminar = personaRecuperada;
        String pathEliminarId = "/"+ personaEliminar.getIdPersona();
        invocationBuilder = webTarget.path(pathEliminarId).request(MediaType.APPLICATION_XML);
        invocationBuilder.delete();
        
        System.out.println("");
        System.out.println("response: " + response.getStatus());
        System.out.println("persona eliminada" + personaEliminar);
        
    }
    
    public static void imprimirPersonas(List<Persona> personas){
        for (Persona persona1 : personas) {
            System.out.println("persona: "+ persona1);
        }
    }
    
}
