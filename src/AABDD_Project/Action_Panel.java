/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AABDD_Project;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author mahdj
 */
public class Action_Panel extends javax.swing.JPanel {

    /**
     * Creates new form Product_Panel
     */
    public Action_Panel() {
        initComponents();
    }
    public void fillPopUp(String active){
        table=MainFrame.consultation_Panel1.table;
        container.removeAll();
            if (table.equalsIgnoreCase("produit")){
                container.add(products_Form1,BorderLayout.CENTER);
                products_Form1.fillForm(active);
             }else if (table.equalsIgnoreCase("affectation")){
                 container.add(affectation_Form1,BorderLayout.CENTER);
                 affectation_Form1.fillForm(active);
             }else if (table.equalsIgnoreCase("command")){
                 container.add(command_Form1,BorderLayout.CENTER);
             }else if (table.equalsIgnoreCase("department")){
                 container.add(departments_Form1,BorderLayout.CENTER);
                 departments_Form1.fillForm(active);
             }else if (table.equalsIgnoreCase("employe")){
                 container.add(employee_Form1,BorderLayout.CENTER);
                 employee_Form1.fillForm(active);
             }else if (table.equalsIgnoreCase("fournisseur")){
                 container.add(fournisseur_form1,BorderLayout.CENTER);
             }else if (table.equalsIgnoreCase("sortie")){
                 container.add(sortie_Form1,BorderLayout.CENTER);
             }else if (table.equalsIgnoreCase("livraison")){
                 container.add(livraison_Form1,BorderLayout.CENTER);
             }else if (table.equalsIgnoreCase("categorie")){
                container.add(cat_Form1,BorderLayout.CENTER);
             }else {
                 JOptionPane.showMessageDialog(null, "error dans le type de table");
             }

        container.repaint();
        container.revalidate();
        PopUp.setLocationRelativeTo(null);
        PopUp.setVisible(true);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopUp = new javax.swing.JDialog();
        container = new javax.swing.JPanel();
        cat_Form1 = new AABDD_Project.Cat_Form();
        employee_Form1 = new AABDD_Project.Employee_Form();
        fournisseur_form1 = new AABDD_Project.Fournisseur_Form();
        products_Form1 = new AABDD_Project.Products_Form();
        sortie_Form1 = new AABDD_Project.Sortie_Form();
        affectation_Form1 = new AABDD_Project.Affectation_Form();
        command_Form1 = new AABDD_Project.Command_Form();
        livraison_Form1 = new AABDD_Project.Livraison_Form();
        departments_Form1 = new AABDD_Project.Departments_Form();
        ADD = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Restore = new javax.swing.JButton();
        Deleted_Checkbox = new javax.swing.JCheckBox();
        Consultation_Container = new javax.swing.JPanel();

        PopUp.setBackground(new java.awt.Color(0, 204, 204));
        PopUp.setMinimumSize(new java.awt.Dimension(400, 400));

        container.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout PopUpLayout = new javax.swing.GroupLayout(PopUp.getContentPane());
        PopUp.getContentPane().setLayout(PopUpLayout);
        PopUpLayout.setHorizontalGroup(
            PopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );
        PopUpLayout.setVerticalGroup(
            PopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );

        ADD.setText("ADD");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Restore.setText("Restore");
        Restore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestoreActionPerformed(evt);
            }
        });

        Deleted_Checkbox.setText("Deleted");
        Deleted_Checkbox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Deleted_Checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Deleted_CheckboxActionPerformed(evt);
            }
        });

        Consultation_Container.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ADD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(Restore, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(Deleted_Checkbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(Consultation_Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(Deleted_Checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Restore, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(Consultation_Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        edit=true;
        if(active){
            fillPopUp("1");
        }else {
            fillPopUp("0");
        }
        MainFrame.consultation_Panel1.fillTable();
    }//GEN-LAST:event_UpdateActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        edit=false;
        if(active){
            fillPopUp("1");
        }else {
            fillPopUp("0");
        }
        MainFrame.consultation_Panel1.fillTable();
    }//GEN-LAST:event_ADDActionPerformed

    private void Deleted_CheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Deleted_CheckboxActionPerformed
        active=!Deleted_Checkbox.isSelected();
        MainFrame.consultation_Panel1.active=active;
        MainFrame.consultation_Panel1.fillTable();
        
    }//GEN-LAST:event_Deleted_CheckboxActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        table=MainFrame.consultation_Panel1.table;
        String ID=MainFrame.consultation_Panel1.Selected_ID();
        if (table.equalsIgnoreCase("produit")){
            Sql.DeleteFromProduit(ID);
        }else if (table.equalsIgnoreCase("affectation")){
            Sql.DeleteFromAffectation(ID);
        }else if (table.equalsIgnoreCase("command")){
            Sql.DeleteFromcommande(ID);
        }else if (table.equalsIgnoreCase("department")){
            Sql.DeleteFromDepartement(ID);
        }else if (table.equalsIgnoreCase("employe")){
            Sql.DeleteFromEmploye(ID);
        }else if (table.equalsIgnoreCase("fournisseur")){
            Sql.DeleteFromFournisseur(ID);
        }else if (table.equalsIgnoreCase("sortie")){
            Sql.DeleteFromsortie(ID);
        }else if (table.equalsIgnoreCase("livraison")){
            Sql.DeleteFromlivraison(ID);
        }else if (table.equalsIgnoreCase("categorie")){
           Sql.DeleteFromcat(ID);
        }else {
            JOptionPane.showMessageDialog(null, "error dans le type de table");
        }
        MainFrame.consultation_Panel1.fillTable();
        Sql.commit();
    }//GEN-LAST:event_DeleteActionPerformed

    private void RestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestoreActionPerformed
        table=MainFrame.consultation_Panel1.table;
        String ID=MainFrame.consultation_Panel1.Selected_ID();
        if (table.equalsIgnoreCase("produit")){
           Sql.RestoreFromProduit(ID);
        }else if (table.equalsIgnoreCase("affectation")){
           Sql.RestoreFromAffectation(ID);
        }else if (table.equalsIgnoreCase("command")){
            Sql.RestoreFromcommande(ID);
        }else if (table.equalsIgnoreCase("department")){
            Sql.RestoreFromDepartement(ID);
        }else if (table.equalsIgnoreCase("employe")){
            Sql.RestoreFromEmploye(ID);
        }else if (table.equalsIgnoreCase("fournisseur")){
            Sql.RestoreFromFournisseur(ID);
        }else if (table.equalsIgnoreCase("sortie")){
            Sql.RestoreFromsortie(ID);
        }else if (table.equalsIgnoreCase("livraison")){
            Sql.RestoreFromlivraison(ID);
        }else if (table.equalsIgnoreCase("categorie")){
            Sql.RestoreFromcat(ID);
        }else {
            JOptionPane.showMessageDialog(null, "error dans le type de table");
        }
        MainFrame.consultation_Panel1.fillTable();
        Sql.commit();
    }//GEN-LAST:event_RestoreActionPerformed
    public static String table ="";
    public static boolean active=true,edit=false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    public javax.swing.JPanel Consultation_Container;
    private javax.swing.JButton Delete;
    private javax.swing.JCheckBox Deleted_Checkbox;
    public static javax.swing.JDialog PopUp;
    private javax.swing.JButton Restore;
    private javax.swing.JButton Update;
    private AABDD_Project.Affectation_Form affectation_Form1;
    private AABDD_Project.Cat_Form cat_Form1;
    private AABDD_Project.Command_Form command_Form1;
    private javax.swing.JPanel container;
    private AABDD_Project.Departments_Form departments_Form1;
    private AABDD_Project.Employee_Form employee_Form1;
    private AABDD_Project.Fournisseur_Form fournisseur_form1;
    private AABDD_Project.Livraison_Form livraison_Form1;
    private AABDD_Project.Products_Form products_Form1;
    private AABDD_Project.Sortie_Form sortie_Form1;
    // End of variables declaration//GEN-END:variables
}
