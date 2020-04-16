import org.junit.jupiter.api.Test;
import shop.RealItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RealItemTest {

    @Test
    public void testRealItem(){
        RealItem car = new RealItem();
        car.setName("KIA");
        car.setPrice(20000.0);
        car.setWeight(1600.0);
        String realItemCar  = "Class: class shop.RealItem; Name: KIA; Price: 20000.0; Weight: 1600.0";

        assertEquals(realItemCar , car.toString());
    }
}
