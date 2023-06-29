import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PatikaPanel {

    Scanner input = new Scanner(System.in);

    static {
        Brand.brands.add(new Brand("Samsung"));
        Brand.brands.add(new Brand("Apple"));
        Brand.brands.add(new Brand("Lenovo"));
        Brand.brands.add(new Brand("Huawei"));
        Brand.brands.add(new Brand("Casper"));
        Brand.brands.add(new Brand("Asus"));
        Brand.brands.add(new Brand("HP"));
        Brand.brands.add(new Brand("Xiaomi"));
        Brand.brands.add(new Brand("Monster"));
        MobilePhone.mobilePhones.add(new MobilePhone("Samsung Galaxy A51",3199,new Brand("Samsung"),
                "6.5","6 GB","128 GB","4000","Siyah"));

        MobilePhone.mobilePhones.add(new MobilePhone("iphone 11 64 GB",7379,new Brand("Apple"),
                "6.1","6 GB","64 GB","3046","Mavi"));

        MobilePhone.mobilePhones.add(new MobilePhone("Redmi Note 10 Pro 8GB",4012,new Brand("Xiaomi"),
                "6.5","12 GB","128 GB","4000","Beyaz"));

        NoteBook.noteBooks.add(new NoteBook("HUAWEI Matebook 14 ",7000,new Brand("Huawei"),"14.0","16","512"));
        NoteBook.noteBooks.add(new NoteBook("LENOVO V14 IGL ",3699,new Brand("Lenovo"),"14.0","16","1024"));
        NoteBook.noteBooks.add(new NoteBook("ASUS Tuf Gaming  ",8199,new Brand("Asus"),"15.6","16","2048"));

        Product.products.addAll(MobilePhone.mobilePhones);
        Product.products.addAll(NoteBook.noteBooks);

    }
    void run(){

        while (true){
            System.out.println("************************************");
            System.out.println("Notebook işlemleri: 1");
            System.out.println("Cep Telefonu işlemleri: 2");
            System.out.println("Marka Listele : 3");
            System.out.println("Yeni ürün ekle: 4");
            System.out.println("Ürünleri ID numarası veya markaya göre listele: 5");
            System.out.println("Ürün sil: 6");
            System.out.println("Çıkış yapmak için: 7");
            System.out.println("************************************");

            int select;

            try{
                select = input.nextInt();
                input.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("Geçersiz veri girişi");
                break;
            }
            if (select==7){
                break;
            }

            switch (select) {
                case 1 -> {
                    System.out.println("Notebook listelemek için : 1\n" +
                            "Çıkış yapmak için herhangi bir karakteri tuşlayınız.");
                    try {
                        select = Integer.parseInt(input.next());
                    } catch (NumberFormatException e) {
                        System.out.println("Çıkış yapıldı.");
                    }
                    if (select == 1) {
                        listNotebooks();
                    }
                }
                case 2 -> {
                    System.out.println("Cep telefonu listelemek için: 1\n" +
                            "Çıkış yapmak için herhangi bir karakteri tuşlayınız.");
                    try {
                        select = Integer.parseInt(input.next());
                    } catch (NumberFormatException e) {
                        System.out.println("Çıkış yapıldı.");
                    }
                    if (select == 1) {
                        listMobilePhones();
                    }
                }
                case 3 -> listBrands();
                case 4 -> addProduct();
                case 5 -> {
                    System.out.println("ID numarasına göre filtrelemek için 1:\n" +
                            "Markaya göre filtrelemek için 2");
                    try {


                        select = Integer.parseInt(input.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Geçersiz veri girişi.");
                    }
                    if (select == 1) {
                        System.out.println("Ürünün ID numarasını giriniz.");
                        try {
                            select = Integer.parseInt(input.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Geçersiz veri girişi.");
                        }

                        listAllProducts(select);
                    }
                    if (select == 2) {
                        listBrands();
                        System.out.println("Marka ismini giriniz.");

                        listAllProducts(input.nextLine());
                    }
                }
                case 6 -> {
                    System.out.println("Silmek istediğiniz ürünün ID numarasını giriniz.");
                    int idNum = input.nextInt();
                    input.nextLine();
                    Set<Product> toremove = new TreeSet<>();
                    for (Product p : Product.products) {
                        if (p.getID() == idNum) {
                            toremove.add(p);
                        }


                    }
                    Product.products.removeAll(toremove);
                    NoteBook.noteBooks.removeAll(toremove);
                    MobilePhone.mobilePhones.removeAll(toremove);
                }
            }

        }

    }

    public  void listBrands(){
        System.out.println("Markalarımız");
        System.out.println("-----------------------------------");
        for (Brand b:Brand.brands){
            System.out.println(b.getName());
        }
    }

    public void listMobilePhones(){
        System.out.println("Cep Telefonu Listesi");

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-11s%4s%15s%27s%11s%20s%10s%15s%15s%16s%n",
                "ID","Ürün ","Ürün Adı","Fiyat","Marka","Depolama","Ekran","Pil","RAM","Renk");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (MobilePhone mp:MobilePhone.mobilePhones){

            System.out.printf("%-10s%-13s%-30s%-11s%-17s%-13s%-17s%-15s%-15s%-15s%n",mp.getID(),mp.getProductType(),mp.getName(),mp.getPrice(),mp.getBrandInfo().getName()
                    ,mp.getMemoryInfo(),mp.getScreenSize(),mp.getBatteryPower(),mp.getRam(),mp.getColor()

            );
        }

    }

    public  void listNotebooks(){
        System.out.println();
        System.out.println("Notebook Listesi");

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-11s%4s%15s%27s%15s%10s%15s%15s%15s%16s%n",
                "ID","Ürün ","Ürün Adı","Fiyat","İndirim Oranı","Stok","Ekran","Marka","RAM","Depolama");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (NoteBook n:NoteBook.noteBooks){
            System.out.printf("%-10s%-13s%-30s%-11s%-17s%-13s%-17s%-15s%-15s%-15s%n",n.getID(),n.getProductType(),n.getName(),n.getPrice(),n.getDiscountRate()
                    ,n.getAmountofStock(),n.getScreenSize(),n.getBrandInfo().getName(),n.getRam(),n.getStorageCapacity()

            );

        }


    }

    public void addProduct(){
        System.out.println("Eklemek istediğiniz ürün grubunu giriniz.");
        System.out.println(" Telefon için: 1");
        System.out.println("Notebook için: 2");


        int productType = input.nextInt();
        input.nextLine();

        if (productType==1){
            System.out.println("Telefon özelliklerini sırasıyla giriniz.");

            System.out.println("Ürün Adı:");
            String productName = input.nextLine();
            System.out.println("Ürün Fiyatı: ");
            int price = input.nextInt();
            input.nextLine();

            System.out.println("Seçeceğiniz markayı yazınız. ");
            System.out.println("-----------------------------------------");

            listBrands();

            String brand = input.nextLine();
            String firstLatter;
            firstLatter = brand.substring(0,1).toUpperCase();

            brand = firstLatter+brand.substring(1);

            while (!Brand.brands.contains(new Brand(brand))){

                System.out.println("Geçersiz marka ismi. Lütfen tekrar deneyiniz.");
                brand = input.nextLine();
                firstLatter = brand.substring(0,1).toUpperCase();

                brand = firstLatter+brand.substring(1);


            }

            System.out.println("Depolama: ");

            String storageCapacity = input.nextLine();
            System.out.println("Ekran: ");
            String screenSize = input.nextLine();
            System.out.println("Pil: ");
            String battery = input.nextLine();
            System.out.println("RAM: ");
            String ram = input.nextLine();
            System.out.println("Renk: ");
            String color = input.nextLine();

            System.out.println("Ürün eklendi.");
            MobilePhone.mobilePhones.add(new MobilePhone(productName,price,new Brand(brand),screenSize,ram,storageCapacity,battery
                    ,color));


        }
        else if (productType==2) {
            System.out.println("Notebook özelliklerini sırasıyla giriniz.");

            System.out.println("Ürün Adı:");
            String productName = input.nextLine();
            System.out.println("Ürün Fiyatı: ");
            int price = input.nextInt();
            input.nextLine();

            listBrands();

            System.out.println("Seçeceğiniz markayı yazınız. ");
            System.out.println("-----------------------------------------");



            String brand = input.nextLine();
            String firstLatter;
            firstLatter = brand.substring(0,1).toUpperCase();

            brand = firstLatter+brand.substring(1);

            while (!Brand.brands.contains(new Brand(brand))){

                System.out.println("Geçersiz marka ismi. Lütfen tekrar deneyiniz.");
                brand = input.nextLine();
                firstLatter = brand.substring(0,1).toUpperCase();

                brand = firstLatter+brand.substring(1);


            }

            System.out.println("Depolama: ");

            String storageCapacity = input.nextLine();
            System.out.println("Ekran: ");
            String screenSize = input.nextLine();
            System.out.println("RAM: ");
            String ram = input.nextLine();

            System.out.println("Ürün eklendi.");

            NoteBook.noteBooks.add(new NoteBook(productName,price,new Brand(brand),screenSize,ram,storageCapacity));





        }

        Product.products.addAll(NoteBook.noteBooks);
        Product.products.addAll(MobilePhone.mobilePhones);


    }

    public void listAllProducts(int select){
        System.out.println("Ürün Listesi\n");

        System.out.format("%-15s%-35s%-15s%n","Ürün ID","Ürün Adı","Ürün Markası");
        for (Product product:Product.products){
            if(product.getID()==select){
                System.out.format("%-15s%-35s%-15s",product.getID(),product.getName(),product.getBrandInfo().getName());
            }
        }
        System.out.println();
    }

    public void listAllProducts(String select){
        System.out.println("Ürün Listesi\n");
        System.out.format("%-15s%-35s%-15s%n","Ürün ID","Ürün Adı","Ürün Markası");

        for (Product product:Product.products){
            if(product.brandInfo.getName().equalsIgnoreCase(select)){
                System.out.format("%-15s%-35s%-15s",product.getID(),product.getName(),product.getBrandInfo().getName());
            }
        }
        System.out.println();



    }

}