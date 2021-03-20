package UI.Dashboard;

import info5100.university.brewingUniversityModel.Department.DepartmentDirectory;
import info5100.university.brewingUniversityModel.Department.Department;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Mihir Mehta / Hechen Gao
 */
public class DashBoardJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private DepartmentDirectory supplier;
    public DashBoardJPanel(JPanel upc, DepartmentDirectory s) {
        initComponents();
        userProcessContainer = upc;
        supplier = s;
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        allDepartmentBtn = new javax.swing.JButton();
        btnManageProductCatalog1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(650, 600));

        lblTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblTitle.setText("University Performance");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTitle.setIconTextGap(100);

        allDepartmentBtn.setText("All Departments");
        allDepartmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allDepartmentBtnActionPerformed(evt);
            }
        });

        btnManageProductCatalog1.setText("See Student performance");
        btnManageProductCatalog1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageProductCatalog1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Academic unit perofrmance");

        jLabel2.setText("Student job performance");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(allDepartmentBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnManageProductCatalog1)
                                .addGap(35, 35, 35)))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblTitle)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(allDepartmentBtn)
                    .addComponent(btnManageProductCatalog1))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(315, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void allDepartmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allDepartmentBtnActionPerformed

        
        jLabel1.setVisible(true);
//        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("./res/deptStudent.png")).getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH)));
    
        //jLabel1.setIcon(imageIcon);
        jLabel2.setVisible(true);
    }//GEN-LAST:event_allDepartmentBtnActionPerformed

    private void btnManageProductCatalog1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageProductCatalog1ActionPerformed
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
    }//GEN-LAST:event_btnManageProductCatalog1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allDepartmentBtn;
    private javax.swing.JButton btnManageProductCatalog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
