public class Livre extends Document implements Empruntable {
    private final String auteur;
    private final int nbPages;
    private boolean disponible=true;
    public Livre(String titre,int annee,int nbPages,String auteur){
        super(titre,annee);
        this.auteur=auteur;
        this.nbPages=nbPages;

    }
    @Override public String descriptionCourte(){
        return "[livre]"+getTitre()+"("+annee+"),"+auteur+","+nbPages+"p.";
    }
    @Override public void emprunter() throws DocumentIndisponibleException {
        if (!disponible)
            throw new DocumentIndisponibleException ("deja emprunter:"+ getTitre(),
         new IllegalStateException("le livre n est pas disponible"));
        disponible=false;
    }
    @Override public void rendre(){
        disponible=true;
    }
    @Override public boolean estDisponible(){return disponible;}
}
