import java.util.ArrayList;

public abstract class GrapheList implements Graphe{

    private ArrayList<String> noeuds ;
    private ArrayList<Arcs> adjacence ;


    public GrapheList(){
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }


    public int getIndice(String n){
        
    }
}
