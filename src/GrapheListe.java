import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe GrapheListe qui implemente l'interface Graphe
 * il sert a creer un graphe sous forme de liste
 */
public class GrapheListe implements Graphe{

    /**
     * Attributs de la classe GrapheListe, noeuds et adjacence
     */
    private ArrayList<String> noeuds ;
    private ArrayList<Arcs> adjacence ;

    /**
     * Constructeur afin de creer un graphe vide
     */
    public GrapheListe(){
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }

    /**
     * Constructeur afin de creer un graphe a partir de noeuds et d'adjacence
     * @param noeuds
     * @param adjacence
     */
    public GrapheListe(ArrayList<String> noeuds, ArrayList<Arcs> adjacence) {
        this.noeuds = noeuds;
        this.adjacence = adjacence;
    }

    /**
     * Constructeur afin de creer un graphe a partir d'un fichier
     * @param fichier
     * @throws IOException
     */
    public GrapheListe(String fichier) throws IOException {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
        lireFichier(fichier);
    }

    /**
     * Methode pour lire un fichier et creer un graphe
     * @param fichier
     * @throws IOException
     */
    public void lireFichier(String fichier) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichier));
        String ligne;
        while ((ligne = br.readLine()) != null) {
            String[] element = ligne.split("\t");
            String depart = element[0];
            String destination = element[1];
            double cout = Double.parseDouble(element[2]);
            try {
                ajouterArc(depart, destination, cout);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        br.close();
    }

    /**
     * Methode pour obtenir l'indice d'un noeud
     * @param n
     * @return
     */
    public int getIndice(String n){
        return this.noeuds.indexOf(n);
    }

    /**
     * Methode pour ajouter un arc au graphe
     * @param depart
     * @param destination
     * @param cout
     * @throws Exception
     */
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

    /**
     * Methode toString pour afficher le graphe
     * @return
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.noeuds.size(); i++) {
            s += this.noeuds.get(i) + " -> " + this.adjacence.get(i) + "\n";
        }
        return s;
    }

    /**
     * Méthode qui retourne la liste des noeuds
     * @return
     */
    @Override
    public List<String> listeNoeuds() {
        return this.noeuds;
    }

    /**
     * Méthode qui retourne la liste des noeuds suivants
     * @param s
     * @return
     */
     @Override
    public List<Arc> suivants(String s){
        if (!this.noeuds.contains(s)){
            return null;
        } else {
            int i = this.getIndice(s);
            return this.adjacence.get(i).getArcs();
        }
    }
}
