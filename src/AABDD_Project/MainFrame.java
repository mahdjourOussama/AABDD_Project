/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AABDD_Project;

import java.awt.BorderLayout;
import javax.swing.JFrame;



/**
 *
 * @author mahdj
 */
public class MainFrame extends javax.swing.JFrame {
    public static void check_prev(){
        if (action){
            Container.remove(consultation_Panel1);
            Container.add(action_Panel1,BorderLayout.CENTER);
            action_Panel1.Consultation_Container.add(consultation_Panel1,BorderLayout.CENTER);
        }else {
            Container.remove(action_Panel1);
            action_Panel1.Consultation_Container.remove(consultation_Panel1);
            Container.add(consultation_Panel1,BorderLayout.CENTER);
        }
        refrechFrame();
    }
    public static void refrechFrame(){
        Container.repaint();
        Container.revalidate();
        action_Panel1.Consultation_Container.repaint();
        action_Panel1.Consultation_Container.revalidate();
        consultation_Panel1.refresh();
    }
    /**
     * Creates new form NewJFrame
     */
    public MainFrame() {
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

        user3_Menu1 = new AABDD_Project.User3_Menu();
        consultation_Panel1 = new AABDD_Project.Consultation_Panel();
        user1_Menu1 = new AABDD_Project.User1_Menu();
        user2_Menu1 = new AABDD_Project.User2_Menu();
        action_Panel1 = new AABDD_Project.Action_Panel();
        Container = new javax.swing.JPanel();
        Log_in = new AABDD_Project.LogIn_Panel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 200));

        Container.setLayout(new java.awt.BorderLayout());
        Container.add(Log_in, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);   
                
            }
        });
    }
    public static boolean action=true;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Container;
    public static AABDD_Project.LogIn_Panel Log_in;
    public static AABDD_Project.Action_Panel action_Panel1;
    public static AABDD_Project.Consultation_Panel consultation_Panel1;
    public static AABDD_Project.User1_Menu user1_Menu1;
    public static AABDD_Project.User2_Menu user2_Menu1;
    public static AABDD_Project.User3_Menu user3_Menu1;
    // End of variables declaration//GEN-END:variables
}
