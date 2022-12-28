public class TestExcepciones {
    public static void main(String[] args) {
        int resultado = 0;

        /*try {
            Aritmetica.division(10, 0);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println(e.getMessage()); 
        }*/

        //Aritmetica.division(10, 0);

        try {
            Aritmetica.division(10, 0);
        }catch(OperacionExecpcion e){
            System.out.println("ocurrip un error de tipo Operacin excepcion");
        } catch (Exception e) {
            System.out.println("ocurruo un erro de tipo exception");
            //System.out.println(e.getMessage());
        }
        finally{
            System.out.println("se reviso la division entre 0");
        }

        //System.out.println(resultado);

    }
}
