import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <H1>TestSupermarket</H1>
 * Unit testing for the Supermarket program
 *
 * @author Stephen White
 * @since October 17, 2016
 * @version     1.0
 */
public class SupermarketCheckoutsTest {

    @Test
    public void testAddZeroCustomer(){
        SupermarketCheckouts test = new SupermarketCheckouts();
        test.buildMarket(2,2);
        assertEquals("Failed when testing addCustomer with zero items", false, test.addCustomer(0));
    }

    @Test
    public void testAddNegativeCustomer(){
        SupermarketCheckouts test = new SupermarketCheckouts();
        test.buildMarket(2,2);
        assertEquals("Failed when testing addCustomer with negative items", false, test.addCustomer(-5));
    }

    @Test
    public void testCustomerFullLines(){
        SupermarketCheckouts test = new SupermarketCheckouts();
        test.buildMarket(1,2);
        test.addCustomer(1);
        test.addCustomer(2);
        assertEquals("Failed when testing addCustomer when lines are full", false, test.addCustomer(10));
    }

    @Test
    public void testTickRemovesCustomersCorrectly1(){
        SupermarketCheckouts test = new SupermarketCheckouts();
        test.buildMarket(1,3);
        test.addCustomer(2);
        assertEquals("Failed when testing tick", 0, test.tick());
    }

    @Test
    public void testTickRemovesCustomersCorrectly2(){
        SupermarketCheckouts test = new SupermarketCheckouts();
        test.buildMarket(1,3);
        test.addCustomer(1);
        test.addCustomer(2);
        test.addCustomer(2);
        assertEquals("Failed when testing tick 1", 0, test.tick());
        assertEquals("Failed when testing tick 2",1, test.tick());
        assertEquals("Failed when testing tick 3", 0, test.tick());
        assertEquals("Failed when testing tick 4", 0, test.tick());
        assertEquals("Failed when testing tick 5", 1, test.tick());
        assertEquals("Failed when testing tick 6", 0, test.tick());
        assertEquals("Failed when testing tick 7", 0, test.tick());
        assertEquals("Failed when testing tick 8", 1, test.tick());
        assertEquals("Failed when testing tick 9", -1, test.tick());
    }
}
