/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import ConnectDatabase.DatabaseConnection;
import java.sql.Connection;
//import com.mysql.jdbc.Connection;
import static java.nio.file.Files.delete;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Osuri Dunuwila
 */
public class jobLB extends javax.swing.JInternalFrame {
    Connection con=null;
    
    PreparedStatement pst=null;
    ResultSet rst=null;
    

    /**
     * Creates new form jobLB
     */
    public jobLB() {
        initComponents();
        con=DatabaseConnection.connect();
        
        combo();
         tableload();
         comboDs();
    }

    
        private void showM(String s)
    {
        JOptionPane.showMessageDialog(null,s);
    }
  
    public void comboDs()
    {
        String ds="SELECT CONCAT(firstname , ' ' , lastname) as name FROM emp WHERE designation='Designer'";
        
        try
        {
           pst=con.prepareStatement(ds);
            rst=pst.executeQuery();
            
            while (rst.next()){
            String namee=rst.getString("name");
            
           
                des.addItem(namee);
            
            
            }
        } catch (SQLException e) {
            
            System.out.println("Error:"+e);
        }
        
    }
   
    
    
    
    
    public void tableload(){
    
    String sql="SELECT LBID,lbdesc as Description,quantity,givendate as Aquired_date, duedate as Due_Date,remarks,client,design as Designer,jobstat as Status  from joblb";
        try {
            pst=con.prepareStatement(sql);
            rst=pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rst));
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
    

    }
    
    public void combo(){
    String pg="SELECT ClientName FROM client";
    
        try {
            pst=con.prepareStatement(pg);
            rst=pst.executeQuery();
            
            while (rst.next()){
            String name=rst.getString("ClientName");
            
           
                clientt.addItem(name);
            
            
            }
        } catch (SQLException e) {
            
            System.out.println("Error:"+e);
        }
    }
    
    
     public void comboS(){
    String pg="SELECT ds1 FROM client";
    
        try {
            pst=con.prepareStatement(pg);
            rst=pst.executeQuery();
            
            while (rst.next()){
            String name=rst.getString("ds1");
            
           
                des.addItem(name);
            
            
            }
        } catch (SQLException e) {
            
            System.out.println("Error:"+e);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbID = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jbdescription = new javax.swing.JTextArea();
        quantity = new javax.swing.JTextField();
        givendate = new com.toedter.calendar.JDateChooser();
        duedate = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        remarks = new javax.swing.JScrollPane();
        remarkss = new javax.swing.JTextArea();
        clientt = new javax.swing.JComboBox<String>();
        des = new javax.swing.JComboBox<String>();
        status = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        srch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

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
        jLabel2.setText("Job Description");

        jLabel3.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quantity");

        jLabel4.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Given date");

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Due date");

        jbdescription.setColumns(20);
        jbdescription.setRows(5);
        jScrollPane3.setViewportView(jbdescription);

        givendate.setBackground(new java.awt.Color(68, 108, 179));
        givendate.setDateFormatString("yyyy-MM-dd");

        duedate.setBackground(new java.awt.Color(68, 108, 179));
        duedate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantity)
                            .addComponent(lbID))
                        .addGap(66, 66, 66))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(givendate, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(duedate, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(31, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(givendate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(duedate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        jPanel3.setBackground(new java.awt.Color(68, 108, 179));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 350));

        jLabel6.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Remarks");

        jLabel7.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Client");

        jLabel8.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Assigned designer 1");

        jLabel9.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Status");

        remarkss.setColumns(20);
        remarkss.setRows(5);
        remarks.setViewportView(remarkss);

        clientt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        clientt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienttActionPerformed(evt);
            }
        });

        des.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));

        status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Pending", "Completed", "Canceled" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(status, javax.swing.GroupLayout.Alignment.LEADING, 0, 146, Short.MAX_VALUE)
                        .addComponent(des, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clientt, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(clientt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Deescription", "Quantity", "Date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(68, 108, 179));
        jButton1.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Job");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(68, 108, 179));
        jButton2.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
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
        jButton3.setText("Delete Job");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Client");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(srch, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(srch, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String _jblb=lbID.getText();
        String _jbdes=jbdescription.getText();
        String _gdate=((JTextField)givendate.getDateEditor().getUiComponent()).getText();
        String _dudate=((JTextField)duedate.getDateEditor().getUiComponent()).getText();
        String _desrk=remarkss.getText();
        String _cli=clientt.getSelectedItem().toString();
        String _desingr=des.getSelectedItem().toString();
        String _stat=status.getSelectedItem().toString();
        String qty=quantity.getText();
       



        String upd="UPDATE joblb set lbdesc='"+_jbdes+"' ,quantity='"+qty+"',givendate='"+_gdate+"', duedate='"+_dudate+"',remarks='"+_desrk+"',jobstat='"+_stat+"' where LBID='"+_jblb+"'";
                
              try {
            pst=con.prepareStatement(upd);
            pst.execute();
            showM("Successfully updated");
            tableload();
        } catch (SQLException e) {
            
            System.out.println("Error:"+e);
        }
              
              tableload();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String jblb=lbID.getText();
        String jbdes=jbdescription.getText();
        String qty=quantity.getText();
        String gdate=((JTextField)givendate.getDateEditor().getUiComponent()).getText();
        String dudate=((JTextField)duedate.getDateEditor().getUiComponent()).getText();
        String desrk=remarkss.getText();
        String cli=clientt.getSelectedItem().toString();
        String desingr=des.getSelectedItem().toString();
        String stat=status.getSelectedItem().toString();
        
        String que="insert into joblb values ('"+jblb+"','"+jbdes+"','"+qty+"','"+gdate+"','"+dudate+"','"+desrk+"','"+cli+"','"+desingr+"','"+stat+"')";
            
        try {
            
            
            //see the next line
            functionsO fs=new functionsO();
            
            if(fs.validateLB(jblb)){
            pst=con.prepareStatement(que);
            pst.execute();
            showM("Successfully inserted");
            tableload();
            
            lbID.setText("");
        jbdescription.setText("");
        remarkss.setText("");
        clientt.setSelectedItem("");
        quantity.setText("");
        des.setSelectedItem("");
        status.setSelectedItem("");
            
            
            
            
            }
        } catch (SQLException ex) {
            
            System.out.println("Error:"+ex);
            
        }
        
        
        tableload();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         functionsO f2=new functionsO();
        
        ResultSet rs=f2.searchCl(srch.getText());
        
       jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         int row=jTable1.getSelectedRow();
        String id=jTable1.getValueAt(row, 0).toString();
        String desc=jTable1.getValueAt(row,1).toString();
        String qty=jTable1.getValueAt(row, 2).toString();
        String date=jTable1.getValueAt(row, 3).toString();
        String ddate=jTable1.getValueAt(row,4).toString();
        String remrk=jTable1.getValueAt(row,5).toString();
        String client=jTable1.getValueAt(row,6).toString();
        String desgn=jTable1.getValueAt(row,7).toString();
        String stat=jTable1.getValueAt(row,8).toString();
        
        lbID.setText(id);
        jbdescription.setText(desc);
        remarkss.setText(remrk);
        clientt.setSelectedItem(client);
        quantity.setText(qty);
        des.setSelectedItem(desgn);
        status.setSelectedItem(stat);
        
        
        try
        {
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            Date dd=(Date) df.parse(ddate);
            Date gd=df.parse(date);
            
            //System.out.println(dd);
            
            
            duedate.setDate(dd);
            givendate.setDate(gd);
        }
        catch(Exception e)
        {
            System.out.println("error in date :"+e);
            
        }
        
       
        
     
       
        
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int y=JOptionPane.showConfirmDialog(null, "Do you want to delete");
        if (y==0){
        
            
            String id=lbID.getText();
        String del="Delete from joblb where LBID='"+id+"'";
         try {
            
            
            //see the next line
            pst=con.prepareStatement(del);
            pst.execute();
            showM("Successfully Deleted");
            
        } catch (SQLException ex) {
            
            System.out.println("Error:"+ex);
            
        }
        tableload();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void clienttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienttActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> clientt;
    private javax.swing.JComboBox<String> des;
    private com.toedter.calendar.JDateChooser duedate;
    private com.toedter.calendar.JDateChooser givendate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jbdescription;
    private javax.swing.JTextField lbID;
    private javax.swing.JTextField quantity;
    private javax.swing.JScrollPane remarks;
    private javax.swing.JTextArea remarkss;
    private javax.swing.JTextField srch;
    private javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}