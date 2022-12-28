public enum Continentes {
    AFRICA(53),
    EUROPA(46),
    ASIA(44),
    AMERICA(34),
    OCEANIA(14);

    private final int pasises;

    Continentes(int pasises){
        this.pasises = pasises;
    }

    public int getPaises(){
        return this.pasises;
    }

}
