import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String id;
    private String name;
    private String location; //file name or Web page
    private Map<String, Object> tags = new HashMap<>();

    //constructor
    public Document(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }
}
