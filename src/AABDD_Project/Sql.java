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
public static int test_user_priv(String username,String password){
    ResultSet rs =null ;
    String sql="SELECT * FROM  accounts where password= '"+password+"'";
    try {
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            int priv= rs.getInt("id_prev"); 
            return priv;
    } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Test User\n"+e.getMessage());
            return 0;
    }
    
}
//============================//END OF THE Methode//============================

//============================//table produit//=================================
//============================//START OF THE Methode//==========================                       
    public static void InsertToProduit(String code_prod, String Designation,
            String Qte_stock ,String Date_stock,String seuil,String type,String num_cat) {

        String sql = "INSERT INTO products(code_prod, Designation,"
                + " Qte_stock, Date_stock, CurrentBuyingPrice,Position) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, code_prod);
            pst.setString(2, Designation);
            pst.setString(3, Qte_stock);
            pst.setString(4, Date_stock);
            pst.setString(5, seuil);
            pst.setString(6, type);
            pst.setString(6, num_cat);

            pst.execute();
            JOptionPane.showMessageDialog(null, "Added TO Produit\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert To Produit\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * Delete The Produit By turning off the Active
     *
     * @param code_prod
     */
    public static void DeleteFromProduit(String code_prod) {
        String sql = "UPDATE Produit SET active =0 WHERE   code_pro ='1';  ";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete From Produit\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * Restoring The Produit By turning on the Active
     *
     * @param code_prod
     */
    public static void RestoreFromProduit(String code_prod) {
        String sql = "UPDATE Produit set Active= 1 WHERE  code_pro =" + code_prod + ";";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Restore From Produit\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * Selecting a column from¨Produit Without Condition
     *
     * @param Active this is active stats true or false
     * @param ID the Column you want to select
     * @return Selection Result in DefaultListModel
     */
    public static DefaultListModel<String> SelectProduit(String Active, String ID) {
            ResultSet rs = null;
        String sql = "select * from Produit where active ="+Active+" and code_pro="+ID+";" ;

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            DefaultListModel<String> result = new DefaultListModel();

            while (rs.next()) {
                result.addElement(ID);
                result.addElement(rs.getString(2));
                result.addElement(rs.getString(3));
                result.addElement(rs.getString(4));
                result.addElement(rs.getString(5));
                result.addElement(rs.getString(6));
                result.addElement(rs.getString(7));
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "selectString all from Produit\t with  " + ID + "\n" + e.getMessage());
            return null;
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * @param table The JTable u want to fill
     * @param active 
     */
  public static void fillProduitTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from full_produit where  active= '"+active+"'";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String code_prod =rs.getString("code_pro"),
                Designation=rs.getString("Designation"),
                Qte_stock=rs.getString("Qte_stock"),
                Date_stock=rs.getString("Date_stock"),
               seuil=rs.getString("seuil"),
                type=rs.getString("type_pro"),
                num_cat=rs.getString("categorie");


            tab.addRow(new Object[]{code_prod,Designation,Qte_stock,Date_stock,seuil,type,num_cat});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================

 
//============================//table Employe//=================================
//============================//startOF THE Methode//===========================
 /**
     * method of inserting Into Employe
     *
     * @param code_emp
     *
     * @param nom_emp
     * @param prenom_emp
     * @param grade_emp
     * @param function
     * @param cod_dep
     * 
     *
     */
 public static void InsertToEmploye(String code_emp ,String nom_emp,
         String prenom_emp,String grade_emp,String function,String cod_dep) {

        String sql = "INSERT INTO Employe(code_emp, nom_emp,"
                + " prenom_emp, grade_emp, fonction, cod_dep) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, code_emp);
            pst.setString(2, nom_emp);
            pst.setString(3, prenom_emp);
            pst.setString(4, grade_emp);
            pst.setString(5, function);
            pst.setString(6, cod_dep);


            pst.execute();
            JOptionPane.showMessageDialog(null, "Added TO Employe\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert To Employe\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================
//============================//START OF THE Methode//==========================
   /**
     *
     * Delete The Product By turning of the Active
     *
     * @param code_emp
     */
    public static void DeleteFromEmploye(String code_emp) {
        String sql = "UPDATE Employe SET Active= 0 WHERE   code_emp ='" + code_emp + "';";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete From Products\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================
//============================//START OF THE Methode//========================== 
    /**
     *
     * Restoring The Product By turning of the Active
     *
     * @param code_emp
     */
    public static void RestoreFromEmploye(String code_emp) {
        String sql = "UPDATE Employe set Active= 1 WHERE code_emp ='" + code_emp + "';";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Restore From Products\n" + e.getMessage());
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
    public static DefaultListModel<String> SelectEmploye(String Active, String selection) {
            ResultSet rs = null;
        String sql = "select * from Employe where active ='"+Active+"';" ;

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
            JOptionPane.showMessageDialog(null, "selectString all from Employe\t with  " + selection + "\n" + e.getMessage());
            return null;
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * @param table The JTable u want to fill
     * @param active 
     */
  public static void fillEmployeTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from full_employe where  active= "+active+"";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String code_emp =rs.getString("code_emp"),
                nom_emp=rs.getString("nom_emp"),
                prenom_emp=rs.getString("prenom_emp"),
                grade_emp=rs.getString("grade_emp"),
               function=rs.getString("fonction"),
                code_dep=rs.getString("intitule_dep");
            tab.addRow(new Object[]{code_emp,nom_emp,prenom_emp,grade_emp,function,code_dep});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================
  
//============================//table fournissurs//=============================
//============================//START OF THE Methode//==========================
 /**
     * method of inserting Into Fournissuer
     *
     * @param code_fournisseur
     *
     * @param nom_fournisseur
     * @param num_compte
     * @param num_tel
     * 
     *
     */
     public static void InsertToFournisseur(
            String code_fournisseur ,String nom_fournisseur,String num_compte,String num_tel) {

        String sql = "INSERT INTO Fournisseur(code_fournissuer, nom_fournissuer,"
                + " num_compte, num_tel) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, code_fournisseur);
            pst.setString(2, nom_fournisseur);
            pst.setString(3, num_compte);
            pst.setString(4, num_tel);
            


            pst.execute();
            JOptionPane.showMessageDialog(null, "Added TO Fournisseur\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert To Fournisseur\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
/**
     *
     * Delete The Product By turning of the Active
     *
     * @param code_fournisseur
     */
    public static void DeleteFromFournisseur(String code_fournisseur) {
        String sql = "UPDATE Fournisseur SET Active= 0 WHERE   code_fournisseur ='" + code_fournisseur + "'";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete From Fournisseur\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
 /**
     *
     * Restoring The Product By turning of the Active
     *
     * @param code_emp
     */
    public static void RestoreFromFournisseur(String code_fournisseur) {
        String sql = "UPDATE Fournisseur set Active= 1 WHERE code_fournisseur ='" + code_fournisseur + "';";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Restore From Fournisseur\n" + e.getMessage());
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
    public static DefaultListModel<String> SelectFournisseur(String Active, String selection) {
            ResultSet rs = null;
        String sql = "select * from Fournisseur where active ='"+Active+"';" ;

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
            JOptionPane.showMessageDialog(null, "selectString all from Fournisseur\t with  " + selection + "\n" + e.getMessage());
            return null;
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * @param table The JTable u want to fill
     * @param active 
     */
  public static void fillFournisseurTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from Fournisseur where  active= '"+active+"'";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String code_fournisseur =rs.getString("code_fournisseur"),
                nom_fournisseur=rs.getString("nom_fournisseur"),
                num_compte=rs.getString("num_compte"),
                num_tel=rs.getString("num_tel");


            tab.addRow(new Object[]{code_fournisseur,nom_fournisseur,num_compte,num_tel});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================
  
//============================//table departements//============================
//============================//START OF THE Methode//==========================
 /**
     * method of inserting Into Departement
     *
     * @param Code_dep
     *
     * @param Intitule_dep
     * @param Nom_chef
     * @param Prenom_chef
     * 
     *
     */

 public static void InsertToDepartement(
            String Code_dep ,String Intitule_dep,String Nom_chef,String Prenom_chef) {

        String sql = "INSERT INTO Departement(code_fournissuer, Intitule_dep,"
                + " Nom_chef, Prenom_chef) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, Code_dep);
            pst.setString(2, Intitule_dep);
            pst.setString(3, Nom_chef);
            pst.setString(4, Prenom_chef);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added TO Departement\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert To Departement\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
 /**
     *
     * Delete The Product By turning of the Active
     *
     * @param Code_dep
     */
    public static void DeleteFromDepartement(String code_dep) {
        String sql = "UPDATE Departement SET Active= 0 WHERE   code_dep ='" + code_dep + "';";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete From Departement\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
/**
     *
     * Restoring The Product By turning of the Active
     *
     * @param code_dep
     */
    public static void RestoreFromDepartement(String code_dep) {
        String sql = "UPDATE Departement set Active= 1 WHERE code_dep ='" + code_dep + "';";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Restore From Departement\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * Selecting a column from¨Departement Without Condition
     *
     * @param Active this is active stats true or false
     * @param selection the Column you want to select
     * @return Selection Result in DefaultListModel
     */
    public static DefaultListModel<String> SelectDepartement(String Active, String selection) {
            ResultSet rs = null;
        String sql = "select * from Departementurniseur where active ='"+Active+"';" ;

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
            JOptionPane.showMessageDialog(null, "selectString all from Departement\t with  " + selection + "\n" + e.getMessage());
            return null;
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * @param table The JTable u want to fill
     * @param active 
     */
  public static void fillDepartementTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from Departement where  active= '"+active+"'";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String code_dep =rs.getString("code_dep"),
                Intitule_dep=rs.getString("Intitule_dep"),
                nom_chef=rs.getString("nom_chef"),
                prenom_chef=rs.getString("prenom_chef");


            tab.addRow(new Object[]{code_dep,Intitule_dep,nom_chef,prenom_chef});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================
//============================//START OF THE Methode//==========================
      public static void fillline_livraisonTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from line_livraison where  `active`= '"+active+"'";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String Num_bsortir =rs.getString("Num_cammande"),
                Qte=rs.getString("Qte"),
                product_name=rs.getString("product_name");


            tab.addRow(new Object[]{Num_bsortir,Qte,product_name});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================   
//============================//START OF THE Methode//==========================
       public static void fillline_affectationTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from line_affectation where  active= '"+active+"'";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String Num_cammande =rs.getString("Num_cammande"),
                Qte=rs.getString("qte"),
                product_name=rs.getString("product_name");


            tab.addRow(new Object[]{Num_cammande,Qte,product_name});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================
//============================//START OF THE Methode//==========================
       public static void alert_stock(String product){
        ResultSet rs = null;
        String sql ="select * from produit where  code_pro= '"+product+"'";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
        rs.next();
        int qte=rs.getInt("Qte_stock");
        if (qte<=0){
            JOptionPane.showMessageDialog(null, "the stock for the product :"+product +" is  "+qte);
        }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================
//==============================================================================   
//=============================//END OF THE Class//=============================
//==============================================================================

}
