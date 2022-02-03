/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ConnectDatabase.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Manula Ranzika
 */
public class Libraryuser extends javax.swing.JInternalFrame {
    
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs= null;

    /**
     * Creates new form Libraryuser
     */
    public Libraryuser() {
        initComponents();
        con=DatabaseConnection.connect();
        
        tableLoadM L1=new tableLoadM();
        L1.tableloadM();
        
        tableLoadB L2=new tableLoadB();
        L2.tableloadB();
        
        tableLoadCD L3 = new tableLoadCD();
        L3.tableloadCD();
        
        reserve r1 = new reserve();
       r1.tableloadR();
        
        
    }

    
    public class tableLoadCD {
        public void tableloadCD(){
            try{
                String sql="SELECT cdID,cdName,Description,Type FROM cd";
                
                pst = con.prepareStatement(sql);
                rs=pst.executeQuery();
                
                jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){}
    
    }
    
    }
    
        public class tableLoadM {
        
        public void tableloadM() {
             try{
            String sql="SELECT magID,magName,magDescription,type FROM magazines";
            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){}
          
        }


    }
        
        public class reserve {
        
        public void tableloadR() {
             try{
            String sql="SELECT * FROM reservedmat";
            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){}
          
        }
        
    }
        
      public class tableLoadB {
        
        public void tableloadB() {
             try{
            String sql="SELECT BookID,bookName,Description,Type FROM books";
            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        searchbox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        empidBox = new javax.swing.JTextField();
        IDlabel = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        Typelabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(800, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(68, 108, 179));

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
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jTabbedPane1.addTab("CDs", jScrollPane3);

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Books", jScrollPane1);

        jTable2.setBackground(new java.awt.Color(68, 108, 179));
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane1.addTab("Magazines", jScrollPane2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 450, 340));

        searchbox.setBackground(new java.awt.Color(68, 108, 179));
        getContentPane().add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 210, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Boarding_Pass_20px.png"))); // NOI18N
        jButton1.setText("Reserve Material");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 452, 450, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Binoculars_20px.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Material ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Type");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));
        getContentPane().add(empidBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 210, -1));
        getContentPane().add(IDlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 210, 20));
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 210, 20));
        getContentPane().add(Typelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 210, 20));

        jPanel1.setBackground(new java.awt.Color(68, 108, 179));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable4);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, 450, 110));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Reserved Items");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, -1, -1));

        jButton2.setText("View Reserved");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 140, 30));

        jButton3.setText("Clear Fields");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 140, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 450, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 810, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        //SEARCH
        
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
        
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked

        // TODO add your handling code here:
        int row = jTable3.getSelectedRow();
        

        String id=jTable3.getValueAt(row, 0).toString();
        String type=jTable3.getValueAt(row, 3).toString();
        String name=jTable3.getValueAt(row, 1).toString();
     //   String description=jTable3.getValueAt(row, 2).toString();

        IDlabel.setText(id);
        Name.setText(name);
   //     Description.setText(description);
        Typelabel.setText(type);
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        //book
        
        int row = jTable1.getSelectedRow();
        

        String id=jTable1.getValueAt(row, 0).toString();
        String type=jTable1.getValueAt(row, 3).toString();
        String name=jTable1.getValueAt(row, 1).toString();
     //   String description=jTable3.getValueAt(row, 2).toString();

        IDlabel.setText(id);
        Name.setText(name);
   //     Description.setText(description);
        Typelabel.setText(type);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        // TODO add your handling code here:
        //magazine
        int row = jTable2.getSelectedRow();
        

        String id=jTable2.getValueAt(row, 0).toString();
        String type=jTable2.getValueAt(row, 3).toString();
        String name=jTable2.getValueAt(row, 1).toString();
     //   String description=jTable3.getValueAt(row, 2).toString();

        IDlabel.setText(id);
        Name.setText(name);
   //     Description.setText(description);
        Typelabel.setText(type);
        
        
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        try {
            
            
            // TODO add your handling code here:
            //reserve material button
            
            String emp = empidBox.getText();
            if(!"".equals(emp)){
            String materialID = IDlabel.getText();
            String type = Typelabel.getText();
            String name =Name.getText();
            
            String sql3 = "INSERT INTO reservedmat(empID, MaterialID,type,materialname) VALUES ('"+emp+"','"+materialID+"','"+type+"','"+name+"')" ;
            
          
            pst = con.prepareStatement(sql3);
            pst.execute(); //rs is result set
            reserve r1 = new reserve();
            r1.tableloadR();
           // jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            JOptionPane.showMessageDialog(this, "Reserved Successfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            
        }
            else{
                JOptionPane.showMessageDialog(this, "Enter Employee ID to reserve", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Libraryuser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            
            String emp = empidBox.getText();          
            String sql9 = "SELECT * from reservedmat WHERE empID='"+emp+"'" ;
            
            
            pst = con.prepareStatement(sql9);
            rs=pst.executeQuery(); //rs is result set
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
     //       JOptionPane.showMessageDialog(this, "Reserved Successfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Libraryuser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Typelabel.setText("");
        Name.setText("");
        empidBox.setText("");
        IDlabel.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDlabel;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Typelabel;
    private javax.swing.JTextField empidBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField searchbox;
    // End of variables declaration//GEN-END:variables
}
