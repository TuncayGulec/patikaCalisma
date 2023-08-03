package com.paket.View;

import com.paket.Helper.Helper;
import com.paket.Helper.Item;
import com.paket.Helper.Titles;
import com.paket.Model.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tabbedPanel1;
    private JButton çıkışYapButton;
    private JLabel welcome;
    private JTable table1_kullanici;
    private JScrollPane kayarp_panel;
    private JTextField textField1_user_name;
    private JTextField textField1_user_K_name;
    private JPasswordField passwordField1_user_pass;
    private JComboBox comboBox1_type;
    private JButton button1_kayit_ekle;
    private JTextField textField1_user_ID_sil;
    private JButton button1_kullanici_Sil;
    private JTextField textField1_Kayit_Ara_AdSoyad;
    private JTextField textField1_Kayit_Ara_KullaniciAd;
    private JButton KAYITARAButton;
    private JComboBox comboBox1_Kayit_Ara_Tip;
    private JPanel JPanel_Patika_List;
    private JTable table1_patika;
    private JPanel panel1_user_list;
    private JPanel panel1_patika_list;
    private JPanel panel1_patika_add;
    private JTextField textField1_patika_ekle;
    private JButton button1_patika_ekle;
    private JPanel panel1_course_list;
    private JPanel JPanel_Uye_Islem;
    private JPanel JPanel_Uye_Ara;
    private JScrollPane JScrollPane_patika_list;
    private JTable table1_course_list;
    private JPanel JPanel_course_add;
    private JTextField textField1_course_name;
    private JTextField textField1_coruse_lang;
    private JComboBox comboBox1_Patika;
    private JComboBox comboBox1_User;
    private JButton button1_Course_Add;
    private JTable table1_opertr_icerik_list;
    private JTextField textField1_baslik;
    private JTextField textField2_aciklama;
    private JTextField textField3_youtube_lnk;
    private JTextField textField4_quiz;
    private JTextField textField5_bilgi;
    private JButton GÜNCELLEButton;
    private JTextField textField6_silinecek_kisi_id;
    private JButton SİLButton;
    private JButton TEMİZLEButton;
    private final Operator operator;
    private DefaultTableModel userList;
    private Object[] rowUserList;
    private DefaultTableModel patikaList;
    private Object[] rowPatikaList;
    private JPopupMenu patikaMenu;
    private DefaultTableModel courseList;
    private Object[] rowCourseList;
    private DefaultTableModel oprtr_icerik_model;
    private Object[] oprtr_icerik_obj;

    public OperatorGUI(Operator operator) {
        this.operator = operator;

        add(wrapper);
        setSize(1000, 520);
        int x = Helper.screenCenterPoint("x", getSize());
        int y = Helper.screenCenterPoint("y", getSize());
        setLocation(x, y);
        setTitle(Titles.PROJECT_TİTLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        welcome.setText("Hoşgeldin " + operator.getAd());

        userList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] kolonListe = {"Id", "Ad Soyad", "Kullanıcı Ad", "Kullanıcı Şifre", "Tip"};
        userList.setColumnIdentifiers(kolonListe);
        rowUserList = new Object[kolonListe.length];
        loadTableList();

        table1_kullanici.setModel(userList);
        table1_kullanici.getTableHeader().setReorderingAllowed(false);
        table1_kullanici.getSelectionModel().addListSelectionListener(e -> {
            try {
                if (!e.getValueIsAdjusting()) {
                    String select_user_Id = table1_kullanici.getValueAt(table1_kullanici.getSelectedRow(), 0).toString();
                    textField1_user_ID_sil.setText(select_user_Id);
                }
            } catch (Exception excp) {

            }

        });
        table1_kullanici.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int user_id = Integer.parseInt(table1_kullanici.getValueAt(table1_kullanici.getSelectedRow(), 0).toString());
                String user_ad = table1_kullanici.getValueAt(table1_kullanici.getSelectedRow(), 1).toString();
                String user_K_ad = table1_kullanici.getValueAt(table1_kullanici.getSelectedRow(), 2).toString();
                String user_K_pass = table1_kullanici.getValueAt(table1_kullanici.getSelectedRow(), 3).toString();
                String user_type = table1_kullanici.getValueAt(table1_kullanici.getSelectedRow(), 4).toString();

                if (User.update(user_id, user_ad, user_K_ad, user_K_pass, user_type)) {
                    Helper.showMessage("done");
                }
                loadTableList();
                loadEducatorCombo();
                loadCourseModel();

            }
        });
        patikaMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("Güncelle");
        JMenuItem deleteMenu = new JMenuItem("Sil");
        patikaMenu.add(updateMenu);
        patikaMenu.add(deleteMenu);

        updateMenu.addActionListener(e -> {
            int selected_id = Integer.parseInt(table1_patika.getValueAt(table1_patika.getSelectedRow(), 0).toString());
            UpdatePatikaGUI upGUI = new UpdatePatikaGUI(Patika.getFecht(selected_id));
            upGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadPatikaModel();
                    loadComboPatika();
                }
            });
        });
        deleteMenu.addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selected_id = Integer.parseInt(table1_patika.getValueAt(table1_patika.getSelectedRow(), 0).toString());
                if (Patika.delete(selected_id)) {
                    Helper.showMessage("done");
                    loadPatikaModel();
                    loadComboPatika();
                    loadCourseModel();
                } else {
                    Helper.showMessage("error");
                }
            }
        });

        patikaList = new DefaultTableModel();
        Object[] patikaListCol = {"ID", "Patika Adı"};
        patikaList.setColumnIdentifiers(patikaListCol);
        rowPatikaList = new Object[patikaListCol.length];

        loadPatikaModel();

        table1_patika.setModel(patikaList);
        table1_patika.setComponentPopupMenu(patikaMenu);
        table1_patika.getTableHeader().setReorderingAllowed(false);
        table1_patika.getColumnModel().getColumn(0).setMaxWidth(75);
        loadComboPatika();
        loadComboPatika();
        table1_patika.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = table1_patika.rowAtPoint(point);
                table1_patika.setRowSelectionInterval(selected_row, selected_row);
            }
        });

        courseList = new DefaultTableModel();
        Object[] col_courseList = {"Id", "Ders Adı", "Programlama Dili", "Patika", "Eğitmen", "Eğitmen İd"};
        courseList.setColumnIdentifiers(col_courseList);
        rowCourseList = new Object[col_courseList.length];
        loadCourseModel();
        table1_course_list.setModel(courseList);
        table1_course_list.getColumnModel().getColumn(0).setMaxWidth(75);

        table1_course_list.getTableHeader().setReorderingAllowed(false);

        loadEducatorCombo();

        button1_kayit_ekle.addActionListener(e -> {
            if (Helper.isEmpty(textField1_user_name) || Helper.isEmpty(textField1_user_K_name) || Helper.isEmpty(passwordField1_user_pass)) {
                Helper.showMessage("full");
            } else {
                String name = textField1_user_name.getText();
                String k_name = textField1_user_K_name.getText();
                String k_pass = passwordField1_user_pass.getText();
                String type = comboBox1_type.getSelectedItem().toString();
                if (User.add(name, k_name, k_pass, type)) {
                    Helper.showMessage("done");
                    loadTableList();
                    loadEducatorCombo();
                    textField1_user_name.setText(null);
                    textField1_user_K_name.setText(null);
                    passwordField1_user_pass.setText(null);
                }

            }
        });
        button1_kullanici_Sil.addActionListener(e -> {
            if (Helper.isEmpty(textField1_user_ID_sil)) {
                Helper.showMessage("full");
            } else {
                if (Helper.confirm("sure")) {
                    int user_Id = Integer.parseInt(textField1_user_ID_sil.getText());
                    if (User.deleteUser(user_Id)) {
                        Helper.showMessage("done");
                        loadTableList();
                        loadEducatorCombo();
                        loadCourseModel();

                    } else {
                        Helper.showMessage("error");
                    }
                    textField1_user_ID_sil.setText(null);
                }
            }
        });
        KAYITARAButton.addActionListener(e -> {
            String name = textField1_Kayit_Ara_AdSoyad.getText();
            String userName = textField1_Kayit_Ara_KullaniciAd.getText();
            String type = comboBox1_Kayit_Ara_Tip.getSelectedItem().toString();

            String query = User.kullaniciQuery(name, userName, type);
            ArrayList<User> userSearch = User.kullaniciAra(query);
            loadTableList(userSearch);
            textField1_Kayit_Ara_AdSoyad.setText(null);
            textField1_Kayit_Ara_KullaniciAd.setText(null);

        });
        çıkışYapButton.addActionListener(e -> {
                    dispose();
                    LoginGUI loginGUI = new LoginGUI();
                }
        );
        button1_patika_ekle.addActionListener(e -> {
            if (Helper.isEmpty(textField1_patika_ekle)) {
                Helper.showMessage("full");
            } else {
                if (Patika.add(textField1_patika_ekle.getText())) {
                    Helper.showMessage("done");
                    loadPatikaModel();
                    loadComboPatika();
                    textField1_patika_ekle.setText(null);
                } else {
                    Helper.showMessage("error");
                }
            }
        });
        button1_Course_Add.addActionListener(e -> {
            Item patikaItem = (Item) comboBox1_Patika.getSelectedItem();
            Item userItem = (Item) comboBox1_User.getSelectedItem();
            if (Helper.isEmpty(textField1_course_name) || Helper.isEmpty(textField1_coruse_lang)) {
                Helper.showMessage("full");
            } else {

                if (Course.add(userItem.getKey(), patikaItem.getKey(), textField1_course_name.getText(), textField1_coruse_lang.getText())) {
                    Helper.showMessage("done");
                    loadCourseModel();
                }
            }

            textField1_course_name.setText(null);
            textField1_coruse_lang.setText(null);
        });

        oprtr_icerik_model = new DefaultTableModel();
        Object[] oprtİcerikHead = {"Id", "Eğitmen No", "Başlık", "Açıklama", "Link", "Quiz", "Bilgi"};
        oprtr_icerik_model.setColumnIdentifiers(oprtİcerikHead);
        oprtr_icerik_obj = new Object[oprtİcerikHead.length];

        table1_opertr_icerik_list.setModel(oprtr_icerik_model);
        table1_opertr_icerik_list.getColumnModel().getColumn(0).setMaxWidth(75);
        table1_opertr_icerik_list.getTableHeader().setReorderingAllowed(false);
        loadContentsModel();

        table1_opertr_icerik_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                if (!e.getValueIsAdjusting()) {
                    String select_lesson_Id = table1_opertr_icerik_list.getValueAt(table1_opertr_icerik_list.getSelectedRow(), 0).toString();
                    textField6_silinecek_kisi_id.setText(select_lesson_Id);
                    textField1_baslik.setText(table1_opertr_icerik_list.getValueAt(table1_opertr_icerik_list.getSelectedRow(), 2).toString());
                    textField2_aciklama.setText(table1_opertr_icerik_list.getValueAt(table1_opertr_icerik_list.getSelectedRow(), 3).toString());
                    textField3_youtube_lnk.setText(table1_opertr_icerik_list.getValueAt(table1_opertr_icerik_list.getSelectedRow(), 4).toString());
                    textField4_quiz.setText(table1_opertr_icerik_list.getValueAt(table1_opertr_icerik_list.getSelectedRow(), 5).toString());
                    textField5_bilgi.setText(table1_opertr_icerik_list.getValueAt(table1_opertr_icerik_list.getSelectedRow(), 6).toString());
                }
            } catch (Exception excp) {
                System.out.println(excp.getMessage());
            }
        });
        SİLButton.addActionListener(e -> {
            int sil = Integer.parseInt(textField6_silinecek_kisi_id.getText());
            if (UserInfo.delete(sil)) {
                Helper.showMessage("done");
                loadContentsModel();
                clearTableContents();
            } else {
                Helper.showMessage("error");
            }
        });


        GÜNCELLEButton.addActionListener(e -> {
            if (Helper.isEmpty(textField1_baslik) || Helper.isEmpty(textField2_aciklama) || Helper.isEmpty(textField3_youtube_lnk) || Helper.isEmpty(textField4_quiz) || Helper.isEmpty(textField5_bilgi)) {
                Helper.showMessage("full");
            } else {
                String text1 = textField1_baslik.getText();
                String text2 = textField2_aciklama.getText();
                String text3 = textField3_youtube_lnk.getText();
                String text4 = textField4_quiz.getText();
                String text5 = textField5_bilgi.getText();
                int text_id = Integer.parseInt(textField6_silinecek_kisi_id.getText());
                if (UserInfo.update(text1, text2, text3, text4, text5, text_id)) {
                    Helper.showMessage("done");
                    loadContentsModel();
                    clearTableContents();
                } else {
                    Helper.showMessage("error");
                }

            }
        });
        TEMİZLEButton.addActionListener(e -> {
            clearTableContents();
        });
    }

    public void loadContentsModel() {
        DefaultTableModel claerModel = (DefaultTableModel) table1_opertr_icerik_list.getModel();
        claerModel.setRowCount(0);
        int i;
        for (UserInfo userInfo : UserInfo.getFetch()) {
            i = 0;
            oprtr_icerik_obj[i++] = userInfo.getId();
            oprtr_icerik_obj[i++] = userInfo.getEgitmen_no();
            oprtr_icerik_obj[i++] = userInfo.getIcerik_baslik();
            oprtr_icerik_obj[i++] = userInfo.getIcerik_aciklama();
            oprtr_icerik_obj[i++] = userInfo.getIcerik_youtube_link();
            oprtr_icerik_obj[i++] = userInfo.getIcerik_quiz();
            oprtr_icerik_obj[i++] = userInfo.getIcerik_bilgi();
            oprtr_icerik_model.addRow(oprtr_icerik_obj);
        }
    }

    public void clearTableContents() {
        textField1_baslik.setText(null);
        textField2_aciklama.setText(null);
        textField3_youtube_lnk.setText(null);
        textField4_quiz.setText(null);
        textField5_bilgi.setText(null);
        textField6_silinecek_kisi_id.setText(null);
    }

    private void loadCourseModel() {
        DefaultTableModel claerModel = (DefaultTableModel) table1_course_list.getModel();
        claerModel.setRowCount(0);
        int i;
        for (Course crs : Course.getList()) {
            i = 0;
            rowCourseList[i++] = crs.getId();
            rowCourseList[i++] = crs.getName();
            rowCourseList[i++] = crs.getLang();
            rowCourseList[i++] = crs.getPatika().getAd();
            rowCourseList[i++] = crs.getEducetor().getAd();
            rowCourseList[i++] = crs.getEducetor().getId();
            courseList.addRow(rowCourseList);
        }
    }

    private void loadPatikaModel() {
        DefaultTableModel clearModel = (DefaultTableModel) table1_patika.getModel();
        clearModel.setRowCount(0);

        for (Patika ptk : Patika.getList()) {
            int i = 0;
            rowPatikaList[i++] = ptk.getId();
            rowPatikaList[i++] = ptk.getAd();
            patikaList.addRow(rowPatikaList);
        }
    }

    public void loadTableList(ArrayList<User> query) {
        DefaultTableModel clearModel = (DefaultTableModel) table1_kullanici.getModel();
        clearModel.setRowCount(0);

        for (User us : query) {
            int i = 0;
            rowUserList[i++] = us.getId();
            rowUserList[i++] = us.getAd();
            rowUserList[i++] = us.getK_ad();
            rowUserList[i++] = us.getK_pass();
            rowUserList[i++] = us.getType();
            userList.addRow(rowUserList);
        }
    }

    public void loadTableList() {
        DefaultTableModel clearModel = (DefaultTableModel) table1_kullanici.getModel();
        clearModel.setRowCount(0);

        for (User us : User.getList()) {
            int i = 0;
            rowUserList[i++] = us.getId();
            rowUserList[i++] = us.getAd();
            rowUserList[i++] = us.getK_ad();
            rowUserList[i++] = us.getK_pass();
            rowUserList[i++] = us.getType();
            userList.addRow(rowUserList);
        }
    }

    public void loadComboPatika() {
        comboBox1_Patika.removeAllItems();
        for (Patika obj : Patika.getList()) {
            comboBox1_Patika.addItem(new Item(obj.getId(), obj.getAd()));
        }
    }

    public void loadEducatorCombo() {
        comboBox1_User.removeAllItems();
        for (User obj : User.getListEducator()) {
            comboBox1_User.addItem(new Item(obj.getId(), obj.getAd()));
        }
    }

    public static void main(String[] args) {
        Helper.setLayouts();
        Operator o = new Operator();
        o.setId(1);
        o.setAd("TUNCAY");
        o.setK_ad("tuncay@");
        o.setK_pass("123");
        o.setType("ogrenci");
        OperatorGUI oguı = new OperatorGUI(o);
    }
}
