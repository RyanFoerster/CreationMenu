package be.technifutur.menu;

import java.util.Map;
import java.util.Scanner;

public class menuVueImpl implements MenuVue{
    private Scanner scan = new Scanner(System.in);
    private String userInput;

    @Override
    public void affiche(Map<String, String> map) {
        map.forEach((k, v) -> System.out.printf(k + " : " + v + "%n"));
    }

    @Override
    public String getChoice(Menu menu) {
        Map<String, String> mapItemText = menu.getItemText();
        this.affiche(mapItemText);
        System.out.println("Saisir votre choix : ");
        userInput = scan.nextLine();
        return userInput;
    }
}
