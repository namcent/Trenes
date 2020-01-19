import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Formacion {
    private List<Vagon> vagones=new ArrayList<>();
    private List<Locomotora> locomotoras=new ArrayList<>();

    public Integer totalPasajerosTransportables(){
        return this.vagones.stream().map(vagon->vagon.cantPasajeros()).reduce(0, Integer::sum);
    }

    public Integer cantidadVagonesLivianos(){
        return (int) vagones.stream().filter(vagon -> vagon.esVagonLiviano()).count();

    }

    public Integer velMaximaFormacion(){
        return locomotoras.stream().min(Comparator.comparing(v->v.getVelMaxima())).get().getVelMaxima(); //devuelve la vel max de la locomotora mas rapida
    }

    public Boolean esFormacionEficiente(){
        return locomotoras.stream().allMatch(locomotora -> locomotora.esEficiente());
    }

    public Boolean puedeMoverse(){
        return arrastreUtilTotalLocomotoras()>=pesoMaximoTotalVagones();
    }

    public Integer arrastreUtilTotalLocomotoras(){
        return locomotoras.stream().map(locomotora -> locomotora.arrastreUtil()).reduce(0, Integer::sum);
    }

    public Integer pesoMaximoTotalVagones(){
        return vagones.stream().map(vagon -> vagon.pesoMaximo()).reduce(0,Integer::sum);
    }

    public Integer kgsEmpujeFaltanteParaMoverse(){
        if (puedeMoverse()==true){
            return 0;
        }else {
            return pesoMaximoTotalVagones()-arrastreUtilTotalLocomotoras();
        }
    }

    public Vagon vagonMasPesado(){
        return vagones.stream().max(Comparator.comparing(vagon -> vagon.pesoMaximo())).get(); //devuelve el vagon que tiene el max en pesomax
    }

    public Boolean esCompleja(){
        return locomotoras.size()+vagones.size()>20 || pesoTotal() > 10000;
    }

    public Integer pesoTotal(){
        return pesoLocomotoras()+ pesoMaximoTotalVagones();
    }

    public Integer pesoLocomotoras(){
        return locomotoras.stream().map(locomotora -> locomotora.getPeso()).reduce(0,Integer::sum);
    }

    public void agregarLocomotora(Locomotora locomotora){
        locomotoras.add(locomotora);
    }
}
