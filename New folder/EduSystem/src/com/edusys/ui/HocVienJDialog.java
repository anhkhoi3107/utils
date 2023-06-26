package com.edusys.ui;

import com.edusys.model.ChuyenDe;
import com.edusys.model.HocVien;
import com.edusys.model.KhoaHoc;
import com.edusys.model.NguoiHoc;
import com.edusys.utils.MsgBox;
import dao.ChuyenDeDAO;
import dao.HocVienDAO;
import dao.KhoaHocDAO;
import dao.NguoiHocDAO;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class HocVienJDialog extends javax.swing.JDialog {
    int row = 0;

    public HocVienJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();

    }

    void init() {
        tblGridView.setRowHeight(40);
        tblGridView.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {
                    com.setBackground(new Color(200, 200, 200));
                } else {
                    com.setBackground(new Color(255, 255, 255));
                }
                return com;
            }

        });

        setLocationRelativeTo(null);
        setTitle("QUẢN LÝ HỌC VIÊN KHÓA HỌC");
        fillTable();
        fillCombobox();
    }

    void fillTable() {
        DefaultTableModel model_table = (DefaultTableModel) tblGridView.getModel();
        ArrayList<com.edusys.model.HocVien> list = HocVienDAO.getInstance().selectAll();
        for (com.edusys.model.HocVien hv : list) {
            NguoiHoc nh = new NguoiHoc();
            nh.setMaNH(hv.getMaNH());
            NguoiHoc nhd = NguoiHocDAO.getInstance().selectByID(nh);
            model_table.addRow(new Object[]{
                hv.getMaHV(), hv.getMaKH(), nhd.getHoTen(), hv.getDiem()
            });
        }

    }
    
    

    public void fillCombobox() {
        DefaultComboBoxModel cboModel = new DefaultComboBoxModel();

        ArrayList<NguoiHoc> datas = HocVienDAO.getInstance().selectAllNotCourse();
        cboModel.addElement("");
        for (NguoiHoc data : datas) {
           
            cboModel.addElement(data.getHoTen());
        }
        cboNguoiHoc.setModel(cboModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        cboNguoiHoc = new javax.swing.JComboBox<>();
        txtDiem = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGridView = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoDaNhap = new javax.swing.JRadioButton();
        rdoChuaNhap = new javax.swing.JRadioButton();
        btnCapNhat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HỌC VIÊN KHÁC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        cboNguoiHoc.setFocusable(false);
        cboNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNguoiHocActionPerformed(evt);
            }
        });

        txtDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiemActionPerformed(evt);
            }
        });

        btnThem.setText("THÊM");
        btnThem.setFocusable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboNguoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThem)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNguoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HỌC VIÊN CỦA KHÓA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblGridView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ HV", "MÃ NH", "HỌ VÀ TÊN", "ĐIỂM", "XÓA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblGridView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblGridViewMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblGridView);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        buttonGroup1.add(rdoTatCa);
        rdoTatCa.setText("TẤT CẢ");
        rdoTatCa.setFocusPainted(false);
        jPanel2.add(rdoTatCa);

        buttonGroup1.add(rdoDaNhap);
        rdoDaNhap.setText("ĐÃ NHẬP ĐIỂM");
        rdoDaNhap.setFocusPainted(false);
        rdoDaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaNhapActionPerformed(evt);
            }
        });
        jPanel2.add(rdoDaNhap);

        buttonGroup1.add(rdoChuaNhap);
        rdoChuaNhap.setText("CHƯA NHẬP ĐIỂM");
        rdoChuaNhap.setFocusPainted(false);
        jPanel2.add(rdoChuaNhap);

        btnCapNhat.setText("CẬP NHẬT");
        btnCapNhat.setFocusPainted(false);
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCapNhat)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNguoiHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNguoiHocActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int row_Count = tblGridView.getRowCount();
        for (int i = 0; i < row_Count; i++) {
            String maHV = tblGridView.getValueAt(i, 0).toString();
            
        }

    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void tblGridViewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGridViewMousePressed
        if (evt.getClickCount() == 2) {
            this.row = tblGridView.rowAtPoint(evt.getPoint());
            
            
            
        }
    }//GEN-LAST:event_tblGridViewMousePressed

    private void rdoDaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaNhapActionPerformed
        
    }//GEN-LAST:event_rdoDaNhapActionPerformed

    private void txtDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiemActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    HocVienJDialog dialog = new HocVienJDialog(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception ex) {

                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboNguoiHoc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoChuaNhap;
    private javax.swing.JRadioButton rdoDaNhap;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JTable tblGridView;
    private javax.swing.JTextField txtDiem;
    // End of variables declaration//GEN-END:variables
}
