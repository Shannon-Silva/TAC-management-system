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
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author shannon
 */ //850, 561
public class employeeVote extends javax.swing.JFrame {

    /**
     * Creates new form employeeVote
     */
    
    Connection con = null; 
    PreparedStatement pst = null;
    ResultSet rs = null; Statement st = null;
    ResultSet rs2 = null; Statement st2 = null;
    ResultSet rs3 = null; Statement st3 = null;
    ResultSet rs4 = null; Statement st4 = null;
    ResultSet rs5 = null; Statement st5 = null;
    
    Statement st6 = null; ResultSet rs6 = null;
    Statement st7 = null; ResultSet rs7 = null;
    Statement st8 = null; ResultSet rs8 = null;
    Statement st9 = null; ResultSet rs9 = null;
    Statement st10 = null; ResultSet rs10 = null;
    
    String VEMP=null ;        //voter's empid from login 
       
        
    int count=0;
    int did=0;
    int pmid=0;
    int crid=0;
    int tacid=0;
    int rcid=0;
        
    public employeeVote() {
        initComponents();
        
         con=DatabaseConnection.connect();
         designer();
         pageManager();
         creativeEye();
         tacer();
         recruit();
                 
    }
    
    
 public employeeVote(String x) {
        initComponents();
        
         con=DatabaseConnection.connect();
         
         designer();
         pageManager();
         creativeEye();
         tacer();
         recruit();
         
         VEMP=x;
         empid.setText(VEMP);
    }
        
    public void designer(){
        String query1;
        try{
            st = con.createStatement();
            query1= "SELECT firstname, lastname FROM emp WHERE designation= 'Designer';";
            rs = st.executeQuery(query1);
            
            String fname= null;
            String lname=null;
            
            while(rs.next()){
	  fname= rs.getString(1);
	  lname= rs.getString(2);
	  de.addItem(fname +' '+lname);
            }                      
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void pageManager(){
        String query2;
        
        try{
            st2 = con.createStatement();
            query2= "SELECT firstname, lastname  FROM emp WHERE designation= 'Page Manager';";
            rs2 = st2.executeQuery(query2);
            
            String fname= null;
            String lname=null;
            
            while(rs2.next()){
	  fname= rs2.getString(1);
	  lname= rs2.getString(2);
	  pm.addItem(fname +' '+lname);
            }                        
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void creativeEye(){
        String query3;
        try{
            st3 = con.createStatement();
            query3= "SELECT firstname, lastname  FROM emp;";
            rs3 = st3.executeQuery(query3);
            
            String fname= null;
            String lname=null;
            
            while(rs3.next()){
	  fname= rs3.getString(1);
	  lname= rs3.getString(2);
	  creat.addItem(fname +' '+lname);
            }                        
        }
        catch(Exception ex){
           System.out.println(ex);
        }
    }
    
    public void tacer(){
        String query4;
        try{
            st4 = con.createStatement();
            query4= "SELECT firstname, lastname  FROM emp;";
            rs4 = st4.executeQuery(query4);
            
            String fname= null;
            String lname=null;
            
            while(rs4.next()){
	  fname= rs4.getString(1);
	  lname= rs4.getString(2);
	  tacer.addItem(fname +' '+lname);
            }                        
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void recruit(){
                                     
        String query5;
        
        try{
            st5 = con.createStatement();
            query5= "SELECT firstname, lastname FROM emp WHERE YEAR(joineddate) = YEAR(CURDATE());";
            rs5 = st5.executeQuery(query5);
            
            String fname= null;
            String lname=null;
            
            while(rs5.next()){
	  fname= rs5.getString(1);
	  lname= rs5.getString(2);
	  rec.addItem(fname +' '+lname);
            }                        
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        de = new javax.swing.JComboBox<>();
        deTXT = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pm = new javax.swing.JComboBox<>();
        pmTXT = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rec = new javax.swing.JComboBox<>();
        recruitTXT = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tacer = new javax.swing.JComboBox<>();
        tacerTXT = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        creat = new javax.swing.JComboBox<>();
        creatTXT = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        empid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setBackground(new java.awt.Color(68, 108, 179));

        jPanel1.setBackground(new java.awt.Color(68, 108, 179));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setBackground(new java.awt.Color(68, 108, 179));
        jLabel2.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Best Designer of the Year:");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBackground(new java.awt.Color(68, 108, 179));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Candidate Name:");

        jLabel3.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Candidate ID:");

        de.setBackground(new java.awt.Color(68, 108, 179));
        de.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        de.setMaximumRowCount(100);
        de.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        de.setToolTipText("");
        de.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deActionPerformed(evt);
            }
        });

        deTXT.setBackground(new java.awt.Color(255, 255, 255));
        deTXT.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        deTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deTXT.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        deTXT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(de, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(de, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(deTXT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel6.setBackground(new java.awt.Color(68, 108, 179));
        jLabel6.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Best Page Manager of the Year:");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBackground(new java.awt.Color(68, 108, 179));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(68, 108, 179));
        jLabel8.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Candidate Name:");

        jLabel7.setBackground(new java.awt.Color(68, 108, 179));
        jLabel7.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Candidate ID:");

        pm.setBackground(new java.awt.Color(68, 108, 179));
        pm.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        pm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        pm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmActionPerformed(evt);
            }
        });

        pmTXT.setBackground(new java.awt.Color(255, 255, 255));
        pmTXT.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        pmTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pmTXT.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pmTXT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pm, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pmTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pm, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pmTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jLabel10.setBackground(new java.awt.Color(68, 108, 179));
        jLabel10.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Best Recruit of the Year:");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel5.setBackground(new java.awt.Color(68, 108, 179));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setBackground(new java.awt.Color(68, 108, 179));
        jLabel12.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Candidate Name:");

        jLabel11.setBackground(new java.awt.Color(68, 108, 179));
        jLabel11.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Candidate ID:");

        rec.setBackground(new java.awt.Color(68, 108, 179));
        rec.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        rec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        rec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recActionPerformed(evt);
            }
        });

        recruitTXT.setBackground(new java.awt.Color(255, 255, 255));
        recruitTXT.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        recruitTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recruitTXT.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        recruitTXT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(recruitTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 89, Short.MAX_VALUE))
                    .addComponent(rec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rec, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(recruitTXT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel14.setBackground(new java.awt.Color(68, 108, 179));
        jLabel14.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("TACer of the year:");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel6.setBackground(new java.awt.Color(68, 108, 179));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setBackground(new java.awt.Color(68, 108, 179));
        jLabel15.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Candidate Name:");

        jLabel16.setBackground(new java.awt.Color(68, 108, 179));
        jLabel16.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Candidate ID:");

        tacer.setBackground(new java.awt.Color(68, 108, 179));
        tacer.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        tacer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        tacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tacerActionPerformed(evt);
            }
        });

        tacerTXT.setBackground(new java.awt.Color(255, 255, 255));
        tacerTXT.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        tacerTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tacerTXT.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tacerTXT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(tacerTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 96, Short.MAX_VALUE))
                    .addComponent(tacer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tacer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(tacerTXT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel18.setBackground(new java.awt.Color(68, 108, 179));
        jLabel18.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Creative Eye of the Year:");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel7.setBackground(new java.awt.Color(68, 108, 179));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel19.setBackground(new java.awt.Color(68, 108, 179));
        jLabel19.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Candidate Name:");

        jLabel20.setBackground(new java.awt.Color(68, 108, 179));
        jLabel20.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Candidate ID:");

        creat.setBackground(new java.awt.Color(68, 108, 179));
        creat.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        creat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        creat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creatActionPerformed(evt);
            }
        });

        creatTXT.setBackground(new java.awt.Color(255, 255, 255));
        creatTXT.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        creatTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        creatTXT.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        creatTXT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(creatTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(creat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(creatTXT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        jButton1.setBackground(new java.awt.Color(68, 108, 179));
        jButton1.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Vote");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(68, 108, 179));
        jButton2.setForeground(new java.awt.Color(68, 108, 179));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Tac-White.png"))); // NOI18N

        empid.setBackground(new java.awt.Color(68, 108, 179));
        empid.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        empid.setForeground(new java.awt.Color(51, 255, 255));
        empid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empid.setText("16721");
        empid.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        empid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(43, 43, 43))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(empid, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(empid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(238, 238, 238)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void creatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creatActionPerformed
        // TODO add your handling code here:
        
        String b = String.valueOf(creat.getSelectedItem());
        String[] names = b.split(" ");
        String f_name = names[0]; 
        String l_name = names[1];
       
       String q5;
       try{
            st10 = con.createStatement();
            q5= "SELECT empid FROM emp WHERE firstname='" +f_name+ "' AND lastname='"+l_name+"';";
            rs10 = st10.executeQuery(q5);
            
            if(rs10.next()){
	  crid=rs10.getInt(1);
	  String ID= Integer.toString(crid);
	  creatTXT.setText(ID);}
            
       }catch(Exception ex){
           System.out.println(ex);
       }
    }//GEN-LAST:event_creatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    
        /*String TACER=String.valueOf(tacer.getSelectedItem()); 
        String CREAT=String.valueOf(creat.getSelectedItem());
        String DESIGN = String.valueOf(de.getSelectedItem());
        String PAGE = String.valueOf(pm.getSelectedItem());
        String RECRUIT = String.valueOf(rec.getSelectedItem());*/
        
        String designer=Integer.toString(did);
        String pg=Integer.toString(pmid);
        String re=Integer.toString(rcid);
        String cr=Integer.toString(crid);
        String tc=Integer.toString(tacid);
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = df.format(new Date());
        
        if(de.getSelectedIndex()!=0 && rec.getSelectedIndex()!=0 && creat.getSelectedIndex()!=0 && pm.getSelectedIndex()!=0 && tacer.getSelectedIndex()!=0){
      /**/      if(!pg.equals(VEMP) && !designer.equals(VEMP) && !re.equals(VEMP) && !cr.equals(VEMP) && !tc.equals(VEMP)){
	      String sql;
	      try{
	          sql="INSERT INTO vote (voteEmp,voteDate,bestTacer,creativeEye,bestPageManager,bestDesigner,bestRecruit) VALUES ('" +VEMP+ "', '" +formatted+ "', '" +tacid+ "', '" +crid+ "', '" +pmid+ "', '" +did+ "', '" +rcid+ "');"  ;
	          pst = con.prepareStatement(sql);
	          pst.execute();

	          JOptionPane.showMessageDialog(this,"You Vote has been Placed Successfully!");
	          this.dispose();
	      } 
	      catch(SQLException ex){
	          System.out.println(ex);
	          JOptionPane.showMessageDialog(this,"You have Voted Already");
	          Login L1=new Login();
	          L1.setVisible(true);
	          this.dispose();
	      }
	      
            } else {JOptionPane.showMessageDialog(this,"Error: You cannot vote for Youself!");}
        } else {JOptionPane.showMessageDialog(this,"Invalid Vote: Select all options!");}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deActionPerformed
        // TODO add your handling code here:
        String x = String.valueOf(de.getSelectedItem());
        String[] names = x.split(" ");
        String f_name = names[0]; 
        String l_name = names[1]; 
        
        String q1;
       try{
            st6 = con.createStatement();
            q1= "SELECT empid FROM emp WHERE firstname='" +f_name+ "' AND lastname='"+l_name+"';";
            rs6 = st6.executeQuery(q1);
            
            if(rs6.next()){
	  did=rs6.getInt(1);
	  String ID= Integer.toString(did);
	  deTXT.setText(ID);
            }
            
       }catch(Exception ex){
           System.out.println(ex);
       }
    }//GEN-LAST:event_deActionPerformed

    private void pmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmActionPerformed
        // TODO add your handling code here:
        String y = String.valueOf(pm.getSelectedItem());
        String[] names = y.split(" ");
        String f_name = names[0]; 
        String l_name = names[1];
       
       String q2;
       try{
            st7 = con.createStatement();
            q2= "SELECT empid FROM emp WHERE firstname='" +f_name+ "' AND lastname='"+l_name+"';";
            rs7 = st7.executeQuery(q2);
                        
            if(rs7.next()){
	  pmid=rs7.getInt(1);
	  String ID= Integer.toString(pmid);
	  pmTXT.setText(ID);}
            
       }catch(Exception ex){
           System.out.println(ex);
       }
    }//GEN-LAST:event_pmActionPerformed

    private void recActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recActionPerformed
        // TODO add your handling code here:
        String z = String.valueOf(rec.getSelectedItem());
        String[] names = z.split(" ");
        String f_name = names[0]; 
        String l_name = names[1];
       
       String q3;
       try{
            st8 = con.createStatement();
            q3= "SELECT empid FROM emp WHERE firstname='" +f_name+ "' AND lastname='"+l_name+"';";
            rs8 = st8.executeQuery(q3);
                        
            if(rs8.next()){
	  rcid=rs8.getInt(1);
	  String ID= Integer.toString(rcid);
	  recruitTXT.setText(ID);}
            
       }catch(Exception ex){
           System.out.println(ex);
       }
    }//GEN-LAST:event_recActionPerformed

    private void tacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tacerActionPerformed
        // TODO add your handling code here:
        
        String a = String.valueOf(tacer.getSelectedItem());
        String[] names = a.split(" ");
        String f_name = names[0]; 
        String l_name = names[1];
       
       String q4;
       try{
            st9 = con.createStatement();
            q4= "SELECT empid FROM emp WHERE firstname='" +f_name+ "' AND lastname='"+l_name+"';";
            rs9 = st9.executeQuery(q4);
                        
            if(rs9.next()){
	  tacid=rs9.getInt(1);
	  String ID= Integer.toString(tacid);
	  tacerTXT.setText(ID);}
            
       }catch(Exception ex){
           System.out.println(ex);
       }
    }//GEN-LAST:event_tacerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	  if ("Nimbus".equals(info.getName())) {
	      javax.swing.UIManager.setLookAndFeel(info.getClassName());
	      break;
	  }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(employeeVote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employeeVote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employeeVote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employeeVote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
	  new employeeVote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> creat;
    private javax.swing.JLabel creatTXT;
    private javax.swing.JComboBox<String> de;
    private javax.swing.JLabel deTXT;
    private javax.swing.JLabel empid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JComboBox<String> pm;
    private javax.swing.JLabel pmTXT;
    private javax.swing.JComboBox<String> rec;
    private javax.swing.JLabel recruitTXT;
    private javax.swing.JComboBox<String> tacer;
    private javax.swing.JLabel tacerTXT;
    // End of variables declaration//GEN-END:variables
}
