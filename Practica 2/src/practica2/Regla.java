package practica2;
import java.util.*;

public class Regla {
    private String par_izq; // parte izquierda
    private String par_der; // parte derecha
    private ArrayList<String> conPred; // conjunto de prediccion

    public Regla(String par_izq, String par_der) {
        this.par_izq = par_izq;
        this.par_der = par_der;
        this.conPred = new ArrayList<>();
    }

    public String getPar_izq() {
        return par_izq;
    }

    public void setPar_izq(String par_izq) {
        this.par_izq = par_izq;
    }

    public String getPar_der() {
        return par_der;
    }

    public void setPar_der(String par_der) {
        this.par_der = par_der;
    }

    public ArrayList<String> getConPred() {
        return conPred;
    }

    public void setConPred(ArrayList<String> conPred) {
        this.conPred = conPred;
    }

    public void addPrediccion(String prediccion){
        this.conPred.add(prediccion);
    }
}
