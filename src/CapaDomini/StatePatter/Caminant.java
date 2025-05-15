package CapaDomini.StatePatter;

import CapaDomini.Zombi;

public class Caminant implements IEstatZombi {
    private static final Caminant instance = new Caminant();
    
    private Caminant() {}
    
    public static Caminant getInstance() {
        return instance;
    }
    
    @Override
    public void canviarEstat(Zombi zombi, IEstatZombi nouEstat) {
        zombi.setEstat(nouEstat);
    }

    @Override
    public void detectarPersonatge(Zombi zombi, int distancia) {
        if (distancia < 2) {
            canviarEstat(zombi, Atacant.getInstance());
        }
    }

    @Override
    public void rebreDany(Zombi zombi, int dany) {
        int vidaActual = zombi.getVida() - dany;
        zombi.setVida(vidaActual);
        
        if (vidaActual <= 0) {
            canviarEstat(zombi, Destruit.getInstance());
        } else {
            canviarEstat(zombi, Lesionat.getInstance());
        }
    }
    
    @Override
    public void actualitzar(Zombi zombi) {
        // Simula el zombi caminant
    }
}
