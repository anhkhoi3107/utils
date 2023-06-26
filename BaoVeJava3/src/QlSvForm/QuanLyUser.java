/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package QlSvForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.NhanVien;

/**
 *
 * @author ACER
 */
public class QuanLyUser extends javax.swing.JDialog {

    String email = "^([a-z0-9_\\.-]){3,}+@([\\da-z]){2,}\\.([a-z]){2,}(\\.|[a-z]{2,}){0,}$";

    public QuanLyUser(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        LoadDataToArray();
//        Display(current);
    }

    ArrayList<USer> list = new ArrayList<>();
    int current = 0;

    public static Connection getConnection() {
        Connection c = null;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            String url = "jdbc:sqlserver://localhost:1433;databaseName=BaoVe;"
                    + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
            String user = "sa";
            String passWord = "123";
            c = DriverManager.getConnection(url, user, passWord);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return c;
    }

    public void LoadDataToArray() throws SQLException {
        try {
            try ( Connection con = getConnection()) {
                Statement st = con.createStatement();
                String Query = "select * from NhanVien";
                ResultSet rs = st.executeQuery(Query);
                list.clear();
                while (rs.next()) {
                    String maSv = rs.getString(1);
                    String Ten = rs.getString(2);
                    String Email = rs.getString(3);
                    String sodt = rs.getString(4);
                    boolean gt = rs.getBoolean(5);
                    String diaChi = rs.getString(6);
//                    Student sv = new Student(maSv, Ten, Email, sodt, diaChi, gt);
                    USer sv = new USer(maSv, Ten, Email, sodt, gt, diaChi);
                    list.add(sv);
                }
                st.close();
                rs.close();
                System.out.println(con);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void New() {
        txtMa.setText("");
        txtEmaill.setText("");
        txtHoten.setText("");
        txtSdt.setText("");
        this.buttonGroup1.clearSelection();
        txtDiachi.setText("");
    }

    public void Delete() {
        try {
            Connection c = null;
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            String url = "jdbc:sqlserver://localhost:1433;databaseName=BaoVe;"
                    + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String user = "sa";
            String passWord = "123";
            c = DriverManager.getConnection(url, user, passWord);
            PreparedStatement ps = con.prepareStatement("delete from Users where MaSv=? ");
            ps.setString(1, txtMa.getText());
            int kq = ps.executeUpdate();
            if (kq == 1) {
                JOptionPane.showMessageDialog(this, " Xóa thành công");
            }
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean check() {
        if (txtMa.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui Long Nhap Ma!!");
            txtMa.requestFocus();
            return false;
        }
        if (txtEmaill.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui Long Nhap HoTen!!");
            txtEmaill.requestFocus();
            return false;
        }
        if (txtHoten.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui Long Nhap Email!!");
            txtHoten.requestFocus();
            return false;
        }
        if (!this.txtEmaill.getText().matches(email)) {
            JOptionPane.showMessageDialog(this, "Email nhập sai kiểu,email không Được Có kí đặc biệt!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtSdt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui Long Nhap Sdt!!");
            txtSdt.requestFocus();
            return false;
        }
        if (!this.rdoNam.isSelected() && !this.rdoNu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Chưa Nhập Giới tính", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (txtDiachi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui Long Nhap Dia Chi!!");
            txtMa.requestFocus();
            return false;
        }

        return true;
    }

    public void Save() {
        try {
            Connection c = null;
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            String url = "jdbc:sqlserver://localhost:1433;databaseName=BaoVe;"
                    + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String user = "sa";
            String passWord = "123";
            c = DriverManager.getConnection(url, user, passWord);
            PreparedStatement ps = con.prepareStatement("insert into Users values(?,?,?,?,?,?)");
            ps.setString(1, txtMa.getText());
            ps.setString(2, txtHoten.getText());
            ps.setString(3, txtEmaill.getText());
            ps.setString(4, txtSdt.getText());
            ps.setBoolean(5, (rdoNam.isSelected() == true) ? true : false);
            ps.setString(6, txtDiachi.getText());

            int kq = ps.executeUpdate();
            if (kq == 1) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Update() {
        try {
            Connection c = null;
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            String url = "jdbc:sqlserver://localhost:1433;databaseName=BaoVe;"
                    + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String user = "sa";
            String passWord = "123";
            c = DriverManager.getConnection(url, user, passWord);
            PreparedStatement ps = con.prepareStatement("update Users set HoTen=?, Email=?, SoDT=?, GioiTinh=?, DiaChi=? where MaSV=?");

            ps.setString(1, txtHoten.getText());
            ps.setString(2, txtEmaill.getText());
            ps.setString(3, txtSdt.getText());
            ps.setBoolean(4, (rdoNam.isSelected() == true) ? true : false);
            ps.setString(5, txtDiachi.getText());
            ps.setString(6, txtMa.getText());
            int kq = ps.executeUpdate();
            if (kq == 1) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");

            } else {

            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Display(int i) {
        USer sv = list.get(i);
        txtMa.setText(sv.MaSv);
        txtEmaill.setText(sv.HoTen);
        txtSdt.setText(sv.SoDT);
        txtHoten.setText(sv.Email);
        txtDiachi.setText(sv.DiaChi);
        txtMa.setText(sv.MaSv);
        boolean gt = sv.GioiTinh;
        if (gt == true) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiachi = new javax.swing.JTextArea();
        txtHoten = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        rdoNam = new javax.swing.JRadioButton();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bttnSave = new javax.swing.JButton();
        rdoNu = new javax.swing.JRadioButton();
        txtEmaill = new javax.swing.JTextField();
        btnFistAction = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLastt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Họ Tên: ");

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Close-icon.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtDiachi.setColumns(20);
        txtDiachi.setRows(5);
        jScrollPane1.setViewportView(txtDiachi);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update-icon.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel4.setText("Email: ");

        jLabel5.setText("Số Đt: ");

        jLabel6.setText("Giới Tính: ");

        jLabel7.setText("Địa Chỉ: ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý User ");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-New-icon.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        jLabel2.setText("Mã Sv: ");

        bttnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save-icon.png"))); // NOI18N
        bttnSave.setText("Save");
        bttnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnSaveActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        btnFistAction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-First-icon.png"))); // NOI18N
        btnFistAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFistActionActionPerformed(evt);
            }
        });

        btnPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Rewind-icon.png"))); // NOI18N
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Forward-icon.png"))); // NOI18N
        btnNext.setToolTipText("");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLastt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Last-icon.png"))); // NOI18N
        btnLastt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLasttActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(50, 50, 50)
                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHoten)
                                    .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(txtEmaill)
                                    .addComponent(txtSdt)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFistAction, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLastt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bttnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btnAdd))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEmaill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(bttnSave)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPre)
                    .addComponent(btnNext)
                    .addComponent(btnLastt)
                    .addComponent(btnFistAction))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnFistActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFistActionActionPerformed
        current = 0;
        Display(current);
    }//GEN-LAST:event_btnFistActionActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        current--;
        if (current < 0) {
            JOptionPane.showMessageDialog(null, "Đang ở đầu danh sách!!!");
            return;
        }

        Display(current);

    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        current++;
        if (current >= list.size()) {
            JOptionPane.showMessageDialog(null, "Đang ở cuối danh sách!!!");
            return;
        }
        Display(current);

    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLasttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLasttActionPerformed
        current = list.size() - 1;
        Display(current);
    }//GEN-LAST:event_btnLasttActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn Chắc Chắn Muốn Xóa Users Này", "??", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            return;
        }
        Delete();
        New();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        New();
    }//GEN-LAST:event_btnAddActionPerformed

    private void bttnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnSaveActionPerformed
        if (check()) {
            Save();
        }
    }//GEN-LAST:event_bttnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLyUser dialog = null;
                try {
                    dialog = new QuanLyUser(new javax.swing.JFrame(), true);
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLyUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFistAction;
    private javax.swing.JButton btnLastt;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton bttnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTextArea txtDiachi;
    private javax.swing.JTextField txtEmaill;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSdt;
    // End of variables declaration//GEN-END:variables
}
