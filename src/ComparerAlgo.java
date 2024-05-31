/**
 * Classe permettant de comparer les differents algorithmes de recherche de chemin
 */
public class ComparerAlgo {
    /**
     * Attributs, temps d'execution, nombre de noeuds visites, nombre d'arcs visites et qualite du chemin
     */
    private long tempsExecution;
    private int nombreNoeudsVisites;
    private int nombreArcsVisites;
    private double qualiteChemin;

    /**
     * Methode set pour le temps d'execution
     * @param tempsExecution
     */

    public void setTempsExecution(long tempsExecution) {
        this.tempsExecution = tempsExecution;
    }

    /**
     * Methode set pour le nombre de noeuds visites
     * @param nombreNoeudsVisites
     */
    public void setNbNoeuds(int nombreNoeudsVisites) {
        this.nombreNoeudsVisites = nombreNoeudsVisites;
    }

    /**
     * Methode set pour le nombre d'arcs visites
     * @param nombreArcsVisites
     */
    public void setNbArcs(int nombreArcsVisites) {
        this.nombreArcsVisites = nombreArcsVisites;
    }

    /**
     * Methode set pour la qualite du chemin
     * @param qualiteChemin
     */
    public void setQualiteChemin(double qualiteChemin) {
        this.qualiteChemin = qualiteChemin;
    }


    /**
     * Methode toString pour afficher les resultats de la comparaison
     * @return
     */
    public String toString() {
        return "Temps d'execution : " + tempsExecution + "ms" + "\nNombre de noeuds visites : " + nombreNoeudsVisites + "\nNombre d'arcs visites : " + nombreArcsVisites + "\nQualite du chemin : " + qualiteChemin;
    }

    /**
     * Methode get pour la qualite du chemin
     * @return
     */
    public double getQualiteChemin() {
        return qualiteChemin;
    }

    /**
     * Methode get pour le nombre d'arcs visites
     * @return
     */
    public int getNbArcs() {
        return nombreArcsVisites;
    }

    /**
     * Methode get pour le nombre de noeuds visites
     * @return
     */
    public int getNbNoeuds() {
        return nombreNoeudsVisites;
    }

    /**
     * Methode get pour le temps d'execution
     * @return
     */
    public long getTempsExecution() {
        return tempsExecution;
    }
}
