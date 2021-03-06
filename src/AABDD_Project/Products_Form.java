/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AABDD_Project;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;

/**
 *
 * @author mahdj
 */
public class Products_Form extends javax.swing.JPanel {

    /**
     * Creates new form Employee_form
     */
    public Products_Form() {
        initComponents();
        
    }
    public void fillForm(String actif){
        idlist=Sql.fillComboBox(CategorieComboBox,"categorie","categorie", actif);
        if(MainFrame.action_Panel1.edit){
            String id=MainFrame.consultation_Panel1.Selected_ID();
            DefaultListModel l = Sql.SelectProduit(actif, id);
            codeTXt.setEditable(false);
            codeTXt.setText(id);
            designation.setText(l.getElementAt(1).toString());
            QteTxt.setText(l.getElementAt(2).toString());
            ((JTextField) DateTxt.getDateEditor().getUiComponent()).setText(l.getElementAt(3).toString());
            SeuilTxt.setText(l.getElementAt(4).toString());
            TypeTxt.setText(l.getElementAt(5).toString());
            Submit_button.setText("Update");
        }else{
            codeTXt.setText("");
            designation.setText("");
            QteTxt.setText("");
            ((JTextField) DateTxt.getDateEditor().getUiComponent()).setText("");
            SeuilTxt.setText("");
            TypeTxt.setText("");
            Submit_button.setText("ADD");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codeTXt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        designation = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        QteTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CategorieComboBox = new javax.swing.JComboBox<>();
        Clear_button = new javax.swing.JButton();
        Submit_button = new javax.swing.JButton();
        TypeTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SeuilTxt = new javax.swing.JTextField();
        DateTxt = new com.toedter.calendar.JDateChooser();

        jLabel1.setText("Code");

        jLabel2.setText("Designation");

        jLabel3.setText("Qte Stock");

        jLabel4.setText("Date");

        jLabel5.setText("Categorie");

        CategorieComboBox.setModel(mCombo);

        Clear_button.setText("Clear");
        Clear_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_buttonActionPerformed(evt);
            }
        });

        Submit_button.setText("ADD");
        Submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submit_buttonActionPerformed(evt);
            }
        });

        jLabel6.setText("Type");

        jLabel7.setText("Seuil");

        DateTxt.setDateFormatString("dd/MMM/yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codeTXt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(designation, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QteTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DateTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CategorieComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Clear_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Submit_button))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SeuilTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TypeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(codeTXt)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(designation)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(QteTxt)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SeuilTxt)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TypeTxt)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CategorieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clear_button)
                    .addComponent(Submit_button)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_buttonActionPerformed
        codeTXt.setText("");
            designation.setText("");
            QteTxt.setText("");
            ((JTextField) DateTxt.getDateEditor().getUiComponent()).setText("");
            SeuilTxt.setText("");
            TypeTxt.setText("");
    }//GEN-LAST:event_Clear_buttonActionPerformed

    private void Submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submit_buttonActionPerformed
        String code=codeTXt.getText(),
                name=designation.getText(),
                qte=QteTxt.getText(),
                date=((JTextField) DateTxt.getDateEditor().getUiComponent()).getText(),
                seuil=SeuilTxt.getText(),
                type=TypeTxt.getText(),
                cat=idlist.getElementAt(CategorieComboBox.getSelectedIndex()).toString();
        if(MainFrame.action_Panel1.edit){
            Sql.UpdateProduit(code, name, qte, date, seuil, type, cat);
        }else {
            Sql.InsertToProduit(code, name, qte, date, seuil, type, cat);
        }
    }//GEN-LAST:event_Submit_buttonActionPerformed
    public DefaultComboBoxModel mCombo = new DefaultComboBoxModel();
    public DefaultListModel idlist =new DefaultListModel();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> CategorieComboBox;
    public javax.swing.JButton Clear_button;
    private com.toedter.calendar.JDateChooser DateTxt;
    public javax.swing.JTextField QteTxt;
    public javax.swing.JTextField SeuilTxt;
    public javax.swing.JButton Submit_button;
    public javax.swing.JTextField TypeTxt;
    public javax.swing.JTextField codeTXt;
    public javax.swing.JTextField designation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
