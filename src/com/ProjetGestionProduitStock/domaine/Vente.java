/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.domaine;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GeniSoft
 */
public class Vente {
    
    private String codeVente;
    private int quantite;
    private double prixUnitaire;
    
    private String codeStock;
   private String dateVente;
   private String codeuser;
    public Vente() {
    }

    public Vente(String codeVente, int quantite, double prixUnitaire, String codeStock, String dateVente,  String codeuser) {
        this.codeVente = codeVente;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.codeStock = codeStock;
        this.dateVente = dateVente;
        this.codeuser=codeuser;
    }

    public String getCodeVente() {
        return codeVente;
    }

    public void setCodeVente(String codeVente) {
        this.codeVente = codeVente;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getCodeStock() {
        return codeStock;
    }

    public void setCodeStock(String codeStock) {
        this.codeStock = codeStock;
    }

    public String getDateVente() {
        return dateVente;
    }

    public void setDateVente(String dateVente) {
        this.dateVente = dateVente;
    }

    public String getCodeuser() {
        return codeuser;
    }

    public void setCodeuser(String codeuser) {
        this.codeuser = codeuser;
    }


    public List listerNomProduitEnStock()
    {
       List<String> nomprod=new ArrayList<String>();
      List t=new ArrayList();
   Produit pro=new Produit();
    
     String rek="select d.codedesc,d.nomdesc,d.typedesc from description d,stock s where s.codedesc=d.codedesc and s.quantiteDispo!=0";
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
                
          nomprod.add(rs.getString(2));

        nomprod.get(i);
         
            i++;
            }
            st.close();con.close();
        } catch (SQLException e) 
                {
                message="anyen pa bon";
                }
        
           
        
        
        
    return nomprod;

    }
    
    
    
      public JTable listeVente()
    {
        DefaultTableModel dtm=new DefaultTableModel();
        JTable tabprod=new JTable(dtm);
     dtm.addColumn("CodeVente");
     dtm.addColumn("Nom-Produit");
     dtm.addColumn("Type-produit");
     dtm.addColumn("Qauntité");
     dtm.addColumn("Prix-unitaire");
     dtm.addColumn("Date vente");
     dtm.addColumn("Utilisateur");
      String rek="select v.codeVente as codevente, v.datevente,v.quantite,d.nomdesc,d.typedesc, v.prixunitaire,v.codeuser from description d, stock s , vente v where s.codedesc=d.codedesc and s.codeStock=v.codestock";
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
              
Object [] liste={rs.getString(1),rs.getString(4),rs.getString(5),rs.getString(3),rs.getString(6),rs.getString(2),rs.getString(7)};
     dtm.addRow(liste);
     
            }
            st.close();con.close();
        } catch (SQLException e) 
                {
                message="anyen pa bon";
                }
        
           
        
        System.out.println("c"+tabprod);
          
    
return tabprod;
    }
      
      
      
      
    
   public String EnregistrerVente()
   {
       Produit p=new Produit();
    String reponse="",rep="";
          
             String reket="Select s.codestock,s.quantiteDispo from description d,stock s where s.codedesc=d.codedesc  and  d.nomdesc='"+this.getCodeStock()+"'";  
      
        Connection conn=null;
        String codestock="",nomdesc="";
           int     quantite=0;
        Statement stt=null;
        try 
        {
        conn=DriverManager.getConnection("jdbc:mysql://Localhost/baseproduit","root","");   
            stt=conn.createStatement();
            ResultSet rs=stt.executeQuery(reket);
            if(rs.next())
            {
               codestock=rs.getString(1);
           
              
               
               
                Calendar da=Calendar.getInstance();
        int j=da.get(da.DAY_OF_MONTH);
        int mo=da.get(da.MONTH)+1;
        int a=da.get(da.YEAR);
        String date=a+"-"+mo+"-"+j;
        
         int coded=(int)(Math.random()*100);
         int codet=(int)(Math.random()*99);
         String cod=""+"V"+"-"+coded+""+codet; 
        
             quantite=Integer.parseInt(rs.getString(2))-this.getQuantite();
       //dimunition dans vente
               String requet="Update stock set quantiteDispo='"+quantite+"' where codestock='"+codestock+"'";
        
        int verif = 0;
        String  repons="";
        try
        {
        Connection c=DriverManager.getConnection("jdbc:mysql://Localhost/baseproduit","root","");    
        Statement s=c.createStatement();
         s.executeUpdate(requet);
         
        s.close();c.close();
             
        }
        catch(SQLException sex)
        {
            reponse="M Gen Pwoblem pou update:"+sex.getMessage();
        }
        
        
            
         
         
         
         
         
         
         
         
         
         
         
     
      String requete="Insert into vente values('"+cod+"','"+this.getQuantite()+"','"+this.getPrixUnitaire()+"','"+codestock+"','"+date+"','"+this.getCodeuser()+"')";
        int verifye=0;
        
        try
        {
         
         Connection con=DriverManager.getConnection("jdbc:mysql://Localhost/baseproduit","root","");   
        Statement st=con.createStatement();
        verifye=st.executeUpdate(requete);
        st.close();con.close();
      
        reponse="Insertion fait avec succes et le numero  de vente est  :"+cod;
        }
        catch(SQLException cn2)
        {
        reponse="Probleme  , pou kisa:"+cn2.getMessage();
        
        } 
      
       
            }
           
              stt.close();conn.close();
        }
        catch(SQLException ef)
        {
            reponse="M Gen Pwoblem pou tout:"+ef.getMessage();
        }
     
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    return reponse;
    
    
   
   }
    
    
   
    public Vente rechercherVente(String cod)
     {
     Vente v=new Vente();
     String rek="select v.codevente as codevente,v.datevente as datevente,d.nomdesc,v.prixunitaire as prixunitaire,v.quantite as quantite,v.codeuser from vente v,stock s,description d  where v.codestock=s.codestock and s.codedesc=d.codedesc and v.codevente='"+cod+"'";
     Connection c=null;
     Statement st=null;
         try {
             c=DriverManager.getConnection("jdbc:mysql://localhost/baseproduit","root","");
             st=c.createStatement();
             ResultSet rs=st.executeQuery(rek);
             while(rs.next()){
                 v.setCodeVente(rs.getString("codevente"));
            v.setCodeStock(rs.getString("d.nomdesc"));
         v.setPrixUnitaire(rs.getFloat("prixunitaire"));
         v.setQuantite(rs.getInt("quantite"));
     v.setCodeuser(rs.getString(rs.getString("v.codeusser")));
             v.setDateVente(rs.getString("datevente"));
            
             }
             st.close();c.close();
         } catch (Exception e) {
         }
     
     return v;
     
     }
    
   
   
   
    
    
    
    
    
    
    
    
//     public String ModifierVente()
//   {
//       Produit p=new Produit();
//    String reponse="",rep="";
//          
//             String reket="Select s.codestock,s.quantiteDispo,v.quantite from description d,vente v,stock s where s.codedesc=d.codedesc and s.codestock=v.codestock and  d.nomdesc='"+this.getCodeStock()+"'";  
//      
//        Connection conn=null;
//        String codestock="",nomdesc="";
//           int     quantite=0;
//        Statement stt=null;
//        try 
//        {
//        conn=DriverManager.getConnection("jdbc:mysql://Localhost/baseproduit","root","");   
//            stt=conn.createStatement();
//            ResultSet rs=stt.executeQuery(reket);
//            if(rs.next())
//            {
//               codestock=rs.getString(1);
//           
//              
//               
//               
//                Calendar da=Calendar.getInstance();
//        int j=da.get(da.DAY_OF_MONTH);
//        int mo=da.get(da.MONTH)+1;
//        int a=da.get(da.YEAR);
//        String date=a+"-"+mo+"-"+j;
//        
//         int coded=(int)(Math.random()*100);
//         int codet=(int)(Math.random()*99);
//         String cod=""+"V"+"-"+coded+""+codet; 
//        
//             quantite=Integer.parseInt(rs.getString(2))-this.getQuantite();
//       //dimunition dans vente
//               String requet="Update stock set quantiteDispo='"+quantite+"' where codestock='"+codestock+"'";
//        
//        int verif = 0;
//        String  repons="";
//        try
//        {
//        Connection c=DriverManager.getConnection("jdbc:mysql://Localhost/baseproduit","root","");    
//        Statement s=c.createStatement();
//         s.executeUpdate(requet);
//         
//        s.close();c.close();
//             
//        }
//        catch(SQLException sex)
//        {
//            reponse="M Gen Pwoblem pou update:"+sex.getMessage();
//        }
//        
//        
//            
//         
//         
//         
//         
//         
//         
//         
//         
//         
//         
//         
//     
//      String requete="Insert into vente values('"+cod+"','"+this.getQuantite()+"','"+this.getPrixUnitaire()+"','"+codestock+"','"+date+"','"+this.getCodeuser()+"')";
//        int verifye=0;
//        
//        try
//        {
//         
//         Connection con=DriverManager.getConnection("jdbc:mysql://Localhost/baseproduit","root","");   
//        Statement st=con.createStatement();
//        verifye=st.executeUpdate(requete);
//        st.close();con.close();
//      
//        reponse="Insertion fait avec succes";
//        }
//        catch(SQLException cn2)
//        {
//        reponse="Probleme  , pou kisa:"+cn2.getMessage();
//        
//        } 
//      
//       
//            }
//           
//              stt.close();conn.close();
//        }
//        catch(SQLException ef)
//        {
//            reponse="M Gen Pwoblem pou tout:"+ef.getMessage();
//        }
//     
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//    return reponse;
//    
//    
//   
//   }
//    
    
    
    
    
    
}
