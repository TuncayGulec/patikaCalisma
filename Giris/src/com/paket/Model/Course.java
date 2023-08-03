package com.paket.Model;

import com.paket.Helper.DBConnector;
import com.paket.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course {
    private int id;
    private int user_id;
    private int patika_id;
    private String name;
    private String lang;
    private Patika patika;
    private User educetor;

    public Course(){

    }

    public Course(int id, int user_id, int patika_id, String name, String lang) {
        this.id = id;
        this.user_id = user_id;
        this.patika_id = patika_id;
        this.name = name;
        this.lang = lang;
        this.patika=Patika.getFecht(patika_id);
        this.educetor=User.getFetch(user_id);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPatika_id() {
        return this.patika_id;
    }

    public void setPatika_id(int patika_id) {
        this.patika_id = patika_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Patika getPatika() {
        return this.patika;
    }

    public void setPatika(Patika patika) {
        this.patika = patika;
    }

    public User getEducetor() {
        return this.educetor;
    }

    public void setEducetor(User educetor) {
        this.educetor = educetor;
    }
    public static ArrayList<Course> getList(){
        ArrayList<Course> obj= new ArrayList<>();
        String query= "SELECT * FROM kurs";
        Course crs;
        try {
            Statement st = DBConnector.baglantiYap().createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                crs= new Course(rs.getInt("id"),rs.getInt("user_id"),rs.getInt("patika_id"),rs.getString("name"),rs.getString("lang"));
                obj.add(crs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }
    public static boolean add(int user_id,int patika_id,String name, String lang){
        String query="INSERT INTO kurs (user_id,patika_id,name,lang) VALUES (?,?,?,?)";
        Course c=Course.getListUser(user_id);
        if(c.getName()!=null){
            Helper.showMessage("Böyle bir kayır var");
            return false;
        }
        try {
            PreparedStatement ps=DBConnector.baglantiYap().prepareStatement(query);
            ps.setInt(1,user_id);
            ps.setInt(2,patika_id);
            ps.setString(3,name);
            ps.setString(4,lang);
            return ps.executeUpdate() != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
    public static ArrayList<Course> getListByUser(int user_id){
        ArrayList<Course> courseList= new ArrayList<>();
        Course obj;
        String query= "SELECT * FROM kurs WHERE user_id=?";
        try {
            PreparedStatement st = DBConnector.baglantiYap().prepareStatement(query);
            st.setInt(1,user_id);
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                int id= rs.getInt("id");
                int user_ID=rs.getInt("user_id");
                int patika_id= rs.getInt("patika_id");
                String name=rs.getString("name");
                String lang = rs.getString("lang");
                obj= new Course(id,user_ID,patika_id,name,lang);
                courseList.add(obj);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return courseList;
    }
    public static Course getListUser(int user_id){

        Course obj=null;
        String query= "SELECT * FROM kurs WHERE user_id=?";
        try {
            PreparedStatement st = DBConnector.baglantiYap().prepareStatement(query);
            st.setInt(1,user_id);
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                int id= rs.getInt("id");
                int user_ID=rs.getInt("user_id");
                int patika_id= rs.getInt("patika_id");
                String name=rs.getString("name");
                String lang = rs.getString("lang");
                obj= new Course(id,user_ID,patika_id,name,lang);


            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }

    public static boolean deleteUser(int Id){
        String query="DELETE FROM kurs WHERE user_id=?";

        try {
            PreparedStatement ps= DBConnector.baglantiYap().prepareStatement(query);
            ps.setInt(1,Id);
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static boolean deletePatika(int Id){
        String query="DELETE FROM kurs WHERE patika_id=?";

        try {
            PreparedStatement ps= DBConnector.baglantiYap().prepareStatement(query);
            ps.setInt(1,Id);
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
