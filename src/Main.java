import be.technifutur.menu.Item;
import be.technifutur.menu.ItemExecutable;
import be.technifutur.menu.Menu;
import be.technifutur.menu.menuVueImpl;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        AtomicBoolean loop = new AtomicBoolean(true);
        Menu menuPrincipal = new Menu("Menu principal", new menuVueImpl());
        Menu menuSecondaire = new Menu("Menu secondaire", new menuVueImpl());
        ItemExecutable option1 = new ItemExecutable("Option 1", getOption1(menuPrincipal));
        ItemExecutable option2 = new ItemExecutable("Option 2", getOption2(menuPrincipal));
        ItemExecutable option3 = new ItemExecutable("Option 3", getOption3(menuPrincipal));
        ItemExecutable option4 = new ItemExecutable("Option 4", getOption4(menuPrincipal));
        ItemExecutable option5 = new ItemExecutable("Option 5", getOption5(menuPrincipal));
        ItemExecutable retour = new ItemExecutable("Retour au menu principal ", retourProgram(menuPrincipal));
        ItemExecutable close = new ItemExecutable("Quitter", () -> loop.set(false));

        menuSecondaire.addItem("3", option3);
        menuSecondaire.addItem("4", option4);
        menuSecondaire.addItem("r", retour);
        menuSecondaire.addItem("q", close);
        menuPrincipal.addItem("1", option1);
        menuPrincipal.addItem("2", option2);
        menuPrincipal.addItem("5", option5);
        menuPrincipal.addItem("s", menuSecondaire);
        menuPrincipal.addItem("q", close);

        while (loop.get()){
            menuPrincipal.execute();
        }
    }

    private static Runnable retourProgram(Menu menuPrincipal) {
        return new Runnable() {
            @Override
            public void run() {
                menuPrincipal.execute();
            }
        };
    }

    private static Runnable getOption5(Menu menu) {

        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Vous avez choisis l'option 5");
                menu.execute();
            }
        };
    }

    private static Runnable getOption4(Menu menu) {
        return () -> {
            System.out.println("Vous avez choisis l'option 4");
            menu.execute();
        };
    }

    private static Runnable getOption3(Menu menu) {
        return () -> {
            System.out.println("Vous avez choisis l'option 3");
            menu.execute();
        };
    }

    private static Runnable getOption2(Menu menu) {
        return () -> {
            System.out.println("Vous avez choisis l'option 2");
            menu.execute();
        };
    }

    private static Runnable getOption1(Menu menu) {
        return () -> {
            System.out.println("Vous avez choisis l'option 1");
            menu.execute();
        };

    }
}