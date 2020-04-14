import com.google.gson.Gson;
import org.junit.jupiter.api.*;
import parser.JsonParser;
import parser.NoSuchFileException;
import parser.Parser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class myTest {
    private Cart ilyaCart;

    private RealItem car;
    private String realItemCar;

    private VirtualItem game;
    private String virtualItemGame;

    private String itemsAll;

    private Double expectedPrice;
    private static final double TAX = 0.2;

    private Parser parser = new JsonParser();

    private Gson gson = new Gson();

    private String ilyaCartObjectContent;

    private final ByteArrayOutputStream outShowItemsContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

        @AfterAll
        public static void deleteFile() {
            File ilyaCartFile = new File("src/main/resources/ilya-cart.json");
            ilyaCartFile.deleteOnExit();
        }

        @AfterEach
        public void setOriginalSystemOut(){
            System.setOut(originalOut);
        }

        @BeforeEach
        public void setUP()  {
            ilyaCart = new Cart("ilya-cart");

            car = new RealItem();
            car.setName("KIA");
            car.setPrice(20000.0);
            car.setWeight(1600.0);
            realItemCar  = "Class: class shop.RealItem; Name: KIA; Price: 20000.0; Weight: 1600.0";

            game = new VirtualItem();
            game.setName("Star Wars");
            game.setPrice(100);
            game.setSizeOnDisk(36000.0);
            virtualItemGame = "Class: class shop.VirtualItem; Name: Star Wars; Price: 100.0; Size on disk: 36000.0";

            itemsAll = realItemCar + "\r\n" + virtualItemGame + "\r\n";

            ilyaCart.addRealItem(car);
            ilyaCart.addVirtualItem(game);

            expectedPrice = game.getPrice() + game.getPrice()*TAX + car.getPrice() + car.getPrice()*TAX;

            ilyaCartObjectContent = gson.toJson(ilyaCart);

            System.setOut(new PrintStream(outShowItemsContent));
        }

        @Test
        @Order(3)
        @Tag("Cart")
        public void testCartName() {
            assertEquals("ilya-cart", ilyaCart.getCartName());
        }

        @Test
        @Order(4)
        @Tag("Cart")
        public void testTotalPrice() {
            assertEquals(expectedPrice, ilyaCart.getTotalPrice());
        }

        @Test
        @Order(5)
        @Tag("Cart")
        public void testShowItems() {
            ilyaCart.showItems();
            assertEquals(itemsAll, outShowItemsContent.toString());
        }

        @Test
        @Order(6)
        @Tag("Cart")
        public void testDeleteRealItem() {
            ilyaCart.deleteRealItem(car);
            ilyaCart.showItems();
            assertEquals(virtualItemGame+"\r\n", outShowItemsContent.toString());
        }

        @Test
        @Order(7)
        @Tag("Cart")
        public void testDeleteVirtualItem() {
            ilyaCart.deleteVirtualItem(game);
            ilyaCart.showItems();
            assertEquals(realItemCar+"\r\n", outShowItemsContent.toString());
        }

        @Test
        @Tag("RealItem")
        @Order(1)
        public void testRealItem(){
            assertAll("Should return name, weight and price of the car",
                    ()-> assertEquals("KIA",car.getName()),
                    ()-> assertEquals(20000.0, car.getPrice()),
                    ()-> assertEquals(1600.0, car.getWeight())                    ,
                    ()-> assertEquals(realItemCar , car.toString())
            );
        }

        @Test
        @Tag("VirtualItem")
        @Order(2)
        public void testVirtualItem(){
            assertAll("Should return name, weight and price of the game",
                    ()-> assertEquals("Star Wars", game.getName()),
                    ()-> assertEquals(100.0, game.getPrice()),
                    ()-> assertEquals(36000.0, game.getSizeOnDisk()),
                    ()-> assertEquals(virtualItemGame, game.toString())
            );
        }

        @Disabled
        @Order(10)
        @Tag("Parser")
        @Test
        public void noSuchFileExceptionTest(){
            Assertions.assertThrows(NoSuchFileException.class, () -> parser.readFromFile(new File("src/main/resources/unexisting-cart.json")));
        }

        @Tag("Parser")
        @Order(8)
        @Test
        public void writeToFileTest() throws IOException {
            parser.writeToFile(ilyaCart);
            String ilyaCartFileContent = new String(Files.readAllBytes(Paths.get("src/main/resources/ilya-cart.json")), StandardCharsets.UTF_8);
            assertEquals(ilyaCartObjectContent, ilyaCartFileContent);
        }

        @Tag("Parser")
        @Order(9)
        @Test
        public void readFromFileTest(){
            Cart readCart = parser.readFromFile(new File("src/main/resources/ilya-cart.json"));
            String readCartObjectContent = gson.toJson(readCart);
            assertEquals(ilyaCartObjectContent, readCartObjectContent);
        }

}





