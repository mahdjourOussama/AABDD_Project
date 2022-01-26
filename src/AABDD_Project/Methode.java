/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AABDD_Project;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mahdj
 */
public class Methode {

//==========================//START OF THE Declaration//========================
//============================//END OF THE Declaration//========================

//============================//START OF THE Methode//==========================   
    /**
     * SearchInTheTable From table
     * @param table
     * @param text
     */
    public static void SearchInTheTable (JTable table,JTextField text){
        DefaultTableModel model =(DefaultTableModel) table.getModel();
        String search = text.getText();
        TableRowSorter <DefaultTableModel> tr = new TableRowSorter<>(model);
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" +search));
    }
//============================//END OF THE Methode//============================

 
//============================//START OF THE Methode//==========================
    /**
     * Restore from Given table
     * @param table
     */
    public static String get_Selected_ID (JTable table){
        try {
            int Selecteed =table.getSelectedRow();
            String ID =table.getValueAt(Selecteed, 0).toString();
            return ID;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Select Item");
            return null;
        }
    }
//============================//END OF THE Methode//============================
 
//============================//START OF THE Methode//==========================
    /**
     * @param table The JTable u want to Clear
     */
  public static void ClearTable(JTable table){
        DefaultTableModel tab =(DefaultTableModel) table.getModel();
        while(table.getRowCount()>0){
            tab.removeRow(0);
        }
  }
//============================//END OF THE Methode//============================


//============================//START OF THE Methode//==========================
public static DefaultListModel getTableContent(JTable table){
                 DefaultTableModel model =(DefaultTableModel) table.getModel();
            int selected =table.getSelectedRow(),colomn=table.getColumnCount();
            DefaultListModel selectedValues=new DefaultListModel();
            if (selected>-1) {
                for (int i = 0; i < colomn; i++) {
                    selectedValues.addElement(model.getValueAt(selected, i).toString());
                }
                return selectedValues;  
            }else{
             JOptionPane.showMessageDialog(null, "Please Select Item");
             return selectedValues;
            }
                  
    }
//============================//END OF THE Methode//============================
 
//============================//START OF THE Methode//==========================
  /**
     * Make the TextFIled Accept only Double
     * @param evt
     * @param text
     */
public static void DoubleTextFiled (KeyEvent evt ,JTextField text ){
            char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
            || (c == KeyEvent.VK_BACK_SPACE)
            || ((c == KeyEvent.VK_PERIOD) && !text.getText().contains("."))
            || (c == KeyEvent.VK_DELETE))) {
        new JFrame().getToolkit().beep();
        evt.consume();
        }
}
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
  /**
     * Make the TextFIled Accept only Intgers
     * @param evt
     * @param text
     */
public static void IntegerTextFiled (KeyEvent evt ,JTextField text ){
            char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
            || (c == KeyEvent.VK_BACK_SPACE)
            || (c == KeyEvent.VK_DELETE))) {
        new JFrame().getToolkit().beep();
        evt.consume();
        }
}
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
public static String GetTodayDate(){
    Calendar cal = Calendar.getInstance();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            String today = dt.format(cal.getTime());
    return today;
}
//============================//END OF THE Methode//============================

//==============================================================================
//=============================//END OF THE Class//=============================
//==============================================================================

}
