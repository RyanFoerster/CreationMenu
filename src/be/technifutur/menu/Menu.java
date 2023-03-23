package be.technifutur.menu;

import java.util.*;
import java.util.stream.Collectors;

public class Menu extends Item {
    private Map<String, Item> itemMap = new LinkedHashMap<>();
    private MenuVue vue;

    public Menu(String libelle, MenuVue vue) {
        super(libelle);
        Objects.requireNonNull(vue);
        this.vue = vue;
    }

    public Item addItem(String key, Item value) {
        return itemMap.put(key, value);
    }

    public boolean removeItem(Object key, Object value) {
        return itemMap.remove(key, value);
    }

    public MenuVue getVue() {
        return vue;
    }

    public void setVue(MenuVue vue) {
        Objects.requireNonNull(vue);
        this.vue = vue;
    }

    @Override
    public void execute() {
        String userInput;
        userInput  = vue.getChoice(this);

        while(!itemMap.containsKey(userInput)){
            userInput = vue.getChoice(this);
        }

        itemMap.get(userInput).execute();

    }

    public Map<String, String> getItemText() {
        
        Map<String, String> stringMap = new LinkedHashMap<>();

        for (Map.Entry<String, Item> e : this.itemMap.entrySet()) {
            stringMap.put(e.getKey(), e.getValue().getLibelle());
        }

        return this.itemMap.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> e.getValue().getLibelle(),
                (a,b) -> {
                        throw new IllegalArgumentException("Doublon non autoriser ");
                    },
                LinkedHashMap::new
        ));
        
        
//        return stringMap;
    }
}
