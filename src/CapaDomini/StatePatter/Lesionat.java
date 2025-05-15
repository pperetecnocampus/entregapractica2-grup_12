package CapaDomini.StatePatter;

import CapaDomini.Zombi;

public class Lesionat implements IEstatZombi {
    private static final Lesionat instance = new Lesionat();
    private int cicles = 0;
    
    private Lesionat() {}
    
    public static Lesionat getInstance() {
        return instance;
    }
    
    @Override
    public void canviarEstat(Zombi zombi, IEstatZombi nouEstat) {
        cicles = 0; // Reinicia el comptador
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
        cicles++;
        if (cicles >= 3) {
            canviarEstat(zombi, Inactiu.getInstance());
        }
    }
}
