/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.domaine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GeniSoft
 */
public class Stock {
    private String codeStock;
    private String dateReception;
    private int quantiteDispo;
private double prix;
private String codedesc;
    public Stock() {
    }

    public Stock(String codeStock, String dateReception, int quantiteDispo, double prix, String codedesc) {
        this.codeStock = codeStock;
        this.dateReception = dateReception;
        this.quantiteDispo = quantiteDispo;
        this.prix = prix;
        this.codedesc = codedesc;
    }

    public String getCodeStock() {
        return codeStock;
    }

    public void setCodeStock(String codeStock) {
        this.codeStock = codeStock;
    }

    public String getDateReception() {
        return dateReception;
    }

    public void setDateReception(String dateReception) {
        this.dateReception = dateReception;
    }

    public int getQuantiteDispo() {
        return quantiteDispo;
    }

    public void setQuantiteDispo(int quantiteDispo) {
        this.quantiteDispo = quantiteDispo;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getCodedesc() {
        return codedesc;
    }

    public void setCodedesc(String codedesc) {
        this.codedesc = codedesc;
    }

   
    
    
       public JTable listerProduitEnStock()
    {
        DefaultTableModel dtm=new DefaultTableModel();
        JTable tabprod=new JTable(dtm);
     dtm.addColumn("Code");
     dtm.addColumn("Nom-Produit");
     dtm.addColumn("Type-produit");
        dtm.addColumn("Prix-Unitaire");
     dtm.addColumn("Date d'ajout");
     dtm.addColumn("Quantité dispo");
    
      String rek="select s.codeStock as codestock, s.dateRecep,s.quantiteDispo,d.nomdesc,d.typedesc,s.prixprod from description d, stock s where s.codedesc=d.codedesc";
        String message="";
        Statement st=null;
         Connection con=null;
         int i=0;
        try {
         con  =DriverManager.getConnection("jdbc:mysql://Localhost/baseproduit","root","");   
            st=con.createStatement();
            ResultSet  rs=st.executeQuery(rek);
           
          
    
            
  

          while(rs.next()) 
            {
              
Object [] liste={rs.getString(1),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(2),rs.getString(3)};
     dtm.addRow(liste);
     
            }
            st.close();con.close();
        } catch (SQLException e) 
                {
                message="anyen pa bon";
                }
        
           
        
        
          
    
return tabprod;
    }
    
    
      public Stock rechercherSock(String cod)
     {
     Stock s=new Stock();
     String rek="select s.codestock, s.dateRecep,s.prixprod,s.quantiteDispo,d.nomdesc from stock s, description d where s.codedesc=d.codedesc and s.codestock='"+cod+"'";
     Connection c=null;
     Statement st=null;
         try {
             c=DriverManager.getConnection("jdbc:mysql://localhost/baseproduit","root","");
             st=c.createStatement();
             ResultSet rs=st.executeQuery(rek);
             while(rs.next()){
               s.setQuantiteDispo(rs.getInt("s.quantiteDispo"));
             s.setCodeStock(rs.getString("s.codestock"));
          s.setCodedesc(rs.getString("d.nomdesc"));
          s.setPrix(rs.getDouble("s.prixprod"));
             
             }
             st.close();c.close();
         } catch (Exception e) {
         }
     
     return s;
     
     } 
       
      
               public  String ModifierProduitStock(String cod) 
{    
    
    
         
        String reket="Update stock set  prixprod='"+this.getPrix()+"',quantiteDispo='"+this.getQuantiteDispo()+"' where codestock='"+this.getCodeStock()+"'";
        int verif = 0;
        String  repons="";
        try
        {
        Connection conn=DriverManager.getConnection("jdbc:mysql://Localhost/baseproduit","root","");    
        Statement st=conn.createStatement();
        verif = st.executeUpdate(reket);
        st.close();conn.close();
        if (verif!=0)
        {
             repons="Modification Reussie";   
        }
        }
         
        catch(SQLException cn2)
        {
        repons="Probleme Connexion, pou kisa:"+cn2.getMessage(); 
        }
        return repons;
        }
      
      
      
      
       
}
