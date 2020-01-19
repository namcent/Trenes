import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Deposito {
    private List<Formacion> formaciones = new ArrayList<>();
    private List<Locomotora> locomotorasSueltas = new ArrayList<>();

    public List<Vagon> vagonesMasPesados(){
        return formaciones.stream().map(formacion->formacion.vagonMasPesado()).collect(Collectors.toList());
    }

    public Boolean necesitaConductorExperimentado(){
        return formaciones.stream().anyMatch(formacion -> formacion.esCompleja());
    }

    public void agregarLocomotoraAFormacion(Formacion formacion){
        if (!formacion.puedeMoverse()) {
            Integer empujeFaltante=formacion.kgsEmpujeFaltanteParaMoverse();
            Locomotora laLocomotora = locomotorasSueltas.stream().filter(locomotora -> locomotora.arrastreUtil()>= empujeFaltante).findFirst().get();
            formacion.agregarLocomotora(laLocomotora);
        }
    }

}
