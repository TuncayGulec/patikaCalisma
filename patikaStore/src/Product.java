import java.util.Set;
import java.util.TreeSet;

abstract class Product implements Comparable<Product> {

    private static int count;

    private int ID;
    private String name;
    private double price;
    private double discountRate;
    private int amountofStock;
    Brand brandInfo;
    private String screenSize;
    private String ram;
    static Set<Product> products = new TreeSet<>();


    public Product(String name, double price, Brand brandInfo, String screenSize, String ram) {

        count++;
        this.ID = count;
        this.name = name;

        this.price = price;
        this.brandInfo = brandInfo;
        this.screenSize = screenSize;
        this.ram = ram;
        this.discountRate = 0;
        this.amountofStock = 50;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        double tempDiscountNum;
        tempDiscountNum = this.discountRate / 100;
        tempDiscountNum = this.price * tempDiscountNum;
        this.price -= tempDiscountNum;
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;

    }

    public int getAmountofStock() {
        return amountofStock;
    }

    public void setAmountofStock(int amountofStock) {
        this.amountofStock = amountofStock;
    }

    public Brand getBrandInfo() {
        return brandInfo;
    }

    public void setBrandInfo(Brand brandInfo) {
        this.brandInfo = brandInfo;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }


    @Override
    public int compareTo(Product o) {
        if (this.getID() > o.getID()) {
            return 1;
        } else if (o.getID() > this.getID()) {
            return -1;
        } else {
            return 0;
        }
    }
}
