import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Kitap> kitapListesi = new ArrayList<>();
        kitapListesi.add(new Kitap("yeşil vadi", 50, "ali", "2020"));
        kitapListesi.add(new Kitap("keloğlan", 200, "mehmet", "2019"));
        kitapListesi.add(new Kitap("alibaba", 120, "murat", "2021"));
        kitapListesi.add(new Kitap("istanbul", 250, "hasan", "2018"));
        kitapListesi.add(new Kitap("kara gece", 80, "veli", "2022"));
        kitapListesi.add(new Kitap("mavi gökyüzü", 180, "hacı", "2017"));
        kitapListesi.add(new Kitap("su perisi", 300, "mert", "2016"));
        kitapListesi.add(new Kitap("teneke adam", 100, "mustafa", "2023"));
        kitapListesi.add(new Kitap("alice", 220, "ahmet", "2015"));
        kitapListesi.add(new Kitap("çınar", 150, "ayşe", "2024"));

        Map<String,String> kitapMap=kitapListesi.stream().collect(Collectors.toMap(Kitap::getKitapAd,Kitap::getYazarAdi));
        for(Map.Entry<String,String> keyValue:kitapMap.entrySet() ){
            System.out.println("Kitap: "+keyValue.getKey()+" - Yazar: "+keyValue.getValue());
        }

        List<Kitap> kitapFiltrele=kitapListesi.stream().filter(kitap -> kitap.getSayfaSayisi()>100).collect(Collectors.toList());

        System.out.println("-----------------------------");
        System.out.println("sayfa sayısı 100'den fazla olan kitaplar: ");
        for(Kitap k:kitapFiltrele){
            System.out.println(k.getKitapAd());
        }
    }
}