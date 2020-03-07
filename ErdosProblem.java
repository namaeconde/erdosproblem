import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Author {
    String name;
    List<Paper> papers;

    Author(String name, List<Paper> papers) {
        this.name = name;
        this.papers = papers;
    }

    boolean isErdos() {
        return this.name == "Erdos";
    }
}

class Erdos extends Author {

    Erdos() {
        super("Erdos", Collections.EMPTY_LIST);
    }
}

class Paper {
    String title;
    List<Author> authors;

    public Paper(String title, List<Author> authors) {
        this.title = title;
        this.authors = authors;
    }
}

public class ErdosProblem {

    private Queue<Author> queue;

    public ErdosProblem() {
        this.queue = new LinkedList<Author>();
    }

    public int getErdosNumber(Author author) {
        int erdosNumber = 0;

        if (author.isErdos()) return 0;

        queue.add(author);
        while (!queue.isEmpty()) {
            Author element = queue.remove();
            List<Paper> papers = element.papers;
            for (int p = 0; p < papers.size(); p++) {
                Paper paper = papers.get(p);
                System.out.println(element.name + " > " +paper.title);
                if (paper!=null) {
                    List<Author> coAuthors = paper.authors;
                    for (int ca = 0; ca < coAuthors.size(); ca++) {
                        Author coAuthor = coAuthors.get(ca);
                        if (coAuthor.isErdos()) {
                            return erdosNumber;
                        }

                        if (coAuthor!=null && coAuthor.name != element.name && !coAuthor.isErdos()) {
                            queue.add(coAuthor);
                        }
                    }
                }
            }
            erdosNumber++;
        }

        return erdosNumber;
    }
}
