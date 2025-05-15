package CapaDomini;

import CapaDomini.StatePatter.IEstatZombi;

public class Zombi {
    private IEstatZombi estat;
    private int vida;
    private int posicio;
    
    public Zombi() {
        this.estat = IEstatZombi.getEstatInicial();
        this.vida = 3;
        this.posicio = 0;
    }
    
    public IEstatZombi getEstat() {
        return this.estat;
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public int getPosicio() {
        return this.posicio;
    }
    
    public void setEstat(IEstatZombi estat) {
        this.estat = estat;
    }
    
    public void rebreDany(int dany) {
        estat.rebreDany(this, dany);
    }
    
    public void update(int posicioPersonatge) {
        estat.detectarPersonatge(this, posicioPersonatge);
        estat.actualitzar(this);
    }
}
