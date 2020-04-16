import com.google.gson.Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import parser.NoSuchFileException;
import parser.Parser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.testng.AssertJUnit.assertEquals;

public class ParserTest {
    private Cart ilyaCart;
    private Parser parser = new JsonParser();
    private Gson gson = new Gson();
    private String ilyaCartObjectContent;

    @AfterAll
    public static void deleteFile() {
        File ilyaCartFile = new File("src/main/resources/ilya-cart.json");
        ilyaCartFile.deleteOnExit();
    }

    @BeforeEach
    public void setUP()  {
        ilyaCart = new Cart("ilya-cart");
        RealItem car = new RealItem();
        car.setName("KIA");
        car.setPrice(20000.0);
        car.setWeight(1600.0);
        VirtualItem game = new VirtualItem();
        game.setName("Star Wars");
        game.setPrice(100);
        game.setSizeOnDisk(36000.0);
        ilyaCart.addRealItem(car);
        ilyaCart.addVirtualItem(game);
    }

    //@Disabled
    @ParameterizedTest
    @EmptySource
    //@CsvSource({ "'anything', 3" })
    @ValueSource(strings = {"C:/Windows/","src/test/resources/unexisting.json", "src/test/resources/unexisting","///unexisting.json","../unexisting.json","D:123::bat"} )
    public void noSuchFileExceptionTest(String unexistingFilePath){
        Assertions.assertThrows(NoSuchFileException.class, () -> parser.readFromFile(new File(unexistingFilePath)));
    }

    @Test
    public void writeToFileTest() throws IOException {
        ilyaCartObjectContent = gson.toJson(ilyaCart);

        parser.writeToFile(ilyaCart);

        String ilyaCartFileContent = new String(Files.readAllBytes(Paths.get("src/main/resources/ilya-cart.json")), StandardCharsets.UTF_8);
        assertEquals(ilyaCartObjectContent, ilyaCartFileContent);
    }

    @Test
    public void readFromFileTest(){
        ilyaCartObjectContent = gson.toJson(ilyaCart);

        Cart readCart = parser.readFromFile(new File("src/main/resources/ilya-cart.json"));

        String readCartObjectContent = gson.toJson(readCart);
        assertEquals(ilyaCartObjectContent, readCartObjectContent);
    }
}
