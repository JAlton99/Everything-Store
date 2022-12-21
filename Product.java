package domain;

public class Product {
    private int id;
    private String SKU;
    private String description;
    private String category;
    private int price;

    public Product(int id, String SKU, String description, String category, int price) {
        this.id = id;
        this.SKU = SKU;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSKU(String SKU) {
    }
    public String getSKU() {
        return SKU;
    }
    public void setDescription(String description) {
    }
    public String getDescription() {
        return description;
    }
    public void setCategory(String category) {
    }
    public String getCategory() {
        return category;
    }
    public void setPrice(int price) {
    }
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "domain.Product{" +
                "id=" + id +
                ", SKU='" + SKU + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}

