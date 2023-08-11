package com.paket.Model;

import com.paket.Operational.Operator;
import com.paket.Static.Complements;
import com.paket.Static.DataBase;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OtelKayit {
    private String otelKod;
    private String otelAd;
    private String adres;
    private String telefon;
    private String eposta;
    private String yildiz;
    private String tip;
    private String tesisOzellik;
    private String odaSayisi;
    private String odaTip;
    private String yatakSayi;
    private String metrekare;
    private String televizyon;
    private String minibar;
    private String oyunkonsol;

    public OtelKayit() {
    }

    public OtelKayit(String otelKod, String otelAd, String adres, String telefon, String eposta, String yildiz, String tip, String tesisOzellik, String odaSayisi, String odaTip, String yatakSayi, String metrekare, String televizyon, String minibar, String oyunkonsol) {
        this.otelKod=otelKod;
        this.otelAd = otelAd;
        this.adres = adres;
        this.telefon = telefon;
        this.eposta = eposta;
        this.yildiz = yildiz;
        this.tip = tip;
        this.tesisOzellik = tesisOzellik;
        this.odaSayisi = odaSayisi;
        this.odaTip = odaTip;
        this.yatakSayi = yatakSayi;
        this.metrekare = metrekare;
        this.televizyon = televizyon;
        this.minibar = minibar;
        this.oyunkonsol = oyunkonsol;
    }

    public String getOtelKod() {
        return this.otelKod;
    }

    public void setOtelKod(String otelKod) {
        this.otelKod = otelKod;
    }

    public String getOtelAd() {
        return this.otelAd;
    }

    public void setOtelAd(String otelAd) {
        this.otelAd = otelAd;
    }

    public String getAdres() {
        return this.adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return this.telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEposta() {
        return this.eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getYildiz() {
        return this.yildiz;
    }

    public void setYildiz(String yildiz) {
        this.yildiz = yildiz;
    }

    public String getTip() {
        return this.tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getTesisOzellik() {
        return this.tesisOzellik;
    }

    public void setTesisOzellik(String tesisOzellik) {
        this.tesisOzellik = tesisOzellik;
    }

    public String getOdaSayisi() {
        return this.odaSayisi;
    }

    public void setOdaSayisi(String odaSayisi) {
        this.odaSayisi = odaSayisi;
    }

    public String getOdaTip() {
        return this.odaTip;
    }

    public void setOdaTip(String odaTip) {
        this.odaTip = odaTip;
    }

    public String getYatakSayi() {
        return this.yatakSayi;
    }

    public void setYatakSayi(String yatakSayi) {
        this.yatakSayi = yatakSayi;
    }

    public String getMetrekare() {
        return this.metrekare;
    }

    public void setMetrekare(String metrekare) {
        this.metrekare = metrekare;
    }

    public String getTelevizyon() {
        return this.televizyon;
    }

    public void setTelevizyon(String televizyon) {
        this.televizyon = televizyon;
    }

    public String getMinibar() {
        return this.minibar;
    }

    public void setMinibar(String minibar) {
        this.minibar = minibar;
    }

    public String getOyunkonsol() {
        return this.oyunkonsol;
    }

    public void setOyunkonsol(String oyunkonsol) {
        this.oyunkonsol = oyunkonsol;
    }

    public static boolean add(String otelKod,String otelAd, String adres, String telefon, String eposta, String yildiz, String tip, String tesisOzellik, String odaSayisi, String odaTip, String yatakSayi, String metrekare, String televizyon, String minibar, String oyunkonsol) {
        String query = "INSERT INTO otelekle (otelKod,otelAd,adres,telefon,eposta,yildiz,tip,tesisOzellik,odaSayisi,odatip,yatakSayi,metrekare,televizyon,minibar,oyunkonsol) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DataBase.baglantiYap().prepareStatement(query);
            ps.setString(1,otelKod);
            ps.setString(2, otelAd);
            ps.setString(3, adres);
            ps.setString(4, telefon);
            ps.setString(5, eposta);
            ps.setString(6, yildiz);
            ps.setString(7, tip);
            ps.setString(8, tesisOzellik);
            ps.setString(9, odaSayisi);
            ps.setString(10, odaTip);
            ps.setString(11, yatakSayi);
            ps.setString(12, metrekare);
            ps.setString(13, televizyon);
            ps.setString(14, minibar);
            ps.setString(15, oyunkonsol);
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static ArrayList<OtelKayit> select() {
        String query = "SELECT * FROM otelekle";
        ArrayList<OtelKayit> arrayList= new ArrayList<>();
        OtelKayit otelKayit;
        try {
            Statement st = DataBase.baglantiYap().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                otelKayit = new OtelKayit();
                otelKayit.setOtelKod(rs.getString("otelKod"));
                otelKayit.setOtelAd(rs.getString("otelAd"));
                otelKayit.setAdres(rs.getString("adres"));
                otelKayit.setTelefon(rs.getString("telefon"));
                otelKayit.setEposta(rs.getString("eposta"));
                otelKayit.setYildiz(rs.getString("yildiz"));
                otelKayit.setTip(rs.getString("tip"));
                otelKayit.setTesisOzellik(rs.getString("tesisOzellik"));
                otelKayit.setOdaSayisi(rs.getString("odaSayisi"));
                otelKayit.setOdaTip(rs.getString("odaTip"));
                otelKayit.setYatakSayi(rs.getString("yatakSayi"));
                otelKayit.setMetrekare(rs.getString("metrekare"));
                otelKayit.setTelevizyon(rs.getString("televizyon"));
                otelKayit.setMinibar(rs.getString("minibar"));
                otelKayit.setOyunkonsol(rs.getString("oyunkonsol"));
                arrayList.add(otelKayit);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
}
