package UI.CourseSupplier;

import info5100.university.brewingUniversityModel.Department.DepartmentDirectory;
import info5100.university.brewingUniversityModel.Department.Department;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Mihir Mehta / Hechen Gao
 */
public class LoginDepartmentJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private DepartmentDirectory departmentDirectory;
    public LoginDepartmentJPanel(JPanel upc, DepartmentDirectory sd) {
        initComponents();
        this.userProcessContainer = upc;
        this.departmentDirectory = sd;
        
        cmbSupplier.removeAllItems();;
        for (Department supplier : departmentDirectory.getDepartmentlist()) {
            cmbSupplier.addItem(supplier);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSupplierChooser = new javax.swing.JLabel();
        cmbSupplier = new javax.swing.JComboBox();
        btnFind = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(650, 600));

        lblSupplierChooser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSupplierChooser.setText("Choose Department:");

        cmbSupplier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSupplierActionPerformed(evt);
            }
        });

        btnFind.setText("Login >>");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblTitle.setText("Department Portal");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTitle.setIconTextGap(50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSupplierChooser)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFind)
                            .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitle)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplierChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(371, 371, 371))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed

        Department department = (Department) cmbSupplier.getSelectedItem();
        DepartmentWorkAreaJPanel swajp = new DepartmentWorkAreaJPanel(userProcessContainer, department);
        userProcessContainer.add("DepartmentWorkAreaJPanel", swajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnFindActionPerformed

    private void cmbSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSupplierActionPerformed

    }//GEN-LAST:event_cmbSupplierActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFind;
    private javax.swing.JComboBox cmbSupplier;
    private javax.swing.JLabel lblSupplierChooser;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
    
}
