import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

@Test(groups = {"cartTestGroup"})
public class CartTest {
        private Cart ilyaCart;
        private RealItem car;
        private String realItemCar;
        private VirtualItem game;
        private String virtualItemGame;

        @AfterMethod
        public void setOriginalSystemOut() {
            final PrintStream originalOut = System.out;
            System.setOut(originalOut);
        }

        @BeforeMethod
        public void setUP() {
            ilyaCart = new Cart("ilya-cart");
            car = new RealItem();
            car.setName("KIA");
            car.setPrice(20000.0);
            car.setWeight(1600.0);
            realItemCar  = "Class: class shop.RealItem; Name: KIA; Price: 20000.0; Weight: 1600.0";
            game = new VirtualItem();
            game.setName("Star Wars");
            game.setPrice(100.0);
            game.setSizeOnDisk(36000.0);
            virtualItemGame = "Class: class shop.VirtualItem; Name: Star Wars; Price: 100.0; Size on disk: 36000.0";
            ilyaCart.addRealItem(car);
            ilyaCart.addVirtualItem(game);
        }

        @Test
        public void testTotalPrice() {
            double TAX = 0.2;
            Double expectedPrice = game.getPrice() + game.getPrice() * TAX + car.getPrice() + car.getPrice() * TAX;

            assertEquals(expectedPrice, ilyaCart.getTotalPrice());
        }

        @Test()
        public void testShowItems() {
            final ByteArrayOutputStream outShowItemsContent = new ByteArrayOutputStream();
            String itemsAll = realItemCar + "\r\n" + virtualItemGame + "\r\n";
            System.setOut(new PrintStream(outShowItemsContent));

            ilyaCart.showItems();

            assertEquals(itemsAll, outShowItemsContent.toString());
        }

        @Test()
        public void testDeleteRealItem() {
            final ByteArrayOutputStream outShowItemsContent1 = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outShowItemsContent1));

            ilyaCart.deleteRealItem(car);

            ilyaCart.showItems();
            assertEquals(virtualItemGame+"\r\n", outShowItemsContent1.toString());
        }


        @Test()
        public void testDeleteVirtualItem() {
            final ByteArrayOutputStream outShowItemsContent2 = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outShowItemsContent2));

            ilyaCart.deleteVirtualItem(game);

            ilyaCart.showItems();
            assertEquals(realItemCar+"\r\n", outShowItemsContent2.toString());
        }
    }


