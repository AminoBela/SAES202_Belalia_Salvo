import java.util.*;
public class Arcs {
    private List<Arc> arcs;

    public Arcs() {
        this.arcs = new ArrayList<Arc>();
    }

    public void ajouterArc(Arc a) {
        this.arcs.add(a);
    }

    public List<Arc> getArcs() {
        return this.arcs;
    }

    public String toString() {
        String s = "";
        for (Arc a : this.arcs) {
            s += a + " ";
        }
        return s;
    }

}
