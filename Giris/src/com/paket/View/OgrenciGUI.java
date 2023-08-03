package com.paket.View;

import com.paket.Helper.Helper;
import com.paket.Helper.Titles;
import com.paket.Model.Course;
import com.paket.Model.Egitim;
import com.paket.Model.Patika;
import com.paket.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class OgrenciGUI extends JFrame {
    private JPanel wrapper;
    private JLabel JLabel1_giris_isim;
    private JButton ÇIKIŞButton;
    private JTabbedPane tabbedPane1;
    private JTable table1_ogr_egitim;
    private JButton DERSEKAYDOLButton;
    private JTable table1_ogr_sepet;
    private JTextField textField1_ogr_sepet_sil;
    private JButton EĞİTİMİSİLButton;
    private DefaultTableModel dfl_tbl_mdl_ogr_icrk;
    private Object[] obj_ogr_icrk;
    private DefaultTableModel getDfl_tbl_mdl_ogr_spt;
    private Object[] obj_ogr_spt;
    private ArrayList arrayList;

    private String egitimAdi;

    private String egitimId;
    private String kAdi;



    public OgrenciGUI(String kAdi) {
        this.kAdi=kAdi;

        add(wrapper);
        setSize(800, 400);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Titles.PROJECT_TİTLE);
        setResizable(false);
        setVisible(true);

        ÇIKIŞButton.addActionListener(e -> {
            dispose();
            LoginGUI loginGUI = new LoginGUI();
        });
        dfl_tbl_mdl_ogr_icrk = new DefaultTableModel();
        Object[] icerikHeader = {"No","Ders Adı", "Patika Adı", "Ders Dili", "Eğitmen"};
        dfl_tbl_mdl_ogr_icrk.setColumnIdentifiers(icerikHeader);
        obj_ogr_icrk = new Object[icerikHeader.length];
        table1_ogr_egitim.setModel(dfl_tbl_mdl_ogr_icrk);
        table1_ogr_egitim.getColumnModel().getColumn(0).setMaxWidth(50);
        table1_ogr_egitim.getTableHeader().setReorderingAllowed(false);
        icerikAl();

        table1_ogr_egitim.getSelectionModel().addListSelectionListener(e -> {
            try{
                if(!e.getValueIsAdjusting()){
                    egitimId=table1_ogr_egitim.getValueAt(table1_ogr_egitim.getSelectedRow(),0).toString();

                    egitimAdi=table1_ogr_egitim.getValueAt(table1_ogr_egitim.getSelectedRow(),1).toString();


                }
            }catch(Exception excp){
                System.out.println(excp.getMessage());
            }
        });
        DERSEKAYDOLButton.addActionListener(e -> {
            dersEkle();
            icerikYenile();
        });

        getDfl_tbl_mdl_ogr_spt= new DefaultTableModel();
        Object[] sepetHeader={"Başlık","Açıklama","Video Link","Quiz","Bilgi"};
        getDfl_tbl_mdl_ogr_spt.setColumnIdentifiers(sepetHeader);
        obj_ogr_spt= new Object[sepetHeader.length];
        table1_ogr_sepet.setModel(getDfl_tbl_mdl_ogr_spt);
        table1_ogr_sepet.getTableHeader().setReorderingAllowed(false);
        icerikYenile();
    }
    public void dersEkle(){

        try{
            if(egitimAdi==null){
                Helper.showMessage("Lütfen tablodan bir seçim yapın");
            }
            else{

                if(Egitim.add(kAdi,egitimId,egitimAdi)){
                    Helper.showMessage("done");
                }
                else{
                    Helper.showMessage("error");
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void icerikAl() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table1_ogr_egitim.getModel();
        defaultTableModel.setRowCount(0);
        int i;

        for (Course c : Course.getList()) {
            i=0;
            obj_ogr_icrk[i++]=c.getEducetor().getId();
            obj_ogr_icrk[i++]=c.getName();
            obj_ogr_icrk[i++]=c.getPatika().getAd();
            obj_ogr_icrk[i++]=c.getLang();
            obj_ogr_icrk[i++]=c.getEducetor().getAd();

            defaultTableModel.addRow(obj_ogr_icrk);
        }
    }
    public void icerikYenile(){
        DefaultTableModel defaultTableModel=(DefaultTableModel) table1_ogr_sepet.getModel();
        defaultTableModel.setRowCount(0);
        User user=User.getFetch(kAdi);

        int i;
        for(Egitim e:Egitim.select(user.getId())){
            i=0;
            obj_ogr_spt[i++]=e.getBaslik();
            obj_ogr_spt[i++]=e.getAciklama();
            obj_ogr_spt[i++]=e.getVideolink();
            obj_ogr_spt[i++]=e.getQuiz();
            obj_ogr_spt[i++]=e.getBilgi();
            getDfl_tbl_mdl_ogr_spt.addRow(obj_ogr_spt);
        }
    }



    public static void main(String[] args) {
        Helper.setLayouts();
        OgrenciGUI ogrenci = new OgrenciGUI("");
    }
}
