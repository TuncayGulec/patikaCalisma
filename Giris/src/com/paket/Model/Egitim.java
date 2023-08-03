package com.paket.Model;

import com.paket.Helper.DBConnector;
import com.paket.Helper.Helper;
import org.w3c.dom.ls.LSOutput;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Egitim {
    private int id;
    private int ogr_id;
    private int akdm_id;
    private String baslik;
    private String aciklama;
    private String videolink;
    private String quiz;
    private String bilgi;
    private String kAdi;
    int OId;
    public Egitim(){}

    public Egitim(int id, int ogr_id,int akdm_id, String baslik, String aciklama, String videolink, String quiz, String bilgi) {
        this.id = id;
        this.ogr_id = ogr_id;
        this.akdm_id=akdm_id;
        this.baslik = baslik;
        this.aciklama = aciklama;
        this.videolink = videolink;
        this.quiz = quiz;
        this.bilgi = bilgi;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOgr_id() {
        return this.ogr_id;
    }

    public void setOgr_id(int ogr_id) {
        this.ogr_id = ogr_id;
    }

    public int getAkdm_id() {
        return this.akdm_id;
    }

    public void setAkdm_id(int akdm_id) {
        this.akdm_id = akdm_id;
    }

    public String getBaslik() {
        return this.baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAciklama() {
        return this.aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getVideolink() {
        return this.videolink;
    }

    public void setVideolink(String videolink) {
        this.videolink = videolink;
    }

    public String getQuiz() {
        return this.quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public String getBilgi() {
        return this.bilgi;
    }

    public void setBilgi(String bilgi) {
        this.bilgi = bilgi;
    }

    public String getkAdi() {
        return this.kAdi;
    }

    public void setkAdi(String kAdi) {
        this.kAdi = kAdi;
    }

    public static boolean add(String ogrK_ad, String egtm_id, String eBaslik){

        User user=User.getFetch(ogrK_ad);
        Egitim egitim=Egitim.select2(eBaslik);
        int egtm=Integer.parseInt(egtm_id);
        Ders ders=Ders.select(egtm);
        String query="INSERT INTO calisma (ogr_id,akdm_id,baslik ,aciklama ,videolink ,quiz ,bilgi) VALUES (?,?,?,?,?,?,?)";

        try{
            PreparedStatement ps=DBConnector.baglantiYap().prepareStatement(query);
            ps.setInt(1,user.getId());
            ps.setInt(2,Integer.parseInt(egtm_id));
            ps.setString(3, ders.getIcerik_baslik());
            ps.setString(4,ders.getIcerik_aciklama());
            ps.setString(5, ders.getIcerik_youtube_link());
            ps.setString(6, ders.getIcerik_quiz());
            ps.setString(7, ders.getIcerik_bilgi());
            return ps.executeUpdate() != -1;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return true;
    }
    public static ArrayList<Egitim> select(int id){
        String query="SELECT * FROM calisma WHERE ogr_id=?";
        ArrayList<Egitim> arrayList= new ArrayList<>();
        Egitim obj;
        try{
            PreparedStatement ps =DBConnector.baglantiYap().prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                obj=new Egitim(rs.getInt("id"),rs.getInt("ogr_id"),rs.getInt("akdm_id"),rs.getString("baslik"), rs.getString("aciklama"), rs.getString("videolink"),rs.getString("quiz"),rs.getString("bilgi"));
                arrayList.add(obj);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
    public static Egitim select2(String baslik){
        String query="SELECT * FROM calisma WHERE baslik=?";
        //ArrayList<Egitim> arrayList= new ArrayList<>();
        Egitim obj=null;
        try{
            PreparedStatement ps =DBConnector.baglantiYap().prepareStatement(query);
            ps.setString(1,baslik);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                obj=new Egitim(rs.getInt("id"),rs.getInt("ogr_id"),rs.getInt("akdm_id"),rs.getString("baslik"), rs.getString("aciklama"), rs.getString("videolink"),rs.getString("quiz"),rs.getString("bilgi"));
                //arrayList.add(obj);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return obj;
    }/*
    public static Egitim select2(int Id){
        String query="SELECT * FROM ders WHERE egitmen_no=?";
        //ArrayList<Egitim> arrayList= new ArrayList<>();
        Egitim obj=null;
        try{
            PreparedStatement ps =DBConnector.baglantiYap().prepareStatement(query);
            ps.setInt(1,Id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                obj=new Egitim(rs.getInt("id"),rs.getInt("ogr_id"),rs.getInt("akdm_id"),rs.getString("baslik"), rs.getString("aciklama"), rs.getString("videolink"),rs.getString("quiz"),rs.getString("bilgi"));
                //arrayList.add(obj);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return obj;
    }
    public static Egitim select2(){
        String query="SELECT * FROM calisma";
        //ArrayList<Egitim> arrayList= new ArrayList<>();
        Egitim obj=null;
        try{
            PreparedStatement ps =DBConnector.baglantiYap().prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                obj=new Egitim(rs.getInt("id"),rs.getInt("ogr_id"),rs.getInt("akdm_id"),rs.getString("baslik"), rs.getString("aciklama"), rs.getString("videolink"),rs.getString("quiz"),rs.getString("bilgi"));
                //arrayList.add(obj);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return obj;
    }*/
}
