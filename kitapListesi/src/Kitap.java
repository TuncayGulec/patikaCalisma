public class Kitap {
    private String kitapAd;
    private int sayfaSayisi;
    private String yazarAdi;
    private String yayinTarihi;

    public Kitap(String kitapAd, int sayfaSayisi, String yazarAdi, String yayinTarihi) {
        this.kitapAd = kitapAd;
        this.sayfaSayisi = sayfaSayisi;
        this.yazarAdi = yazarAdi;
        this.yayinTarihi = yayinTarihi;
    }

    public String getKitapAd() {
        return this.kitapAd;
    }

    public void setKitapAd(String kitapAd) {
        this.kitapAd = kitapAd;
    }

    public int getSayfaSayisi() {
        return this.sayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    public String getYazarAdi() {
        return this.yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public String getYayinTarihi() {
        return this.yayinTarihi;
    }

    public void setYayinTarihi(String yayinTarihi) {
        this.yayinTarihi = yayinTarihi;
    }
}
