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
                          
    public static void InsertToProduit(String code_prod, String Designation,
            String Qte_stock ,String Date_stock,String seuil,String type,String num_cat) {

        String sql = "INSERT INTO `products`(`code_prod`, `Designation`,"
                + " `Qte_stock`, `Date_stock`, `CurrentBuyingPrice`,Position) "
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
        String sql = "UPDATE `Produit` SET `Active`= 0 WHERE   code_prod ='" + code_prod + "';";
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
        String sql = "UPDATE `Produit` set `Active`= 1 WHERE  code_prod ='" + code_prod + "';";
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
     * @param selection the Column you want to select
     * @return Selection Result in DefaultListModel
     */
    public static DefaultListModel<String> SelectProduit(String Active, String selection) {
            ResultSet rs = null;
        String sql = "select * from Produit where active ='"+Active+"';" ;

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
            JOptionPane.showMessageDialog(null, "selectString all from Produit\t with  " + selection + "\n" + e.getMessage());
            return null;
        }
    }
//============================//END OF THE Methode//============================
    
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
    
//============================//startOF THE Methode//============================
 /**
     * method of inserting Into Employee
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


 public static void InsertToEmployee(String code_emp ,String nom_emp,
         String prenom_emp,String grade_emp,String function,String cod_dep) {

        String sql = "INSERT INTO `Employee`(`code_emp`, `nom_emp`,"
                + " `prenom_emp`, `grade_emp`, `function`, `cod_dep`) "
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
            JOptionPane.showMessageDialog(null, "Added TO Employee\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert To Employee\n" + e.getMessage());
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
    public static void DeleteFromEmployee(String code_emp) {
        String sql = "UPDATE `Employee` SET `Active`= 0 WHERE   code_emp ='" + code_emp + "';";
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
    public static void RestoreFromEmployee(String code_emp) {
        String sql = "UPDATE `Employee` set `Active`= 1 WHERE code_emp ='" + code_emp + "';";
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
    public static DefaultListModel<String> SelectEmployee(String Active, String selection) {
            ResultSet rs = null;
        String sql = "select * from Employee where active ='"+Active+"';" ;

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
            JOptionPane.showMessageDialog(null, "selectString all from Employee\t with  " + selection + "\n" + e.getMessage());
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
public static DefaultListModel fillEmployeeList(JList List,String active){
          ResultSet rs = null;
        DefaultListModel model =(DefaultListModel) List.getModel(),
                code_emps= new DefaultListModel();
        model.removeAllElements();
        String sql ="select * from Employee where  `active`= '"+active+"'  LIMIT 30;";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String code_emp=rs.getString("code_emp"),
                Nom_emp=rs.getString("Nom_emp");
            model.addElement(Nom_emp);
            code_emps.addElement(code_emp);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
     return code_emps;
  }
//============================//END OF THE Methode//============================


//============================//START OF THE Methode//==========================
    /**
     *
     * @param table The JTable u want to fill
     * @param active 
     */
  public static void fillEmployeeTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from Employee where  `active`= '"+active+"'";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String code_emp =rs.getString("code_emp"),
                nom_emp=rs.getString("nom_emp"),
                prenom_emp=rs.getString("prenom_emp"),
                grade_emp=rs.getString("grade_emp"),
               function=rs.getString("function"),
                code_dep=rs.getString("code_dep");


            tab.addRow(new Object[]{code_emp,nom_emp,prenom_emp,grade_emp,function,code_dep});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================
  
//============================//table fournissurs//============================
  
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
     public static void InsertToFourniseur(
            String code_fournisseur ,String nom_fournisseur,String num_compte,String num_tel) {

        String sql = "INSERT INTO `Fourniseur`(`code_fournissuer`, `nom_fournissuer`,"
                + " `num_compte`, `num_tel`) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, code_fournisseur);
            pst.setString(2, nom_fournisseur);
            pst.setString(3, num_compte);
            pst.setString(4, num_tel);
            


            pst.execute();
            JOptionPane.showMessageDialog(null, "Added TO Fourniseur\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert To Fourniseur\n" + e.getMessage());
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
    public static void DeleteFromFourniseur(String code_fournisseur) {
        String sql = "UPDATE `Fourniseur` SET `Active`= 0 WHERE   code_fournisseur ='" + code_fournisseur + "';";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete From Fourniseur\n" + e.getMessage());
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
    public static void RestoreFromFourniseur(String code_fournisseur) {
        String sql = "UPDATE `Fourniseur` set `Active`= 1 WHERE code_fournisseur ='" + code_fournisseur + "';";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Restore From Fourniseur\n" + e.getMessage());
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
    public static DefaultListModel<String> SelectFourniseur(String Active, String selection) {
            ResultSet rs = null;
        String sql = "select * from Fourniseur where active ='"+Active+"';" ;

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
            JOptionPane.showMessageDialog(null, "selectString all from Fourniseur\t with  " + selection + "\n" + e.getMessage());
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
public static DefaultListModel fillFourniseurList(JList List,String active){
          ResultSet rs = null;
        DefaultListModel model =(DefaultListModel) List.getModel(),
                code_fournisseurs= new DefaultListModel();
        model.removeAllElements();
        String sql ="select * from Fourniseur where  `active`= '"+active+"'  LIMIT 30;";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String code_fournisseur=rs.getString("code_fournisseur"),
                nom_fournisseur=rs.getString("nom_fournisseur");
            model.addElement(nom_fournisseur);
            code_fournisseurs.addElement(code_fournisseur);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
     return code_fournisseurs;
  }
//============================//END OF THE Methode//============================


//============================//START OF THE Methode//==========================
    /**
     *
     * @param table The JTable u want to fill
     * @param active 
     */
  public static void fillFourniseurTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from Fourniseur where  `active`= '"+active+"'";
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
     * method of inserting Into Departments
     *
     * @param Code_dep
     *
     * @param Intitule_dep
     * @param Nom_chef
     * @param Prenom_chef
     * 
     *
     */

 public static void InsertToDepartments(
            String Code_dep ,String Intitule_dep,String Nom_chef,String Prenom_chef) {

        String sql = "INSERT INTO `Departments`(`code_fournissuer`, `Intitule_dep`,"
                + " `Nom_chef`, `Prenom_chef`) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, Code_dep);
            pst.setString(2, Intitule_dep);
            pst.setString(3, Nom_chef);
            pst.setString(4, Prenom_chef);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added TO Departments\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert To Departments\n" + e.getMessage());
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
    public static void DeleteFromDepartments(String code_dep) {
        String sql = "UPDATE `Departments` SET `Active`= 0 WHERE   code_dep ='" + code_dep + "';";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete From Departments\n" + e.getMessage());
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
    public static void RestoreFromDepartments(String code_dep) {
        String sql = "UPDATE `Departments` set `Active`= 1 WHERE code_dep ='" + code_dep + "';";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Restore From Departments\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * Selecting a column from¨Departments Without Condition
     *
     * @param Active this is active stats true or false
     * @param selection the Column you want to select
     * @return Selection Result in DefaultListModel
     */
    public static DefaultListModel<String> SelectDepartments(String Active, String selection) {
            ResultSet rs = null;
        String sql = "select * from Departmentsurniseur where active ='"+Active+"';" ;

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
            JOptionPane.showMessageDialog(null, "selectString all from Departments\t with  " + selection + "\n" + e.getMessage());
            return null;
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * @param List The List u want to fill With Componts
     * @param active 
     * @return code_dep list  
     */
public static DefaultListModel fillDepartmentsList(JList List,String active){
          ResultSet rs = null;
        DefaultListModel model =(DefaultListModel) List.getModel(),
                code_deps= new DefaultListModel();
        model.removeAllElements();
        String sql ="select * from Departments where  `active`= '"+active+"'  LIMIT 30;";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String code_dep=rs.getString("code_dep"),
                Intitule_dep=rs.getString("Intitule_dep");
            model.addElement(Intitule_dep);
            code_deps.addElement(code_deps);
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
     return code_deps;
  }
//============================//END OF THE Methode//============================


//============================//START OF THE Methode//==========================
    /**
     *
     * @param table The JTable u want to fill
     * @param active 
     */
  public static void fillDepartmentsTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from Departments where  `active`= '"+active+"'";
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
//==============================================================================   
//=============================//END OF THE Class//=============================
//==============================================================================

}
