package be.technifutur.menu;

import java.util.Map;

public interface MenuVue {

    public void affiche(Map<String, String> map);

    String getChoice(Menu menu);
}
