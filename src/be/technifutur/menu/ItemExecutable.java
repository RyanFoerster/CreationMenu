package be.technifutur.menu;

public class ItemExecutable extends Item{

    private Runnable action;

    public ItemExecutable(String libelle, Runnable action) {
        super(libelle);
        this.action = action;
    }


    @Override
    public void execute() {
        if(this.isActif()){
            this.action.run();
        }
    }
}
