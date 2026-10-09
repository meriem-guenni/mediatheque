import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmpruntManagerTest {

    @Test
    void testException() throws Exception {
        Catalogue<Document> catalogue = new Catalogue<>();
        catalogue.ajouter(new Livre("Java", 2020, 300, "Dupont"));
        EmpruntManager manager = new EmpruntManager(catalogue);

        manager.emprunter("Java");   // 1er emprunt : pas d'erreur

        DocumentIndisponibleException e = assertThrows(
                DocumentIndisponibleException.class,
                () -> manager.emprunter("Java"));   // 2e emprunt : erreur attendue

        assertTrue(e.getMessage().contains("Java"));   // le message contient le titre
        assertNotNull(e.getCause());                   // la cause est chaînée
    }
}