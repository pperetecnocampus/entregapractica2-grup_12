package CapaDomini.StatePatter;

import CapaDomini.Zombi;

public class Destruit implements IEstatZombi {
    private static final Destruit instance = new Destruit();
    
    private Destruit() {}
    
    public static Destruit getInstance() {
        return instance;
    }
    
    @Override
    public void canviarEstat(Zombi zombi, IEstatZombi nouEstat) {
        throw new RuntimeException("No es pot canviar l'estat d'un zombi destruït");
    }

    @Override
    public void detectarPersonatge(Zombi zombi, int distancia) {
        throw new RuntimeException("Un zombi destruït no pot detectar personatges");
    }

    @Override
    public void rebreDany(Zombi zombi, int dany) {
        // No fa res, ja està destruït
    }
    
    @Override
    public void actualitzar(Zombi zombi) {
        // No fa res, ja està destruït
    }
}
