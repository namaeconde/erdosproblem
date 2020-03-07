import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ErdosProblem ep = new ErdosProblem();

        Erdos erdos = new Erdos();
        Author a1 = new Author("a1", new ArrayList<Paper>());
        Author a2 = new Author("a2", new ArrayList<Paper>());
        Author a3 = new Author("a3", new ArrayList<Paper>());

        Paper p1 = new Paper("p1", Arrays.asList(a1, erdos));
        Paper p2 = new Paper("p2", Arrays.asList(a1, a2));
        Paper p3 = new Paper("p3", Arrays.asList(a2, a3));
        Paper p4 = new Paper("p4", Arrays.asList(a3, erdos));

        a1.papers.add(p1); // e = 0
        a1.papers.add(p2); // e = 0

        a2.papers.add(p2); // e = 1
        a2.papers.add(p3); // e = 1

        a3.papers.add(p3); // e = 2
        a3.papers.add(p4); // e = 0

        System.out.println("Erdos number: " + ep.getErdosNumber(a3));
    }
}
