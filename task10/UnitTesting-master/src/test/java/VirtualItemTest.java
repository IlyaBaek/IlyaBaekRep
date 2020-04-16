import org.junit.jupiter.api.Test;
import shop.VirtualItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualItemTest {

    @Test
    public void testVirtualItem(){
        VirtualItem game = new VirtualItem();
        game.setName("Star Wars");
        game.setPrice(100);
        game.setSizeOnDisk(36000.0);
        String virtualItemGame = "Class: class shop.VirtualItem; Name: Star Wars; Price: 100.0; Size on disk: 36000.0";

        assertEquals(virtualItemGame, game.toString());
    }
}
