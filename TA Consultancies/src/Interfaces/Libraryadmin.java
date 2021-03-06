/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ConnectDatabase.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Manula Ranzika
 */
public class Libraryadmin extends javax.swing.JInternalFrame {
    
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs= null;
    
    /**
     * Creates new form LibraryAdmin
     */
    public Libraryadmin() {
        initComponents();
        con=DatabaseConnection.connect();
        
        tableLoadB b1 = new tableLoadB();
        b1.tableloadB();
        
        tableLoadC c1 = new tableLoadC();
        c1.tableloadC();
        
        tableLoadM m1 = new tableLoadM();
        m1.tableloadM();
        
    }

 //load books   
public class tableLoadB {
        public void tableloadB(){
            try{
                String sql="SELECT BookID,bookName,Description,type FROM books";
                
                pst = con.prepareStatement(sql);
                rs=pst.executeQuery();
                
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){}
    
        }
    
    }
//load cds
public class tableLoadC {
        public void tableloadC(){
            try{
                String sql="SELECT cdID,cdName,Description,type FROM cd";
                
                pst = con.prepareStatement(sql);
                rs=pst.executeQuery();
                
                jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){}
    
        }
    
    }
//load magazines
public class tableLoadM {
        public void tableloadM(){
            try{
                String sql="SELECT magID,magName,magDescription,type FROM magazines";
                
                pst = con.prepareStatement(sql);
                rs=pst.executeQuery();
                
                jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){}
    
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IDlabel = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        typeBox = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setForeground(new java.awt.Color(68, 108, 179));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Books", jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane1.addTab("Magazines", jScrollPane2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jTabbedPane1.addTab("CDs", jScrollPane3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 108, 428, 281));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Material ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 128, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 169, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Description");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 298, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Type");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 236, -1, -1));
        getContentPane().add(IDlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 128, 57, 14));

        Name.setBackground(new java.awt.Color(68, 108, 179));
        Name.setBorder(null);
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 189, 260, -1));

        typeBox.setBackground(new java.awt.Color(68, 108, 179));
        typeBox.setForeground(new java.awt.Color(255, 255, 255));
        typeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Book", "Magazine", "CD" }));
        getContentPane().add(typeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 256, 260, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 215, 260, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 153, 260, 10));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 282, 260, 10));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 395, 260, 10));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Binoculars_20px.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 67, -1, -1));

        searchbox.setBackground(new java.awt.Color(68, 108, 179));
        searchbox.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 64, 234, -1));

        jPanel1.setBackground(new java.awt.Color(68, 108, 179));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(68, 108, 179));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Available_Updates_25px.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(68, 108, 179));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Minus_20px.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(68, 108, 179));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Attach_25px_1.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Description.setBackground(new java.awt.Color(68, 108, 179));
        Description.setColumns(20);
        Description.setRows(2);
        jScrollPane5.setViewportView(Description);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setForeground(new java.awt.Color(68, 108, 179));
        jButton4.setText("Print Full Report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setForeground(new java.awt.Color(68, 108, 179));
        jButton5.setText("Save Full Report");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(322, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(194, 194, 194))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 830, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Add to tables
        String MaterialType=typeBox.getSelectedItem().toString();
        
        switch (MaterialType){
        
            case "Book":
            {
                String type = typeBox.getSelectedItem().toString();
                String bookName=Name.getText();
                String description=Description.getText();
                try{

                    String q="INSERT INTO books(type,bookName,Description) VALUES('"+type+"','"+bookName+"','"+description+"')";
                    pst = con.prepareStatement(q);
                    pst.execute();
                    tableLoadB L1= new tableLoadB();
                    L1.tableloadB();

                }
                catch(Exception e){System.out.println(e);}
                break;  
            
            }
            
            case "Magazine":
            {
                String type = typeBox.getSelectedItem().toString();
                String bookName=Name.getText();
                String description=Description.getText();
                try{

                    String q="INSERT INTO magazines(type,magName,magDescription) VALUES('"+type+"','"+bookName+"','"+description+"')";
                    pst = con.prepareStatement(q);
                    pst.execute();
                    tableLoadM L2= new tableLoadM();
                    L2.tableloadM();

                }
                catch(Exception e){System.out.println(e);}
                break;
            
            
            }
                
            case "CD":
            {
                String type = typeBox.getSelectedItem().toString();
                String bookName=Name.getText();
                String description=Description.getText();
                try{

                    String q="INSERT INTO CD(type,cdName,Description) VALUES('"+type+"','"+bookName+"','"+description+"')";
                    pst = con.prepareStatement(q);
                    pst.execute();
                    tableLoadC L3= new tableLoadC();
                    L3.tableloadC();

                }
                catch(Exception e){System.out.println(e);}
                break;
                
            
            
            }
                
                
        
        }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        // TO update books
        int x= JOptionPane.showConfirmDialog(null,"Do you want to update Material?");
                if(x==0){
            String type = typeBox.getSelectedItem().toString();
            System.out.print(type);

            if ("Book".equals(type)){
                String id=IDlabel.getText();
                String name=Name.getText();
                String description= Description.getText();

                String sql= "UPDATE books SET bookName='"+ name+"',Description='"+description+"' where BookID='"+id+"'";
                try{
                    pst = con.prepareStatement(sql);
                    pst.execute();

                    tableLoadB L1= new tableLoadB();
                    L1.tableloadB();
                    JOptionPane.showMessageDialog(this, "Item Updated!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                }

                catch(Exception e){}
            }
            
                else if ("Magazine".equals(type)){
                String id=IDlabel.getText();
                String name=Name.getText();
                String description= Description.getText();

                String sql= "UPDATE magazines SET magName='"+ name+"',magDescription='"+description+"' where magID='"+id+"'";
                try{
                    pst = con.prepareStatement(sql);
                    pst.execute();

                    tableLoadM L1= new tableLoadM();
                    L1.tableloadM();
                    JOptionPane.showMessageDialog(this, "Item Updated!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                }

                catch(Exception e){}
            }
            
                else if ("CD".equals(type)){
                String id=IDlabel.getText();
                String name=Name.getText();
                String description= Description.getText();

                String sql= "UPDATE cd SET cdName='"+ name+"',Description='"+description+"' where cdID='"+id+"'";
                try{
                    pst = con.prepareStatement(sql);
                    pst.execute();

                    tableLoadC L1= new tableLoadC();
                    L1.tableloadC();
                    JOptionPane.showMessageDialog(this, "Item Updated!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                }

                catch(Exception e){}
            }
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here://books mouse click
        int row = jTable1.getSelectedRow();
        String type = jTable1.getValueAt(row,3).toString();

        String id=jTable1.getValueAt(row, 0).toString();
        //    String type=jTable1.getValueAt(row, 3).toString();
        String name=jTable1.getValueAt(row, 1).toString();
        String description=jTable1.getValueAt(row, 2).toString();

        IDlabel.setText(id);
        Name.setText(name);
        Description.setText(description);
        typeBox.setSelectedItem(type);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here://magazines mouse click
        
        int row = jTable2.getSelectedRow();
        String type = jTable2.getValueAt(row,3).toString();

        String id=jTable2.getValueAt(row, 0).toString();
        //    String type=jTable1.getValueAt(row, 3).toString();
        String name=jTable2.getValueAt(row, 1).toString();
        String description=jTable2.getValueAt(row, 2).toString();

        IDlabel.setText(id);
        Name.setText(name);
        Description.setText(description);
        typeBox.setSelectedItem(type);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here://cd mouseclick
        
        int row = jTable3.getSelectedRow();
        String type = jTable3.getValueAt(row,3).toString();

        String id=jTable3.getValueAt(row, 0).toString();
        //    String type=jTable1.getValueAt(row, 3).toString();
        String name=jTable3.getValueAt(row, 1).toString();
        String description=jTable3.getValueAt(row, 2).toString();

        IDlabel.setText(id);
        Name.setText(name);
        Description.setText(description);
        typeBox.setSelectedItem(type);
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        String MaterialType=typeBox.getSelectedItem().toString();
        if ("Book".equals(MaterialType)){

            int x= JOptionPane.showConfirmDialog(null,"Do you want to delete Book?");

            if(x==0){
                String id= IDlabel.getText();

                String sql="DELETE FROM books WHERE BookID='"+id+"'";

                try{
                    pst = con.prepareStatement(sql);
                    pst.execute();

                    //     tableLoadB L1=new tableLoadB();
                    tableLoadB L1=new tableLoadB();

                    L1.tableloadB();
                    JOptionPane.showMessageDialog(this, "Item Deleted!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                }
                catch(Exception e){}
            }
        }
        
            else if ("Magazine".equals(MaterialType)){

            int x= JOptionPane.showConfirmDialog(null,"Do you want to delete Magazine?");

            if(x==0){
                String id= IDlabel.getText();

                String sql="DELETE FROM magazines WHERE magID='"+id+"'";

                try{
                    pst = con.prepareStatement(sql);
                    pst.execute();

                    //     tableLoadB L1=new tableLoadB();
                    tableLoadM L2=new tableLoadM();

                    L2.tableloadM();
                    JOptionPane.showMessageDialog(this, "Item Deleted!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                }
                catch(Exception e){}
            }
        }
        
            else if ("CD".equals(MaterialType)){

            int x= JOptionPane.showConfirmDialog(null,"Do you want to delete CD?");

            if(x==0){
                String id= IDlabel.getText();

                String sql="DELETE FROM cd WHERE cdID='"+id+"'";

                try{
                    pst = con.prepareStatement(sql);
                    pst.execute();

                    //     tableLoadB L1=new tableLoadB();
                    tableLoadC L3=new tableLoadC();

                    L3.tableloadC();
                    JOptionPane.showMessageDialog(this, "Item Deleted!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                }
                catch(Exception e){}
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // SEARCH BUTTON
        //in books
        String search =searchbox.getText();
        String sql = "SELECT * from books WHERE bookName LIKE '%"+search+"%'";
        try{
      
        pst = con.prepareStatement(sql);
        rs= pst.executeQuery(); //rs is result set
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        
        //in magazines
        
        String sql2 = "SELECT * from magazines WHERE magName LIKE '%"+search+"%'";
        
      
        pst = con.prepareStatement(sql2);
        rs= pst.executeQuery(); //rs is result set
        jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        
        //in CDs
        String sql3 = "SELECT * from cd WHERE cdName LIKE '%"+search+"%'";
        
      
        pst = con.prepareStatement(sql3);
        rs= pst.executeQuery(); //rs is result set
        jTable3.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        catch(Exception e){}
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        // TODO add your handling code here:
        
        MessageFormat header = new MessageFormat("Library Material Report");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        
        
        try{
            jTable1.print(JTable.PrintMode.NORMAL, header, footer);
            jTable2.print(JTable.PrintMode.NORMAL, header, footer);
            jTable3.print(JTable.PrintMode.NORMAL, header, footer);
        }
        catch(Exception e){
            System.err.format("Cannot print",e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
         String report="C:\\Users\\MAX\\Documents\\NetBeansProjects\\TA Consultancies\\src\\Reports\\LibMaterial.jrxml";
        try
        {
            JasperReport jr= JasperCompileManager.compileReport(report);
            JasperPrint jp= JasperFillManager.fillReport(jr,null, con);
            JasperViewer.viewReport(jp,false);

        }
        catch(Exception e)
        {
            System.out.println("Error:"+e);
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Description;
    private javax.swing.JLabel IDlabel;
    private javax.swing.JTextField Name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField searchbox;
    private javax.swing.JComboBox typeBox;
    // End of variables declaration//GEN-END:variables
}
