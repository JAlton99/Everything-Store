package DAO;

import domain.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO extends DAO{

    public ProductDAO() {}

   public static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            String dbURL = "jdbc:sqlite:everything.db";
            dbConnection = DriverManager.getConnection(dbURL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       return dbConnection;
   }
    public ArrayList<Product> getALLProducts() throws SQLException {
        System.out.println("Retrieving all products ...");
        Connection dbConnection = null;
        Statement statement = null;
        String query = "SELECT * FROM product;";
        ArrayList<Product> products = new ArrayList<>();
        ResultSet result = null;

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {

                int id = result.getInt("ID");
                String SKU = result.getString("SKU");
                String description = result.getString("Description");
                String category = result.getString("Category");
                int price = result.getInt("Price");

                products.add(new Product(id,SKU,description,category,price));
            }
        }   catch(Exception e) {
            System.out.println("get all products: "+e);
        } finally {
            if (result !=null) {
                result.close();
            }if (statement !=null) {
                statement.close();
            }
            if (dbConnection !=null) {
                dbConnection.close();
            }
        }
        return products;
   }

    public Product getProduct (int id) throws SQLException {

        Product product = null;
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet result = null;

        String query = "SELECT * FROM product WHERE ID =" +
                id + ";";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {
                int temp_id = result.getInt("id");
                String SKU = result.getString("SKU");
                String description = result.getString("Description");
                String category = result.getString("Category");
                int price = result.getInt("Price");
                product = new Product(temp_id,SKU,description,category,price);
            }

        }finally {
            if (result != null) {
                result.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return product;
    }


    public Boolean deleteProduct(int product_id) throws SQLException {
        System.out.println("Deleting Product");
        Connection dbConnection = null;
        Statement statement = null;
        int result = 0;
        String query = "DELETE FROM product WHERE ID = " + product_id
                +";";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            result = statement.executeUpdate(query);
        }finally {
            if (statement !=null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
         }
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }
    public Boolean updateProduct(Product product) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String query = "UPDATE product " + "SET ID = '" +
    product.getId() + "'," + "SKU = '"
                +product.getSKU() + "'," + "Description= '" + product.getDescription() +
    "'," + "Category= " +product.getCategory() + ", Price=" + product.getPrice() +
    " WHERE ID = " + product.getId()
        + ";";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            statement.executeUpdate(query);

        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;

        }finally {

            if (statement !=null) {
                statement.close();
            }
        }
        return true;
    }

    public boolean addProduct(Product in) throws SQLException{
        Connection dbConnection = null;
        Statement statement = null;

        String update = "INSERT INTO product (String SKU, String description, String category, int price, int id) VALUES ("+in.getId()+",'"+
                in.getSKU()+"',"+in.getDescription()+"',"+in.getCategory()+","+in.getPrice() + ");";
        boolean ok = false;
                    try {
                        dbConnection = getDBConnection();
                        statement = dbConnection.createStatement();
                        System.out.println(update);
                        statement.executeUpdate(update);
                        ok = true;
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        if (statement != null) {
                            statement.close();
                        }
                        if (dbConnection != null) {
                            dbConnection.close();
                        }

                    }
        return ok;
    }
    }


