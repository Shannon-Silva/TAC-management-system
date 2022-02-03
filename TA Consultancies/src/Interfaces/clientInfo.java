/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ConnectDatabase.DatabaseConnection;
import java.sql.Connection;
//import com.mysql.jdbc.Connection;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
//import javax.mail.internet.AddressException;



/**
 *
 * @author Osuri Dunuwila
 */
public class clientInfo extends javax.swing.JInternalFrame {
    
    
    Connection con=null;
    
    PreparedStatement pst,pst2,pst3,pst4=null;
    ResultSet rst,rst2,rst3=null;
    
            String pidd=null;
    
            String fname=null;
            String lname=null;
            String Dfname=null;
            String Dlname=null;

    /**
     * Creates new form clientInfo
     */
    public clientInfo() {
        initComponents();
        con=DatabaseConnection.connect();
        
        comboPM();
        comboDs();
        tableload();
        
        getID();
        
    }

    
     private void showM(String s)
    {
        JOptionPane.showMessageDialog(null,s);
    }
    
    
     public void comboPM(){
    
        try {
            String pg="SELECT empid,firstname, lastname FROM emp WHERE designation='Page Manager'";
    
            pst=con.prepareStatement(pg);
            rst=pst.executeQuery();
            
            
            while (rst.next()){
                  fname=rst.getString("firstname");
                  lname=rst.getString("lastname");
                
                  aspgm.addItem(fname+" "+lname);
            
            
            }
        } catch (SQLException e) {
            
            System.out.println("Error:"+e);
        }
    
    
    }
    
    public void comboDs()
    {
        String ds="SELECT empid,firstname,lastname FROM emp WHERE designation='Designer'";
        
        try
        {
           pst=con.prepareStatement(ds);
            rst=pst.executeQuery();
            
            while (rst.next()){
            
                 Dfname=rst.getString("firstname");
                 Dlname=rst.getString("lastname");
           
                des.addItem(Dfname+" "+Dlname);
            
            
            }
        } catch (SQLException e) {
            
            System.out.println("Error:"+e);
        }
        
    }
   
    public void tableload(){
    
    
    String sq="SELECT * from client";
    try{
    
    pst=con.prepareStatement(sq);
    rst=pst.executeQuery();
    clientT.setModel(DbUtils.resultSetToTableModel(rst));
    
    }
    catch(SQLException e){
            System.out.println("Error:"+e);
    
    
    }
    

    }
    
    public void toForm(int r)
    {
        String cno=clientT.getValueAt(r, 0).toString();
        String cname=clientT.getValueAt(r, 1).toString();
        String busTyp=clientT.getValueAt(r, 2).toString();
        String cntPer=clientT.getValueAt(r, 3).toString();
        String mail=clientT.getValueAt(r, 4).toString();
        String addr=clientT.getValueAt(r, 5).toString();
        String numb=clientT.getValueAt(r, 6).toString();
        
        String pm=clientT.getValueAt(r, 7).toString();
        String ds=clientT.getValueAt(r, 8).toString();
        
        cid.setText(cno);
        name.setText(cname);
        type.setSelectedItem(busTyp);
        person.setText(cntPer);
        email.setText(mail);
        add.setText(addr);
        num.setText(numb);
        aspgm.setSelectedItem(pm);
        des.setSelectedItem(ds);
        
            
            
    }
 
    public static boolean validatePhone(String phoneNumber)
    {
        boolean isValid = false;
        String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        
        if(matcher.matches())
        {
            isValid = true;
        }
            return isValid;
    }
    
    public void getID()
    {
        String getid="SHOW TABLE STATUS WHERE `name`='client'"; //get table information
        
        try 
        {
            pst=con.prepareStatement(getid);
            rst=pst.executeQuery();
            
            rst.next();
            
            String id=rst.getString("Auto_increment");
            
            
            
            System.out.println("id:"+id);
            
            cid.setText(id);
                    
            
        } catch (Exception e) 
        {
            System.out.println("error getting id:"+e);
        }
        
    }
    
   public static boolean validatemail(String email)
    {
     boolean result = true;
    
        try   
            {
             InternetAddress mailaddress = new InternetAddress(email);
             mailaddress.validate();
            }
     catch (AddressException ex)
            {
                result = false;
            }
        return result;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cid = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        type = new javax.swing.JComboBox<>();
        person = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        add = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        co = new javax.swing.JLabel();
        num = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        aspgm = new javax.swing.JComboBox<>();
        des = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientT = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(68, 108, 179));
        setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel4.setBackground(new java.awt.Color(68, 108, 179));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel2.setBackground(new java.awt.Color(68, 108, 179));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 400));

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Client ID");

        jLabel2.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Client Name");

        jLabel3.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Business Type");

        jLabel4.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contact Person");

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email address");

        jLabel6.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address");

        cid.setEditable(false);
        cid.setBackground(new java.awt.Color(68, 108, 179));
        cid.setForeground(new java.awt.Color(51, 255, 255));
        cid.setBorder(null);

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Business Type", "Clothing", "Banking", "Finance", "Food & Beverage", "Entertainment", "Photography", "Airline", "Education Institute" }));

        person.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                personKeyTyped(evt);
            }
        });

        add.setColumns(20);
        add.setRows(5);
        jScrollPane2.setViewportView(add);

        co.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        co.setForeground(new java.awt.Color(255, 255, 255));
        co.setText("Contact number");

        num.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(co, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(email, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(person, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(type, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cid, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(num))
                .addGap(0, 41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cid))
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(person, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(co)
                    .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        jPanel1.setBackground(new java.awt.Color(68, 108, 179));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));

        jLabel7.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Page Manager");

        jLabel8.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Designer");

        aspgm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        des.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jLabel9.setFont(new java.awt.Font("Corbel", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Assign Team");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(des, 0, 115, Short.MAX_VALUE)
                            .addComponent(aspgm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(aspgm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(68, 108, 179));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 250));

        jPanel5.setBackground(new java.awt.Color(68, 108, 179));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        clientT.setModel(new javax.swing.table.DefaultTableModel(
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
        clientT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clientT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(68, 108, 179));
        jButton1.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(68, 108, 179));
        jButton2.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(68, 108, 179));
        jButton3.setFont(new java.awt.Font("Corbel", 1, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 667, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                    String CID=cid.getText();                    
            String client=name.getText();
            String btype=type.getSelectedItem().toString();
            String cont=person.getText();
            String Email=email.getText();
            String address=add.getText();
            String number=num.getText();
            String page=aspgm.getSelectedItem().toString();
            String desi1=des.getSelectedItem().toString();
            
            
            
            String pid=null;
            String did= null;
            String did1= null;
            
            //getting pm empId;
            String getPmID="SELECT empid from emp where firstname='"+fname+"' AND lastname='"+lname+"'";  
            
            //getting ds id
            String getDsID="SELECT empid from emp WHERE firstname='"+Dfname+"' AND lastname='"+Dlname+"'";
           
            try
            {
                
            pst2=con.prepareStatement(getPmID);
            pst3=con.prepareStatement(getDsID);
            
            rst2=pst2.executeQuery();
            rst3=pst3.executeQuery();
            
            rst2.next();
            rst3.next();
            
            pid=rst2.getObject("empid").toString();
            did=rst3.getObject("empid").toString();
            
                System.out.println(pid);
                System.out.println(did);
            
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            //String ids="insert into client() values()"s
            String que="insert into client(ClientName,BusinessType,Cont,email,Address,number,pg,ds1,desID,pgID) values ('"+client+"','"+btype+"','"+cont+"','"+Email+"','"+address+"','"+number+"','"+page+"','"+desi1+"','"+did+"','"+pid+"')";
            
            
        try {
            
            String phone=num.getText();
            String mail=email.getText();
            if(validatePhone(phone)){
                if(validatemail(mail))
                {
            
            pst=con.prepareStatement(que);
            pst.execute();
            
            showM("Succesfully added");
            tableload();
                }
            }
            else
            {
                showM("Enter Valid number");
            }
           
            
                }
        catch (SQLException ex) {
            //Logger.getLogger(viewClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error:" +ex);
        }
            
        
        
        
        
        
        
            
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                   String CID=cid.getText();  
            String client=name.getText();
            String btype=type.getSelectedItem().toString();
            String cont=person.getText();
            String Email=email.getText();
            String address=add.getText();
            String number=num.getText();
            String page=aspgm.getSelectedItem().toString();
            String desi1=des.getSelectedItem().toString();
            
//            fname=getString("firstname");
//            lname=getString("lastname");

               String[] namesPm=page.split(" ");
               String[] namesGd=desi1.split(" ");
            
            
            String pid=null;
            String did= null;
        
            //getting pm empId;
            String getPmID="SELECT empid from emp where firstname='"+namesPm[0]+"' AND lastname='"+namesPm[1]+"'";  
            
            //getting ds id
            String getDsID="SELECT empid from emp WHERE firstname='"+namesGd[0]+"' AND lastname='"+namesGd[1]+"'";
           
            try
            {
                
            pst2=con.prepareStatement(getPmID);
            pst3=con.prepareStatement(getDsID);
            
            rst2=pst2.executeQuery();
            rst3=pst3.executeQuery();
            
            rst2.next();
            rst3.next();
            
            pid=rst2.getObject("empid").toString();
            did=rst3.getObject("empid").toString();
            
                System.out.println(pid);
                System.out.println(did);
            
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
            
             String que="UPDATE client set ClientName='"+client+"',BusinessType='"+btype+"',Cont='"+cont+"',email='"+Email+"',Address='"+address+"',number='"+number+"',pg='"+page+"',ds1='"+desi1+"',desID='"+did+"',pgID='"+pid+"' WHERE clientID='"+CID+"' ";
            
            
            
        try {
            pst=con.prepareStatement(que);
            
           
            pst.execute();
            showM("Succesfully updated");
            
            tableload();
        } catch (SQLException ex) {
            //Logger.getLogger(viewClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error:" +ex);
        }



    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           
             int y=JOptionPane.showConfirmDialog(null, "Do you want to delete");
        if (y==0){
        
            functionsO f1=new functionsO();
           f1.deleteCli(Integer.parseInt(cid.getText()));
           
        tableload();
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void clientTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientTMouseClicked

         int row=clientT.getSelectedRow();
        
        toForm(row);
    }//GEN-LAST:event_clientTMouseClicked

    private void numKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numKeyTyped
        char c= evt.getKeyChar();
        if(!((c>='0') && (c<='9') ||
          (c== KeyEvent.VK_BACK_SPACE) ||
                (c==KeyEvent.VK_DELETE))){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_numKeyTyped

    private void personKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_personKeyTyped
         char c= evt.getKeyChar();
        if(((c>='0') && (c<='9') ||
          (c== KeyEvent.VK_BACK_SPACE) ||
                (c==KeyEvent.VK_DELETE))){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_personKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea add;
    private javax.swing.JComboBox<String> aspgm;
    private javax.swing.JTextField cid;
    private javax.swing.JTable clientT;
    private javax.swing.JLabel co;
    private javax.swing.JComboBox<String> des;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField num;
    private javax.swing.JTextField person;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
