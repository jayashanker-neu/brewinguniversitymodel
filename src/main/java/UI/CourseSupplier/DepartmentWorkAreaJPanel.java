package UI.CourseSupplier;

import info5100.university.brewingUniversityModel.Department.Department;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Mihir Mehta / Hechen Gao
 */
public class DepartmentWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Department supplier;
    public DepartmentWorkAreaJPanel(JPanel upc, Department s) {
        initComponents();
        userProcessContainer = upc;
        supplier = s;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnManageProductCatalog = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(650, 600));

        lblTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblTitle.setText("Department Work Area");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTitle.setIconTextGap(100);

        btnManageProductCatalog.setText("Manage Course Catalog >>");
        btnManageProductCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageProductCatalogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(400, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnManageProductCatalog)
                        .addGap(28, 28, 28))
                    .addComponent(lblTitle))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblTitle)
                .addGap(98, 98, 98)
                .addComponent(btnManageProductCatalog)
                .addContainerGap(420, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void btnManageProductCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageProductCatalogActionPerformed

        ManageCourseCatalogJPanel mpcjp = new ManageCourseCatalogJPanel(userProcessContainer, supplier);
        userProcessContainer.add("ManageProductCatalogJPanel", mpcjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageProductCatalogActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageProductCatalog;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
