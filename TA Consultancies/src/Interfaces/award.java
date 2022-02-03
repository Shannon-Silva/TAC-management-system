/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ConnectDatabase.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author shannon
 */
public class award {
    Connection con=DatabaseConnection.connect();
    
    public void findTacer(){
        
        String SQL;
        try{
            SQL="Select CONCAT(e.firstname, ' ', e.lastname) AS name, v.bestTacer, count(*) countOftac From vote v, emp e WHERE v.bestTacer=e.empid Group By v.bestTacer Having count(*) = (Select Max(cnt) From (Select count(*) cnt From vote v Group By v.bestTacer) as z);";
            PreparedStatement pst = con.prepareStatement(SQL);
            ResultSet rs1= pst.executeQuery();
            
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = df.format(new Date());
            
             int id = 0;
             String name = null;
             int marks = 0;
             while(rs1.next()){
	  name= rs1.getString(1);
	  id=rs1.getInt(2);
	  marks=rs1.getInt(3);
	  
	  try{
	      String sql1;
	      sql1="INSERT INTO awards(awardName,asAtDate,CandidateID,CandidateName,marks) VALUES ('Tacer Of The Year','" +formatted+ "'," +id+ ",'" +name+"'," +marks+ ");";
	      PreparedStatement pst1 = con.prepareStatement(sql1);
	      pst1.execute();
	  
	  } catch(Exception ex){
	      System.out.println(ex);
	  }
            }
        } catch(Exception ex){
            System.out.println(ex);
        }
    }
    
        public void creativeEye(){
         String SQL1;
        try{
            SQL1= "Select CONCAT(e.firstname, ' ', e.lastname) AS name, v.creativeEye, count(*) countOftac From vote v, emp e WHERE v.creativeEye=e.empid Group By v.creativeEye Having count(*) = (Select Max(cnt) From (Select count(*) cnt From vote v Group By v.creativeEye) as z)";
            PreparedStatement pst2 = con.prepareStatement(SQL1);
            ResultSet rs2= pst2.executeQuery();
            
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = df.format(new Date());
            
             int id = 0;
             String name = null;
             int marks = 0;
             while(rs2.next()){
	  name= rs2.getString(1);
	  id=rs2.getInt(2);
	  marks=rs2.getInt(3);
	  
	  try{
	      String sql1;
	      sql1="INSERT INTO awards(awardName,asAtDate,CandidateID,CandidateName,marks) VALUES ('Creative Eye Of The Year','" +formatted+ "'," +id+ ",'" +name+"'," +marks+ ");";
	      PreparedStatement pst1 = con.prepareStatement(sql1);
	      pst1.execute();
	  
	  } catch(Exception ex){
	      System.out.println(ex);}
            }
        } catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void bestRecruit(){
         String SQL2;
        try{
            SQL2= "Select CONCAT(e.firstname, ' ', e.lastname) AS name, v.bestRecruit, count(*) countOftac From vote v, emp e WHERE v.bestRecruit=e.empid Group By v.bestRecruit Having count(*) = (Select Max(cnt) From (Select count(*) cnt From vote v Group By v.bestRecruit) as z)";
            PreparedStatement pst3 = con.prepareStatement(SQL2);
            ResultSet rs3= pst3.executeQuery();
            
             SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = df.format(new Date());
            
             int id = 0;
             String name = null;
             int marks = 0;
             while(rs3.next()){
	  name= rs3.getString(1);
	  id=rs3.getInt(2);
	  marks=rs3.getInt(3);
	  
	  try{
	      String sql1;
	      sql1="INSERT INTO awards(awardName,asAtDate,CandidateID,CandidateName,marks) VALUES ('Best Recruit Of The Year','" +formatted+ "'," +id+ ",'" +name+"'," +marks+ ");";
	      PreparedStatement pst1 = con.prepareStatement(sql1);
	      pst1.execute();
	  
	  } catch(Exception ex){
	      System.out.println(ex);}
            }
        } catch(Exception ex){
            System.out.println(ex);
        }        
    }
    
    public void bestDesigner(){
         String SQL3;
        try{
            SQL3= "Select CONCAT(e.firstname, ' ', e.lastname) AS name, v.bestDesigner, count(*) countOftac From vote v, emp e WHERE v.bestDesigner=e.empid Group By v.bestDesigner Having count(*) = (Select Max(cnt) From (Select count(*) cnt From vote v Group By v.bestDesigner) as z)";
            PreparedStatement pst4 = con.prepareStatement(SQL3);
            ResultSet rs4= pst4.executeQuery();
            
             SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = df.format(new Date());
            
             int id = 0;
             String name = null;
             int marks = 0;
             while(rs4.next()){
	  name= rs4.getString(1);
	  id=rs4.getInt(2);
	  marks=rs4.getInt(3);
	  
	  try{
	      String sql1;
	      sql1="INSERT INTO awards(awardName,asAtDate,CandidateID,CandidateName,marks) VALUES ('Best Designer Of The Year','" +formatted+ "'," +id+ ",'" +name+"'," +marks+ ");";
	      PreparedStatement pst1 = con.prepareStatement(sql1);
	      pst1.execute();
	  
	  } catch(Exception ex){
	      System.out.println(ex);}
            }
        } catch(Exception ex){
            System.out.println(ex);
        }        
    }
    
    public void bestPageManager(){
         String SQL4;
        try{
            SQL4= "Select CONCAT(e.firstname, ' ', e.lastname) AS name, v.bestPageManager, count(*) countOftac From vote v, emp e WHERE v.bestPageManager=e.empid Group By v.bestPageManager Having count(*) = (Select Max(cnt) From (Select count(*) cnt From vote v Group By v.bestPageManager) as z)";
            PreparedStatement pst5 = con.prepareStatement(SQL4);
            ResultSet rs5= pst5.executeQuery();
            
             SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = df.format(new Date());
            
             int id = 0;
             String name = null;
             int marks = 0;
             while(rs5.next()){
	  name= rs5.getString(1);
	  id=rs5.getInt(2);
	  marks=rs5.getInt(3);
	  
	  try{
	      String sql1;
	      sql1="INSERT INTO awards(awardName,asAtDate,CandidateID,CandidateName,marks) VALUES ('Best Page Manager Of The Year','" +formatted+ "'," +id+ ",'" +name+"'," +marks+ ");";
	      PreparedStatement pst1 = con.prepareStatement(sql1);
	      pst1.execute();
	  
	  } catch(Exception ex){
	      System.out.println(ex);}
            }
        } catch(Exception ex){
            System.out.println(ex);
        }        
    }
    
}
