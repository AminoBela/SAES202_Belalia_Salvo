import java.util.ArrayList;
import java.util.List;

/**
 * Classe Dijkstra qui permet de resoudre le probleme du plus court chemin

 */
public class Dijkstra {
    /**
     * Methode resoudre qui permet de resoudre le probleme du plus court chemin
     * @param g
     * @param depart
     * @return
     */
    public Valeur resoudre(Graphe g, String depart) {

        Valeur v = new Valeur();
        List<String> q = new ArrayList<>();
        for (String noeud : g.listeNoeuds()) {
            v.setValeur(noeud, Double.MAX_VALUE);
            v.setParent(noeud, null);
            q.add(noeud);
        }

        v.setValeur(depart, 0);

        while (!q.isEmpty()) {
            String u = null;
            for (String n : q) {
                if (u == null || v.getValeur(n) < v.getValeur(u)) {
                    u = n;
                }
            }
            q.remove(u);
            for (int i = 0; i < g.suivants(u).size(); i++) {
                String v1 = g.suivants(u).get(i).getDestination();
                double d = v.getValeur(u) + g.suivants(u).get(i).getCout();
                if (d < v.getValeur(v1)) {
                    v.setValeur(v1, d);
                    v.setParent(v1, u);
                }
            }
        }
        return v;
    }
}