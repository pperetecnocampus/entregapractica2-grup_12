package CapaDomini.StatePatter;

import CapaDomini.Zombi;
import java.util.HashMap;
import java.util.Map;

public class Lesionat implements IEstatZombi {
    private static final Lesionat instance = new Lesionat();
    private Map<Zombi, Integer> ciclesMap = new HashMap<>();

    private Lesionat() {}

    public static Lesionat getInstance() {
        return instance;
    }

    @Override
    public void canviarEstat(Zombi zombi, IEstatZombi nouEstat) {
        ciclesMap.remove(zombi); // Eliminar el comptador quan canvia d'estat
        zombi.setEstat(nouEstat);
    }

    @Override
    public void detectarPersonatge(Zombi zombi, int distancia) {
        // No pot detectar personatges mentre està lesionat
    }

    @Override
    public void rebreDany(Zombi zombi, int dany) {
        int vidaActual = zombi.getVida() - dany;
        zombi.setVida(vidaActual);

        if (vidaActual <= 0) {
            canviarEstat(zombi, Destruit.getInstance());
        }
        // Si ja està lesionat, no canvia d'estat
    }

    @Override
    public void actualitzar(Zombi zombi) {
        // Obtenir el comptador de cicles actual per aquest zombi, o 0 si no existeix
        int ciclesActuals = ciclesMap.getOrDefault(zombi, 0);
        ciclesActuals++;

        if (ciclesActuals >= 3) {
            canviarEstat(zombi, Inactiu.getInstance());
        } else {
            ciclesMap.put(zombi, ciclesActuals); // Actualitzar el comptador
        }
    }
}
