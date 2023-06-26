/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.edusys.ui;

import com.edusys.dao.NhanVienDAO;
import com.edusys.ulils.DialogHelper;
import com.edusys.ulils.ShareHelper;
import com.edusys.ulils.XImage;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author ACER
 */
public class MenuJDialog extends javax.swing.JDialog {

    /**
     * Creates new form MenuJDialog
     */
    public MenuJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        init();
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Hệ THỐNG QUẢN LÝ ĐÀO TẠO");

    }
//    NhanVienDAO dao = new NhanVienDAO();

    void init() {
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);

        new Timer(1000, new ActionListener() {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");

            @Override
            public void actionPerformed(ActionEvent e) {
                lblDongHo.setText(format.format(new Date()));

            }

        }).start();
        this.openLogin();
        this.openWelcome();

    }

    public void openLogin() {
        DangNhapJDialog dangNhapJDialog = new DangNhapJDialog();
        dangNhapJDialog.setVisible(true);
    }
    private Frame ChaoJDialogg;

    public void openWelcome() {
        ChaoJDialogg Ch = new ChaoJDialogg(ChaoJDialogg, true);
        Ch.setVisible(true);
    }

//    void logoff() {
//        ShareHelper.logoff();
//        this.openLogin();
//    }
//
//    void exit() {
//        if (DialogHelper.confirm(this, "Bạn thực sự muốn kết thúc?")) {
//            System.exit(0);
//        }
//    }
//    
//private Frame TongHopThongKeJDialog ;
//    void openThongKe(int index) {
//        if (ShareHelper.authenticated()) {
//            new TongHopThongKeJDialog(TongHopThongKeJDialog, true);
//        } else {
//            DialogHelper.alert(this, "Vui lòng đăng nhập!");
//        }
//    }
//private Frame QLNhanVienJDialog ;
//    void openNhanVien() {
//        if (ShareHelper.authenticated()) {
//            new QLNhanVienJDialog(QLNhanVienJDialog, true).setVisible(true);
//        } else {
//            DialogHelper.alert(this, "Vui lòng đăng nhập!");
//        }
//    }
//private Frame QuanLyKhoaHocJDialog ;
//    void openKhoaHoc() {
//        if (ShareHelper.authenticated()) {
//            new QuanLyKhoaHocJDialog(QuanLyKhoaHocJDialog, true).setVisible(true);
//        } else {
//            DialogHelper.alert(this, "Vui lòng đăng nhập!");
//        }
//    }
//private Frame QuanLyChuyenDeJDialog ;
//    void openChuyenDe() {
//        if (ShareHelper.authenticated()) {
//            new QuanLyChuyenDeJDialog(QuanLyChuyenDeJDialog, true).setVisible(true);
//        } else {
//            DialogHelper.alert(this, "Vui lòng đăng nhập!");
//        }
//    }
//
//    private Frame QLNguoiHocJDialog ;
//    void openNguoiHoc() {
//        if (ShareHelper.authenticated()) {
//            new QLNguoiHocJDialog(QLNguoiHocJDialog, true).setVisible(true);
//        } else {
//            DialogHelper.alert(this, "Vui lòng đăng nhập!");
//        }
//    }
//
////    void openAbout() {
////        new GioiThieuJDialog(this, true).setVisible(true);
////    }
////
////    void openWebsite() {
////        try {
////            Desktop.getDesktop().browse(new File("help/index.html").toURI());
////        } catch (IOException ex) {
////            DialogHelper.alert(this, "Không tìm thấy file hướng dẫn!");
////        }
////    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator6 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        bntDangXuat = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnChuyenDe = new javax.swing.JButton();
        btnNguoiHoc = new javax.swing.JButton();
        btnKhoaHoc = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnHuongDan = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        lbltrangThai = new javax.swing.JLabel();
        lblDongHo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuHeThong = new javax.swing.JMenu();
        mniDangNhap = new javax.swing.JMenuItem();
        mniDangXuat = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniDoiMatKhau = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mniKetThuc = new javax.swing.JMenuItem();
        mnuQuanLy = new javax.swing.JMenu();
        mniNguoiHoc = new javax.swing.JMenuItem();
        mniChuyenDe = new javax.swing.JMenuItem();
        mniKhoaHoc = new javax.swing.JMenuItem();
        mniNhanVien = new javax.swing.JMenuItem();
        mnuThongKe = new javax.swing.JMenu();
        mniTKNguoiHoc = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mniTKBangDiem = new javax.swing.JMenuItem();
        mniTKDiemKhoaHoc = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mniTKDoanhThu = new javax.swing.JMenuItem();
        mnuTroGiup = new javax.swing.JMenu();
        mniHuongDan = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mniGioiThieu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("HỆ THỐNG QUẢN LÝ ĐÀO TẠO ");

        jToolBar1.setRollover(true);

        bntDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Exit.png"))); // NOI18N
        bntDangXuat.setText("Đăng xuất");
        bntDangXuat.setFocusable(false);
        bntDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntDangXuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bntDangXuat);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Stop.png"))); // NOI18N
        btnExit.setText("Kết thúc");
        btnExit.setFocusable(false);
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExit);
        jToolBar1.add(jSeparator7);

        btnChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Lists.png"))); // NOI18N
        btnChuyenDe.setText("Chuyên đề");
        btnChuyenDe.setFocusable(false);
        btnChuyenDe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenDe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnChuyenDe);

        btnNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Conference.png"))); // NOI18N
        btnNguoiHoc.setText("Người học");
        btnNguoiHoc.setFocusable(false);
        btnNguoiHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNguoiHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnNguoiHoc);

        btnKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Certificate.png"))); // NOI18N
        btnKhoaHoc.setText("Khóa học");
        btnKhoaHoc.setFocusable(false);
        btnKhoaHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhoaHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnKhoaHoc);
        jToolBar1.add(jSeparator8);

        btnHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Globe.png"))); // NOI18N
        btnHuongDan.setText("Hướng dẫn");
        btnHuongDan.setFocusable(false);
        btnHuongDan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHuongDan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnHuongDan);

        lbltrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Info.png"))); // NOI18N
        lbltrangThai.setText("Hệ quản lý đào tạo");

        lblDongHo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Alarm.png"))); // NOI18N
        lblDongHo.setText("00:00:00 AM");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/FPT_Polytechnic.png"))); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        mnuHeThong.setText("Hệ Thống");

        mniDangNhap.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Key.png"))); // NOI18N
        mniDangNhap.setText("Đăng nhập");
        mniDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangNhapActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniDangNhap);

        mniDangXuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Exit.png"))); // NOI18N
        mniDangXuat.setText("Đăng xuất");
        mnuHeThong.add(mniDangXuat);
        mnuHeThong.add(jSeparator1);

        mniDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Refresh.png"))); // NOI18N
        mniDoiMatKhau.setText("Đổi mật khẩu");
        mnuHeThong.add(mniDoiMatKhau);
        mnuHeThong.add(jSeparator2);

        mniKetThuc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        mniKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Stop.png"))); // NOI18N
        mniKetThuc.setText("Kết thúc");
        mniKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKetThucActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniKetThuc);

        jMenuBar1.add(mnuHeThong);

        mnuQuanLy.setText("Quản Lý");

        mniNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Conference.png"))); // NOI18N
        mniNguoiHoc.setText("Người học ");
        mnuQuanLy.add(mniNguoiHoc);

        mniChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Lists.png"))); // NOI18N
        mniChuyenDe.setText("Chuyên đề");
        mniChuyenDe.setToolTipText("");
        mnuQuanLy.add(mniChuyenDe);

        mniKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Certificate.png"))); // NOI18N
        mniKhoaHoc.setText("Khóa học");
        mnuQuanLy.add(mniKhoaHoc);

        mniNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/User group.png"))); // NOI18N
        mniNhanVien.setText("Nhân viên");
        mnuQuanLy.add(mniNhanVien);

        jMenuBar1.add(mnuQuanLy);

        mnuThongKe.setText("Thống Kê");

        mniTKNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Clien list.png"))); // NOI18N
        mniTKNguoiHoc.setText("Người học từng năm");
        mnuThongKe.add(mniTKNguoiHoc);
        mnuThongKe.add(jSeparator3);

        mniTKBangDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Card file.png"))); // NOI18N
        mniTKBangDiem.setText("Bảng điểm khóa...");
        mnuThongKe.add(mniTKBangDiem);

        mniTKDiemKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Bar chart.png"))); // NOI18N
        mniTKDiemKhoaHoc.setText("Điểm từng khóa học");
        mnuThongKe.add(mniTKDiemKhoaHoc);
        mnuThongKe.add(jSeparator4);

        mniTKDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Dollar.png"))); // NOI18N
        mniTKDoanhThu.setText("Doanh thu từng chuyên đề...");
        mnuThongKe.add(mniTKDoanhThu);

        jMenuBar1.add(mnuThongKe);

        mnuTroGiup.setText("Trợ Giúp");

        mniHuongDan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mniHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Globe.png"))); // NOI18N
        mniHuongDan.setText("Hướng dẫn sử dụng");
        mnuTroGiup.add(mniHuongDan);
        mnuTroGiup.add(jSeparator5);

        mniGioiThieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Hinh/Home.png"))); // NOI18N
        mniGioiThieu.setText("Giới thiệu sản phẩm");
        mnuTroGiup.add(mniGioiThieu);

        jMenuBar1.add(mnuTroGiup);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator9)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbltrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDongHo)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniDangNhapActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void mniKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKetThucActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mniKetThucActionPerformed

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
            java.util.logging.Logger.getLogger(MenuJDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuJDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuJDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuJDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuJDialog dialog = new MenuJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bntDangXuat;
    private javax.swing.JButton btnChuyenDe;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHuongDan;
    private javax.swing.JButton btnKhoaHoc;
    private javax.swing.JButton btnNguoiHoc;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lbltrangThai;
    private javax.swing.JMenuItem mniChuyenDe;
    private javax.swing.JMenuItem mniDangNhap;
    private javax.swing.JMenuItem mniDangXuat;
    private javax.swing.JMenuItem mniDoiMatKhau;
    private javax.swing.JMenuItem mniGioiThieu;
    private javax.swing.JMenuItem mniHuongDan;
    private javax.swing.JMenuItem mniKetThuc;
    private javax.swing.JMenuItem mniKhoaHoc;
    private javax.swing.JMenuItem mniNguoiHoc;
    private javax.swing.JMenuItem mniNhanVien;
    private javax.swing.JMenuItem mniTKBangDiem;
    private javax.swing.JMenuItem mniTKDiemKhoaHoc;
    private javax.swing.JMenuItem mniTKDoanhThu;
    private javax.swing.JMenuItem mniTKNguoiHoc;
    private javax.swing.JMenu mnuHeThong;
    private javax.swing.JMenu mnuQuanLy;
    private javax.swing.JMenu mnuThongKe;
    private javax.swing.JMenu mnuTroGiup;
    // End of variables declaration//GEN-END:variables

}
