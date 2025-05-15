package CapaDomini.StatePatter;
import CapaDomini.Zombi;

public interface IEstatZombi {
    void canviarEstat(Zombi zombi, IEstatZombi nouEstat);
    void detectarPersonatge(Zombi zombi, int distancia);
    void rebreDany(Zombi zombi, int dany);
    void actualitzar(Zombi zombi);
    
    static IEstatZombi getEstatInicial() {
        return Inactiu.getInstance();
    }
}
