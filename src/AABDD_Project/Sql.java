    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AABDD_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mahdj
 */
public  class Sql {
//==========================//START OF THE Declaration//========================
    static Connection conn = Oracle.ConnectDB();
    static PreparedStatement pst = null;
//============================//END OF THE Declaration//========================

//============================//START OF THE Methode//==========================
    /**
     * method of inserting Into SellingList
     *
     * @param IDProduct
     *
     * @param IDFacture
     * @param Qte
     * @param SellingPrice
     * @param BuyingPrice
     * @param Position
     * 
     *
     */
    public static void InsertToProduit(String IDProduct, String IDFacture,
            String Qte ,String SellingPrice,String BuyingPrice,String Position) {

        String sql = "INSERT INTO produit(`IDProduct`, `IDSellingFacture`,"
                + " `Qte`, `CurrentSellingPrice`, `CurrentBuyingPrice`,Position) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, IDProduct);
            pst.setString(2, IDFacture);
            pst.setString(3, Qte);
            pst.setString(4, SellingPrice);
            pst.setString(5, BuyingPrice);
            pst.setString(6, Position);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added TO SellingList\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert To SellingList\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * Delete The Product By turning of the Active
     *
     * @param ID
     */
    public static void DeleteFromSupplier(String ID) {
        String sql = "UPDATE `Supplier` SET `Active`= 0 WHERE   IDSupplier ='" + ID + "';";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete From Supplier\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * Restoring The Product By turning of the Active
     *
     * @param ID
     */
    public static void RestoreFromSupplier(String ID) {
        String sql = "UPDATE `Supplier` set `Active`= 1 WHERE IDSupplier ='" + ID + "';";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Restore From Supplier\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * Selecting a column from¨Product Without Condition
     *
     * @param Active this is active stats true or false
     * @param selection the Column you want to select
     * @return Selection Result in DefaultListModel
     */
    public static DefaultListModel<String> SelectProduct(String Active, String selection) {
            ResultSet rs = null;
        String sql = "select * from Product where Type =OriginalProduct AND active ='"+Active+"';" ;

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            DefaultListModel<String> result = new DefaultListModel();

            while (rs.next()) {
                result.addElement(rs.getString(selection));

            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "selectString all from Product\t with  " + selection + "\n" + e.getMessage());
            return null;
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * @param List The List u want to fill With Componts
     * @param active 
     * @return ID list  
     */
public static DefaultListModel fillCostumerList(JList List,String active){
          ResultSet rs = null;
        DefaultListModel model =(DefaultListModel) List.getModel(),
                IDs= new DefaultListModel();
        model.removeAllElements();
        String sql ="select * from costumer where  `active`= '"+active+"'  LIMIT 30;";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String ID=rs.getString("IDCostumer"),
                Name=rs.getString("Name");
            model.addElement(Name);
            IDs.addElement(ID);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
     return IDs;
  }
//============================//END OF THE Methode//============================


//============================//START OF THE Methode//==========================
    /**
     *
     * @param table The JTable u want to fill
     * @param active 
     */
  public static void fillSuppliersTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from Supplier where  `active`= '"+active+"'";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String ID=rs.getString("IDSupplier"),
                Name=rs.getString("Name"),
                phone=rs.getString("Address"),
                address=rs.getString("PhoneNumber");
            tab.addRow(new Object[]{ID,Name,address,phone});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
public static DefaultListModel<String []> SearchForRecepice (String ConfigID){
  ResultSet rs = null;
  String sql="SELECT * FROM `recipe` WHERE `IDConfig` ='"+ConfigID+"';";
  DefaultListModel ID= new DefaultListModel();
    try {
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery(sql);
        while (rs.next()){
            String []item ={rs.getString("Product"),rs.getString("Coef")  };
            ID.addElement(item);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
  return ID;  
}
//============================//END OF THE Methode//============================

public static void test(String username,String password){
     username.charAt(20);
}

//============================//START OF THE Methode//==========================
    /**
     *
     * @param Qte
     * @param ID Product ID
     */
public static void UpdateStock(String Qte, String ID){
    String sql="UPDATE `product` SET Qte =? WHERE `IDProduct`=?";
    try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, Qte);
            pst.setString(2, ID);
            pst.execute();
    } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "UpdateStock\n"+e.getMessage());
    }
}
//============================//END OF THE Methode//============================

//==============================================================================   
//=============================//END OF THE Class//=============================
//==============================================================================

}
