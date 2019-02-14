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
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GeniSoft
 */
public class utlisateur {
     private String codeuser;
    private String nom;
    private String prenom;
    private String sexe;
   private String Cin;
    private String fonction;
    private String username;
    private String password;
private String etat;

    public utlisateur() {
    }

    public utlisateur(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public utlisateur(String codeuser) {
        this.codeuser = codeuser;
      
    }

    public utlisateur(String codeuser, String nom, String prenom, String sexe, String Cin,String fonction, String username, String password,String etat ) {
        this.codeuser = codeuser;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.Cin=Cin;
        this.fonction = fonction;
        this.username = username;
        this.password = password;
         this.etat=etat;
    }

    public String getCodeuser() {
        return codeuser;
    }

    public void setCodeuser(String codeuser) {
        this.codeuser = codeuser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getCin() {
        return Cin;
    }

    public void setCin(String Cin) {
        this.Cin = Cin;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    
    public utlisateur rechercherFonctionUtilisateur(String user,String modpas)
{
    utlisateur u=new utlisateur();
 String req="Select*from utilisateur where username='"+user+"' and  password='"+modpas+"' ";
                Connection con=null;
                Statement st=null;
                String fonction="";
                int verif=0;
                ResultSet rs;
               try
               {
                   con=DriverManager.getConnection("jdbc:mysql://localhost/baseproduit","root","");
                   st=con.createStatement();
                   rs=st.executeQuery(req);
                   while(rs.next())
                   {
                   u.setFonction(rs.getString(6));
                   u.setEtat(rs.getString(9));
                     u.setCodeuser(rs.getString(1));
                   verif++;
                   }
                   
                    st.close();con.close();
               }catch(SQLException se)
                       {
                       
                       }
              System.out.println("fff"+verif);
               return u;
}
    
    
    
    public utlisateur rechercherUtilisateur(String cod)
     {
     utlisateur u =new utlisateur();
     String rek="select *from utilisateur where codeuser='"+cod+"'";
     Connection c=null;
     Statement st=null;
         try {
             c=DriverManager.getConnection("jdbc:mysql://localhost/baseproduit","root","");
             st=c.createStatement();
             ResultSet rs=st.executeQuery(rek);
             while(rs.next()){
             
           u.setCodeuser(rs.getString(1));
           u.setNom(rs.getString(2));
           u.setPrenom(rs.getString(3));
           u.setSexe(rs.getString(4));
           u.setCin(rs.getString(5));
           u.setFonction(rs.getString(6));
           u.setPassword(rs.getString(8));
           u.setUsername(rs.getString(7));
             u.setEtat(rs.getString(9));
             
             
             }
             st.close();c.close();
         } catch (Exception e) {
         }
     
     return u;
     
     }
    
    
    
    
    
    
    
    
    
     public String recherchernomUtilisateur(String user)
{
    utlisateur u=new utlisateur();
 String req="select*from utilisateur where username='"+user+"'";
                Connection con=null;
                Statement st=null;
                String username="";
                int verif=0;
                ResultSet rs;
               try
               {
                   con=DriverManager.getConnection("Jdbc:mysql://localhost/baseproduit","root","");
                   st=con.createStatement();
                   rs=st.executeQuery(req);
                   if(rs.next())
                   {
                 
                   username=rs.getString(7);
                   }
                   
                    st.close();con.close();
               }catch(SQLException se)
                       {
                       
                       }
             
               return username;
}
    
    
    
    
       public String EnregistrerUtilisateur()
  {
      
       String reponse="",rep="";
      
      String req="select*from utilisateur where username='"+this.getUsername()+"'";
                Connection conn=null;
                Statement stt=null;
                String username="";
                int verif=0;
                ResultSet rss;
               try
               {
                   conn=DriverManager.getConnection("Jdbc:mysql://localhost/baseproduit","root","");
                   stt=conn.createStatement();
                   rss=stt.executeQuery(req);
                   
                   while(rss.next())
                   {
                 
                   username=rss.getString(7);
         
       verif++;
                   }
               if(verif!=0)
               {
               reponse="nom utilisaateur existe deja ";
               }
               else{
                         Calendar da=Calendar.getInstance();
        int j=da.get(da.DAY_OF_MONTH);
        int mo=da.get(da.MONTH)+1;
        int a=da.get(da.YEAR);
        String date=j+"/"+mo+"/"+a;
        
         int code=(int)(Math.random()*1200);
         String cod="UT"+"-"+code;         
         char eta='1';
                 String requete="insert into utilisateur values('"+cod+"','"+this.getNom()+"','"+this.getPrenom()+"','"+this.getSexe()+"','"+this.getCin()+"','"+this.getFonction()+"','"+this.getUsername()+"','"+this.getPassword()+"','"+eta+"')";
        int verifye=0;
       
        try
        {
         
        Connection con=DriverManager.getConnection("jdbc:mysql://Localhost/baseproduit","root","");   
        Statement st=con.createStatement();
        verifye=st.executeUpdate(requete);
        st.close();con.close();
        
        if(verifye!=0)
        {
                 
          rep="Et Voici votre Code:"+cod;      
         reponse="Insertion Reussie ".concat(rep);
        
        }
        }
        
        
        catch(SQLException cn2)
        {
        reponse="Probleme Connexion, pou kisa:"+cn2.getMessage();
        
                   }
               
               
               
               }
                    stt.close();conn.close();
               }catch(SQLException se)
                       {
                       
                       }
      
      
      
      
      
      
        
        return reponse;
       }
    
       
       
       
          public  String ModifierUtilisateur(String cod) 
{    
         
        String reket="Update utilisateur set  nom='"+this.getNom()+"',prenom='"+this.getPrenom()+"',sexe='"+this.getSexe()+"',cin='"+this.getCin()+"',fonction='"+this.getFonction()+"',username='"+this.getUsername()+"',password='"+this.getPassword()+"',etat='"+this.getEtat()+"' where codeuser='"+this.getCodeuser()+"'";
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
       
       
       
           
          public  String BloquerUtilisateur(String cod) 
{    
         String etat="0";
        String reket="Update utilisateur set  etat='"+etat+"' where codeuser='"+cod+"'";
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
             repons="Utilisateur bloqué!";   
        }
        }
         
        catch(SQLException cn2)
        {
        repons="Probleme Connexion, pou kisa:"+cn2.getMessage(); 
        }
        return repons;
        }
          
         public  String DebloquerUtilisateur(String cod) 
{    
         String etat="1";
        String reket="Update utilisateur set  etat='"+etat+"' where codeuser='"+cod+"'";
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
             repons="Utilisateur débloqué!";   
        }
        }
         
        catch(SQLException cn2)
        {
        repons="Probleme Connexion, pou kisa:"+cn2.getMessage(); 
        }
        return repons;
        }
      
       
       
       
           public JTable listerUtilisateur()
    {
        DefaultTableModel dtm=new DefaultTableModel();
        JTable tabprod=new JTable(dtm);
     dtm.addColumn("Code");
     dtm.addColumn("Nom");
     dtm.addColumn("Prenom");
        dtm.addColumn("Sexe");
     dtm.addColumn("Cin");
     dtm.addColumn("Fonction");
      dtm.addColumn("username");
     dtm.addColumn("password");
        dtm.addColumn("etat");
      String rek="select * from utilisateur";
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
              
Object [] liste={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)};
     dtm.addRow(liste);
     
            }
            st.close();con.close();
        } catch (SQLException e) 
                {
                message="anyen pa bon";
                }
        
           
        
        
          
    
return tabprod;
    }
    
       
}
