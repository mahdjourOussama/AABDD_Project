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
    String sql="SELECT * FROM  accounts where username='"+username+
            "' and password= '"+password+"'";
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
//============================//START OF THE Methode//==========================
public static DefaultListModel FillList(DefaultListModel model,String table,String Active,String selection){
    ResultSet rs =null ;
    model.removeAllElements();
    String sql="SELECT * FROM  "+table+" where active= '"+Active+"'";
    DefaultListModel ids= new DefaultListModel();
    try {
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                model.addElement(rs.getString(selection));
                ids.addElement(rs.getString(1));
            }
            
            
    } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "fill list\n"+e.getMessage());
            
    }
    return ids;
}
//============================//END OF THE Methode//============================ 
//============================//START OF THE Methode//==========================
    public static void insertIntoAccount(String Id_user,String username,
            String password,String Id_prev,String active){
    String sql="INSERT INTO accounts (id_user, username, password,ID_PREV,ACTIVE )VALUES (?,?,?,?,?)";
    try {
             pst = conn.prepareStatement(sql);
            pst.setString(1, Id_user);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.setString(4,Id_prev );
            pst.setString(5, active);
            pst.execute();
            
    } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert accounts \n"+e.getMessage());
            
    }
}
//============================//END OF THE Methode//============================ 
//============================//START OF THE Methode//==========================
    public static void insertIntoLine_Affectation(String produit,String qte,String num_baf){
    String sql="INSERT INTO concerner(num_baf, code_pro, Qte_aff )VALUES (?,?,?)";
    try {
             pst = conn.prepareStatement(sql);
            pst.setString(1, num_baf);
            pst.setString(2, produit);
            pst.setString(3, qte);
            pst.execute();
            
    } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert line affectation \n"+e.getMessage());
            
    }
}
//============================//END OF THE Methode//============================ 
//============================//START OF THE Methode//==========================
    public static void insertIntoLine_Command(String produit,String qte,String num_bco){
    String sql="INSERT INTO contenir  (num_bco, code_pro, Qte_cde )VALUES (?,?,?)";
    try {
             pst = conn.prepareStatement(sql);
            pst.setString(1, num_bco);
            pst.setString(2, produit);
            pst.setString(3, qte);
            pst.execute();
            
    } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert line affectation \n"+e.getMessage());
            
    }
}
//============================//END OF THE Methode//============================ 
//============================//START OF THE Methode//==========================
    public static void insertIntoLine_Sortie(String produit,String qte,String num_bco){
    String sql="INSERT INTO se_refere  (num_bso, code_pro, Qte_sortie )VALUES (?,?,?)";
    try {
             pst = conn.prepareStatement(sql);
            pst.setString(1, num_bco);
            pst.setString(2, produit);
            pst.setString(3, qte);
            pst.execute();
            
    } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert line affectation \n"+e.getMessage());
            
    }
}
//============================//END OF THE Methode//============================ 
    //============================//START OF THE Methode//==========================
    public static void insertIntoLine_Livraison(String produit,String qte,String num_bco){
    String sql="INSERT INTO renfermer  (num_bliv, code_pro, Qte_liv )VALUES (?,?,?)";
    try {
             pst = conn.prepareStatement(sql);
            pst.setString(1, num_bco);
            pst.setString(2, produit);
            pst.setString(3, qte);
            pst.execute();
            
    } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert line affectation \n"+e.getMessage());
            
    }
}
//============================//END OF THE Methode//============================ 
//============================//table Employe//=================================
//============================//START OF THE Methode//==========================                       
    public static void InsertToProduit(String code_pro, String Designation,
            String Qte_stock ,String Date_stock,String seuil,String type,String num_cat) {

        String sql = "INSERT INTO produit(code_pro, Designation,"
                + " Qte_stock, Date_stock, seuil,type_pro,num_cat) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, code_pro);
            pst.setString(2, Designation);
            pst.setString(3, Qte_stock);
            pst.setString(4, Date_stock);
            pst.setString(5, seuil);
            pst.setString(6, type);
            pst.setString(7, num_cat);

            pst.execute();
            JOptionPane.showMessageDialog(null, "Added TO Produit\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert To Produit\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================
//============================//START OF THE Methode//==========================                       
    public static void UpdateProduit(String code_pro, String Designation,
            String Qte_stock ,String Date_stock,String seuil,String type,String num_cat) {

        String sql = "UPDATE Produit set  Designation ='"+Designation
                + "' ,Qte_stock="+Qte_stock+", date_stock =TO_DATE('"+Date_stock+ "', 'dd/MM/yyyy '),"
                + " seuil ='"+seuil+"',type_pro ='"+type+"',num_cat ='"+num_cat+
                " 'where code_pro ="+code_pro;
        try {
            pst = conn.prepareStatement(sql);
            pst.execute(sql);
            JOptionPane.showMessageDialog(null, " Produit updated\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "produit update\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================
//============================//START OF THE Methode//==========================
    /**
     *
     * Delete The Produit By turning off the Active
     *
     * @param code_pro
     */
    public static void DeleteFromProduit(String code_pro) {
        String sql ="UPDATE Produit set Active= 0 WHERE  code_pro =" + code_pro;
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
     * @param code_pro
     */
    public static void RestoreFromProduit(String code_pro) {
        String sql = "UPDATE Produit set Active= 1 WHERE  code_pro =" + code_pro ;
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
     * @param id the Column you want to select
     * @return Selection Result in DefaultListModel
     */
    public static DefaultListModel<String> SelectProduit(String Active, String id) {
            ResultSet rs = null;
        String sql = "select * from Produit where active ='"+Active+"' and code_pro= "+id;

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            DefaultListModel<String> result = new DefaultListModel();

            while (rs.next()) {
                result.addElement(id);
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
            JOptionPane.showMessageDialog(null, "selectString all from Produit\t with  " + id + "\n" + e.getMessage());
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
         String code_pro =rs.getString("code_pro"),
                Designation=rs.getString("Designation"),
                Qte_stock=rs.getString("Qte_stock"),
                Date_stock=rs.getString("Date_stock"),
               seuil=rs.getString("seuil"),
                type=rs.getString("type_pro"),
                num_cat=rs.getString("categorie");


            tab.addRow(new Object[]{code_pro,Designation,Qte_stock,Date_stock,seuil,type,num_cat});    
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
                + " prenom_emp, grade_emp, fonction, code_dep) "
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
        String sql = "UPDATE Employe SET Active= 0 WHERE   code_emp ='" + code_emp + "'";
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
        String sql = "UPDATE Employe set Active= 1 WHERE code_emp ='" + code_emp + "'";
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
     * @param id the Column you want to select
     * @return Selection Result in DefaultListModel
     */
    public static DefaultListModel<String> SelectEmploye(String Active, String id) {
            ResultSet rs = null;
        String sql = "select * from Employe where active ='"+Active+"' and code_emp ="+id ;

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            DefaultListModel<String> result = new DefaultListModel();

            while (rs.next()) {
                result.addElement(id);
                result.addElement(rs.getString(2));
                result.addElement(rs.getString(3));
                result.addElement(rs.getString(4));
                result.addElement(rs.getString(5));
                result.addElement(rs.getString(6));
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "selectString all from Employe\t with  " + id + "\n" + e.getMessage());
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

        String sql = "INSERT INTO Fournisseur(CODE_FOURNISSEUR, NOM_FOURNISSEUR,"
                + " NUM_COMPTE , NUM_TEL) "
                + "VALUES (?,?,?,?)";
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
        String sql = "UPDATE Fournisseur set Active= 1 WHERE code_fournisseur ='" + code_fournisseur + "'";
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
     * @param id the Column you want to select
     * @return Selection Result in DefaultListModel
     */
    public static DefaultListModel<String> SelectFournisseur(String Active, String id) {
            ResultSet rs = null;
        String sql = "select * from Fournisseur where active ='"+Active+"' and code_fournisseur="+id ;

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            DefaultListModel<String> result = new DefaultListModel();

            while (rs.next()) {
                result.addElement(id);
                result.addElement(rs.getString(2));
                result.addElement(rs.getString(3));
                result.addElement(rs.getString(4));
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "selectString all from Fournisseur\t with  " + id + "\n" + e.getMessage());
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

 public static void InsertToDepartement(String Intitule_dep,String Nom_chef,String Prenom_chef) {

        String sql = "INSERT INTO Departement(code_dep, Intitule_dep,"
                + " Nom_chef, Prenom_chef) "
                + "VALUES (SEQ1.nextval,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, Intitule_dep);
            pst.setString(2, Nom_chef);
            pst.setString(3, Prenom_chef);
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
        String sql = "UPDATE Departement SET Active= 0 WHERE   code_dep ='" + code_dep + "'";
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
        String sql = "UPDATE Departement set Active= 1 WHERE code_dep ='" + code_dep + "'";
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
     * @param id the Column you want to select
     * @return Selection Result in DefaultListModel
     */
    public static DefaultListModel<String> SelectDepartement(String Active, String id) {
            ResultSet rs = null;
        String sql = "select * from Departement where active ='"+Active+"' and code_dep="+id ;

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            DefaultListModel<String> result = new DefaultListModel();

            while (rs.next()) {
                result.addElement(rs.getString(2));
                result.addElement(rs.getString(3));
                result.addElement(rs.getString(4));
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "selectString all from Departement\t with  " + id + "\n" + e.getMessage());
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
      public static void fillline_livraisonTable(JTable table,String active,String id){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from line_livraison where  active= '"+active+"' and NUM_COMMANDE= "+id;
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String Qte=rs.getString(2),
                product_name=rs.getString(3);


            tab.addRow(new Object[]{Qte,product_name});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================   
//============================//START OF THE Methode//==========================
       public static void fillline_affectationTable(JTable table,String active,String id){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from line_affectation where  active= '"+active+"' and NUM_COMMANDE ="+id;
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String Qte=rs.getString(2),
                product_name=rs.getString(3);


            tab.addRow(new Object[]{product_name,Qte});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================
//============================//START OF THE Methode//==========================
       public static void fillline_commandeTable(JTable table,String active,String id){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from line_command where  active= '"+active+"' and NUM_COMMANDE ="+id;
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String Qte=rs.getString(2),
                product_name=rs.getString(3);


            tab.addRow(new Object[]{product_name,Qte});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================
//============================//START OF THE Methode//==========================
    public static void fillline_SortieTable(JTable table,String active,String id){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from line_sortie where  active= '"+active+"' and NUM_COMMANDE ="+id;
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String Qte=rs.getString(2),
                product_name=rs.getString(3);


            tab.addRow(new Object[]{product_name,Qte});    
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
       
       
//============================//table livraison//=============================
//============================//START OF THE Methode//==========================
 /**
     * method of inserting Into Fournissuer
     *
     * @param code
     *
     * @param date
     * * @param code_emp
     *
     * @param name_emp
     
     * 
     *
     */
     public static void InsertTolivraison(
            String code ,String date,String qte) {

        String sql = "INSERT INTO bon_livraison(num_bliv, date_liv,QUANTITÉ) "
                + "VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, code);
            pst.setString(2, date);
            pst.setString(3, qte);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added TO livraison\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert To livraison\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
/**
     *
     * Delete The Product By turning of the Active
     *
     * @param code
     */
    public static void DeleteFromlivraison(String code) {
        String sql = "UPDATE bon_livraison SET Active= 0 WHERE   num_bliv ='" + code + "'";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete From livraison\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
 /**
     *
     * Restoring The Product By turning of the Active
     *
     * @param code
     */
    public static void RestoreFromlivraison(String code) {
        String sql = "UPDATE bon_livraison set Active= 1 WHERE num_bliv ='" + code + "'";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Restore From livraison\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * Selecting a column from¨Product Without Condition
     *
     * @param Active this is active stats true or false
     * @param ID the Column you want to select
     * @return Selection Result in DefaultListModel
     */
    public static DefaultListModel<String> Selectlivraison(String Active, String ID) {
            ResultSet rs = null;
        String sql = "select * from bon_livraison where active ='"+Active+"' and num_bliv ="+ID ;

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            DefaultListModel<String> result = new DefaultListModel();

            while (rs.next()) {
                result.addElement(rs.getString(2));
                result.addElement(rs.getString(3));
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "selectString all from livraison\t with  " + ID + "\n" + e.getMessage());
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
  public static void filllivraisonTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from bon_livraison where  active= '"+active+"'";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String code=rs.getString(1),
                date=rs.getString(2),
               code_emp=rs.getString(3);
               //Methode.formatdate(date);
            tab.addRow(new Object[]{code,date,code_emp});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================
    public static void InsertTocat(
            String code ,String categorie) {

        String sql = "INSERT INTO categorie(num_cat, categorie) "
                + "VALUES (?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, code);
            pst.setString(2, categorie);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added TO cat\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert To cat\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
/**
     *
     * Delete The Product By turning of the Active
     *
     * @param code
     */
    public static void DeleteFromcat(String code) {
        String sql = "UPDATE categorie set Active= 0 WHERE num_cat='" + code + "'";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete From cat\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
 /**
     *
     * Restoring The Product By turning of the Active
     *
     * @param code
     */
    public static void RestoreFromcat(String code) {
        String sql = "UPDATE categorie set Active= 1 WHERE num_cat ='" + code + "'";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Restore From cat\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * Selecting a column from¨Product Without Condition
     *
     * @param Active this is active stats true or false
     * @param id the Column you want to select
     * @return Selection Result in DefaultListModel
     */
    public static DefaultListModel<String> Selectcat(String Active, String id) {
            ResultSet rs = null;
        String sql = "select * from categorie where active ='"+Active+"' and num_cat="+id ;

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            DefaultListModel<String> result = new DefaultListModel();

            while (rs.next()) {
                result.addElement(rs.getString(1));
                result.addElement(rs.getString(2));
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "selectString all from cat\t with  " + id + "\n" + e.getMessage());
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
  public static void fillcatTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from categorie where  active= '"+active+"'";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String code=rs.getString("num_cat"),
                categorie=rs.getString("categorie");
  
            tab.addRow(new Object[]{code,categorie});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================

//============================//table CAmmande//=============================
//============================//START OF THE Methode//==========================
 /**
     * method of inserting Into Fournissuer
     *
     * @param code
     *
     * @param date
     * * @param code_fournisseur
     *
     * @param name
     
     * 
     *
     */
     public static void InsertTocommande(
            String code ,String date,String code_fournisseur) {

        String sql = "INSERT INTO commande(num_bco, date_com,code_fournisseur) "
                + "VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, code);
            pst.setString(2, date);
            pst.setString(3, code_fournisseur);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added TO commande\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert To commande\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
/**
     *
     * Delete The Product By turning of the Active
     *
     * @param code
     */
    public static void DeleteFromcommande(String code) {
        String sql = "UPDATE commande SET Active= 0 WHERE   num_bco ='" + code + "'";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete From commande\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
 /**
     *
     * Restoring The Product By turning of the Active
     *
     * @param code
     */
    public static void RestoreFromcommande(String code) {
        String sql = "UPDATE commande set Active= 1 WHERE num_bco ='" + code + "'";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Restore From commande\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * Selecting a column from¨Product Without Condition
     *
     * @param Active this is active stats true or false
     * @param id the Column you want to select
     * @return Selection Result in DefaultListModel
     */
    public static DefaultListModel<String> Selectcommande(String Active, String id) {
            ResultSet rs = null;
        String sql = "select * from commande where active ='"+Active+"' and num_bco ="+id ;

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            DefaultListModel<String> result = new DefaultListModel();

            while (rs.next()) {
                result.addElement(rs.getString(2));
                result.addElement(rs.getString(3));
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "selectString all from commande\t with  " + id + "\n" + e.getMessage());
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
  public static void fillCommandeTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from full_command where  active= '"+active+"'";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String code=rs.getString(1),
                date=rs.getString(2),
                name=rs.getString(3);
            tab.addRow(new Object[]{code,date,name});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================
//============================//table sortie//=============================
//============================//START OF THE Methode//==========================
 /**
     * method of inserting Into Fournissuer
     *
     * @param code
     *
     * @param date
     * * @param code_emp
     *
     * @param name_emp
     
     * 
     *
     */
     public static void InsertToAffectation(
            String code ,String date,String code_emp) {

        String sql = "INSERT INTO bon_affectation(num_baf, date_aff,code_emp) "
                + "VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, code);
            pst.setString(2, date);
            pst.setString(3, code_emp);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added TO affectation\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert To affectation\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
/**
     *
     * Delete The Product By turning of the Active
     *
     * @param code
     */
    public static void DeleteFromAffectation(String code) {
        String sql = "UPDATE bon_affectation SET Active= 0 WHERE   num_baf ='" + code + "'";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete From Affectation\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
 /**
     *
     * Restoring The Product By turning of the Active
     *
     * @param code
     */
    public static void RestoreFromAffectation(String code) {
        String sql = "UPDATE bon_affectation set Active= 1 WHERE num_baf ='" + code + "'";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Restore From sortie\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * Selecting a column from¨Product Without Condition
     *
     * @param Active this is active stats true or false
     * @param id the Column you want to select
     * @return Selection Result in DefaultListModel
     */
    public static DefaultListModel<String> SelectAffectation(String Active, String id) {
            ResultSet rs = null;
        String sql = "select * from bon_affectation where active ='"+Active+"' and num_baf ="+id ;

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            DefaultListModel<String> result = new DefaultListModel();

            while (rs.next()) {
                result.addElement(rs.getString(2));
                result.addElement(rs.getString(3));
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "selectString all from sortie\t with  " + id + "\n" + e.getMessage());
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
  public static void fillAffectationTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from full_affectation where  active= '"+active+"'";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String code=rs.getString(1),
                date=rs.getString(2),
               code_emp=rs.getString(3);
              


            tab.addRow(new Object[]{code,date,code_emp});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================

//============================//table sortie//=============================
//============================//START OF THE Methode//==========================
 /**
     * method of inserting Into Fournissuer
     *
     * @param code
     *
     * @param date
     * * @param code_emp
     *
     * @param name_emp
     
     * 
     *
     */
     public static void InsertTosortie(
            String code ,String date,String code_emp) {

        String sql = "INSERT INTO bon_sortie(num_bso, date_sor,code_emp) "
                + "VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, code);
            pst.setString(2, date);
            pst.setString(3, code_emp);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added TO sortie\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "insert To sortie\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
/**
     *
     * Delete The Product By turning of the Active
     *
     * @param code
     */
    public static void DeleteFromsortie(String code) {
        String sql = "UPDATE bon_sortie SET Active= 0 WHERE   num_bso ='" + code + "'";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete From sortie\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
 /**
     *
     * Restoring The Product By turning of the Active
     *
     * @param code
     */
    public static void RestoreFromsortie(String code) {
        String sql = "UPDATE bon_sortie set Active= 1 WHERE num_bso ='" + code + "'";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Restore From sortie\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * Selecting a column from¨Product Without Condition
     *
     * @param Active this is active stats true or false
     * @param id the Column you want to select
     * @return Selection Result in DefaultListModel
     */
    public static DefaultListModel<String> Selectsortie(String Active, String id) {
            ResultSet rs = null;
        String sql = "select * from bon_sortie where active ='"+Active+"' and num_bso= "+id ;

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            DefaultListModel<String> result = new DefaultListModel();

            while (rs.next()) {
                result.addElement(rs.getString(2));
                result.addElement(rs.getString(3));
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "selectString all from sortie\t with  " + id + "\n" + e.getMessage());
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
  public static void fillsortieTable(JTable table,String active){
        ResultSet rs = null;
        DefaultTableModel tab =(DefaultTableModel) table.getModel();

        while(table.getRowCount()>0){
            tab.removeRow(0);
        }

      String sql ="select * from full_sortie where  active= '"+active+"'";
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String code=rs.getString(1),
                date=rs.getString(2),
               code_emp=rs.getString(3);
              


            tab.addRow(new Object[]{code,date,code_emp});    
      }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
//============================//END OF THE Methode//============================

//============================//START OF THE Methode//==========================
    /**
     *
     * @param combobox The ComboBox u want to fill
     * @param active 
     * @return  
     */
public static DefaultListModel fillComboBox(JComboBox combobox,String table,String selection,String active){
        ResultSet rs = null;
        DefaultListModel IDlist= new DefaultListModel();
        DefaultComboBoxModel tab =(DefaultComboBoxModel) combobox.getModel();
        tab.removeAllElements();

      String sql ="select * from "+table+" where active ="+active;
     try {
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery(sql); 
      while(rs.next()){
         String name=rs.getString(selection),
                 id=rs.getString(1);
            tab.addElement(name);
            IDlist.addElement(id);
      }
        combobox.setModel(tab);
      } catch (Exception e) {
          e.printStackTrace();
      }
     return IDlist;
  }
//============================//END OF THE Methode//============================
//============================//START OF THE Methode//==========================                       
    public static void UpdateFournisseur(String code_fournisseur, String first_name,
            String num_compte ,String num_tele) {

        String sql = "UPDATE Fournisseur set  nom_fournisseur ='"+first_name
                + "' ,num_compte="+num_compte+
                ", num_tel ="+num_tele+" where code_fournisseur ="+code_fournisseur;
        try {
            pst = conn.prepareStatement(sql);
            pst.execute(sql);
            JOptionPane.showMessageDialog(null, " Fournisseur updated\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fournisseur update\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================
//============================//START OF THE Methode//==========================                       
    public static void UpdateCat(String num_cat, String cat) {

        String sql = "UPDATE categorie set  categorie ='"+cat
                +"' where num_cat ="+num_cat;
        try {
            pst = conn.prepareStatement(sql);
            pst.execute(sql);
            JOptionPane.showMessageDialog(null, " categorie updated\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "categorie update\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================
    //============================//START OF THE Methode//==========================                       
    public static void UpdateDepartments(String code_dep, String intitule,
            String chef_name ,String chef_prenom) {

        String sql = "UPDATE Departement set Intitule_dep ='"+intitule+"', nom_chef='"+chef_name+
                "', prenom_chef ='"+chef_prenom+"' where code_dep ="+code_dep;
        try {
            pst = conn.prepareStatement(sql);
            pst.execute(sql);
            JOptionPane.showMessageDialog(null, " Departments updated\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Departments update\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================
    public static void UpdateEmployee(String code_emp, String nom_emp,
            String prenom_emp ,String grade_emp ,String function,String code_dep) {

        String sql = "UPDATE Employe set  nom_emp ='"+nom_emp
                + "' ,prenom_emp='"+prenom_emp+
                "', grade_emp ='"+grade_emp+"' ,fonction='"+function+"',code_dep="+code_dep+
                " where code_emp ="+code_emp;
        try {
            pst = conn.prepareStatement(sql);
            pst.execute(sql);
            JOptionPane.showMessageDialog(null, " Employee updated\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Employee update\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================
//============================//startOF THE Methode//============================
    public static void Updateaffectation(String num_baf, String date_aff,
            String code_emp) {

        String sql = "UPDATE bon_affectation set  code_emp='"+code_emp 
                + "' ,date_aff= TO_DATE('"+date_aff+ "', 'dd/MM/yyyy ') where num_baf ="+num_baf;
        try {
            pst = conn.prepareStatement(sql);
            pst.execute(sql);
            JOptionPane.showMessageDialog(null, " affectation updated\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "affectation update\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================
    public static void Updatecammande(String num_bco, String date_com,String code_fournisseur) {

        String sql = "UPDATE commande set code_fournisseur='"+code_fournisseur
                + "' ,date_com=TO_DATE('"+date_com+ "', 'dd/MM/yyyy ') where num_bco ="+num_bco;
        try {
            pst = conn.prepareStatement(sql);
            pst.execute(sql);
            JOptionPane.showMessageDialog(null, " cammande updated\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "cammande update\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================
    
//============================//startOF THE Methode//============================
    public static void Updatesortie(String num_bso, String date,String code_emp) {

        String sql = "UPDATE bon_sortie set date_sor=TO_DATE('"+date+ "', 'dd/MM/yyyy ') ,code_emp="+code_emp
                + " where num_bso ="+num_bso;
        try {
            pst = conn.prepareStatement(sql);
            pst.execute(sql);
            JOptionPane.showMessageDialog(null, " sortie updated\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "sortie update\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================
//============================//startOF THE Methode//============================
    public static void UpdateLivraison(String num_bliv,String date_liv,
            String qte) {

        String sql = "UPDATE bon_livraison set  QUANTITÉ='"+qte
                + "' ,date_liv=TO_DATE('"+date_liv+ "', 'dd/MM/yyyy ') where num_bliv ="+num_bliv ;
        try {
            pst = conn.prepareStatement(sql);
            pst.execute(sql);
            JOptionPane.showMessageDialog(null, " Livraison updated\t");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Livraison update\n" + e.getMessage());
        }
    }
//============================//END OF THE Methode//============================
    public static void commit(){
        String sql ="commit";
        
        try {
            pst=conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//============================//END OF THE Methode//============================
//==============================================================================   
//=============================//END OF THE Class//=============================
//==============================================================================

}
