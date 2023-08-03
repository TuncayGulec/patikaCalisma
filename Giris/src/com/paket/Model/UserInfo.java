package com.paket.Model;

import com.paket.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserInfo {

    private int id;
    private String egitmen_no;
    private String icerik_baslik;
    private String icerik_aciklama ;
    private String icerik_youtube_link;
    private String icerik_quiz;
    private String icerik_bilgi;
    public UserInfo(){}
    public UserInfo(int id, String egitmen_no, String icerik_baslik, String icerik_aciklama, String icerik_youtube_link, String icerik_quiz, String icerik_bilgi) {
        this.id = id;
        this.egitmen_no=egitmen_no;
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
    public String getEgitmen_no(){
        return this.egitmen_no;
    }
    public void setEgitmen_no(String egitmen_no){
        this.egitmen_no=egitmen_no;
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

    public static ArrayList<UserInfo> getFetch(int egitmen_no){
        ArrayList<UserInfo> arrayList=new ArrayList<>();
        String query="SELECT * FROM ders WHERE egitmen_no="+egitmen_no;
        UserInfo userInfo;
        try {
            Statement st= DBConnector.baglantiYap().createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                userInfo= new UserInfo();
                userInfo.id=rs.getInt("id");
                userInfo.egitmen_no=rs.getString("egitmen_no");
                userInfo.icerik_baslik=rs.getString("icerik_baslik");
                userInfo.icerik_aciklama=rs.getString("icerik_aciklama");
                userInfo.icerik_youtube_link=rs.getString("icerik_youtube_link");
                userInfo.icerik_quiz=rs.getString("icerik_quiz");
                userInfo.icerik_bilgi=rs.getString("icerik_bilgi");
                arrayList.add(userInfo);

            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
    public static ArrayList<UserInfo> getFetch(){
        ArrayList<UserInfo> arrayList=new ArrayList<>();
        String query="SELECT * FROM ders";
        UserInfo userInfo;
        try {
            Statement st= DBConnector.baglantiYap().createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                userInfo= new UserInfo();
                userInfo.id=rs.getInt("id");
                userInfo.egitmen_no=rs.getString("egitmen_no");
                userInfo.icerik_baslik=rs.getString("icerik_baslik");
                userInfo.icerik_aciklama=rs.getString("icerik_aciklama");
                userInfo.icerik_youtube_link=rs.getString("icerik_youtube_link");
                userInfo.icerik_quiz=rs.getString("icerik_quiz");
                userInfo.icerik_bilgi=rs.getString("icerik_bilgi");
                arrayList.add(userInfo);

            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
    public static boolean add(String egitmen_no,String icerik_baslik,String icerik_aciklama,String icerik_youtube_link,String icerik_quiz,String icerik_bilgi){

        String query="INSERT INTO ders (egitmen_no,icerik_baslik,icerik_aciklama,icerik_youtube_link,icerik_quiz,icerik_bilgi) VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement ps= DBConnector.baglantiYap().prepareStatement(query);
            ps.setString(1,egitmen_no);
            ps.setString(2,icerik_baslik);
            ps.setString(3,icerik_aciklama);
            ps.setString(4,icerik_youtube_link);
            ps.setString(5,icerik_quiz);
            ps.setString(6,icerik_bilgi);
            return ps.executeUpdate() != -1;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static boolean delete(int id){
        String query="DELETE FROM ders WHERE id=?";
        try{
            PreparedStatement ps= DBConnector.baglantiYap().prepareStatement(query);
            ps.setInt(1,id);
            return ps.executeUpdate() != -1;

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static boolean update(String icerik_baslik,String icerik_aciklama,String icerik_youtube_link,String icerik_quiz, String icerik_bilgi, int id){
        String query="UPDATE ders SET icerik_baslik=?,icerik_aciklama=?,icerik_youtube_link=?,icerik_quiz=?,icerik_bilgi=? WHERE id=?";
        try{
            PreparedStatement ps= DBConnector.baglantiYap().prepareStatement(query);
            ps.setString(1,icerik_baslik);
            ps.setString(2,icerik_aciklama);
            ps.setString(3,icerik_youtube_link);
            ps.setString(4,icerik_quiz);
            ps.setString(5,icerik_bilgi);
            ps.setInt(6,id);
            return ps.executeUpdate() != -1;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }

}
