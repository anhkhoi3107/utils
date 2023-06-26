package com.edusys.ui;

import com.edusys.model.KhoaHoc;
import dao.ChuyenDeDAO;
import dao.KhoaHocDAO;
import dao.NguoiHocDAO;
import dao.ThongKeDAO;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class ThongKeJDialog extends javax.swing.JDialog {

    public ThongKeJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void init() {
        setLocationRelativeTo(null);
        setTitle("THỐNG KÊ");
        fillTableNguoiHoc();
        fillTableThongKeDiem();
        loadComboBoxKhoaHoc();
        loadComBoBoxYear();
    }

    void fillTableThongKeDiem() {
        DefaultTableModel model_table = (DefaultTableModel) tblTongHopDiem.getModel();
        List<Object[]> list = ThongKeDAO.getInstance().getDiemChuyenDe();

        for (Object[] objects : list) {
            model_table.addRow(new Object[]{
                objects[0], objects[1], objects[2], objects[3], objects[4]});

        }
    }

    void loadComboBoxKhoaHoc() {
        try {
            ArrayList<KhoaHoc> list = KhoaHocDAO.getInstance().selectAll();
            cboKhoaHoc.addItem("");
            for (KhoaHoc khoaHoc : list) {
                this.cboKhoaHoc.addItem(khoaHoc);
            }
        } catch (Exception e) {
        }
    }

    public void loadComBoBoxYear() {
        cboYear.addItem("");
        ArrayList<Integer> list = KhoaHocDAO.getInstance().getYearKH();
        for (Integer integer : list) {
            cboYear.addItem(integer);
        }
    }

    public void loadTableDoanhThu() {
        try {
            DefaultTableModel model_table = (DefaultTableModel) tblDoanhThu.getModel();
            int nam = Integer.valueOf(cboYear.getSelectedItem()+"");
            List<Object[]> list = ThongKeDAO.getInstance().getDoanhThu(nam);
            for (Object[] objects : list) {
                model_table.addRow(objects);
            }
        } catch (Exception e) {
        }
    }

    void loadTableBangDiem() {
        try {
            KhoaHoc kh = (KhoaHoc) cboKhoaHoc.getSelectedItem();
            List<Object[]> list = ThongKeDAO.getInstance().getBangDiem(kh.getMaKH());
            DefaultTableModel model_table = (DefaultTableModel) tblBangDiem.getModel();
            for (Object[] objects : list) {
                model_table.addRow(new Object[]{
                    objects[0], objects[1], objects[2]
                });
            }
        } catch (Exception e) {
        }
    }

    void fillTableNguoiHoc() {
        DefaultTableModel model_table = (DefaultTableModel) tblNguoiHoc.getModel();
        List<Object[]> list = ThongKeDAO.getInstance().getLuongNguoiHoc();

        for (Object[] objects : list) {
            model_table.addRow(new Object[]{
                objects[0], objects[1], objects[2], objects[3],});

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNguoiHoc = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboKhoaHoc = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBangDiem = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTongHopDiem = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboYear = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("TỔNG HỢP THỐNG KÊ");

        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NĂM", "SỐ NGƯỜI HỌC", "ĐẦU TIÊN", "SAU CÙNG"
            }
        ));
        jScrollPane1.setViewportView(tblNguoiHoc);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("NGƯỜI HỌC", jPanel1);

        jLabel2.setText("KHÓA HỌC;");

        cboKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhoaHocActionPerformed(evt);
            }
        });

        tblBangDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ NH", "HỌ VÀ TÊN", "ĐIỂM", "XẾP LOẠI"
            }
        ));
        jScrollPane2.setViewportView(tblBangDiem);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("BẢNG ĐIỂM", jPanel2);

        tblTongHopDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CHUYÊN ĐỀ", "TỔNG SỐ HV", "CAO NHẤT", "THẤP NHẤT", "ĐIỂM TB"
            }
        ));
        jScrollPane3.setViewportView(tblTongHopDiem);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("TỔNG HỢP ĐIỂM", jPanel3);

        jLabel3.setText("NĂM");

        cboYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboYearActionPerformed(evt);
            }
        });

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CHUYÊN ĐỀ", "SỐ KHÓA", "SỐ HV", "DOANH SỐ", "HP CAO NHẤT", "HP THẤP NHẤT", "HP TRUNG BÌNH"
            }
        ));
        jScrollPane4.setViewportView(tblDoanhThu);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DOANH THU", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKhoaHocActionPerformed
        // TODO add your handling code here:
        loadTableBangDiem();
    }//GEN-LAST:event_cboKhoaHocActionPerformed

    private void cboYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboYearActionPerformed
        // TODO add your handling code here:
        loadTableDoanhThu();
    }//GEN-LAST:event_cboYearActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThongKeJDialog dialog = new ThongKeJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<Object> cboKhoaHoc;
    private javax.swing.JComboBox<Object> cboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBangDiem;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTable tblNguoiHoc;
    private javax.swing.JTable tblTongHopDiem;
    // End of variables declaration//GEN-END:variables
}
