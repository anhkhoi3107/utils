package com.edusys.ui;

import com.edusys.utils.Auth;
import com.edusys.utils.MsgBox;
import com.edusys.utils.XImage;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.AuthPermission;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class EduSysJFrame extends javax.swing.JFrame {

    private ImageIcon icon = new ImageIcon(EduSysJFrame.class.getResource("/com/edusys/icon/fpt.png"));

    void init() {
        setSize(1000, 600);
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setTitle("HỆ THỐNG QUẢN LÝ ĐÀO TẠO EDUSYS");
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

    public EduSysJFrame() {
        initComponents();
        init();
    }

    void openWelcome() {
        new ChaoJDialog(this, true).setVisible(true);
    }

    void openLogin() {
        new DangNhapJDialog(this, true).setVisible(true);
    }

    void openDoiMatKhau() {

        new DoiMatKhauJDialog(this, true).setVisible(true);

    }

    // Webcode
    public void web() {
        try {
//            System.out.println("123");
            Runtime run = Runtime.getRuntime();
            String url = "http://127.0.0.1:5500/chariteam-1.0.0/index.html";
            run.exec("rundll32 url.dll, FileProtocolHandler " + url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void webAbout() {
        try {
//            System.out.println("123");
            Runtime run = Runtime.getRuntime();
            String url = "http://127.0.0.1:5500/chariteam-1.0.0/about.html";
            run.exec("rundll32 url.dll, FileProtocolHandler " + url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnDangXuat = new javax.swing.JButton();
        btnKetThuc = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnChuyenDe = new javax.swing.JButton();
        btnNguoiHoc = new javax.swing.JButton();
        btnKhoaHoc = new javax.swing.JButton();
        btnHocVien = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnHuongDan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        lbltrangThai = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblDongHo = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnHeThong = new javax.swing.JMenu();
        mniDoiMatKhau = new javax.swing.JMenuItem();
        mniDangXuat = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        mniKetThuc = new javax.swing.JMenuItem();
        mnQuanLy = new javax.swing.JMenu();
        mniChuyenDe = new javax.swing.JMenuItem();
        mniKhoaHoc = new javax.swing.JMenuItem();
        mniNguoiHoc = new javax.swing.JMenuItem();
        mniNhanVien = new javax.swing.JMenuItem();
        mnThongKe = new javax.swing.JMenu();
        mniBangDiem = new javax.swing.JMenuItem();
        mniLuongNguoiHoc = new javax.swing.JMenuItem();
        mniDiemChuyenDe = new javax.swing.JMenuItem();
        mniDoanhThu = new javax.swing.JMenuItem();
        mniGioiThieuSanPham = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(900, 800));

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator3);

        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Log out.png"))); // NOI18N
        btnDangXuat.setText("ĐĂNG XUẤT");
        btnDangXuat.setFocusable(false);
        btnDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDangXuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDangXuat);

        btnKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Stop.png"))); // NOI18N
        btnKetThuc.setText("KẾT THÚC");
        btnKetThuc.setFocusable(false);
        btnKetThuc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKetThuc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKetThuc);
        jToolBar1.add(jSeparator1);

        btnChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Address book.png"))); // NOI18N
        btnChuyenDe.setText("CHUYÊN ĐỀ");
        btnChuyenDe.setFocusable(false);
        btnChuyenDe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenDe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenDeActionPerformed(evt);
            }
        });
        jToolBar1.add(btnChuyenDe);

        btnNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Boy.png"))); // NOI18N
        btnNguoiHoc.setText("NGƯỜI HỌC");
        btnNguoiHoc.setFocusable(false);
        btnNguoiHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNguoiHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNguoiHocActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNguoiHoc);

        btnKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Book.png"))); // NOI18N
        btnKhoaHoc.setText("KHÓA HỌC");
        btnKhoaHoc.setFocusable(false);
        btnKhoaHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhoaHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaHocActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKhoaHoc);

        btnHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Girl.png"))); // NOI18N
        btnHocVien.setText("HỌC VIÊN");
        btnHocVien.setFocusable(false);
        btnHocVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHocVien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHocVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHocVienActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHocVien);
        jToolBar1.add(jSeparator2);

        btnHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/List.png"))); // NOI18N
        btnHuongDan.setText("HƯỚNG DẪN");
        btnHuongDan.setFocusable(false);
        btnHuongDan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHuongDan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuongDanActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHuongDan);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Info.png"))); // NOI18N

        lbltrangThai.setText("Hệ quản lý đào tạo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(lbltrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/logo.png"))); // NOI18N
        jPanel2.add(jLabel2);

        lblDongHo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Clock.png"))); // NOI18N
        lblDongHo.setText("00:00:00 AM");

        mnHeThong.setText("Hệ thống");

        mniDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Key.png"))); // NOI18N
        mniDoiMatKhau.setText("Đăng nhập");
        mniDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDoiMatKhauActionPerformed(evt);
            }
        });
        mnHeThong.add(mniDoiMatKhau);

        mniDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Exit.png"))); // NOI18N
        mniDangXuat.setText("Đăng xuất");
        mniDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangXuatActionPerformed(evt);
            }
        });
        mnHeThong.add(mniDangXuat);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Refresh.png"))); // NOI18N
        jMenuItem5.setText("Đổi mật khẩu");
        mnHeThong.add(jMenuItem5);

        mniKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Free.png"))); // NOI18N
        mniKetThuc.setText("Kết thúc");
        mniKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKetThucActionPerformed(evt);
            }
        });
        mnHeThong.add(mniKetThuc);

        jMenuBar1.add(mnHeThong);

        mnQuanLy.setText("Quản lý");

        mniChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Calendar.png"))); // NOI18N
        mniChuyenDe.setText("Chuyên đề");
        mniChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniChuyenDeActionPerformed(evt);
            }
        });
        mnQuanLy.add(mniChuyenDe);

        mniKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Billboard.png"))); // NOI18N
        mniKhoaHoc.setText("Khóa học");
        mniKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKhoaHocActionPerformed(evt);
            }
        });
        mnQuanLy.add(mniKhoaHoc);

        mniNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Conference.png"))); // NOI18N
        mniNguoiHoc.setText("Người học");
        mniNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNguoiHocActionPerformed(evt);
            }
        });
        mnQuanLy.add(mniNguoiHoc);

        mniNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Bricks.png"))); // NOI18N
        mniNhanVien.setText("Quản Lý Nhân Viên");
        mniNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNhanVienActionPerformed(evt);
            }
        });
        mnQuanLy.add(mniNhanVien);

        jMenuBar1.add(mnQuanLy);

        mnThongKe.setText("Thống kê");

        mniBangDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Calculator_1.png"))); // NOI18N
        mniBangDiem.setText("Bảng điểm khóa trước");
        mniBangDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBangDiemActionPerformed(evt);
            }
        });
        mnThongKe.add(mniBangDiem);

        mniLuongNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/User group.png"))); // NOI18N
        mniLuongNguoiHoc.setText("Người học từng năm");
        mniLuongNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLuongNguoiHocActionPerformed(evt);
            }
        });
        mnThongKe.add(mniLuongNguoiHoc);

        mniDiemChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Statistics.png"))); // NOI18N
        mniDiemChuyenDe.setText("Điểm từng khóa học");
        mniDiemChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDiemChuyenDeActionPerformed(evt);
            }
        });
        mnThongKe.add(mniDiemChuyenDe);

        mniDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Dollar.png"))); // NOI18N
        mniDoanhThu.setText("Doanh thu từng chuyên đề");
        mniDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDoanhThuActionPerformed(evt);
            }
        });
        mnThongKe.add(mniDoanhThu);

        jMenuBar1.add(mnThongKe);

        mniGioiThieuSanPham.setText("Trợ giúp");

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Globe.png"))); // NOI18N
        jMenuItem14.setText("Hướng dẫn sử dụng");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        mniGioiThieuSanPham.add(jMenuItem14);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Bomb.png"))); // NOI18N
        jMenuItem15.setText("Giới thiệu sản phẩm");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        mniGioiThieuSanPham.add(jMenuItem15);

        jMenuBar1.add(mniGioiThieuSanPham);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(204, 204, 204))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator4)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDongHo)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        this.setVisible(false);
        DangNhapJDialog Dn = new DangNhapJDialog(this, true);
        Dn.setVisible(true);
        Auth.clear();

    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void mniDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDoiMatKhauActionPerformed
        openDoiMatKhau();
    }//GEN-LAST:event_mniDoiMatKhauActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        if (MsgBox.confirm(this, "Bạn muốn kết thúc ứng dụng?")) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnKetThucActionPerformed


    private void btnHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuongDanActionPerformed
        web();
    }//GEN-LAST:event_btnHuongDanActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        webAbout();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        web();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void mniKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKetThucActionPerformed
        if (MsgBox.confirm(this, "Bạn muốn kết thúc ứng dụng?")) {
            System.exit(0);
        }
    }//GEN-LAST:event_mniKetThucActionPerformed

    private void btnChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenDeActionPerformed
        new ChuyenDeJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnChuyenDeActionPerformed

    private void btnNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNguoiHocActionPerformed
        new NguoiHocJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnNguoiHocActionPerformed

    private void btnKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaHocActionPerformed
        new KhoaHocJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnKhoaHocActionPerformed

    private void btnHocVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHocVienActionPerformed
        new HocVienJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnHocVienActionPerformed

    private void mniDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDoanhThuActionPerformed
        ThongKeJDialog Tk = new ThongKeJDialog(this, true);
        Tk.setVisible(true);
        Tk.chon(4);
    }//GEN-LAST:event_mniDoanhThuActionPerformed

    private void mniChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniChuyenDeActionPerformed
        new ChuyenDeJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_mniChuyenDeActionPerformed

    private void mniKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKhoaHocActionPerformed
        new KhoaHocJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_mniKhoaHocActionPerformed

    private void mniNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNhanVienActionPerformed
        new NhanVienJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_mniNhanVienActionPerformed

    private void mniBangDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBangDiemActionPerformed
        ThongKeJDialog Tk = new ThongKeJDialog(this, true);
        Tk.setVisible(true);
        Tk.chon(1);

    }//GEN-LAST:event_mniBangDiemActionPerformed

    private void mniLuongNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLuongNguoiHocActionPerformed
        ThongKeJDialog Tk = new ThongKeJDialog(this, true);
        Tk.setVisible(true);
        Tk.chon(0);
    }//GEN-LAST:event_mniLuongNguoiHocActionPerformed

    private void mniDiemChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDiemChuyenDeActionPerformed
        ThongKeJDialog Tk = new ThongKeJDialog(this, true);
        Tk.setVisible(true);
        Tk.chon(3);
    }//GEN-LAST:event_mniDiemChuyenDeActionPerformed

    private void mniDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangXuatActionPerformed
        this.setVisible(false);
        DangNhapJDialog Dn = new DangNhapJDialog(this, true);
        Dn.setVisible(true);
        Auth.clear();
    }//GEN-LAST:event_mniDangXuatActionPerformed

    private void mniNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNguoiHocActionPerformed
        new NguoiHocJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_mniNguoiHocActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    EduSysJFrame frame = new EduSysJFrame();
                    frame.setVisible(true);
                } catch (Exception ex) {
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenDe;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnHocVien;
    private javax.swing.JButton btnHuongDan;
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnKhoaHoc;
    private javax.swing.JButton btnNguoiHoc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lbltrangThai;
    private javax.swing.JMenu mnHeThong;
    private javax.swing.JMenu mnQuanLy;
    private javax.swing.JMenu mnThongKe;
    private javax.swing.JMenuItem mniBangDiem;
    private javax.swing.JMenuItem mniChuyenDe;
    private javax.swing.JMenuItem mniDangXuat;
    private javax.swing.JMenuItem mniDiemChuyenDe;
    private javax.swing.JMenuItem mniDoanhThu;
    private javax.swing.JMenuItem mniDoiMatKhau;
    private javax.swing.JMenu mniGioiThieuSanPham;
    private javax.swing.JMenuItem mniKetThuc;
    private javax.swing.JMenuItem mniKhoaHoc;
    private javax.swing.JMenuItem mniLuongNguoiHoc;
    private javax.swing.JMenuItem mniNguoiHoc;
    private javax.swing.JMenuItem mniNhanVien;
    // End of variables declaration//GEN-END:variables

}
