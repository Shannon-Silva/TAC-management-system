package Interfaces;


import ConnectDatabase.DatabaseConnection;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHMALI.UTTHARA
 */
public class nQuotation extends javax.swing.JInternalFrame  {
    //String label;
    public String w;
    String word;
    int total;
    Connection con = null;
    PreparedStatement pst =null;
    ResultSet  rs =null;
    ResultSet  rs1 =null;
    ResultSet rs2=null;
  
    public static String id;
    public static String cname;
    public static String designer;
    public static String clientID;
    public static String contactp;
    public static String contactp1;
    public static String pg;
    public static String pgID;
    public static String add11;
    public static String number;
    public static Date date1;
    public static String contact;
    public static String dcost;
    //public static String did1;
    /**
     * Creates new form nQuotation
     */
    public  nQuotation() {
        
        //this.total=t1.getsum();
        initComponents();
        con = DatabaseConnection.connect();
        getid();
        
    }
    public  nQuotation(Date date) {
        
        //this.total=t1.getsum();
        initComponents();
        con = DatabaseConnection.connect();
        date1=date;
        getid();
        
        
    }
      public  void getid() {
        
        //this.total=t1.getsum();
        initComponents();
        con = DatabaseConnection.connect();
        jDateChooser1.setDate(date1);
        String sql="select LBID from joblb";
        try{
            pst = con.prepareStatement(sql);
            rs =pst.executeQuery(sql);
            while(rs.next())
            {
                String jid=rs.getString("LBID");
                jComboBox1.addItem(jid);
            }
        }
        catch(Exception e)
        {
            
        }
        
    }
    public String[] remindMaint()
     {
         PreparedStatement pst=null;
         ResultSet rs3=null;
         
         long diff=0;
         //int mpd=0;
         String asno=null;
         
         int units,day=0;
         
         String[] result=new String[50];
         int i=0;
         
         String maintDet="SELECT did,dispatchDate from delivery";
         
         
         
         try
         {
            pst=con.prepareStatement(maintDet);
            rs3=pst.executeQuery();
            
           
            
            while(rs3.next())
            {
                 asno=rs3.getObject("did").toString();
                //mpd=Integer.parseInt(rs3.getObject("mperiod").toString());
                //String mtu=rs3.getObject("mtimeUnit").toString();
                String lmd=rs3.getObject("dispatchDate").toString();
                
                
                
                DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
                
                Date lstMnt=df.parse(lmd);
                Date today =new Date();
                
                Calendar d1=getCalendar(today);
                Calendar d2=getCalendar(lstMnt);
                
                
                    //diff=d2.get(Calendar.DAY_OF_MONTH)-d1.get(Calendar.DAY_OF_MONTH);
                    diff=today.getTime()-lstMnt.getTime();
                    
                     units = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                     
                     day=d1.get(Calendar.MONTH)-d2.get(Calendar.MONTH);
                    
                    //System.out.println(units);
                
//                else if(mtu.equalsIgnoreCase("Month(s)"))
//                {
//                    units=d1.get(Calendar.MONTH)-d2.get(Calendar.MONTH);
//                    
//                    //diff=today.getTime()-lstMnt.getTime();
//                    
//                    //units = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
//                    
//                    day=d1.get(Calendar.DAY_OF_MONTH)-d2.get(Calendar.DAY_OF_MONTH);
////                    System.out.println("d="+day);
////                    
////                    System.out.println(units);
//                    
//                }
//                else if(mtu.equalsIgnoreCase("Year(s)"))
//                {
//                    units=d1.get(1)-d2.get(1);
//                    day=d1.get(Calendar.DAY_OF_YEAR)-d2.get(Calendar.DAY_OF_YEAR);
//                    
//                    if(day<0)
//                        day++;
//                    
//                    System.out.println(units+","+day);
//                }
               
                
                //System.out.println("i="+i);
                
                if(units==0 )
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
             
         }
         if(i==0)
            return null;
         else
             return result;
        
     }
  
    /*public  nQuotation(String s) {
        this.w=s;
        this.total=t1.getsum();
        initComponents();
        con = DBconnect.connect();
        jTextArea1.setText(w);
        
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel2 = new javax.swing.JPanel();
        c2l = new javax.swing.JLabel();
        area = new javax.swing.JComboBox<>();
        addl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tot1 = new javax.swing.JTextField();
        d2l = new javax.swing.JLabel();
        c2 = new javax.swing.JTextField();
        did = new javax.swing.JTextField();
        totl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        add = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        c1l = new javax.swing.JLabel();
        delCost = new javax.swing.JTextField();
        d1l = new javax.swing.JLabel();
        c1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(68, 108, 179));
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setForeground(java.awt.Color.black);
        setResizable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(795, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel2.setBackground(new java.awt.Color(68, 108, 179));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        c2l.setForeground(new java.awt.Color(255, 255, 255));
        c2l.setText("Contact Number");
        jPanel2.add(c2l, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 110, 20));

        area.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose area", "Colombo", "Galle", "Kandy", "Matara" }));
        area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaActionPerformed(evt);
            }
        });
        jPanel2.add(area, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 422, 141, 33));

        addl.setBackground(new java.awt.Color(68, 108, 179));
        addl.setForeground(new java.awt.Color(255, 255, 255));
        addl.setText("Address");
        jPanel2.add(addl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DID");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 39, -1));

        tot1.setBackground(new java.awt.Color(68, 108, 179));
        jPanel2.add(tot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 141, 32));

        d2l.setForeground(new java.awt.Color(255, 255, 255));
        d2l.setText("Dispatch Date");
        jPanel2.add(d2l, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        c2.setBackground(new java.awt.Color(68, 108, 179));
        c2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c2KeyTyped(evt);
            }
        });
        jPanel2.add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 150, 140, 34));

        did.setBackground(new java.awt.Color(68, 108, 179));
        did.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                didActionPerformed(evt);
            }
        });
        jPanel2.add(did, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 120, 29));

        totl.setForeground(new java.awt.Color(255, 255, 255));
        totl.setText("Delivery Charges");
        jPanel2.add(totl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 473, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 39, -1));

        add.setBackground(new java.awt.Color(68, 108, 179));
        add.setColumns(20);
        add.setRows(5);
        jScrollPane1.setViewportView(add);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 180, 170));

        jButton6.setText("Get Amount");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 141, 33));

        c1l.setForeground(new java.awt.Color(255, 255, 255));
        c1l.setText("Contact Person");
        jPanel2.add(c1l, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        delCost.setBackground(new java.awt.Color(68, 108, 179));
        jPanel2.add(delCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 493, 149, 32));

        d1l.setForeground(new java.awt.Color(255, 255, 255));
        d1l.setText("Date");
        jPanel2.add(d1l, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        c1.setBackground(new java.awt.Color(68, 108, 179));
        c1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c1KeyTyped(evt);
            }
        });
        jPanel2.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 80, 140, 31));

        jDateChooser1.setDateFormatString("yyyy/MM/dd");
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 363, 141, 30));

        jDateChooser2.setDateFormatString("yyyy/MM/dd");
        jPanel2.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 141, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane5)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 31, 380, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quotation");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 61, -1));

        jButton2.setText("Get Contact Person details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 280, 250, 40));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Client Name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 140, 33));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Job ID" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 283, 100, 32));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Buy_22px.png"))); // NOI18N
        jButton1.setText("Add/ Remove Item Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 549, 190, 40));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Invoice_22px.png"))); // NOI18N
        jButton7.setText("Quotation");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 150, 40));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Save_22px.png"))); // NOI18N
        jButton4.setText("Save Quotation ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 549, 140, 40));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Exit_22px_1.png"))); // NOI18N
        jButton8.setText("Exit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 550, 140, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_20px.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 20, 30));

        jButton5.setText("Email Quotation");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 550, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String word1 = did.getText();
        String did1=did.getText();
        String add1=add.getText();
        String cn1=c1.getText();
        String cp1=c2.getText();
        String d3=delCost.getText();
        int val=7;
        //String tot=tot1.getText();
        if(!"".equals(did1) && !"".equals(add1) && !"".equals(cn1) && !"".equals(cp1) && !"".equals(d3))
        {
            String sq1="select DeliveryID from delivery";
            try{
                 pst = con.prepareStatement(sq1);
                 rs =pst.executeQuery(sq1);
                 while(rs.next())
                {
                    String a=rs.getString("DeliveryID");
                    if(word1.equals(a))
                    {
                        val=0;
                        break;
                    }
                    else
                    {
                        val=1;
                        continue;
                    }
                }
                if(val==0)
                {
                    JOptionPane.showMessageDialog(this,"Delivery exists under the same id","",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    item1 t1=new item1(word1);
                        t1.setVisible(true);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Some fields are missing","",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            
        String did1=did.getText();
        String add1=add.getText();
        String cn1=c1.getText();
        String cp1=c2.getText();
        String subt=delCost.getText();
        String tot=tot1.getText();
        
        String disdate=((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText();

        if(!"".equals(did1) && !"".equals(add1) && !"".equals(cn1) && !"".equals(cp1) && !"".equals(tot))
        {
              
            Date d1=new Date();
            DateFormat df=new SimpleDateFormat("yyyy/MM/dd");
            String temp=df.format(d1);
            try {
                Date d2=df.parse(temp);
                Date d3=df.parse(disdate);
            if(d2.after(d3))
            {
                JOptionPane.showMessageDialog(this,"Invalid Dispatch date!","",JOptionPane.ERROR_MESSAGE);

            }
            if(cp1.length()!=10)
            {
               JOptionPane.showMessageDialog(this,"Phone number should only have 10 digits","",JOptionPane.ERROR_MESSAGE);
               
            }
         
            else
            {
                        jTextArea1.append("TAC CONSULTIES\t Quotation\nNo.23/d\t\t Date\t"+ ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText()+"\n"+"Park lane,\t\t Quotation No.\t"+did1+" \n"+"Prak road,\t\t Client ID\t "+cname+"\n"+"Wellawatta\t\t Valids until\t"+ ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText()+"\n"+"Contact Number : 0112435676\n\nQuotation for:\nMr./Mrs./Miss "+contactp+"\n"+cname+"\n"+add11+"\n"+number+"\nComments or Special instructions :");
                        jTextArea2.append("Delivery Charges :"+subt+"(Rs)\n"+"Total amount to be paid :"+tot+"(Rs)\n"+"Email : LBcompany@yahoo.com   Fax : 0213659856\n\n\tTHANKYOU FOR YOUR BUSINESS!");

                        String sql = "select Job_ID,Description,Qty,Unit_price,SubTotal from myitem where DeliveryID='"+did.getText()+"'";
                        try
                        {
                                pst = con.prepareStatement(sql);
                                rs2=pst.executeQuery(sql);
           
                                jTable1.setModel(DbUtils.resultSetToTableModel(rs2));
                    
                        }
                        catch (SQLException e)
                        {
                                System.out.println(e);
                        }
                }
            }
            catch (ParseException ex) 
            {
                Logger.getLogger(nQuotation.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Some fields are missing","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaActionPerformed
        //String a=area.getSelectedItem().toString();
        double colombo=100;
        double galle=200;
        double kandy=600;
        double matara=400;
        
        if(area.getSelectedItem().equals("Colombo"))
        {
            String d1= String.format("%.2f",colombo);
            delCost.setText(d1);
        }
        if(area.getSelectedItem().equals("Galle"))
        {
            String d1= String.format("%.2f",galle);
            delCost.setText(d1);
        }
        if(area.getSelectedItem().equals("Kandy"))
        {
            String d1= String.format("%.2f",kandy);
            delCost.setText(d1);
        }
        if(area.getSelectedItem().equals("Matara"))
        {
            String d1= String.format("%.2f",matara);
            delCost.setText(d1);
        }
        if(area.getSelectedItem().equals("Choose an area"))
        {
            
            delCost.setText(null);
        }
        
    }//GEN-LAST:event_areaActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
                
    }//GEN-LAST:event_jButton8ActionPerformed

    private void didActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_didActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_didActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        dcost=delCost.getText();
        String d=did.getText();
        if(!"".equals(dcost))
        {
            if(!"".equals(d))
            {
                
            double t2= Double.parseDouble(delCost.getText());
        
            String sql = "select sum(SubTotal) from myitem where DeliveryID='"+d+"' group by '"+d+"' ";
            try{
                pst = con.prepareStatement(sql);
                rs1=pst.executeQuery(sql);
//                if(!rs.isBeforeFirst())
//                {
//                    JOptionPane.showMessageDialog(this,"You haven't entered any Job entries","",JOptionPane.ERROR_MESSAGE);
//
//                }
                while(rs1.next())
                {
                    double t1=rs1.getDouble("sum(SubTotal)");
                    double t3=t1+t2;
                    String s=String.format("%.2f",t3);
                    tot1.setText(s);
                
                
                }
                    
            }
        
            catch (Exception e){
                        System.out.println(e);
            }
            }
        }
        else
        {
            
            JOptionPane.showMessageDialog(this,"Please choose an area","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void c1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
          if (((c >= '0') && (c <= '9') ||
             (c == KeyEvent.VK_BACK_SPACE) ||
             (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
          }

    }//GEN-LAST:event_c1KeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

        
        

        String did1=did.getText();
        String add1=add.getText();
        String t=tot1.getText();
        String ddate=((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        String disdate=((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText();
        String sql = "Insert into delivery(DeliveryID,dispatchDate,delDate,address,status) values ('"+did1+"','"+disdate+"','"+ddate+"','"+add1+"','Pending')";
        //System.out.println(disdate);
        try{
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this,"Delivery details was successfully added to DB","",JOptionPane.INFORMATION_MESSAGE);

       }
       
        catch (SQLException | HeadlessException e){
                System.out.println(e);
        }
        double d11=Double.parseDouble(delCost.getText());
        System.out.println(d11);
        String sql4 = "Insert into payment(DeliveryID,amount) values ('"+did1+"','"+t+"')";
        //System.out.println(disdate);
        try{
            pst = con.prepareStatement(sql4);
            pst.execute();
            JOptionPane.showMessageDialog(this,"Payment details was successfully added to DB","",JOptionPane.INFORMATION_MESSAGE);
            
       }
       
        catch (SQLException | HeadlessException e){
                System.out.println(e);
        }
          String sqlq = "Insert into quotaiondel(DeliveryID,JobID,Client,Total,delcharge) values ('"+did1+"','"+jComboBox1.getSelectedItem().toString()+"','"+cname+"','"+t+"','"+d11+"')";
        //System.out.println(disdate);
        try{
            pst = con.prepareStatement(sqlq);
            pst.execute();
            JOptionPane.showMessageDialog(this,"Quotation details was successfully added to DB","",JOptionPane.INFORMATION_MESSAGE);

       }
       
        catch (SQLException | HeadlessException e){
                System.out.println(e);
        }
Document d1=new Document();
        try
        {
            PdfWriter wr=PdfWriter.getInstance(d1, new FileOutputStream("C:\\Users\\MAX\\Desktop\\Delivery"+did1+".pdf"));
            d1.open();
            d1.add(new Paragraph("TAC CONSULTIES                                                                        Quotation\nNo.23/d                                                                                      Date -"+ ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText()+"\n"+"Park lane,                                                                                  Quotation No. -\t"+did1+" \n"+"Prak road,                                                                                  Client ID -\t "+cname+"\n"+"Wellawatta                                                                                 Valids until -\t"+ ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText()+"\n"+"Contact Number : 0112435676\n\nQuotation for:\nMr./Mrs./Miss "+contactp+"\n"+cname+"\n"+add11+"\n"+number+"\nComments or Special instructions :"));
            PdfPTable pt=new PdfPTable(5);
            
            pt.setWidthPercentage(105);
            pt.setSpacingAfter(7f);
            pt.setSpacingBefore(7f);
            float[] colWidth={2f,2f,2f,2f,2f};
            pt.setWidths(colWidth);
            PdfPCell cl1=new PdfPCell(new Paragraph("Job ID"));
            PdfPCell cl2=new PdfPCell(new Paragraph("Description"));
            PdfPCell cl3=new PdfPCell(new Paragraph("Quantity"));
            PdfPCell cl4=new PdfPCell(new Paragraph("Unit Price"));
            PdfPCell cl5=new PdfPCell(new Paragraph("Total"));
            pt.addCell(cl1);
            pt.addCell(cl2);
            pt.addCell(cl3);
            pt.addCell(cl4);
            pt.addCell(cl5);
            String sq = "select Job_ID,Description,Qty,Unit_price,SubTotal from myitem where DeliveryID='"+did.getText()+"'";
                        try
                        {
                                pst = con.prepareStatement(sq);
                                rs=pst.executeQuery(sq);
           
                                while(rs.next())
                                {
                                    String jid=rs.getString("Job_ID");
                                    String d=rs.getString("Description");
                                    String qty=rs.getString("Qty");
                                    String u=rs.getString("Unit_price");
                                    String jst=rs.getString("SubTotal");
                                    PdfPCell l1=new PdfPCell(new Paragraph(jid));
                                    PdfPCell l2=new PdfPCell(new Paragraph(d));
                                    PdfPCell l3=new PdfPCell(new Paragraph(qty));
                                    PdfPCell l4=new PdfPCell(new Paragraph(u));
                                    PdfPCell l5=new PdfPCell(new Paragraph(jst));
                                     pt.addCell(l1);
            pt.addCell(l2);
            pt.addCell(l3);
            pt.addCell(l4);
            pt.addCell(l5);
                                    
                                    
                                }
                    
                        }
                        catch (SQLException e)
                        {
                                System.out.println(e);
                        }
            pt.addCell(cl4);
            pt.addCell(cl5);
            d1.add(pt);
            d1.add(new Paragraph("Delivery Charges :"+delCost.getText()+"(Rs)\n"+"Total amount to be paid :"+tot1.getText()+"(Rs)\n"+"Email : LBcompany@yahoo.com   Fax : 0213659856\n\n        THANKYOU FOR YOUR BUSINESS!"));
            JOptionPane.showMessageDialog(this,"Quotation was saved successfully to your desktop","",JOptionPane.INFORMATION_MESSAGE);
            d1.close();
            wr.close();
            
            
        }
        
        catch(FileNotFoundException | DocumentException e)
        {
            System.out.println(e);
        }
                   
       

    }//GEN-LAST:event_jButton4ActionPerformed

    private void c2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c2KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
          if (!((c >= '0') && (c <= '9') ||
             (c == KeyEvent.VK_BACK_SPACE) ||
             (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
          }
    }//GEN-LAST:event_c2KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String jid=jComboBox1.getSelectedItem().toString();
        System.out.println(jid);
        String sql1="Select client,design from joblb where LBID='"+jid+"'";
        try{
            pst = con.prepareStatement(sql1);
            rs =pst.executeQuery(sql1);
            while(rs.next())
            {
                cname=rs.getString("client");
                designer=rs.getString("design");
            
                String sql2="select clientID,Cont,pg,Address,number from client where ClientName='"+cname+"' ";
            try{
                        pst = con.prepareStatement(sql2);
                        rs1=pst.executeQuery(sql2);
                     while(rs1.next())
                     {   
                        clientID=rs1.getString("clientID");
                        contactp=rs1.getString("Cont");
                        //contactp="0"+contactp1;
                        pg=rs1.getString("pg");
                        //pgID=rs1.getString("pgID");
                        add11=rs1.getString("Address");
                        contact=rs1.getString("number");
                        number="0"+contact;
                        add.setText(add11);
                        c1.setText(contactp);
                        c2.setText(number);
                        jTextField1.setText(cname);
                     }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            }
        }
        catch(Exception e)
        {
            System.out.println("error sql1");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        //close button
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       chamaemail cr=new chamaemail();
       cr.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea add;
    private javax.swing.JLabel addl;
    private javax.swing.JComboBox<String> area;
    private javax.swing.JTextField c1;
    private javax.swing.JLabel c1l;
    private javax.swing.JTextField c2;
    private javax.swing.JLabel c2l;
    private javax.swing.JLabel d1l;
    private javax.swing.JLabel d2l;
    private javax.swing.JTextField delCost;
    private javax.swing.JTextField did;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField tot1;
    private javax.swing.JLabel totl;
    // End of variables declaration//GEN-END:variables

    private Calendar getCalendar(Date date) {
        Calendar cal=Calendar.getInstance(Locale.US); 
        cal.setTime(date);
        return cal;//To change body of generated methods, choose Tools | Templates.
    }
}
