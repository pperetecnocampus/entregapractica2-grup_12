package CapaDomini.StatePatter;

import CapaDomini.Zombi;

public class Atacant implements IEstatZombi {
    private static final Atacant instance = new Atacant();
    
    private Atacant() {}
    
    public static Atacant getInstance() {
        return instance;
    }
    
    @Override
    public void canviarEstat(Zombi zombi, IEstatZombi nouEstat) {
        zombi.setEstat(nouEstat);
    }

    @Override
    public void detectarPersonatge(Zombi zombi, int distancia) {
        if (distancia >= 2) {
            canviarEstat(zombi, Caminant.getInstance());
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
        // Simula el zombi atacant
    }
}
