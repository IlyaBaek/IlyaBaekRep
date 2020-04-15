import com.google.gson.Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
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
import static org.junit.jupiter.api.Assertions.assertEquals;



public class MyTest {
    private Cart ilyaCart;
    private RealItem car;
    private String realItemCar;
    private VirtualItem game;
    private String virtualItemGame;
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
            ilyaCart.addRealItem(car);
            ilyaCart.addVirtualItem(game);
        }

        @Test
        @Tag("Cart")
        public void testTotalPrice() {
            Double expectedPrice = game.getPrice() + game.getPrice() * TAX + car.getPrice() + car.getPrice() * TAX;

            assertEquals(expectedPrice, ilyaCart.getTotalPrice());
        }

        @Test
        @Tag("Cart")
        public void testShowItems() {
            String itemsAll = realItemCar + "\r\n" + virtualItemGame + "\r\n";
            System.setOut(new PrintStream(outShowItemsContent));

            ilyaCart.showItems();

            assertEquals(itemsAll, outShowItemsContent.toString());
        }

        @Test
        @Tag("Cart")
        public void testDeleteRealItem() {
            System.setOut(new PrintStream(outShowItemsContent));

            ilyaCart.deleteRealItem(car);

            ilyaCart.showItems();
            assertEquals(virtualItemGame+"\r\n", outShowItemsContent.toString());
        }

        @Test
        @Tag("Cart")
        public void testDeleteVirtualItem() {
            System.setOut(new PrintStream(outShowItemsContent));

            ilyaCart.deleteVirtualItem(game);

            ilyaCart.showItems();
            assertEquals(realItemCar+"\r\n", outShowItemsContent.toString());
        }

        @Test
        @Tag("RealItem")
        public void testRealItem(){
            assertEquals(realItemCar , car.toString());
        }

        @Test
        @Tag("VirtualItem")
        public void testVirtualItem(){
            assertEquals(virtualItemGame, game.toString());
        }

        //@Disabled
        @Tag("Parser")
        @ParameterizedTest
        @EmptySource
        @CsvSource({ "'anything', 3" })
        @ValueSource(strings = {"src/test/resources/unexisting-cart.json"} )
        //@CsvFileSource(resources = "/12.txt")
        public void noSuchFileExceptionTest(String unexistingFilePath){
            Assertions.assertThrows(NoSuchFileException.class, () -> parser.readFromFile(new File(unexistingFilePath)));
        }

        @Tag("Parser")
        @Test
        public void writeToFileTest() throws IOException {
            ilyaCartObjectContent = gson.toJson(ilyaCart);

            parser.writeToFile(ilyaCart);

            String ilyaCartFileContent = new String(Files.readAllBytes(Paths.get("src/main/resources/ilya-cart.json")), StandardCharsets.UTF_8);
            assertEquals(ilyaCartObjectContent, ilyaCartFileContent);
        }

        @Tag("Parser")
        @Test
        public void readFromFileTest(){
            ilyaCartObjectContent = gson.toJson(ilyaCart);

            Cart readCart = parser.readFromFile(new File("src/main/resources/ilya-cart.json"));

            String readCartObjectContent = gson.toJson(readCart);
            assertEquals(ilyaCartObjectContent, readCartObjectContent);
        }
}