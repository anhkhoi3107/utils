package com.edusys.ui;

import com.edusys.model.ChuyenDe;
import com.edusys.model.KhoaHoc;
import com.edusys.utils.XImage;
import dao.ChuyenDeDAO;
import dao.KhoaHocDAO;
import dao.NguoiHocDAO;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class KhoaHocJDialog extends javax.swing.JDialog {

    int index = 0;
    KhoaHocDAO dao = new KhoaHocDAO();
    ChuyenDeDAO cddao = new ChuyenDeDAO();
    int row = 0;

    public KhoaHocJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void init() {
        tblKhoaHoc.setRowHeight(40);
        tblKhoaHoc.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        setTitle("QUẢN LÝ KHÓA HỌC");
        fillTableKhoaHoc();
        fillComboBox();
    }

    void fillTableKhoaHoc() {
        DefaultTableModel model_table = (DefaultTableModel) tblKhoaHoc.getModel();
        ArrayList<com.edusys.model.KhoaHoc> list = KhoaHocDAO.getInstance().selectAll();
        for (com.edusys.model.KhoaHoc kh : list) {
            model_table.addRow(new Object[]{
                kh.getMaKH(), kh.getMaCD(), kh.getThoiLuong(), kh.getHocPhi(), kh.getNgayKG(), null, kh.getNgayTao()
            });

        }
    }

    void fillComboBox() {
        cboChuyenDe.addItem("");
        ArrayList<ChuyenDe> list_CD = ChuyenDeDAO.getInstance().selectAll();
        for (ChuyenDe chuyenDe : list_CD) {
            cboChuyenDe.addItem(chuyenDe.getTenCD());
        }

    }

    void edit() {
        try {
            int MaKH =  Integer.valueOf( tblKhoaHoc.getValueAt(this.row, 0)+"");
            KhoaHoc khm = new KhoaHoc();
            khm.setMaKH(MaKH);
            KhoaHoc model = dao.selectByID(khm);
            System.out.println(model);
            if (model != null) {

                tabs.setSelectedIndex(0);
                setForm(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setForm(KhoaHoc model) {
        try {
            ChuyenDe cd = new ChuyenDe();
            cd.setMaCD(model.getMaCD());
            ChuyenDe cdd = ChuyenDeDAO.getInstance().selectById(cd);
            cboChuyenDe.setSelectedItem(cdd.getTenCD());
            txtHocPhi.setText(model.getHocPhi() + "");
            txtNguoiTao.setText(null);
            txtNgayKG.setText(model.getNgayKG() + "");
            txtThoiLuong.setText(model.getThoiLuong() + "");
            txtNgayTao.setText(model.getNgayTao() + "");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        tabz = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboChuyenDe = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHocPhi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtThoiLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNguoiTao = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        txtNgayKG = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhoaHoc = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("QUẢN LÝ KHÓA HỌC");

        jLabel2.setText("Chuyên đề");

        jLabel3.setText("Ngày Khai Giảng");

        jLabel4.setText("Học Phí");

        jLabel5.setText("Thời lượng(giờ)");

        jLabel6.setText("Người tạo");

        jLabel7.setText("Ngày tạo");

        jLabel8.setText("Ghi chú");

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        btnThem.setText("THÊM");

        btnMoi.setText("MỚI");

        btnSua.setText("SỬA");

        btnXoa.setText("XÓA");

        btnFirst.setText("<|");

        btnPrev.setText("<<");

        btnNext.setText(">>");

        btnLast.setText("|>");

        javax.swing.GroupLayout tabzLayout = new javax.swing.GroupLayout(tabz);
        tabz.setLayout(tabzLayout);
        tabzLayout.setHorizontalGroup(
            tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabzLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabzLayout.createSequentialGroup()
                        .addGroup(tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtGhiChu)
                            .addGroup(tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addGroup(tabzLayout.createSequentialGroup()
                                    .addGroup(tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtNguoiTao)
                                        .addGroup(tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtHocPhi, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cboChuyenDe, javax.swing.GroupLayout.Alignment.LEADING, 0, 392, Short.MAX_VALUE))
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6)))
                                    .addGap(47, 47, 47)
                                    .addGroup(tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5)
                                        .addComponent(txtThoiLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtNgayTao)
                                        .addComponent(txtNgayKG, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(tabzLayout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabzLayout.setVerticalGroup(
            tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabzLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayKG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnMoi)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabs.addTab("CẬP NHẬT", tabz);

        tblKhoaHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ KH", "CHUYÊN ĐỀ", "THỜI LƯỢNG", "HỌC PHÍ", "KHAI GIẢNG", "TẠO BỞI", "NGÀY TẠO"
            }
        ));
        tblKhoaHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKhoaHocMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhoaHoc);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );

        tabs.addTab("DANH SÁCH", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhoaHocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoaHocMousePressed
        if (evt.getClickCount() == 2) {
            int rowM = tblKhoaHoc.getSelectedRow();
            this.row = rowM;
            tabs.setSelectedIndex(0);
            edit();

        }
    }//GEN-LAST:event_tblKhoaHocMousePressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KhoaHocJDialog dialog = new KhoaHocJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cboChuyenDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JPanel tabz;
    private javax.swing.JTable tblKhoaHoc;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtHocPhi;
    private javax.swing.JTextField txtNgayKG;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNguoiTao;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
