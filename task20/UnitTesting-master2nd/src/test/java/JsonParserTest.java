import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
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
import com.google.gson.Gson;

import static org.testng.Assert.assertEquals;

@Test(groups = {"JsonParserTestGroup"})
public class JsonParserTest {
    private Cart ilyaCart;
    private Parser parser = new JsonParser();
    private Gson gson = new Gson();
    private String ilyaCartObjectContent;
    File ilyaCartFile = new File("src/main/resources/ilya-cart.json");

    @AfterClass
    public void deleteFile() {
        ilyaCartFile.deleteOnExit();
    }

    @BeforeMethod
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

    @DataProvider(name = "noSuchFileExceptionDataSet")
    public Object[][] createDataForExceptionTest() {
        return new Object[][] {
                { "/usr;local/bin"},
                {"src/test/resources/unexisting"},
                { "src/test/r:esources/unexisting.json"},
                {"///unexisting.json"},
                {"../unexisting.json"},
                {"D:123::.bat"}
        };
    }

    @Test(expectedExceptions = NoSuchFileException.class, dataProvider = "noSuchFileExceptionDataSet", groups = {"ExceptionGroup"})
    public void exceptionTestWitParamFromDataProvider(String value1){
        ilyaCart = parser.readFromFile(new File(value1));
    }

    @Parameters(value = {"value"})
    @Test(expectedExceptions = NoSuchFileException.class, enabled = false, groups = {"ExceptionGroup"})
    public void exceptionTestWithParamFromXML(String value){
        ilyaCart = parser.readFromFile(new File(value));
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
        parser.writeToFile(ilyaCart);

        Cart readCart = parser.readFromFile(ilyaCartFile);

        String readCartObjectContent = gson.toJson(readCart);
        assertEquals(ilyaCartObjectContent, readCartObjectContent);
    }

}
