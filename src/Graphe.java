import java.util.List;

/**
 * Interface Graphe
 */
public interface Graphe {

    /**
     * Methodes listNoeuds et suivants, pour obtenir la liste des noeuds et les noeuds suivants
     * @return
     */
    public List<String> listeNoeuds();
    public List<Arc> suivants(String s);
}
