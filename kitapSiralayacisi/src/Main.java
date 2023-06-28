import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> siralaAd= new TreeSet<>(new BookName());
        siralaAd.add(new Book("sefiller","victor hugo",450,"1850"));
        siralaAd.add(new Book("suc ve ceza","victor hugo",520,"1850"));
        siralaAd.add(new Book("anna caranına","victor hugo",300,"1850"));
        siralaAd.add(new Book("keloğlan","victor hugo",700,"1850"));
        siralaAd.add(new Book("şirinler","victor hugo",640,"1850"));

        System.out.println("İsme göre kitap adı sıralama");
        for(Book b:siralaAd){
            System.out.println(b.getKitapAdi());
        }

        System.out.println("-------------------------------");

        TreeSet <Book> siralaSayfa= new TreeSet<>(new BookSayfa());
        siralaSayfa.add(new Book("sefiller","victor hugo",450,"1850"));
        siralaSayfa.add(new Book("suc ve ceza","victor hugo",520,"1850"));
        siralaSayfa.add(new Book("anna caranına","victor hugo",300,"1850"));
        siralaSayfa.add(new Book("keloğlan","victor hugo",700,"1850"));
        siralaSayfa.add(new Book("şirinler","victor hugo",640,"1850"));

        System.out.println("Sayfa sayısına göre kitap adı sıralama");
        for(Book s:siralaSayfa){
            System.out.println(s.getKitapAdi());
        }

    }
}