package be.technifutur.menu;



public abstract class Item {
    private final String libelle;
    private boolean actif = true;

    public Item(String libelle) {
        if(libelle == null || libelle.isBlank()){
            throw new IllegalArgumentException("Le libelle ne peut pas être vide ou null");
        }
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public abstract void execute();


}
