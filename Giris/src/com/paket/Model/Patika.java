package com.paket.Model;

import com.paket.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Patika {
    private int id;
    private String ad;

    public Patika(int id, String ad){
        this.id=id;
        this.ad=ad;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAd() {
        return ad;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }
    public static ArrayList<Patika> getList(){
        ArrayList<Patika> patikaList= new ArrayList<>();
        String query="SELECT * FROM patika";
        Patika obj;
        try{
            Statement st= DBConnector.baglantiYap().createStatement();
            ResultSet rs= st.executeQuery(query);
            while(rs.next()){
                obj= new Patika(rs.getInt("id"),rs.getString("ad"));
                patikaList.add(obj);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return patikaList;
    }
    public static boolean add(String name){
        String query="INSERT INTO patika (ad) VALUES (?)";
        try {
            PreparedStatement ps=DBConnector.baglantiYap().prepareStatement(query);
            ps.setString(1,name);
            return ps.executeUpdate() !=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static boolean update(int id, String ad){
        String query="UPDATE patika SET ad=? WHERE id=?";
        try {
            PreparedStatement ps =DBConnector.baglantiYap().prepareStatement(query);
            ps.setInt(2,id);
            ps.setString(1,ad);
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static Patika getFecht(int id){
        Patika obj = null;
        String query="SELECT * FROM patika WHERE id=?";
        try{
            PreparedStatement ps =DBConnector.baglantiYap().prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                obj= new Patika(rs.getInt("id"),rs.getString("ad"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return obj;
    }
    public static boolean delete(int id) {
        String query= "DELETE FROM patika WHERE id=?";
        ArrayList<Course> courseList= Course.getList();
        for (Course c: courseList){
            if(c.getPatika().getId()==c.getPatika_id()){
                Course.deletePatika(id);
            }
        }
        try {
            PreparedStatement ps= DBConnector.baglantiYap().prepareStatement(query);
            ps.setInt(1,id);
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return true;
    }
}
