import DAO.ProductDAO;
import domain.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println();
        System.out.println("******* Welcome To The Everything Store *******");
        System.out.println("-----------------------------------------------");

        Product PS5 = new Product(0,"PS101", "Playstation 5", "Technology",300);
        Product XBOX = new Product(1,"XB102", "Xbox Series X","Technology",250);
        Product Candle = new Product(3,"CDL103", "Scented Candle", "Home", 10);

        System.out.println("SKU: " + PS5.getSKU());
        System.out.println("domain.Product: " + PS5.getDescription());
        System.out.println("Category: " + PS5.getCategory());
        System.out.println("Price: £" + PS5.getPrice());

        System.out.println();

        System.out.println("SKU: " + XBOX.getSKU());
        System.out.println("domain.Product: " + XBOX.getDescription());
        System.out.println("Category: " + XBOX.getCategory());
        System.out.println("Price: £" + XBOX.getPrice());

        System.out.println();

        System.out.println("SKU: " + Candle.getSKU());
        System.out.println("domain.Product: " + Candle.getDescription());
        System.out.println("Category: " + Candle.getCategory());
        System.out.println("Price: £" + Candle.getPrice());

        System.out.println();

        System.out.println(Candle.toString());
        System.out.println(PS5.toString());
        System.out.println(XBOX.toString());

        ProductDAO productDAO = new ProductDAO();

        Product prod = productDAO.getProduct(1);

        System.out.println(prod);

        ArrayList<Product> products = productDAO.getALLProducts();

        System.out.println(products);
    }
}