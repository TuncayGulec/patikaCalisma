import java.util.*;

public class Match {

    public List<String> ekle(){

        System.out.print("kac tane takım girmek istiyorsunuz: ");
        Scanner adet= new Scanner(System.in);
        int takimSayisi= adet.nextInt();

        List<String> takim= new ArrayList<>();
        if(takimSayisi%2!=0){
            takim.add("bay");
        }

        for(int i=0;i<takimSayisi;i++){
            String takimEkle;
            System.out.print((i+1)+". takım: ");
            takimEkle=adet.next();
            takim.add(takimEkle);
        }
        Collections.shuffle(takim);
        return takim;

    }


    public List<String> eslestir(List<String> eklenti){

        List<String> eslesmeler = new ArrayList<>();
        List<String> takimlar= eklenti;


        int takimSayisi = takimlar.size();
        int turSayisi = takimSayisi - 1;
        int turBasiEslesmeSayisi = takimSayisi / 2;

        for (int tur = 0; tur < turSayisi; tur++) {
            StringBuilder eslesme = new StringBuilder("Tur " + (tur + 1) + ": ");

            for (int eslesmeSayisi = 0; eslesmeSayisi < turBasiEslesmeSayisi; eslesmeSayisi++) {
                String evSahibiTakim = takimlar.get(eslesmeSayisi);
                String deplasmanTakim = takimlar.get(takimSayisi - 1 - eslesmeSayisi);
                eslesme.append(evSahibiTakim).append(" vs ").append(deplasmanTakim).append(", ");
            }

            eslesmeler.add(eslesme.toString());
            Collections.rotate(takimlar.subList(1, takimSayisi), 1); // Takımları döndür

        }

        return eslesmeler;


    }
    public void print(){
        List<String> takim=ekle();

        System.out.println("---------- takımlar ---------");
        for(String y:takim){
            System.out.println(y);
        }
        List<String> esit=eslestir(takim);
        System.out.println();
        System.out.println("---------- eşleşmeler -----------");
        for (String e: esit){
            System.out.println(e);
        }
    }

}
