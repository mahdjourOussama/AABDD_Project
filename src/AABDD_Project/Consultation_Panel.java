/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AABDD_Project;

/**
 *
 * @author mahdj
 */
public class Consultation_Panel extends javax.swing.JPanel {

    /**
     * Creates new form Categories_Panel
     */
    public Consultation_Panel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        departments_Table1 = new AABDD_Project.Departments_Table();
        employee_Table1 = new AABDD_Project.Employee_Table();
        fourniseur_Table1 = new AABDD_Project.Fourniseur_Table();
        products_Table1 = new AABDD_Project.Products_Table();
        Searchfield = new javax.swing.JTextField();
        Table_Container = new javax.swing.JPanel();

        javax.swing.GroupLayout Table_ContainerLayout = new javax.swing.GroupLayout(Table_Container);
        Table_Container.setLayout(Table_ContainerLayout);
        Table_ContainerLayout.setHorizontalGroup(
            Table_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Table_ContainerLayout.setVerticalGroup(
            Table_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Searchfield, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
            .addComponent(Table_Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Table_Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public String table="";
    public boolean active=true;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Searchfield;
    private javax.swing.JPanel Table_Container;
    private AABDD_Project.Departments_Table departments_Table1;
    private AABDD_Project.Employee_Table employee_Table1;
    private AABDD_Project.Fourniseur_Table fourniseur_Table1;
    private AABDD_Project.Products_Table products_Table1;
    // End of variables declaration//GEN-END:variables
}