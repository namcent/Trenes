public class VagonCarga implements Vagon{
    private Integer cargaMaxima;
    public Integer pesoMaximo(){
        return getCargaMaxima() +160;
    }

    public Integer getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(Integer cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public Integer cantPasajeros(){
        return 0;
    }

    public Boolean esVagonLiviano(){
        return pesoMaximo()<2500;
    }
}
