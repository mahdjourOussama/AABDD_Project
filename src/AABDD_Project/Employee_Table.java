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
public class Employee_Table extends javax.swing.JPanel {

    /**
     * Creates new form Departments_Panel
     */
    public Employee_Table() {
        initComponents();
    }
    public void fillTable(boolean active){
        String active_stat= "1";
        if (active){
            active_stat="1";
        }else {
            active_stat="0";
        }
        Sql.fillEmployeTable(Employee_Table, active_stat);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Employe_table = new javax.swing.JScrollPane();
        Employee_Table = new javax.swing.JTable();

        Employee_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "code", "first name", "family name", "Grade", "Fonction", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Employe_table.setViewportView(Employee_Table);
        if (Employee_Table.getColumnModel().getColumnCount() > 0) {
            Employee_Table.getColumnModel().getColumn(0).setResizable(false);
            Employee_Table.getColumnModel().getColumn(1).setResizable(false);
            Employee_Table.getColumnModel().getColumn(2).setResizable(false);
            Employee_Table.getColumnModel().getColumn(3).setResizable(false);
            Employee_Table.getColumnModel().getColumn(4).setResizable(false);
            Employee_Table.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Employe_table, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Employe_table, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Employe_table;
    public javax.swing.JTable Employee_Table;
    // End of variables declaration//GEN-END:variables
}
