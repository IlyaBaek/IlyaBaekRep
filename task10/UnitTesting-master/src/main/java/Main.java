import parser.JsonParser;
import parser.Parser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Cart andrewCart = new Cart("andrew-cart");

        RealItem car = new RealItem();
        car.setName("Audi");
        car.setPrice(32026.9);
        car.setWeight(1560);

        VirtualItem disk = new VirtualItem();
        disk.setName("Windows");
        disk.setPrice(11);
        disk.setSizeOnDisk(20000);

        andrewCart.addRealItem(car);
        andrewCart.addVirtualItem(disk);
        andrewCart.showItems();

        Parser parser = new JsonParser();
        parser.writeToFile(andrewCart);

        Cart eugenCart = parser.readFromFile(new File("src/main/resources/eugen-cart.json"));
        eugenCart.showItems();
    }
}
