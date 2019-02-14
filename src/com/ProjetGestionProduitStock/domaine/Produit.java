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
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author GeniSoft
 */
public class Produit {
    private String codeproduit;
    private String typeproduit;
    private int quantite;
    private double prix;
    private String dates;
    private String codedesc;

    public Produit() {
    }

    public Produit(String codeproduit, String typeproduit, int quantite, double prix, String dates, String codedesc) {
        this.codeproduit = codeproduit;
        this.typeproduit = typeproduit;
        this.quantite = quantite;
        this.prix = prix;
        this.dates = dates;
        this.codedesc = codedesc;
    }

   
    public String getCodeproduit() {
        return codeproduit;
    }

    public void setCodeproduit(String codeproduit) {
        this.codeproduit = codeproduit;
    }

    public String getTypeproduit() {
        return typeproduit;
    }

    public void setTypeproduit(String typeproduit) {
        this.typeproduit = typeproduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getCodedesc() {
        return codedesc;
    }

    public void setCodedesc(String codedesc) {
        this.codedesc = codedesc;
    }

  
     
    
    public String enregistrerProduit(){
        Produit p=new Produit();
    String reponse="",rep="";
          
             String reket="Select * from description where nomdesc='"+this.getCodedesc()+"'";  
      
        Connection conn=null;
        String codedesc="",nomdesc="",typedesc="";
        Statement stt=null;
        try 
        {
        conn=DriverManager.getConnection("jdbc:mysql://Localhost/baseproduit","root","");   
            stt=conn.createStatement();
            ResultSet rs=stt.executeQuery(reket);
            if(rs.next())
            {
               codedesc=rs.getString(1);
              nomdesc=rs.getString(2);
              typedesc=rs.getString(3);
               
               
               
                Calendar da=Calendar.getInstance();
        int j=da.get(da.DAY_OF_MONTH);
        int mo=da.get(da.MONTH)+1;
        int a=da.get(da.YEAR);
        String date=a+"-"+mo+"-"+j;
        
         int coded=(int)(Math.random()*100);
         int codet=(int)(Math.random()*99);
         String cod=""+"Prod"+"-"+coded+""+codet; 
        String  getnom=this.getCodedesc();
        String typeprod=this.getTypeproduit();
      if((getnom.equals(nomdesc)) && (typeprod.equals(typedesc)))
      {
      String requete="Insert into produit values('"+cod+"','"+this.getTypeproduit()+"','"+date+"','"+codedesc+"')";
        int verifye=0;
        
        try
        {
         
         Connection con=DriverManager.getConnection("jdbc:mysql://Localhost/baseproduit","root","");   
        Statement st=con.createStatement();
        verifye=st.executeUpdate(requete);
        st.close();con.close();
      
        reponse="Insertion fait avec succes";
        }
        catch(SQLException cn2)
        {
        reponse="Probleme  , pou kisa:"+cn2.getMessage();
        
        } 
      
        //selection dans stock pour voir si un contenu existe deja
         String req="Select * from stock where codedesc='"+codedesc+"'";  
      
        Connection co=null;
        
        Statement stat=null;
        try 
        {
        co=DriverManager.getConnection("jdbc:mysql://Localhost/baseproduit","root","");   
            stat=co.createStatement();
            ResultSet resul=stat.executeQuery(req);
            if(resul.next())
            {
                String codeStock=resul.getString(1);
                String dat=resul.getString(2);
                int quant=Integer.parseInt(resul.getString(4))+this.getQuantite();
           
                String coddesc=resul.getString(5);
                //update car le contenu a ete trouve dans la base
                 String requet="Update stock set dateRecep='"+date+"',prixprod='"+this.getPrix()+"',quantiteDispo='"+quant+"',codedesc='"+coddesc+"' where codestock='"+codeStock+"'";
        
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
        
        
            }
            else{
           
         String kod=""+"St"+"-"+coded+""+codet; 
               //insertion des produits
                  String reqsql="Insert into Stock values('"+kod+"','"+date+"','"+this.getPrix()+"','"+this.getQuantite()+"','"+codedesc+"')";
        int veri=0;
         try
        {
         
        Connection connect=DriverManager.getConnection("jdbc:mysql://Localhost/baseproduit","root","");
       Statement sta=connect.createStatement();
        veri=stt.executeUpdate(reqsql);
        //stt.close();co.close();
        if(veri!=0)
        {
        reponse="insertion Reussie"; 
      
        }
        }
        
        catch(SQLException cn1)
        {
        System.out.println("Probleme Connexion, pou kisa A insertion:"+cn1.getMessage());
        }
              
                
                
                
                
                
            }
        
        }
        catch(SQLException sex)
        {
            reponse="M Gen Pwoblem pou recherche:"+sex.getMessage();
        }
     
        
        
        
        
        
        
        
        
        
        
        
        
        }
      else{
      reponse="Le type ne correspond pas au produit";
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
    
    
   
    
    
    
    public List listernom()
    {
       List<String> nomprod=new ArrayList<String>();
      List t=new ArrayList();
   Produit pro=new Produit();
    
     String rek="Select * from description";
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
    
    
     public List listertype()
    {
       List<String> typeprod=new ArrayList<String>();
      List t=new ArrayList();
   Produit pro=new Produit();
    
     String rek="select distinct(typedesc) as typedesc from description";
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
                
          typeprod.add(rs.getString("typedesc"));

        typeprod.get(i);
         
            i++;
            }
            st.close();con.close();
        } catch (SQLException e) 
                {
                message="anyen pa bon";
                }
        
           
        
        
        
    return typeprod;

    }
    
    //mehode rechercher produit
     public Produit rechercherProduit(String cod)
     {
     Produit prod=new Produit();
     String rek="select p.codeproduit ,p.typeproduit as tproduit,p.prixprod as pprodit,p.quantite as pquantite,p.dates as pdate,d.nomdesc as ddesc,d.typedesc as tdesc  from produit p,description d where p.codedesc=d.codedesc and p.codeproduit='"+cod+"'";
     Connection c=null;
     Statement st=null;
         try {
             c=DriverManager.getConnection("jdbc:mysql://localhost/baseproduit","root","");
             st=c.createStatement();
             ResultSet rs=st.executeQuery(rek);
             while(rs.next()){
             
             prod.setCodeproduit(rs.getString("p.codeproduit"));
             prod.setTypeproduit(rs.getString(2));
              prod.setPrix(rs.getDouble(3));
             prod.setQuantite(rs.getInt(4));
            
             prod.setDates(rs.getString(5));
             prod.setCodedesc(rs.getString(6));
             
             
             
             }
             st.close();c.close();
         } catch (Exception e) {
         }
     
     return prod;
     
     }
    
     
     public double PrixProduit(String cod)
     {
     Produit prod=new Produit();
     double prix=0;
     String rek="select s.prixprod as pproduit from stock s,description d where s.codedesc=d.codedesc and d.nomdesc='"+cod+"'";
     Connection c=null;
     Statement st=null;
         try {
             c=DriverManager.getConnection("jdbc:mysql://localhost/baseproduit","root","");
             st=c.createStatement();
             ResultSet rs=st.executeQuery(rek);
             while(rs.next()){
             
             prix=Double.parseDouble(rs.getString("pproduit"));
            
             
             
             
             }
             st.close();c.close();
         } catch (Exception e) {
         }
     System.out.println("oo"+prix);
     
     return prix;
     
     
     
     
     }
      public int QuantiteProduit(String cod)
     {
     Produit prod=new Produit();
     int prix=0;
     String rek="select s.quantitedispo as quantitedispo from stock s,description d where s.codedesc=d.codedesc and d.nomdesc='"+cod+"'";
     Connection c=null;
     Statement st=null;
         try {
             c=DriverManager.getConnection("jdbc:mysql://localhost/baseproduit","root","");
             st=c.createStatement();
             ResultSet rs=st.executeQuery(rek);
             while(rs.next()){
             
             prix=Integer.parseInt(rs.getString("quantitedispo"));
            
             
             
             
             }
             st.close();c.close();
         } catch (Exception e) {
         }
     System.out.println("oo"+prix);
     
     return prix;
     
     
     
     
     }
     
     
     
     public List listerNomProduitEnStock()
    {
       List<String> nomprod=new ArrayList<String>();
      List t=new ArrayList();
   Produit pro=new Produit();
    
     String rek="select d.codedesc,d.nomdesc,d.typedesc from description d,stock s where s.codedesc=d.codedesc";
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
     
     
     
     
        public  String ModifierProd(String cod) 
{  
         
        String reket="Update administrateur set  '";
        int verif = 0;
        String  repons="";
        try
        {
        Connection conn=DriverManager.getConnection("jdbc:mysql://Localhost/projetjava","JAVADALBY7696","INGYBLAD");    
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