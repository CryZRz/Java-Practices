public class Caja {
    int acho;
    int alto;
    int profundidad;

    public Caja(){
        System.out.println("constructor inciado");
    }

    public Caja(int arg1, int arg2, int arg3){
        this.acho = arg1;
        this.alto = arg2;
        this.profundidad = arg3;
    }

    public int calcularVolumen(){
        int volumen = this.acho * this.profundidad * this.alto;

        return volumen;
    }

}
