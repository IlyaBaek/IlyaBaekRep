import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import shop.VirtualItem;

import static org.testng.Assert.assertEquals;

@Test(groups = {"virtualItemTestGroup"})
public class VirtualItemTest {

    @Parameters(value = {"virtualItemString"})
    @Test
    public void virtualItemTest(String virtualItemString){
        VirtualItem game = new VirtualItem();
        game.setName("Star Wars");
        game.setPrice(100);
        game.setSizeOnDisk(36000.0);

        assertEquals(virtualItemString , game.toString());
    }
}
