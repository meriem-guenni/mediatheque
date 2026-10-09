public class EmpruntManager {
    private final Catalogue<Document> catalogue;

    public EmpruntManager(Catalogue<Document> catalogue) {
        this.catalogue = catalogue;
    }

    public void emprunter(String titre) throws DocumentIndisponibleException {
        Document d = catalogue.rechercherParTitre(titre)
                .orElseThrow(() -> new IllegalArgumentException("Document introuvable : " + titre));

        if (d instanceof Empruntable e) {
            e.emprunter();
        } else {
            throw new IllegalArgumentException("Document non empruntable : " + titre);
        }
    }
}