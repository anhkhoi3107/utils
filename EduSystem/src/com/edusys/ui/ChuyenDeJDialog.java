package com.edusys.ui;

import com.edusys.model.ChuyenDe;
import com.edusys.model.NhanVien;
import com.edusys.utils.MsgBox;
import com.edusys.utils.XImage;
import com.helper.DialogHelper;
import com.helper.ShareHelper;
import dao.ChuyenDeDAO;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class ChuyenDeJDialog extends javax.swing.JDialog {

    private ImageIcon icon = new ImageIcon(EduSysJFrame.class.getResource("/com/edusys/icon/fpt.png"));

    JFileChooser fileChooser = new JFileChooser();
    ChuyenDeDAO dao = new ChuyenDeDAO();
    int row = 0;
    int index = 0;
    private String image;

    public ChuyenDeJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        init();
    }

    void fillTable() {
        DefaultTableModel model_table = (DefaultTableModel) tblChuyenDe.getModel();
        ArrayList<com.edusys.model.ChuyenDe> list = ChuyenDeDAO.getInstance().selectAll();
        for (com.edusys.model.ChuyenDe chuyenDe : list) {
            model_table.addRow(new Object[]{
                chuyenDe.getMaCD(), chuyenDe.getTenCD(), chuyenDe.getHocPhi(), chuyenDe.getThoiLuong(), chuyenDe.getHinh()
            });

        }

    }

    void init() {
        setLocationRelativeTo(null);
        setTitle("EDUSYS QUẢN LÝ CHUYÊN ĐỀ");
        fillTable();
    }

    void chonAnh() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            lblHinhAnh.setIcon(icon);
            lblHinhAnh.setToolTipText(file.getName());

        }
    }

    void setForm(ChuyenDe model) {
        txtMaCD.setText(model.getMaCD());
        txtTenCD.setText(model.getTenCD());
        txtThoiLuong.setText(String.valueOf(model.getThoiLuong()));
        txtHocPhi.setText(String.valueOf(model.getHocPhi()));
        txtMoTa.setText(model.getMoTa());
        
        try{
        System.out.println(image);
        ImageIcon icon1 = new ImageIcon(new ImageIcon(ChuyenDe.class.getResource("/com/edusys/icon/"+image)).getImage().getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH));
        
        
        lblHinhAnh.setIcon(icon1);
        if (!model.getHinh().equals("")) {
//            lblHinhAnh.setIcon(XImage.read(model.getHinh()));
//            lblHinhAnh.setToolTipText(model.getHinh());
            
            
        }
        }catch(Exception e){
            System.out.println(e.toString());
        }
       
        
    }

    void getForm() {
        ChuyenDe cd = new ChuyenDe();
        cd.setMaCD(txtMaCD.getText());
        cd.setTenCD(txtTenCD.getText());
        cd.setThoiLuong(Integer.parseInt(txtThoiLuong.getText()));
        cd.setHocPhi(Double.parseDouble(txtHocPhi.getText()));
        cd.setMoTa(txtMoTa.getText());
        cd.setHinh(lblHinhAnh.getToolTipText());
        
    }

    void edit() {
        try {
            String MaCD = (String) tblChuyenDe.getValueAt(this.row, 0);
            ChuyenDe chm = new ChuyenDe();
            chm.setMaCD(MaCD);
            ChuyenDe model = dao.selectById(chm);
            if (model != null) {

                tabs.setSelectedIndex(0);
                setForm(model);
            }

        } catch (Exception e) {

        }
    }

    void selectImage() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (ShareHelper.saveLogo(file)) {
                // Hiển thị hình lên form 
                lblHinhAnh.setIcon(ShareHelper.readLogo(file.getName()));
                lblHinhAnh.setToolTipText(file.getName());
            }
        }
    }

    void insert() {
        ChuyenDe model = new ChuyenDe();
        try {
            dao.insert(model);
//            this.load(); 
//            this.clear(); 
            DialogHelper.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Chuyên đề này đã có!");
        }

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblHinhAnh = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaCD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenCD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHocPhi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtThoiLuong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChuyenDe = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN QUẢN TRỊ");

        jLabel2.setText("Hình logo");

        lblHinhAnh.setBackground(new java.awt.Color(0, 102, 102));
        lblHinhAnh.setForeground(new java.awt.Color(0, 102, 102));
        lblHinhAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblHinhAnhMousePressed(evt);
            }
        });

        jLabel3.setText("Mã Chuyên Đề");

        txtMaCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaCDActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên Chuyên Đề");

        jLabel5.setText("Thời Lượng(giờ)");

        jLabel6.setText("Học phí");

        jLabel7.setText("Mô tả chuyên đề");

        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("XÓA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setText("MỚI");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoi))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnMoi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFirst.setText("<|");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMoTa)
                        .addComponent(jLabel7)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(51, 51, 51)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(txtMaCD)
                                .addComponent(jLabel4)
                                .addComponent(txtTenCD)
                                .addComponent(jLabel5)
                                .addComponent(txtHocPhi, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addComponent(txtThoiLuong)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("CẬP NHẬT", jPanel1);

        tblChuyenDe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ CĐ", "TÊN CĐ", "HỌC PHÍ", "THỜI LƯỢNG", "HÌNH"
            }
        ));
        tblChuyenDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblChuyenDeMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblChuyenDe);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabs.addTab("DANH SÁCH", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHinhAnhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMousePressed
        if (evt.getClickCount() == 2) {
            chonAnh();
            this.selectImage();
        }
    }//GEN-LAST:event_lblHinhAnhMousePressed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        //        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        //        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        //        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        //        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        //        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        //        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        //        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        //        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblChuyenDeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChuyenDeMousePressed
        if (evt.getClickCount() == 2) {
            this.row = tblChuyenDe.rowAtPoint(evt.getPoint());
            tabs.setSelectedIndex(0);
            
            image = tblChuyenDe.getValueAt(row, 4).toString();
           
            
            edit();

        }
    }//GEN-LAST:event_tblChuyenDeMousePressed

    private void txtMaCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaCDActionPerformed

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
            java.util.logging.Logger.getLogger(ChuyenDeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChuyenDeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChuyenDeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChuyenDeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChuyenDeJDialog dialog = new ChuyenDeJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblChuyenDe;
    private javax.swing.JTextField txtHocPhi;
    private javax.swing.JTextField txtMaCD;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtTenCD;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables

    private void setModel(ChuyenDe model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setStatus(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
