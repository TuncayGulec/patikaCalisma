package com.paket.Model;

import com.paket.Helper.DBConnector;
import com.paket.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int id;
    private String ad;
    private String k_ad;
    private String k_pass;
    private String type;

    public User(){}
    public User(int id, String ad, String k_ad, String k_pass, String type) {
        this.id = id;
        this.ad = ad;
        this.k_ad = k_ad;
        this.k_pass = k_pass;
        this.type = type;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return this.ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getK_ad() {
        return this.k_ad;
    }

    public void setK_ad(String k_ad) {
        this.k_ad = k_ad;
    }

    public String getK_pass() {
        return this.k_pass;
    }

    public void setK_pass(String k_pass) {
        this.k_pass = k_pass;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User>getList(){
        ArrayList<User>userList= new ArrayList<>();
        String query="SELECT * FROM kullanici";
        User us;
        try {
            Statement st= DBConnector.baglantiYap().createStatement();
            ResultSet rs= st.executeQuery(query);
            while (rs.next()){
                us=new User();
                us.setId(rs.getInt("id"));
                us.setAd(rs.getString("ad"));
                us.setK_ad(rs.getString("k_ad"));
                us.setK_pass(rs.getString("k_pass"));
                us.setType(rs.getString("type"));
                userList.add(us);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
    public static boolean add(String ad,String k_ad, String k_pass, String type){

        String query="INSERT INTO kullanici(ad,k_ad,k_pass,type) VALUES(?,?,?,?)";
        User findUser= User.getFetch(k_ad);
        if(findUser!=null){
            Helper.showMessage("Böyle bir kullanıcı mevcut, başka bir kullanıcı adı deneyin..");
            return false;
        }
        try {
            PreparedStatement ps=DBConnector.baglantiYap().prepareStatement(query);
            ps.setString(1,ad);
            ps.setString(2,k_ad);
            ps.setString(3,k_pass);
            ps.setString(4,type);

            int response= ps.executeUpdate();
            if(response==-1){
                Helper.showMessage("error");
            }
            return response != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static User getFetch(String k_adi){
        User u=null;
        String query="SELECT * FROM kullanici WHERE k_ad=?";
        try {
            PreparedStatement ps=DBConnector.baglantiYap().prepareStatement(query);
            ps.setString(1,k_adi);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                u= new User();
                u.setId(rs.getInt("id"));
                u.setAd(rs.getString("ad"));
                u.setK_ad(rs.getString("k_ad"));
                u.setK_pass(rs.getString("k_pass"));
                u.setType(rs.getString("type"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return u;
    }
    public static User getListID(){
        //ArrayList<User> arrayList= new ArrayList<>();
        User u=null;
        String query="SELECT * FROM kullanici WHERE type='Akademik'";
        try {
            PreparedStatement ps=DBConnector.baglantiYap().prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                u= new User();
                u.setId(rs.getInt("id"));
                u.setAd(rs.getString("ad"));
                u.setK_ad(rs.getString("k_ad"));
                u.setK_pass(rs.getString("k_pass"));
                u.setType(rs.getString("type"));
                //arrayList.add(u);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return u;
    }

    public static User getFetch(String k_adi, String k_pass){
        User u=null;
        String query="SELECT * FROM kullanici WHERE k_ad=? AND k_pass=?";
        try {
            PreparedStatement ps=DBConnector.baglantiYap().prepareStatement(query);
            ps.setString(1,k_adi);
            ps.setString(2,k_pass);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                switch (rs.getString("type")){
                    case "Operator":
                        u= new Operator();
                        break;
                    default:
                        u= new User();
                }
                u.setId(rs.getInt("id"));
                u.setAd(rs.getString("ad"));
                u.setK_ad(rs.getString("k_ad"));
                u.setK_pass(rs.getString("k_pass"));
                u.setType(rs.getString("type"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return u;
    }
    public static User getFetch(int id){

        User obj= new User();
        String query="SELECT * FROM kullanici WHERE id=?";
        try {
            PreparedStatement ps=DBConnector.baglantiYap().prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){

                obj.setId(rs.getInt("id"));
                obj.setAd(rs.getString("ad"));
                obj.setK_ad(rs.getString("k_ad"));
                obj.setK_pass(rs.getString("k_pass"));
                obj.setType(rs.getString("type"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }
    public static boolean deleteUser(int Id){
        String query="DELETE FROM kullanici WHERE id=?";
        ArrayList<Course> courseList=Course.getListByUser(Id);
        for(Course c:courseList){
            Course.deleteUser(c.getUser_id());
        }
        try {
            PreparedStatement ps= DBConnector.baglantiYap().prepareStatement(query);
            ps.setInt(1,Id);
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static boolean update(int id, String ad, String k_ad, String k_pass, String type){
        String query="UPDATE kullanici SET ad=?, k_ad=?, k_pass=?, type=? WHERE id=?";
        User findUser= User.getFetch(k_ad);
        if(findUser != null && findUser.getId() != id){
            Helper.showMessage("Böyle bir kullanıcı mevcut, başka bir kullanıcı adı deneyin..");
            return false;
        }
        try {
            PreparedStatement ps= DBConnector.baglantiYap().prepareStatement(query);
            ps.setString(1,ad);
            ps.setString(2,k_ad);
            ps.setString(3,k_pass);
            ps.setString(4,type);
            ps.setInt(5,id);
            return ps.executeUpdate()!=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static ArrayList<User> kullaniciAra(String query){
        ArrayList<User>userList= new ArrayList<>();

        User us;
        try {
            Statement st= DBConnector.baglantiYap().createStatement();
            ResultSet rs= st.executeQuery(query);
            while (rs.next()){
                us=new User();
                us.setId(rs.getInt("id"));
                us.setAd(rs.getString("ad"));
                us.setK_ad(rs.getString("k_ad"));
                us.setK_pass(rs.getString("k_pass"));
                us.setType(rs.getString("type"));
                userList.add(us);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;

    }
    public static String kullaniciQuery(String ad, String k_ad, String type){
        String query="SELECT * FROM kullanici WHERE ad LIKE '%{{ad}}%' AND k_ad LIKE '%{{ad}}%'";
        query=query.replace("{{ad}}",ad);
        query=query.replace("{{k_ad}}",k_ad);
        if(!type.isEmpty()){
            query+=" AND type ='{{type}}'";
            query=query.replace("{{type}}",type);
        }

        return query;
    }
    public static ArrayList<User>getListEducator(){
        ArrayList<User>userList= new ArrayList<>();
        String query="SELECT * FROM kullanici WHERE type='Akademik'";
        User us;
        try {
            Statement st= DBConnector.baglantiYap().createStatement();
            ResultSet rs= st.executeQuery(query);
            while (rs.next()){
                us=new User();
                us.setId(rs.getInt("id"));
                us.setAd(rs.getString("ad"));
                us.setK_ad(rs.getString("k_ad"));
                us.setK_pass(rs.getString("k_pass"));
                us.setType(rs.getString("type"));
                userList.add(us);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;

    }


}
