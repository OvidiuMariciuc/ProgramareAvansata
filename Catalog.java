import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    //constructor
    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void add(Document doc) {
        documents.add(doc);
    }

    //The "fancy" way - slides(lab5)
    public Document findById(String id) {
        return documents.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);

    }

    public void setName(String name) {
        this.name = name;
    }
}