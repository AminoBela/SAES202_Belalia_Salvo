import java.util.*;

/**
 * Classe permettant de stocker des arcs
 */
public class Arcs {

    /**
     * Attribut arcs qui est une liste d'arcs
     */
    private List<Arc> arcs;

    /**
     * Constructeur vide qui initialise la liste d'arcs
     */
    public Arcs() {
        this.arcs = new ArrayList<Arc>();
    }

    /**
     * Methode pour ajouter un arc a la liste d'arcs
     * @param a arc
     */
    public void ajouterArc(Arc a) {
        this.arcs.add(a);
    }

    /**
     * Methode pour obtenir la liste d'arcs, getter
     * @return
     */
    public List<Arc> getArcs() {
        return this.arcs;
    }

    /**
     * Methode toString pour afficher la liste d'arcs
     * @return
     */
    public String toString() {
        String s = "";
        for (Arc a : this.arcs) {
            s += a + " ";
        }
        return s;
    }

}
