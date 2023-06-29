import java.util.Set;
import java.util.TreeSet;

public class NoteBook extends Product {
    private String storageCapacity;
    static Set<NoteBook> noteBooks = new TreeSet<>();
    private String productType;


    public NoteBook(String name, double price,Brand brandInfo, String screenSize, String ram, String storageCapacity) {
        super(name, price,brandInfo, screenSize, ram);
        this.storageCapacity = storageCapacity;
        this.productType = "NoteBook";

    }

    public String getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(String storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public String getProductType() {
        return productType;
    }
}