package CapaDomini;

import CapaDomini.StatePatter.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ZombiTest {
    
    @Test
    void testEstatInicial() {
        Zombi zombi = new Zombi();
        assertTrue(zombi.getEstat() instanceof Inactiu);
    }
    
    @Test
    void testDotsZombisIndependents() {
        Zombi zombi1 = new Zombi();
        Zombi zombi2 = new Zombi();
        
        zombi1.update(8); // Canvia a Caminant
        assertTrue(zombi1.getEstat() instanceof Caminant);
        assertTrue(zombi2.getEstat() instanceof Inactiu);
    }
    
    @Test
    void testDetectarPersonatge() {
        Zombi zombi = new Zombi();
        zombi.update(9); // Personatge a menys de 10 passos
        assertTrue(zombi.getEstat() instanceof Caminant);
    }
    
    @Test
    void testAtacarPersonatge() {
        Zombi zombi = new Zombi();
        zombi.update(1); // Personatge a menys de 2 passos
        assertTrue(zombi.getEstat() instanceof Atacant);
    }
    
    @Test
    void testRebreDanyIRecuperar() {
        Zombi zombi = new Zombi();
        zombi.rebreDany(1);
        assertTrue(zombi.getEstat() instanceof Lesionat);
        assertEquals(2, zombi.getVida());
        
        // Simulem 3 cicles
        zombi.update(20); // Primera actualització
        zombi.update(20); // Segona actualització
        zombi.update(20); // Tercera actualització, hauria de tornar a Inactiu
        assertTrue(zombi.getEstat() instanceof Inactiu);
    }
    
    @Test
    void testAtacLetal() {
        Zombi zombi = new Zombi();
        zombi.rebreDany(3); // Atac letal que deixa vida a 0
        assertTrue(zombi.getEstat() instanceof Destruit);
        assertEquals(0, zombi.getVida());
        
        // Verificar que no pot fer actions
        assertThrows(RuntimeException.class, () -> {
            zombi.update(5);
        });
    }
}
