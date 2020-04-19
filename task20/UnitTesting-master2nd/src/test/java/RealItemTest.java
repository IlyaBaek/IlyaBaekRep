import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import shop.RealItem;

import static org.testng.Assert.assertEquals;

@Test(groups = {"realItemTestGroup"})
public class RealItemTest {

    @Parameters(value = {"realItemString"})
    @Test
    public void testRealItem(String realItemString){
        RealItem car = new RealItem();
        car.setName("KIA");
        car.setPrice(20000.0);
        car.setWeight(1600.0);

        assertEquals(realItemString , car.toString());
    }
}
