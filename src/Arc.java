
/**
 * Classe Arc
 */
public class Arc {
    /**
     * Attributs dest et cout
     */
    private String dest;
    private double cout;

    /**
     * Constructeur de la classe Arc
     * @param d
     * @param c
     */
    public Arc(String d, double c) {
        this.dest = d;
        this.cout = c;
    }

    /**
     * Methode pour obtenir la destination de l'arc, toString
     * @return
     */
    @Override
    public String toString() {
        return this.dest + " (" + this.cout + ")";
    }

    /**
     * Methode getteur
     * @return
     */
    public String getDestination() {
        return dest;
    }

    /**
     * Methode getteur
     * @return
     */
    public double getCout() {
        return cout;
    }
}
