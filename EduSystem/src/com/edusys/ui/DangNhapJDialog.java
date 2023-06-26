package com.edusys.ui;

import com.edusys.model.NhanVien;
import com.edusys.utils.Auth;
import com.edusys.utils.MsgBox;
import com.edusys.utils.XImage;
import dao.NhanVienDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class DangNhapJDialog extends javax.swing.JDialog {

    void dangNhap() {
        String strMaNV = txtMaNV.getText();
        String strPassword = new String(txtMatKhau.getPassword());

        if (strMaNV.equals("")) {
            MsgBox.alert(this, "chưa nhập mã");
        }
        if (strPassword.equals("")) {
            MsgBox.alert(this, "chưa nhập pass");

        } else {
            NhanVien nv = new NhanVien();
            nv.setMaNV(strMaNV);
            nv.setMatKhau(strPassword);
            if (NhanVienDAO.getInstance().selectByUandP(nv) == null) {
                MsgBox.alert(this, "Sai tên đăng nhập");

            } else {
                if (!nv.getMatKhau().equals(strPassword)) {
                    MsgBox.alert(this, "Sai mật khẩu");

                } else {
                    Auth.user = nv;
                    this.dispose();
                }
            }

        }
    }

    public DangNhapJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void init() {

        //setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        setTitle("ĐĂNG NHẬP HỆ THỐNG ");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        btnDangNhap = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/ui/18198154_10208600482868814_3469513_n-234x375.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("TÊN ĐĂNG NHẬP:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("MẬT KHẨU:");

        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Key.png"))); // NOI18N
        btnDangNhap.setText("ĐĂNG NHẬP");
        btnDangNhap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDangNhap.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Exit.png"))); // NOI18N
        btnThoat.setText("THOÁT");
        btnThoat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThoat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Noto Serif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Đăng Nhập");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnDangNhap)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(24, 24, 24))
                                .addComponent(jLabel3)
                                .addComponent(txtMatKhau)
                                .addComponent(txtMaNV))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        dangNhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed
    void ketThuc() {
        if (MsgBox.confirm(this, "Bạn muốn kết thúc ứng dụng?")) {
            System.exit(0);
        }
    }


    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        ketThuc();

    }//GEN-LAST:event_btnThoatActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DangNhapJDialog dialog = new DangNhapJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtMatKhau;
    // End of variables declaration//GEN-END:variables
}
