public class VagonPasajeros implements Vagon{
    private Integer largo;
    private Integer ancho;

    public Integer cantPasajeros(){
        if (getAncho() <2.5){
            return getLargo() *8;
        }else{
            return getLargo() *10;
        }
    }

    public Integer pesoMaximo(){
        return cantPasajeros()*80;
    }

    public Integer getLargo() {
        return largo;
    }

    public void setLargo(Integer largo) {
        this.largo = largo;
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public Boolean esVagonLiviano(){
        return pesoMaximo()<2500;
    }
}
