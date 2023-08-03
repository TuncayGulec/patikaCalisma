package com.paket.Model;

import com.paket.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ders {
    private int id;
    private int egitmen_no;
    private String icerik_baslik;
    private String icerik_aciklama;
    private String icerik_youtube_link;
    private String icerik_quiz;
    private String icerik_bilgi;

    public Ders(){}
    public Ders(int id, int egitmen_no, String icerik_baslik, String icerik_aciklama, String icerik_youtube_link, String icerik_quiz, String icerik_bilgi) {
        this.id = id;
        this.egitmen_no = egitmen_no;
        this.icerik_baslik = icerik_baslik;
        this.icerik_aciklama = icerik_aciklama;
        this.icerik_youtube_link = icerik_youtube_link;
        this.icerik_quiz = icerik_quiz;
        this.icerik_bilgi = icerik_bilgi;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEgitmen_no() {
        return this.egitmen_no;
    }

    public void setEgitmen_no(int egitmen_no) {
        this.egitmen_no = egitmen_no;
    }

    public String getIcerik_baslik() {
        return this.icerik_baslik;
    }

    public void setIcerik_baslik(String icerik_baslik) {
        this.icerik_baslik = icerik_baslik;
    }

    public String getIcerik_aciklama() {
        return this.icerik_aciklama;
    }

    public void setIcerik_aciklama(String icerik_aciklama) {
        this.icerik_aciklama = icerik_aciklama;
    }

    public String getIcerik_youtube_link() {
        return this.icerik_youtube_link;
    }

    public void setIcerik_youtube_link(String icerik_youtube_link) {
        this.icerik_youtube_link = icerik_youtube_link;
    }

    public String getIcerik_quiz() {
        return this.icerik_quiz;
    }

    public void setIcerik_quiz(String icerik_quiz) {
        this.icerik_quiz = icerik_quiz;
    }

    public String getIcerik_bilgi() {
        return this.icerik_bilgi;
    }

    public void setIcerik_bilgi(String icerik_bilgi) {
        this.icerik_bilgi = icerik_bilgi;
    }

    public static Ders select(int kAdi){
        String query="SELECT * FROM ders WHERE egitmen_no=?";
        Ders ders=null;
        try{
            PreparedStatement ps= DBConnector.baglantiYap().prepareStatement(query);
            ps.setInt(1,kAdi);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                ders= new Ders();
                ders.setId(rs.getInt("id"));
                ders.setEgitmen_no(rs.getInt("egitmen_no"));
                ders.setIcerik_baslik(rs.getString("icerik_baslik"));
                ders.setIcerik_aciklama(rs.getString("icerik_aciklama"));
                ders.setIcerik_youtube_link(rs.getString("icerik_youtube_link"));
                ders.setIcerik_quiz(rs.getString("icerik_quiz"));
                ders.setIcerik_bilgi(rs.getString("icerik_bilgi"));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ders;
    }

}
