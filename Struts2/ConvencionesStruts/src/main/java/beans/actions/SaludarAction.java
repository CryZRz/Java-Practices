package beans.actions;

import org.apache.logging.log4j.*;

public class SaludarAction {
    Logger log = LogManager.getLogger(SaludarAction.class);
    
    private String saludosAtr;
    
    public String execute(){
        log.debug("ejecutando metodo execute desde struts 2");
        this.saludosAtr = "Hola desde struts2 con convenciones";
        
        return "exito";
    }

    public String getSaludosAtr() {
        return saludosAtr;
    }

    public void setSaludosAtr(String saludosAtr) {
        this.saludosAtr = saludosAtr;
    }
    
}
