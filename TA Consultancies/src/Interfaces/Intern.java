/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ConnectDatabase.DatabaseConnection;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Manula Ranzika
 */
public class Intern extends javax.swing.JInternalFrame {
    
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs= null;
 
    public static String namep;
    /**
     * Creates new form Intern
     */
    public Intern() {
        initComponents();
        con=DatabaseConnection.connect();
      //  namep=namebox.getText();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        namebox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nicbox = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(800, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/intern.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 620));

        jPanel1.setBackground(new java.awt.Color(68, 108, 179));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name");

        namebox.setBackground(new java.awt.Color(68, 108, 179));
        namebox.setBorder(null);
        namebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameboxActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NIC Number");

        nicbox.setBackground(new java.awt.Color(68, 108, 179));
        nicbox.setBorder(null);

        jButton2.setBackground(new java.awt.Color(68, 108, 179));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Copy_to_Clipboard_25px_1.png"))); // NOI18N
        jButton2.setText("Get Daily Task");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nicbox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(namebox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nicbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(247, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 520, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
        String name = namebox.getText();
        String nic= nicbox.getText();
                if(!"".equals(name) && !"".equals(nic)){
                    
                
                String sql2 = "SELECT * from interviewee WHERE nic='"+nic+"'";
                
              
                pst = con.prepareStatement(sql2);
                rs= pst.executeQuery(sql2); //rs is result set
                while(rs.next())
                {
                    String fname=rs.getString("name");
                    String status = rs.getString("status");
                    System.out.println(fname);
                    System.out.println(status);
                    if("intern".equals(status)){
                    
                   
                        System.out.println(status);
                        this.setVisible(false);
                        InternDailyTask i2 = new InternDailyTask(fname);

                        getParent().add(i2);
                        i2.setVisible(true);
 
                        
                     
                    }
                    
                    else{
                        
                        JOptionPane.showMessageDialog(this, "Not an Intern!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    
                    
                    }
                    
                 }
                    
                }
                else{
                    JOptionPane.showMessageDialog(this, "Insert Intern name and NIC", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
                catch(Exception e){}
        

       // d2.setVisible(true);
        
        //try 2
       // JInternalFrame newFrame = JInternalFrame();
        //d2.setBounds(10, 10, 100, 100);
        //d2.setVisible(true);
 
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameboxActionPerformed

    class CustomMouseOverJLabel extends JLabel{
    public CustomMouseOverJLabel(String text) {
        super(text);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(Color.BLUE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(Color.RED);
            }               
        });
    }       
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField namebox;
    private javax.swing.JTextField nicbox;
    // End of variables declaration//GEN-END:variables
}
