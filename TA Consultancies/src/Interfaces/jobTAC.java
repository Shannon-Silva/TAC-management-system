/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import ConnectDatabase.DatabaseConnection;
import java.sql.Connection;
//import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Osuri Dunuwila
 */
public class jobTAC extends javax.swing.JInternalFrame implements ActionListener {
        Connection con=null;
    
    PreparedStatement pst=null;
    ResultSet rst=null;
    
    String client=null;
    
    
    
    String pk;
    /**
     * Creates new form jobTAC
     */
    public jobTAC() {
        initComponents();
        initComponents();
        con=DatabaseConnection.connect();
        
        tableload();
        
        fillClient();
        
        cllientTac.addActionListener(this);
    }
    
    
     public void actionPerformed(ActionEvent e)
    {
        client=cllientTac.getSelectedItem().toString();
        
        String get="SELECT pg,ds1 FROM client WHERE ClientName='"+client+"'";
        
        try 
        {
            pst=con.prepareStatement(get);
            rst=pst.executeQuery();
            
            rst.next();
            
            aspgm1.setText(rst.getObject("pg").toString());
            asignDes.setText(rst.getObject("ds1").toString());
            
            
        } 
        catch (Exception ex) {
            System.out.println("Error assigning:"+ex);
        }
        
    }
    
    private void showM(String s)
    {
        JOptionPane.showMessageDialog(null,s);
    }
    public void tableload(){
    
    String sql="SELECT TACID, descrip as Description,package,gdate as Date,period,client,pgm as 'Page_Manager',designer,job_status,remarks  from jobtac";
        try {
            pst=con.prepareStatement(sql);
            rst=pst.executeQuery();
            jobtac.setModel(DbUtils.resultSetToTableModel(rst));
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
    
    
    
    }
    
    
    public void fillClient()
    {
        try {
            String pg="SELECT ClientName FROM client ";
    
            pst=con.prepareStatement(pg);
            rst=pst.executeQuery();
            
            
            while (rst.next()){
                  
                
                  cllientTac.addItem(rst.getObject("ClientName").toString());
            
            
            }
        } catch (SQLException e) {
            
            System.out.println("Error:"+e);
        }
    }
    
      public void toForm(int r)
    {
        String tacid=jobtac.getValueAt(r, 0).toString();
        String descr=jobtac.getValueAt(r, 1).toString();
        String pkg=jobtac.getValueAt(r, 2).toString();
        String gdt=jobtac.getValueAt(r, 3).toString();
        //String busTyp=jobtac.getValueAt(r, 2).toString();
        String peri=jobtac.getValueAt(r, 4).toString();
        String client=jobtac.getValueAt(r, 5).toString();
        String pg=jobtac.getValueAt(r, 6).toString();
        String desi=jobtac.getValueAt(r, 7).toString();
        String stat=jobtac.getValueAt(r, 8).toString();
        String remrk=jobtac.getValueAt(r, 9).toString();
        
        jbIDTAC.setText(tacid);
        jobdescription.setText(descr);
        period.setSelectedItem(peri);
        cllientTac.setSelectedItem(client);
        aspgm1.setText(pg);
        asignDes.setText(desi);
        statusTAC.setSelectedItem(stat);
        remarksTAC.setText(remrk);
        
        
        if(pkg.equalsIgnoreCase("package 1"))
        {
            ty1.setSelected(true);
        }
        else if(pkg.equalsIgnoreCase("package 2"))
        {
            ty2.setSelected(true);
        }
        else if(pkg.equalsIgnoreCase("package 3"))
        {
            ty3.setSelected(true);
        }
        
        try
        {
             DateFormat df= new SimpleDateFormat("yyyy-MM-dd");//pattern must be the same as in table
             Date givDt;
               
        
            
            givDt=df.parse(gdt);
            
             givendate.setDate(givDt);
        }
        catch(Exception e)
        {
            System.out.println("error in date to form:"+e);   
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbIDTAC = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jobdescription = new javax.swing.JTextArea();
        ty1 = new javax.swing.JRadioButton();
        ty2 = new javax.swing.JRadioButton();
        ty3 = new javax.swing.JRadioButton();
        givendate = new com.toedter.calendar.JDateChooser();
        period = new javax.swing.JComboBox<String>();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cllientTac = new javax.swing.JComboBox<String>();
        statusTAC = new javax.swing.JComboBox<String>();
        aspgm1 = new javax.swing.JTextField();
        asignDes = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        remarksTAC = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jobtac = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(68, 108, 179));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel2.setBackground(new java.awt.Color(68, 108, 179));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 350));

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Job ID");

        jLabel2.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Job description");

        jLabel3.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Package");

        jLabel4.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Given date");

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Period");

        jobdescription.setColumns(20);
        jobdescription.setRows(5);
        jScrollPane2.setViewportView(jobdescription);

        buttonGroup1.add(ty1);
        ty1.setText("Type 1");

        buttonGroup1.add(ty2);
        ty2.setText("Type 2");

        buttonGroup1.add(ty3);
        ty3.setText("Type 3");

        givendate.setBackground(new java.awt.Color(68, 108, 179));
        givendate.setDateFormatString("yyyy-MM-dd");

        period.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "3 Months", "6 Months", "1 Year", "2 Years" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbIDTAC)
                        .addGap(74, 74, 74))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ty3)
                            .addComponent(ty2)
                            .addComponent(ty1)
                            .addComponent(givendate, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(53, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbIDTAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ty1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ty2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ty3)
                        .addGap(18, 18, 18)
                        .addComponent(givendate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel4)))
                .addGap(27, 27, 27))
        );

        jPanel3.setBackground(new java.awt.Color(68, 108, 179));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 350));

        jLabel6.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Client");

        jLabel7.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Assigned Page Manager");

        jLabel8.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Assigned Designer");

        jLabel9.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Job status");

        jLabel10.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Remarks");

        statusTAC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Status", "Pending", "Completed", "Canceled" }));

        remarksTAC.setColumns(20);
        remarksTAC.setRows(5);
        jScrollPane3.setViewportView(remarksTAC);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(asignDes)
                            .addComponent(aspgm1)
                            .addComponent(statusTAC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cllientTac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cllientTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(aspgm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(asignDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(statusTAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jobtac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jobtac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jobtacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jobtac);

        jButton1.setBackground(new java.awt.Color(68, 108, 179));
        jButton1.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add job");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(68, 108, 179));
        jButton2.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update job");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(68, 108, 179));
        jButton3.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete job");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                String TACid=jbIDTAC.getText();
        String descrip=jobdescription.getText();
        //enter the radio button part
        
        
        if(ty1.isSelected())
        {
        
         pk="Package 1";
         
        }
        
        else if(ty2.isSelected())
        {
          pk="Package 2";
        
        }
        else if (ty3.isSelected()){
        
         pk="Package 3";
        }
       else
        {   functionsO ms=new functionsO();
            ms.mesbox("You must select a type");
        
        }
        
       String date=((JTextField)givendate.getDateEditor().getUiComponent()).getText();
       String Period=period.getSelectedItem().toString();
       String clientT=cllientTac.getSelectedItem().toString();
       String aspg=aspgm1.getText();
       String assdes=asignDes.getText();
       String statu=statusTAC.getSelectedItem().toString();
       String remarkT=remarksTAC.getText();
       
       functionsO fs=new functionsO();
       
       
       //DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    try {
       // String da=df.parse(date).toString();
        if(fs.validateTAC(TACid)){
         String query="insert into jobtac values ('"+TACid+"','"+descrip+"','"+pk+"','"+date+"','"+Period+"','"+clientT+"','"+aspg+"','"+assdes+"','"+statu+"','"+remarkT+"')";
      
            pst=con.prepareStatement(query);
            pst.execute();
        
        showM("Successfully Inserted!");
        jbIDTAC.setText("");
        jobdescription.setText("");
        period.setSelectedItem("");
        cllientTac.setSelectedItem("");
        aspgm1.setText("");
        asignDes.setText("");
        statusTAC.setSelectedItem("");
        remarksTAC.setText("");
        

    } 
    }
    catch (SQLException ex) {
        Logger.getLogger(jobTAC.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("err:"+ex);
        
        
    }
       
         tableload();
         

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jobtacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jobtacMouseClicked
            int row=jobtac.getSelectedRow();
            toForm( row);
       
    }//GEN-LAST:event_jobtacMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         String TACid=jbIDTAC.getText();
        String descrip=jobdescription.getText();
        //enter the radio button part
        
        
        if(ty1.isSelected())
        {
        
         pk="Package 1";
         
        }
        
        else if(ty2.isSelected())
        {
          pk="Package 2";
        
        }
        else if (ty3.isSelected()){
        
         pk="Package 3";
        }
       else
        {   functionsO ms=new functionsO();
            ms.mesbox("You must select a type");
        
        }
        
       String date=((JTextField)givendate.getDateEditor().getUiComponent()).getText();
       String Period=period.getSelectedItem().toString();
       String clientT=cllientTac.getSelectedItem().toString();
       String aspg=aspgm1.getText();
       String assdes=asignDes.getText();
       
       String statu=statusTAC.getSelectedItem().toString();
       String remarkT=remarksTAC.getText();
       
       String hu="UPDATE jobtac set  descrip='"+descrip+"' ,package='"+pk+"', gdate='"+date+"', period='"+Period+"' ,client='"+clientT+"' ,pgm='"+aspg+"' ,designer='"+assdes+"', job_status='"+statu+"', remarks='"+remarkT+"' WHERE TACID='"+TACid+"'";
        
        try {
            pst=con.prepareStatement(hu);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Successfully updated");
            tableload();
            
            
        } catch (HeadlessException | SQLException e) {
            
            System.out.println("error"+e);
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String id=jbIDTAC.getText();
        
        String deleteTac="DELETE FROM jobtac WHERE tacid='"+id+"'";
        
        try 
        {
            
         int op=JOptionPane.showConfirmDialog(null,"Delete this record ?");
         
         if(op==0)
         {
             pst=con.prepareStatement(deleteTac);
         
             pst.execute();
         
             JOptionPane.showMessageDialog(null,"Successfully Deleted!");
             tableload();
         }
        } 
        catch (Exception e)
        {
            System.out.println("Error in deleting:"+e);
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField asignDes;
    private javax.swing.JTextField aspgm1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cllientTac;
    private com.toedter.calendar.JDateChooser givendate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jbIDTAC;
    private javax.swing.JTextArea jobdescription;
    private javax.swing.JTable jobtac;
    private javax.swing.JComboBox<String> period;
    private javax.swing.JTextArea remarksTAC;
    private javax.swing.JComboBox<String> statusTAC;
    private javax.swing.JRadioButton ty1;
    private javax.swing.JRadioButton ty2;
    private javax.swing.JRadioButton ty3;
    // End of variables declaration//GEN-END:variables
}
