import java.util.Optional;
/*
 * Problèmes de l'ancien "Bibliothecaire extends Catalogue" :
 * - relation "est-un" fausse : un bibliothécaire n'est pas un catalogue ;
 * - il héritait de méthodes sans sens pour lui (toute l'API de Catalogue exposée) ;
 * - couplage fort : toute modification de Catalogue casse Bibliothecaire ;
 * - l'héritage servait uniquement à réutiliser du code (la composition suffit).
 *
 * Solution : composition, Bibliothecaire possède un Catalogue et lui délègue.
 */

public class Bibliothecaire {
    private final Catalogue<Document> catalogue;

    public Bibliothecaire(Catalogue<Document> catalogue) {
        this.catalogue = catalogue;
    }

    public void ajouter(Document d) {
        catalogue.ajouter(d);
    }

    public Optional<Document> rechercher(String titre) {
        return catalogue.rechercherParTitre(titre);
    }
}