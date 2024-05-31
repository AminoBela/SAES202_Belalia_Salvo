import java.util.ArrayList;
import java.util.List;

/**
 * Classe Dijkstra qui permet de resoudre le probleme du plus court chemin
 */
public class Dijkstra implements Algorithme {

    /**
     * Attribut arcsVisites pour stocker les arcs visites
     */
    private List<Arc> arcsVisitesDijkstra;

    /**
     * Constructeur de la classe Dijkstra
     */
    public Dijkstra() {
        this.arcsVisitesDijkstra = new ArrayList<>();
    }

    /**
     * Methode get pour les arcs visites
     *
     */
    public List<Arc> getArcsVisites() {
        return arcsVisitesDijkstra;
    }

    /**
     * Methode resoudre qui permet de resoudre le probleme du plus court chemin
     * @param g graphe
     * @param depart noeud de depart
     * @return Valeur
     */
    public Valeur resoudre(Graphe g, String depart)  {
        //initialisation des valeurs
        Valeur v = new Valeur();
        List<String> q = new ArrayList<>();
        for (String noeud : g.listeNoeuds()) {
            v.setValeur(noeud, Double.MAX_VALUE);
            v.setParent(noeud, null);
            q.add(noeud);
        }
        //on met la valeur de depart a 0
        v.setValeur(depart, 0);
        //boucle de l'algorithme
        while (!q.isEmpty()) {
            String u = null;
            //on cherche le noeud avec la plus petite valeur
            for (String n : q) {
                if (u == null || v.getValeur(n) < v.getValeur(u)) {
                    u = n;
                }
            }
            //on retire le noeud de la liste
            q.remove(u);
            //pour chaque voisin, on met a jour la valeur si besoin
            for (int i = 0; i < g.suivants(u).size(); i++) {
                //on stocke l'arc visite, pour l'affichage
                Arc arc = g.suivants(u).get(i);
                arcsVisitesDijkstra.add(arc);
                String v1 = g.suivants(u).get(i).getDestination();
                double d = v.getValeur(u) + g.suivants(u).get(i).getCout();
                //si la nouvelle valeur est plus petite, on met a jour
                if (d < v.getValeur(v1)) {
                    v.setValeur(v1, d);
                    v.setParent(v1, u);
                }
            }
        }
        return v;
    }

}