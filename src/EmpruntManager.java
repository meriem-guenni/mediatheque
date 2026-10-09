public class EmpruntManager {
    private final Catalogue<Document> catalogue;

    public EmpruntManager(Catalogue<Document> catalogue) {
        this.catalogue = catalogue;
    }

    public void emprunter(String titre) throws MediathequeException {
        Document d = catalogue.rechercherParTitre(titre)
                .orElseThrow(() -> new DocumentIntrouvableException("Document introuvable : " + titre));

        if (d instanceof Empruntable e) {
            e.emprunter();
        } else {
            throw new DocumentIndisponibleException(
                    "Document non empruntable : " + titre,
                    new UnsupportedOperationException("Consultation sur place"));
        }
    }
}