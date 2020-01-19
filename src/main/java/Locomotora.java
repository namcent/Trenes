public class Locomotora {
    private Integer peso;
    private Integer pesoMaxArrastre;
    private Integer velMaxima;

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getPesoMaxArrastre() {
        return pesoMaxArrastre;
    }

    public void setPesoMaxArrastre(Integer pesoMaxArrastre) {
        this.pesoMaxArrastre = pesoMaxArrastre;
    }

    public Integer getVelMaxima() {
        return velMaxima;
    }

    public void setVelMaxima(Integer velMaxima) {
        this.velMaxima = velMaxima;
    }

    public Integer arrastreUtil(){
        return getPesoMaxArrastre() - getPeso();
    }

    public Boolean esEficiente(){
        return getPeso()*5 <= arrastreUtil();
    }
}
