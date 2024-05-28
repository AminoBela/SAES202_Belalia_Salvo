import java.util.List;

public class Arc {
    private String dest;
    private double cout;
    public Arc(String d, double c) {
        this.dest = d;
        this.cout = c;
    }

    @Override
    public String toString() {
        return this.dest + " (" + this.cout + ")";
    }
}
