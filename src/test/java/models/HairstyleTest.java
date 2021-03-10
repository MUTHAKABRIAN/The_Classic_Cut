package models;


import org.junit.*;
import static org.junit.Assert.*;

public class HairstyleTest {

    @Test
    public void HairstyleIsAnInstanceOfHairstyle() {
        Hairstyle testHairstyle = setUpNewHairstyle();
        assertTrue(testHairstyle instanceof Hairstyle);
    }

    @Test
    public void HairstyleNameInstantiatesCorrectly() {
        Hairstyle testHairstyle = setUpNewHairstyle();
        assertEquals("fade", testHairstyle.getName());
    }

    @Test
    public void equals_ReturnsTrueIfHairstyleIsEqual() {
        Hairstyle testHairstyle = setUpNewHairstyle();
        Hairstyle anotherHairstyle = setUpNewHairstyle();
        assertTrue(testHairstyle.equals(anotherHairstyle));
    }

    // Helper Method //
    public Hairstyle setUpNewHairstyle() {
        return new Hairstyle("fade");
    }

}