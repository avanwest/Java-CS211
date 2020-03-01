

import java.util.Formatter;


 // Define a class to represent a Product entry.
 
public class Product {
    private long id;
    private String brandName;
    private String productName;
    private long price;


    public Product() {
        this.id = -1;
        this.brandName = "none";
        this.productName = "none";
        this.price = -1;
    }

    
    public Product(long id, String brandName, String productName, long price) {
        this.id = id;
        this.brandName = brandName;
        this.productName = productName;
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return String.format("%010d %12s %12s %10d", this.id, this.brandName, this.productName, this.price);
    }
}






