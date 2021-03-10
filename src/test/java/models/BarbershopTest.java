package models;

import org.junit.*;
import static org.junit.Assert.*;


public class BarbershopTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void Barbershop_isAnInstanceOfBarbershop() {
        Barbershop testBarbershop = setUpNewBarberShop();
        assertTrue(testBarbershop instanceof Barbershop);
    }

    @Test
    public void BarbershopNameInstantiatesCorrectly() {
        Barbershop testBarbershop = setUpNewBarberShop();
        assertEquals("Classic Cut", testBarbershop.getName());
    }

    @Test
    public void BarbershopAddressInstantiatesCorrectly() {
        Barbershop testBarbershop = setUpNewBarberShop();
        assertEquals("111-111-111 Ngong Street", testBarbershop.getAddress());
    }

    @Test
    public void BarbershopPhoneInstantiatesCorrectly() {
        Barbershop testBarbershop = setUpNewBarberShop();
        assertEquals("+02025456662", testBarbershop.getPhone());
    }

    @Test
    public void BarbershopWebsiteInstantiatesCorrectly() {
        Barbershop testBarbershop = setUpNewBarberShop();
        assertEquals("www.classiccut.com", testBarbershop.getWebsite());
    }

    @Test
    public void BarbershopEmailInstantiatesCorrectly() {
        Barbershop testBarbershop = setUpNewBarberShop();
        assertEquals("classiccut@hotmail.com", testBarbershop.getEmail());
    }

    @Test
    public void ReturnsTrueIfBarbershopDetailsAreTheSame() {
        Barbershop barbershop = setUpNewBarberShop();
        Barbershop testBarbershop = setUpNewBarberShop();
        assertTrue(barbershop.equals(testBarbershop));
    }



    // Helper Method //
    
    public Barbershop setUpNewBarberShop() {
        return new Barbershop("Classic Cut", "111-111-111 Ngong Street", "+02025456662", "www.classiccut.com", "classiccut@hotmail.com");
    }
}