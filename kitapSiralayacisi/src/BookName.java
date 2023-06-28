import java.util.Comparator;

public class BookName implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getKitapAdi().compareTo(o2.getKitapAdi());
    }
}
