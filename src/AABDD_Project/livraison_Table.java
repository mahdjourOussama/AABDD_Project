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
public class livraison_Table extends javax.swing.JPanel {

    /**
     * Creates new form Departments_Panel
     */
    public livraison_Table() {
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

        Employe_table = new javax.swing.JScrollPane();
        Laivraison_Table = new javax.swing.JTable();
        Detailed = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Detailed_table = new javax.swing.JTable();

        Laivraison_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "code", "date", "code emp", "empl name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Employe_table.setViewportView(Laivraison_Table);
        if (Laivraison_Table.getColumnModel().getColumnCount() > 0) {
            Laivraison_Table.getColumnModel().getColumn(0).setResizable(false);
            Laivraison_Table.getColumnModel().getColumn(1).setResizable(false);
            Laivraison_Table.getColumnModel().getColumn(2).setResizable(false);
            Laivraison_Table.getColumnModel().getColumn(3).setResizable(false);
        }

        Detailed.setText("Detaile");

        Detailed_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produit", "Qte"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Detailed_table);
        if (Detailed_table.getColumnModel().getColumnCount() > 0) {
            Detailed_table.getColumnModel().getColumn(0).setResizable(false);
            Detailed_table.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Employe_table, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Detailed, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Employe_table, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Detailed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Detailed;
    private javax.swing.JTable Detailed_table;
    private javax.swing.JScrollPane Employe_table;
    public javax.swing.JTable Laivraison_Table;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}