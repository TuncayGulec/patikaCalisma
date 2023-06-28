

public class Book{

    private String kitapAdi;
    private String yazarAdi;
    private int sayfaSayisi;
    private String yayinTarihi;

    public Book(String kitapAdi, String yazarAdi, int sayfaSayisi, String yayinTarihi) {
        this.kitapAdi = kitapAdi;
        this.yazarAdi = yazarAdi;
        this.sayfaSayisi = sayfaSayisi;
        this.yayinTarihi = yayinTarihi;
    }

    public String getKitapAdi() {
        return this.kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getYazarAdi() {
        return this.yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    public String getYayinTarihi() {
        return yayinTarihi;
    }

    public void setYayinTarihi(String yayinTarihi) {
        this.yayinTarihi = yayinTarihi;
    }



}
