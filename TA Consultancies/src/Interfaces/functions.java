/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

//import Connection.DatabaseConnection;
import ConnectDatabase.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author Aloka
 */
public class functions extends DatabaseConnection {
    
     
      Connection con=connect();
    
     public void msgbox(String s)
     {
         JOptionPane.showMessageDialog(null, s);
        
     }
        
    //Inserting function
    public void addNew(String ano,String cg, String ven, String dec,String mod,String aqD,String wrp,String wrt,String pri,String mtp,String mtt,String dp,String dprR,String dprA,String st,String std) //throws ParseException
    {
        PreparedStatement pst,pst2,pst3=null;
        
        if(checkEmpty(ano,cg,ven,dec,mod,aqD,wrp,wrt,pri,mtp,mtt,dp,dprR,dprA,st,std))
        {
            try
            {
                //System.out.println(std);   

            String addnew1="INSERT INTO assets(assetNo,vendName,price,purchDate,descript,model,category,location,status,stDate) VALUES('"+ano+"','"+ven+"','"+pri+"','"+aqD+"','"+dec+"','"+mod+"','"+cg+"','"+dp+"','"+st+"','"+std+"')";

            //String addnew2="INSERT INTO category VALUES('"+ano+"','"+cg+"')";

            String addnew2="INSERT INTO depreciation(assetNo,rate,amount) VALUES('"+ano+"','"+dprR+"','"+dprA+"')";

            //String addnew4="INSERT INTO location VALUES('"+ano+"','"+dp+"','"+epl+"')";

            String addnew3="INSERT INTO maintain(assetNo,mperiod,mtimeUnit,lstMaint,wPeriod,wtimeUnit) VALUES('"+ano+"','"+mtp+"','"+mtt+"','"+aqD+"','"+wrp+"','"+wrt+"')";

            //when adding a vendor => String addnew6="INSERT INTO vendor(name,address,contactNo) VALUES('"+ano+"','"+ven+"')";

           // String addnew7="INSERT INTO warranty VALUES('"+ano+"','"+wrp+"','"+wrt+"')";

            pst=con.prepareStatement(addnew1);

            pst2=con.prepareStatement(addnew2);

            pst3=con.prepareStatement(addnew3);



            pst.execute();
            pst2.execute();
            pst3.execute();

             msgbox("Successfuly Inserted! ");


            }
            catch(Exception e)
            {
                msgbox("ERROR! "+e);
            }
        }
    }
    
    //Search function
    public ResultSet search(String key, String typ)
    {
        PreparedStatement pst=null;
        ResultSet rs=null;
        
        if(typ.equals("c"))
        {
            try
            {
            String searchC="SELECT a.assetNo,a.descript,a.model,a.vendName,a.purchDate,a.price,a.status  FROM assets a WHERE a.category='"+key+"'";
            pst=con.prepareStatement(searchC);
            
            rs=pst.executeQuery();
            return rs;
            
            }
            catch(Exception e)
            {
                msgbox("Error in search :"+e);
            }
            
        }
        else if(typ.equals("d"))
        {
            try{
                
                String searchD="SELECT a.assetNo,a.descript,a.model,a.vendName,a.purchDate,a.price,a.status  FROM assets a WHERE a.location='"+key+"'";
                pst=con.prepareStatement(searchD);
                
                rs=pst.executeQuery();
                return rs;
                
            }
            catch(Exception e)
            {
                 msgbox("Error in search :"+e);
            }
        }
        else if(typ.equals("v"))
        {
            try{
                
                String searchV="SELECT a.assetNo,a.descript,a.model,a.vendName,a.purchDate,a.price,a.status  FROM assets a WHERE a.vendName='"+key+"'";
                pst=con.prepareStatement(searchV);
                
                rs=pst.executeQuery();
                return rs;
                
            }
            catch(Exception e)
            {
                 msgbox("Error in search :"+e);
            }
        }
        else
        {  msgbox("Error in search keys!");
            return null;
        
        }
          return null;
        
        
    }
    
     //update function
    
     public boolean update(String ano,String cg, String ven, String dec,String mod,String aqD,String wrp,String wrt,String pri,String mtp,String mtt,String dp,String dprR,String dprA, String st,String std) //throws ParseException
    {
        PreparedStatement pst,pst2,pst3,pst4,pst5,pst6,pst7=null;
        
        if(checkEmpty(ano,cg,ven,dec,mod,aqD,wrp,wrt,pri,mtp,mtt,dp,dprR,dprA,st,std))
        {
            try
            {
                //System.out.println(std);   

            String ud1="UPDATE assets SET descript='"+dec+"',model='"+mod+"',vendName='"+ven+"',purchDate='"+aqD+"',price='"+pri+"',category='"+cg+"',location='"+dp+"' WHERE assetNo='"+ano+"'"; //status='"+st+"',stDate='"+std+"' WHERE assetNo='"+ano+"'";

            //String ud2="UPDATE category SET category='"+cg+"' WHERE assetNo='"+ano+"'";

            String ud2="UPDATE depreciation SET rate='"+dprR+"',amount='"+dprA+"' WHERE assetNo='"+ano+"'";

            //String ud4="UPDATE location SET department='"+dp+"',employee='"+epl+"' WHERE assetNo='"+ano+"'";

            String ud3="UPDATE maintain SET mperiod='"+mtp+"', mtimeUnit='"+mtt+"',wPeriod='"+wrp+"',wtimeUnit='"+wrt+"' WHERE assetNo='"+ano+"'";
            
            String ud4="UPDATE assets SET status='"+st+"', stDate='"+std+"' WHERE assetNo='"+ano+"'";

            //String ud6="UPDATE vendor SET name ='"+ven+"', address='"++"', contactNo='"+ +"' WHERE vendName='"+ven+"'";

           // String ud7="UPDATE warranty SET period='"+wrp+"',timeStamp='"+wrt+"' WHERE assetNo='"+ano+"'";

            pst=con.prepareStatement(ud1);
            pst2=con.prepareStatement(ud2);
            pst3=con.prepareStatement(ud3);
            pst4=con.prepareStatement(ud4);

            pst.execute();
            pst2.execute();
            pst3.execute();
            pst4.execute();


             msgbox("Successfuly updated! ");

             return true;
            }
            catch(Exception e)
            {
                msgbox("ERROR! "+e);
                return false;
            }
        }
        else
            return false;

            
    }
   
     
     //Delete function
     
     public void delete(String asno)
     {
         String dltAq="DELETE FROM assets WHERE assetNo='"+asno+"'";
         String dltMq="DELETE FROM maintain WHERE assetNo='"+asno+"'";
         String dltDq="DELETE FROM depreciation WHERE assetNo='"+asno+"'";
         
         
         PreparedStatement pst1, pst2, pst3;
         
         try
         {
               pst1=con.prepareStatement(dltAq);
               pst2=con.prepareStatement(dltMq);
               pst3=con.prepareStatement(dltDq);
               
               pst1.execute();
               pst2.execute();
               pst3.execute();

               msgbox("Success fully Deleted!");
         }
         catch(Exception e)
         {
          
             msgbox("Error in deleting! "+e);
         }
         
     }
     
     //Add vendor functiion
     
     public boolean addVendor(String nm, String addrs, String conNo )
     {
         PreparedStatement pst=null;
         
         String addV="INSERT INTO vendor(name,address,contactNo) VALUES('"+nm+"','"+addrs+"','"+conNo+"')";
         try {
             
             pst=con.prepareStatement(addV);
         
            pst.execute();

            msgbox("Successfuly Inserted! ");
            return true;
            
         } 
         catch (Exception e) {
             msgbox("Error in inserting to vendor! \n Error:"+e);
             return false;
         }
         
     }
     
     //calc depreciation amount 
     public void calcDepr()
     {
         PreparedStatement pst,pst2=null;
         ResultSet rs=null;
         
         String getDepr="SELECT d.assetNo, d.rate, d.amount, a.price, a.purchDate FROM depreciation d, assets a WHERE d.assetNo=a.assetNo";
         
         
         try 
         {
              pst=con.prepareStatement(getDepr);
              
              rs=pst.executeQuery();
              
              int cnt=1;
              
              DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
              
              while(rs.next())
              {
                             
                  String assetId=rs.getObject("assetNo").toString();
                  double price=Double.parseDouble(rs.getObject("price").toString());
                  double rate=Double.parseDouble(rs.getObject("rate").toString());
                  double amnt=Double.parseDouble(rs.getObject("amount").toString());
                  Date purchD=df.parse(rs.getObject("purchDate").toString());
                  
                  //System.out.println(assetId+","+price+","+rate+","+purchD);
                  
                  
                  Date today=new Date();
                  
                  Calendar d1=getCalendar(purchD);
                  Calendar d2=getCalendar(today);
                  
                 // System.out.println(assetId);
                  
                  int years=d2.get(1)-d1.get(1);
                  
                  double totDep=(amnt*years);
                  
                  String updtDeprc="UPDATE depreciation SET deprcLife='"+years+"' , totalDeprc='"+totDep+"' WHERE assetNo='"+assetId+"'";
                  
                  pst2=con.prepareStatement(updtDeprc);
                  pst2.execute();
                  
                  
                  
                  
              } 
              
              
          } catch (SQLException ex) {
              Logger.getLogger(functions.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ParseException ex) {
              Logger.getLogger(functions.class.getName()).log(Level.SEVERE, null, ex);
          }
         
        
         
         
     }
     
     //calc depreciation precent
     public double calcDeprRate(double rate, String prchD )
     {
         Date today=new Date();
          double totRate=0;
         
         DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
         
         try
         {
            Date purch=df.parse(prchD);

            Calendar d1=getCalendar(today);
            Calendar d2=getCalendar(purch);
            
            int years= d1.get(1)-d2.get(1);
            
            totRate=years * rate;
            
          
         }
         catch(Exception e)
         {
             msgbox("Error in calculating total depreciation rate. \n "+e);
         }
           
           if(totRate>100)
                return 100;
            else
                return totRate;
         
     }
   
     public static Calendar getCalendar(Date date)
         {
             Calendar cal=Calendar.getInstance(Locale.US);
             cal.setTime(date);
            
             return cal;
         }
    
    
     
     //Warranty calculation
     public int leftWarrnty(int num, String time, String pdate)
     {
         DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
         Date today=new Date();
         
         Calendar d2=getCalendar(today);
         
         int left=0;
         
         try
         {
            if(time.equalsIgnoreCase("Year(s)"))
            {
                Calendar d1=getCalendar(df.parse(pdate));

                int x=d2.get(1)-d1.get(1);
                
                left=num-x;

            }
            else if(time.equalsIgnoreCase("Month(s)"))
            {
                Calendar d1=getCalendar(df.parse(pdate));
                
                int x=d2.get(2)-d1.get(2);
                
                left=num-x;
                
            }

         }
         catch(Exception e)
         {
             System.out.println("Error! " +e );
         }
         
         if(left<=0)
             return 0;
         else
            return left;
     }
     
  
     //validation
     private boolean checkEmpty(String ano,String cg, String ven, String dec,String mod,String aqD,String wrp,String wrt,String pri,String mtp,String mtt,String dp,String dprR,String dprA,String st,String std) //throws ParseException
     {
         
         if(ano.isEmpty()| cg.isEmpty()| ven.isEmpty()| dec.isEmpty()| mod.isEmpty()| aqD.isEmpty()| wrp.isEmpty()| wrt.isEmpty()| pri.isEmpty()| mtp.isEmpty()| mtt.isEmpty()| dp.isEmpty()| dprR.isEmpty()| dprA.isEmpty()| st.isEmpty()| std.isEmpty())
         {
             msgbox("Please Fill Every detail");
             return false;
             
         }
         else if(ven.equalsIgnoreCase("select")| cg.equalsIgnoreCase("select")|wrp.equalsIgnoreCase("select")| wrt.equalsIgnoreCase("select")| mtp.equalsIgnoreCase("select")| mtt.equalsIgnoreCase("Select")| dp.equalsIgnoreCase("select"))       
         {
             msgbox("Please Fill Every detail \n Hint:Check Dropdowns ");
             return false;
         }
         else if(chkDate(aqD) )
         { 
             msgbox("The purchase date is in future.\n Please select a valid date");
             return false;
         }
         else if(Idchk(ano))
         {
             msgbox("Asset-No must have 5 characters");
             return false;   
         }
          else if(!ano.matches("^[A-Z]{2}\\d{3}"))
         {
             msgbox("Format of asset number is different.\n Format:[A-Z][A-Z][0-9][0-9][0-9]");
             return false;
         }
         else 
             return true;
         
         
     }
     
     //checking Dates
     public boolean chkDate(String date) 
     {
         Date today=new Date();
         int units=0;
         
         SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
          try 
          {
              Date date1=sd.parse(date);
              String temp=sd.format(today);
              
              Date date2=sd.parse(temp);
             
              
               if(date1.after(date2))
              {
                  System.out.println("date is after");
                  return true;
              }
              else 
                  return false;
              
          } catch (ParseException ex) {
              Logger.getLogger(functions.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Error chking date:"+ex);
               
          }
         return false;
         
         
         
     }
     
     //asset no check
     private boolean Idchk(String asID)
     {
         if(asID.length()==5)
             return false;
         else
             return true;
     }
     
     
     //maintain reminder
     
     public String[] remindMaint()
     {
         PreparedStatement pst=null;
         ResultSet rs=null;
         
         long diff=0;
         int mpd=0;
         String asno=null;
         
         int units,day=0;
         
         String[] result=new String[50];
         int i=0;
         
         String maintDet="SELECT assetNo,mperiod,mtimeUnit,lstMaint from maintain";
         
         
         
         try
         {
            pst=con.prepareStatement(maintDet);
            rs=pst.executeQuery();
            
           
            
            while(rs.next())
            {
                 asno=rs.getObject("assetNo").toString();
                mpd=Integer.parseInt(rs.getObject("mperiod").toString());
                String mtu=rs.getObject("mtimeUnit").toString();
                String lmd=rs.getObject("lstMaint").toString();
                
                
                
                DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
                
                Date lstMnt=df.parse(lmd);
                Date today =new Date();
                
                Calendar d1=getCalendar(today);
                Calendar d2=getCalendar(lstMnt);
                
                if(mtu.equalsIgnoreCase("Day(s)"))
                {
                    //diff=d2.get(Calendar.DAY_OF_MONTH)-d1.get(Calendar.DAY_OF_MONTH);
                    diff=today.getTime()-lstMnt.getTime();
                    
                     units = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                     
                     day=d1.get(Calendar.MONTH)-d2.get(Calendar.MONTH);
                    
                    //System.out.println(units);
                }
                else if(mtu.equalsIgnoreCase("Month(s)"))
                {
                    units=d1.get(Calendar.MONTH)-d2.get(Calendar.MONTH); //check the difference between months
                    
                    //diff=today.getTime()-lstMnt.getTime();
                    
                    //units = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    
                    day=d1.get(Calendar.DAY_OF_MONTH)-d2.get(Calendar.DAY_OF_MONTH); //check the difference of 2 days of months
//                    System.out.println("d="+day);
//                    
//                    System.out.println(units);
                    
                }
                else if(mtu.equalsIgnoreCase("Year(s)"))
                {
                    units=d1.get(1)-d2.get(1);
                    day=d1.get(Calendar.DAY_OF_YEAR)-d2.get(Calendar.DAY_OF_YEAR);
                    
                    if(day<0)
                        day++;
                    
                    System.out.println(units+","+day);
                }
                else
                {
                    msgbox("Error reading from maintain drop down");
                    units=1000000;
                }
                
                //System.out.println("i="+i);
                
                if(units==mpd && day==0)
                {
                    //System.out.println(result);
                    result[i]=asno;
                    i++;
                    
                }
                //System.out.println(i);
                
            }
            
             
      
         
         }
         catch(Exception e)
         {
             System.out.println("Erro:"+e);
         }

         if(i==0)
            return null;
         else
             return result;
         
     }
     
  
     public boolean updMaint(String ano)
     {
         PreparedStatement pst=null;
         
         Date today= new Date();
         
         DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
         
         String tday=df.format(today);
         
         
         String updMnt="UPDATE maintain SET lstMaint='"+tday+"' WHERE assetNo='"+ano+"'";
        
         try
         {
                pst=con.prepareStatement(updMnt);
                pst.execute();
                
                return true;
         }
         catch(Exception e)
         {
             msgbox("Error in updating maintain! "+e);
             return false;
         }
         
         
         
     }
     
      public void popWarrnty()
     {
         PreparedStatement pst=null;
         ResultSet rs=null;
         
         String[] result=new String[50];
         int i=0;
         
         String getWarr="SELECT m.assetNo,m.wPeriod,m.wtimeUnit,a.purchDate FROM maintain m, assets a WHERE a.assetNo=m.assetNo";
        
         try
         {
            pst=con.prepareStatement(getWarr);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                String purDate=rs.getObject(4).toString();
                
                DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
                Date td=new Date();
                
                Date pDate=df.parse(purDate);
                 Date expd=null;

                 String ast=rs.getObject(1).toString();
                
                
                
               if((rs.getObject(3).toString()).equalsIgnoreCase("Month(s)"))
                {
                    int n=(Integer.valueOf(rs.getObject(2).toString()));
                   // System.out.println("n="+n);
                    
                    Calendar c=Calendar.getInstance();
                    c.setTime(pDate);
                    
                    c.add(Calendar.MONTH,n);
                  
                    String d=df.format(c.getTime());
                    expd=df.parse(d);
   
                }
               else if((rs.getObject(3).toString()).equalsIgnoreCase("Year(s)"))
                {
                    int n=(Integer.valueOf(rs.getObject(2).toString()));
                    
                    Calendar c=Calendar.getInstance();
                    c.setTime(td);
                    
                    c.add(Calendar.YEAR,n);
                  
                    String d=df.format(c.getTime());
                    expd=df.parse(d);
   
                }
               
                System.out.println("td:"+td+",expd:"+expd);
                
                
                String d1=df.format(td);
                td=df.parse(d1);
                
                String d2=df.format(expd);
                expd=df.parse(d2);
                
                
                //System.out.println(td.compareTo(expd));
                
                
                int x;
               if((x=td.compareTo(expd))==0)
               {
      
                popUp pp=new popUp(ast);
                
                pp.setVisible(true);
                   
                   //msgbox("Warranty of Asset:"+ast+" expires today!");
               }
               
               
                
            }
            
            
         }
         catch(Exception e)
         {
             System.out.println("Error in warranty expire check:"+e);
             
         }
       
     }
     
}



