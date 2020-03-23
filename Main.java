import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    private void testCreateSave() {
        Catalog catalog =
                new Catalog("Java Resources", "C:\\Users\\ovidi\\IdeaProjects\\Laborator5PA\\catalog.ser");
        Document document = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        Document document2 = new Document("youtube", "Youtube", "https://www.youtube.com/");
        Document document3 = new Document("google", "Google", "https://google.ro");

        document.addTag("type", "Slides");

        catalog.add(document);
        catalog.add(document2);
        catalog.add(document3);

        try {
            CatalogUtil.save(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testLoadView() {
        Catalog catalog = null;
        try {
            catalog = CatalogUtil.load("C:\\Users\\ovidi\\IdeaProjects\\Laborator5PA\\catalog.ser");
        } catch (InvalidCatalogException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        Document document = null;
        if (catalog != null) {
            document = catalog.findById("java1");
        }
        try {
            CatalogUtil.view(document);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        Document document2 = null;
        if (catalog != null) {
            document = catalog.findById("youtube");
        }
        try {
            CatalogUtil.view(document);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        Document document3 = null;
        if (catalog != null) {
            document = catalog.findById("google");
        }
        try {
            CatalogUtil.view(document);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();

    }
}