package HashMap;

import java.util.HashMap;
import java.util.Map;

public class Ubicacion {
    private int id;
    private String description;
    private Map<String, Integer> exits;

    public Ubicacion(int id, String description) {
        this.id = id;
        this.description = description;
        this.exits = new HashMap<>();
        this.exits.put("Q", 0);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void addExit(String direccion, int idUbicación) {
        exits.put(direccion, idUbicación);
    }

    public Map<String, Integer> getExits() {
        return exits;
    }
}
