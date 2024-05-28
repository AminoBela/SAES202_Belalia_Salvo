import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{

    private ArrayList<String> noeuds ;
    private ArrayList<Arcs> adjacence ;


    public int getIndice(String n){
        return this.noeuds.indexOf(n);
    }

    public void ajouterArc(String depart, String destination, double cout) throws Exception {
        //verifier si le noeud depart existe, sinon l'ajouter
        if(!this.noeuds.contains(depart)){
            this.noeuds.add(depart);
            this.adjacence.add(new Arcs());
        }
        //verifier si le noeud destination existe, sinon l'ajouter
        if(!this.noeuds.contains(destination)){
            this.noeuds.add(destination);
            this.adjacence.add(new Arcs());
        }
        //mise a jour liste d'arcs du noeud depart, verifier si l'arc existe, sinon l'ajouter
        int i = this.getIndice(depart);
        Arcs arcs = this.adjacence.get(i);
        arcs.ajouterArc(new Arc(destination, cout));
    }



}
