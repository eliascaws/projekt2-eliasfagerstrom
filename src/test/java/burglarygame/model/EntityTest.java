package burglarygame.model;
import burglarygame.model.Burglar;
import burglarygame.model.Resident;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntityTest {

    @Test
    public void testPunch() {

        Resident resident = new Resident();
        Burglar burglar = new Burglar();

        int initialHealth = resident.getHealth();


        burglar.punch(resident);

        int expectedHealth = initialHealth - burglar.getDamage();
        assertEquals(expectedHealth, resident.getHealth());
    }

    @Test
    public void testDamage(){
        Resident resident = new Resident();
        int initialHealth = resident.getHealth();
        int damageAmount = 7;

        resident.takeDamage(damageAmount);

        assertEquals(initialHealth - damageAmount, resident.getHealth());
    }

    @Test
    public void testConsciousTrue(){
        Resident resident = new Resident();
        Burglar burglar = new Burglar();

        burglar.punch(resident);

        assertTrue(resident.isConscious());
    }

    @Test
    public void testConsciousFalse() {
        Resident resident = new Resident();
        Burglar burglar = new Burglar();

        burglar.setDamage(12);

        burglar.punch(resident);

        assertFalse(resident.isConscious());
    }




}