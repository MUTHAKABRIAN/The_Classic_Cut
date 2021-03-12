//package models;
//
//
//import org.junit.*;
//import static org.junit.Assert.*;
//
//public class HairStyleTest {
//
//    @Test
//    public void HairstyleIsAnInstanceOfHairstyle() {
//        HairStyle testHairStyle = setUpNewHairstyle();
//        assertTrue(testHairStyle instanceof HairStyle);
//    }
//
//    @Test
//    public void HairstyleNameInstantiatesCorrectly() {
//        HairStyle testHairStyle = setUpNewHairstyle();
//        assertEquals("fade", testHairStyle.getName());
//    }
//
//    @Test
//    public void equals_ReturnsTrueIfHairstyleIsEqual() {
//        HairStyle testHairStyle = setUpNewHairstyle();
//        HairStyle anotherHairStyle = setUpNewHairstyle();
//        assertTrue(testHairStyle.equals(anotherHairStyle));
//    }
//
//    // Helper Method //
//    public HairStyle setUpNewHairstyle() {
//
//        return new HairStyle("fade");
//    }
//
//}