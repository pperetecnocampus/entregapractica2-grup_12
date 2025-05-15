package CapaDomini.StatePatter;

import CapaDomini.Zombi;

public class Inactiu implements IEstatZombi {
    private static final Inactiu instance = new Inactiu();
    
    private Inactiu() {}
    
    public static Inactiu getInstance() {
        return instance;
    }
    
    @Override
    public void canviarEstat(Zombi zombi, IEstatZombi nouEstat) {
        zombi.setEstat(nouEstat);
    }

    @Override
    public void detectarPersonatge(Zombi zombi, int distancia) {
        if (distancia < 10) {
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
        // No fa res en estat inactiu
    }
}
