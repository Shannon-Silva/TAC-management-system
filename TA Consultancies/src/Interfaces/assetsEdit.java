/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ConnectDatabase.DatabaseConnection;
//import database.functions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Aloka
 */
public class assetsEdit extends javax.swing.JInternalFrame {

    
     ResultSet rs=null;
        Connection con=null;
 
        String catgr, depart, vdr=null;
        private String sts = null,stDate = null;
        
    /**
     * Creates new form assetsEdit
     */
    public assetsEdit() {
        initComponents();
        
        con=DatabaseConnection.connect();
        
        
        fillCombo();
    }
    
    public void msgbox(String s)
     {
         JOptionPane.showMessageDialog(null, s);
     }

    private void findSearchKeys(String c, String d, String v)
    {
        functions f1=new functions();
        
        
        if(rb_ct.isSelected())
        {
            rs=f1.search(c, "c");
        }
        else if(rb_de.isSelected())
        {
            rs=f1.search(d ,"d");
        }
        else if(rb_vn.isSelected())
        {
            rs=f1.search(v,"v");
        }
        else
            f1.msgbox("Error: Please select a search key ");
        
     }
    
      //Fill vendor combobox
     public void fillCombo()
     {
         PreparedStatement pst=null;
         ResultSet rs=null;
         String getVend="SELECT name FROM vendor";
         
         try {
         
             pst=con.prepareStatement(getVend);
             rs=pst.executeQuery();
             
             while(rs.next())
             {
                 String name=rs.getString("name");
                 vendr.addItem(name);
                 S_vend.addItem(name);
             }
         
             
         } 
         catch (Exception e) {
             msgbox("Couldn't load the vendors to combobox");
         }
         
         
     }
     
     //from maintains
     public void fillmaintInfo(String ano)
     {
         String getV="SELECT vendName FROM assets WHERE assetNo='"+ano+"'";
         
         PreparedStatement pst=null;
         
         try{
             pst=con.prepareStatement(getV);
             rs=pst.executeQuery();
             
             rs.next();
             String ven=rs.getObject("vendName").toString();
             
             fillForm(ano,ven);
             
         }
         catch(Exception e)
         {
             msgbox("error in loading asset details"+ e);
             
         }
         
     }
    
    
    
     //Fill function
    private void fillForm(String no,String vname) 
    {
        String purchD = null;
        
        PreparedStatement pst1,pst2,pst3,pst4=null;
        ResultSet rs=null;
        
        
        String getAsset="SELECT assetNo,vendName,price,purchDate,descript,model,category,location,status, stDate  FROM assets  WHERE assetNo='"+no+"'";
        
        String getDepr="SELECT rate,amount,deprcLife,totalDeprc FROM depreciation WHERE assetNo='"+no+"'";
        
        String getMain="SELECT mperiod,mtimeUnit,lstMaint,wPeriod,wtimeUnit FROM maintain WHERE assetNo='"+no+"'";
        
        String getVend="SELECT vendorID,name,address,contactNo FROM vendor WHERE name='"+vname+"'";
        
        
        //to genaral
        try{
            pst1=con.prepareStatement(getAsset);
            rs=pst1.executeQuery();
            
            rs.next();
            
            //System.out.println(rs);
            
            asNo.setText(rs.getObject(1).toString());
            vendr.setSelectedItem(rs.getObject(2));
            pprice.setText(rs.getObject(3).toString());
            prc.setText(rs.getObject(3).toString());
           // dtAq.setDateFormatString(rs.getObject(4).toString());
            descr.setText(rs.getObject(5).toString());
            modl.setText(rs.getObject(6).toString());
            catg.setSelectedItem(rs.getObject(7));
            dept.setSelectedItem(rs.getObject(8));
            
            
            //Setting the date in date fields
        DateFormat df= new SimpleDateFormat("yyyy-MM-dd");//pattern must be the same as in table
        Date purDt,date;
               
        
            
            purDt=df.parse(rs.getObject(4).toString());
            
             dtAq.setDate(purDt);
            
             
            //for warrnty calculation
            purchD=rs.getObject(4).toString();
            //outd=df.parse(cout);

           
            //ch_out2.setDate(outd);
            
  
            
            if(rs.getObject(9).toString().equalsIgnoreCase("using"))
            {
                use.setSelected(true);
                
                reDt.setCalendar(null);
                disDt.setCalendar(null);
            }
            else if(rs.getObject(9).toString().equalsIgnoreCase("reinstalled"))
            {
                reIns.setSelected(true);
                date=df.parse(rs.getObject(10).toString());
                 reDt.setDate(date);
                
                 disDt.setCalendar(null);
                
            }
            else if(rs.getObject(9).toString().equalsIgnoreCase("disposed"))
            {
                dis.setSelected(true);
                date=df.parse(rs.getObject(10).toString());
                disDt.setDate(date);
                
                 reDt.setCalendar(null);
            }
           
        }
        catch(Exception e)
        {
            msgbox("Can't assign to form \n error: "+e);
        }
        
        
        //to maintains
        try{
            pst2=con.prepareStatement(getMain);
            
            rs=pst2.executeQuery();
            
            rs.next();
            
            mp.setSelectedItem(rs.getObject(1).toString());
             mt.setSelectedItem(rs.getObject(2).toString());
            wp.setSelectedItem(rs.getObject(4).toString());
            wt.setSelectedItem(rs.getObject(5).toString());
            
            lm.setText(rs.getObject(3).toString());
           
            
        }
        catch(Exception e)
        {
            msgbox("Can't assign the data to form! \n Error: "+e);
        }
    
         //calc warrnty left
            functions f2=new functions();
            
            int left=f2.leftWarrnty(Integer.parseInt(wp.getSelectedItem().toString()), wt.getSelectedItem().toString(),purchD);
        
            if(left==0)
            {
                warrLeft.setText("Warranty is expired");
            }
            else
                warrLeft.setText(left+" "+wt.getSelectedItem().toString()+" left of Warranty" );
        
        
        //to depreciation
        try{
            pst3=con.prepareStatement(getDepr);
            rs=pst3.executeQuery();
            
            rs.next();
            
            drate.setText(rs.getObject(1).toString());
            damnt.setText(rs.getObject(2).toString());
            dlife.setText(rs.getObject(3).toString());
            totDep.setText(rs.getObject(4).toString());
            
            //basis cal
            
            double basis;
            basis =Double.valueOf(pprice.getText())- Double.valueOf(totDep.getText());
            depBas.setText(Double.toString(basis));

            double rate= f2.calcDeprRate(Double.parseDouble(drate.getText()),purchD );
            dprTotR.setText(String.valueOf(rate));
            
            
        }
        catch(Exception e)
        {
            msgbox("Can't assign in depreciation fields! \n Error: "+e);        
        }
        
        //to vendor
        try {
            pst4=con.prepareStatement(getVend);
            
            rs=pst4.executeQuery();
            
            rs.next();
            
            vID.setText(rs.getObject(1).toString());
            vName.setText(rs.getObject(2).toString());
            vAddress.setText(rs.getObject(3).toString());
            vContact.setText(rs.getObject(4).toString());
            
      
        } 
        catch (Exception e) 
        {
            msgbox("Can't assign to vendor fields! \n error:"+e);
        }

    }
    
    
      public void getStatus(String stus, String stsDate)
    {
        //String stus= &st;
        
        if(use.isSelected())
        {
            sts="Using";
            stDate="0000/00/00";
            //System.out.println("this"+stsDate);
        }
        else if(reIns.isSelected())
        {
            sts="Reinstalled";
            stDate=((JTextField)reDt.getDateEditor().getUiComponent()).getText();
        }
        else if(dis.isSelected())
        {
            sts="Disposed";
            stDate=((JTextField)disDt.getDateEditor().getUiComponent()).getText();
        }
        else
            msgbox("Please select a Status");
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rb_ct = new javax.swing.JRadioButton();
        rb_de = new javax.swing.JRadioButton();
        rb_vn = new javax.swing.JRadioButton();
        S_dept = new javax.swing.JComboBox();
        S_cat = new javax.swing.JComboBox();
        S_vend = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        rslt_Tbl = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        num = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        warrLeft = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descr = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        catg = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        vendr = new javax.swing.JComboBox();
        prc = new javax.swing.JTextField();
        modl = new javax.swing.JTextField();
        dtAq = new com.toedter.calendar.JDateChooser();
        wp = new javax.swing.JComboBox();
        wt = new javax.swing.JComboBox();
        mp = new javax.swing.JComboBox();
        mt = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        asNo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        lm = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        mntButn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        dept = new javax.swing.JComboBox();
        use = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        reIns = new javax.swing.JRadioButton();
        dis = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        reDt = new com.toedter.calendar.JDateChooser();
        disDt = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        totDep = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        depBas = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        drate = new javax.swing.JTextField();
        damnt = new javax.swing.JTextField();
        dlife = new javax.swing.JTextField();
        pprice = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        dprTotR = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        vID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        vName = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        vAddress = new javax.swing.JTextArea();
        vContact = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(68, 108, 179));

        jPanel2.setBackground(new java.awt.Color(68, 108, 179));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rb_ct.setBackground(new java.awt.Color(68, 108, 179));
        buttonGroup2.add(rb_ct);
        rb_ct.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        rb_ct.setForeground(new java.awt.Color(255, 255, 255));
        rb_ct.setText("Category");

        rb_de.setBackground(new java.awt.Color(68, 108, 179));
        buttonGroup2.add(rb_de);
        rb_de.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        rb_de.setForeground(new java.awt.Color(255, 255, 255));
        rb_de.setText("Department");

        rb_vn.setBackground(new java.awt.Color(68, 108, 179));
        buttonGroup2.add(rb_vn);
        rb_vn.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        rb_vn.setForeground(new java.awt.Color(255, 255, 255));
        rb_vn.setText("Vendor");
        rb_vn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_vnActionPerformed(evt);
            }
        });

        S_dept.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Design", "Finance", "Management", "Personal" }));

        S_cat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Computer", "Printer", "Furniture" }));

        S_vend.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));

        rslt_Tbl.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rslt_Tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        rslt_Tbl.setSelectionBackground(new java.awt.Color(102, 102, 255));
        rslt_Tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rslt_TblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rslt_Tbl);

        jButton1.setBackground(new java.awt.Color(68, 108, 179));
        jButton1.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Search_25px_1.png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("No. of Results : ");

        num.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        num.setForeground(new java.awt.Color(255, 255, 255));
        num.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb_ct)
                            .addComponent(rb_de)
                            .addComponent(rb_vn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(S_vend, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(S_dept, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(S_cat, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(num))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rb_ct)
                            .addComponent(S_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rb_de)
                            .addComponent(S_dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(S_vend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rb_vn))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.setBackground(new java.awt.Color(68, 108, 179));

        jPanel4.setBackground(new java.awt.Color(68, 108, 179));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        jPanel5.setBackground(new java.awt.Color(68, 108, 179));

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Date aquire");

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Warranty Period");

        warrLeft.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        warrLeft.setForeground(new java.awt.Color(255, 255, 255));
        warrLeft.setText("this much left");

        descr.setBackground(new java.awt.Color(68, 108, 179));
        descr.setColumns(20);
        descr.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        descr.setForeground(new java.awt.Color(21, 255, 255));
        descr.setRows(5);
        descr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        descr.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jScrollPane2.setViewportView(descr);

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Maintain in Every");

        catg.setBackground(new java.awt.Color(68, 108, 179));
        catg.setForeground(new java.awt.Color(21, 255, 255));
        catg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Computer", "Printer", "Furniture" }));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Price");

        vendr.setBackground(new java.awt.Color(68, 108, 179));
        vendr.setForeground(new java.awt.Color(21, 255, 255));
        vendr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));

        prc.setBackground(new java.awt.Color(68, 108, 179));
        prc.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        prc.setForeground(new java.awt.Color(21, 255, 255));
        prc.setBorder(null);

        modl.setBackground(new java.awt.Color(68, 108, 179));
        modl.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        modl.setForeground(new java.awt.Color(21, 255, 255));
        modl.setBorder(null);

        dtAq.setBackground(new java.awt.Color(68, 108, 179));
        dtAq.setForeground(new java.awt.Color(21, 255, 255));
        dtAq.setDateFormatString("yyyy-MM-dd");
        dtAq.setMinSelectableDate(new java.util.Date(946666883000L));

        wp.setBackground(new java.awt.Color(68, 108, 179));
        wp.setForeground(new java.awt.Color(21, 255, 255));
        wp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        wt.setBackground(new java.awt.Color(68, 108, 179));
        wt.setForeground(new java.awt.Color(21, 255, 255));
        wt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Month(s)", "Year(s)" }));

        mp.setBackground(new java.awt.Color(68, 108, 179));
        mp.setForeground(new java.awt.Color(21, 255, 255));
        mp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        mp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpActionPerformed(evt);
            }
        });

        mt.setBackground(new java.awt.Color(68, 108, 179));
        mt.setForeground(new java.awt.Color(21, 255, 255));
        mt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Day(s)", "Month(s)", "Year(s)" }));

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Asset No");

        asNo.setBackground(new java.awt.Color(68, 108, 179));
        asNo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        asNo.setForeground(new java.awt.Color(21, 255, 255));
        asNo.setText("Asset No");

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Category");

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Vendor");

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Description");

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Model");

        lm.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        lm.setForeground(new java.awt.Color(255, 255, 255));
        lm.setText("Last maintained");

        label.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Last maintained");

        mntButn.setBackground(new java.awt.Color(255, 255, 255));
        mntButn.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        mntButn.setText("Maintained");
        mntButn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntButnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(label))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addComponent(modl)
                    .addComponent(catg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vendr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(prc)
                    .addComponent(jSeparator5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mntButn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(dtAq, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mp, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(warrLeft)
                            .addComponent(asNo)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(wp, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(mt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(wt, 0, 87, Short.MAX_VALUE))))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(asNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(catg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(vendr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modl))
                .addGap(2, 2, 2)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(dtAq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(prc, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(warrLeft)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(mp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lm)
                    .addComponent(label)
                    .addComponent(mntButn))
                .addGap(25, 25, 25))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel6.setBackground(new java.awt.Color(68, 108, 179));

        jLabel13.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Department");

        dept.setBackground(new java.awt.Color(68, 108, 179));
        dept.setForeground(new java.awt.Color(21, 255, 255));
        dept.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Design", "Finance", "Management", "Personal" }));

        use.setBackground(new java.awt.Color(68, 108, 179));
        buttonGroup1.add(use);
        use.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        use.setForeground(new java.awt.Color(255, 255, 255));
        use.setText("In Use");
        use.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(51, 51, 51));
        jLabel17.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Date");

        reIns.setBackground(new java.awt.Color(68, 108, 179));
        buttonGroup1.add(reIns);
        reIns.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        reIns.setForeground(new java.awt.Color(255, 255, 255));
        reIns.setText("Reinstalled");

        dis.setBackground(new java.awt.Color(68, 108, 179));
        buttonGroup1.add(dis);
        dis.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        dis.setForeground(new java.awt.Color(255, 255, 255));
        dis.setText("Disposed");

        jLabel18.setBackground(new java.awt.Color(51, 51, 51));
        jLabel18.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Date");

        reDt.setBackground(new java.awt.Color(68, 108, 179));
        reDt.setDateFormatString("yyyy/MM/dd");

        disDt.setBackground(new java.awt.Color(68, 108, 179));
        disDt.setDateFormatString("yyyy/MM/dd");

        jLabel6.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Locate in");

        jLabel19.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Status");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(dis)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(disDt, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(reIns)
                                    .addComponent(use))
                                .addGap(22, 22, 22)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(reDt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(dept, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jLabel6)
                    .addComponent(jLabel19))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(use)
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reIns)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel17)
                        .addComponent(reDt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dis)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel18)
                        .addComponent(disDt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        jTabbedPane1.addTab("Details", jPanel4);

        jPanel7.setBackground(new java.awt.Color(68, 108, 179));

        jLabel20.setBackground(new java.awt.Color(51, 51, 51));
        jLabel20.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Depreciasion Rate");

        totDep.setBackground(new java.awt.Color(68, 108, 179));
        totDep.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        totDep.setForeground(new java.awt.Color(51, 255, 255));
        totDep.setBorder(null);
        totDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totDepActionPerformed(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(51, 51, 51));
        jLabel21.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Depreciasion Amount");

        depBas.setBackground(new java.awt.Color(68, 108, 179));
        depBas.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        depBas.setForeground(new java.awt.Color(51, 255, 255));
        depBas.setBorder(null);
        depBas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depBasActionPerformed(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(51, 51, 51));
        jLabel22.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Depreciasion Life");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel23.setBackground(new java.awt.Color(51, 51, 51));
        jLabel23.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Purchase Price");

        jLabel24.setBackground(new java.awt.Color(51, 51, 51));
        jLabel24.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Total depreciation");

        jLabel25.setBackground(new java.awt.Color(51, 51, 51));
        jLabel25.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Depreciation Balance");

        drate.setBackground(new java.awt.Color(68, 108, 179));
        drate.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        drate.setForeground(new java.awt.Color(51, 255, 255));
        drate.setBorder(null);
        drate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drateActionPerformed(evt);
            }
        });

        damnt.setBackground(new java.awt.Color(68, 108, 179));
        damnt.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        damnt.setForeground(new java.awt.Color(51, 255, 255));
        damnt.setBorder(null);

        dlife.setBackground(new java.awt.Color(68, 108, 179));
        dlife.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        dlife.setForeground(new java.awt.Color(51, 255, 255));
        dlife.setBorder(null);

        pprice.setBackground(new java.awt.Color(68, 108, 179));
        pprice.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        pprice.setForeground(new java.awt.Color(51, 255, 255));
        pprice.setBorder(null);
        pprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppriceActionPerformed(evt);
            }
        });

        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 5));

        jLabel27.setBackground(new java.awt.Color(51, 51, 51));
        jLabel27.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Depreciasion Precentage");

        dprTotR.setBackground(new java.awt.Color(68, 108, 179));
        dprTotR.setForeground(new java.awt.Color(51, 255, 255));
        dprTotR.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("%");

        jLabel14.setFont(new java.awt.Font("Corbel", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("%");

        jLabel28.setFont(new java.awt.Font("Corbel", 0, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Rs.");

        jLabel29.setFont(new java.awt.Font("Corbel", 0, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Rs.");

        jLabel30.setFont(new java.awt.Font("Corbel", 0, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Rs.");

        jLabel31.setFont(new java.awt.Font("Corbel", 0, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Rs.");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel20))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel21))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel22))
                    .addComponent(jLabel27))
                .addGap(5, 5, 5)
                .addComponent(jLabel28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dlife, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dprTotR, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(drate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(damnt, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel23))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel24))
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(pprice, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(totDep, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(depBas, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel20)
                .addGap(22, 22, 22)
                .addComponent(jLabel21)
                .addGap(21, 21, 21)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1)
                .addGap(99, 99, 99)
                .addComponent(jLabel14))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel23)
                .addGap(25, 25, 25)
                .addComponent(jLabel24)
                .addGap(24, 24, 24)
                .addComponent(jLabel25))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel29)
                .addGap(22, 22, 22)
                .addComponent(jLabel30)
                .addGap(23, 23, 23)
                .addComponent(jLabel31))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(pprice, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totDep, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(depBas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(damnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(drate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(dlife, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(dprTotR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Depreciation", jPanel7);

        jPanel3.setBackground(new java.awt.Color(68, 108, 179));

        vID.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        vID.setForeground(new java.awt.Color(51, 255, 255));
        vID.setText("Vendor ID");

        jLabel2.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Address");

        jLabel3.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vendor Name");

        jLabel16.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Contact No");

        jLabel26.setFont(new java.awt.Font("Corbel", 0, 15)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Vendor ID");

        vName.setBackground(new java.awt.Color(68, 108, 179));
        vName.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        vName.setForeground(new java.awt.Color(51, 255, 255));
        vName.setText("jTextField1");
        vName.setBorder(null);
        vName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vNameActionPerformed(evt);
            }
        });

        vAddress.setBackground(new java.awt.Color(68, 108, 179));
        vAddress.setColumns(20);
        vAddress.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        vAddress.setForeground(new java.awt.Color(51, 255, 255));
        vAddress.setRows(5);
        vAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane4.setViewportView(vAddress);

        vContact.setBackground(new java.awt.Color(68, 108, 179));
        vContact.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        vContact.setForeground(new java.awt.Color(51, 255, 255));
        vContact.setText("jTextField2");
        vContact.setBorder(null);
        vContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vContactActionPerformed(evt);
            }
        });
        vContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vContactKeyTyped(evt);
            }
        });

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel26))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel3)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vID)
                            .addComponent(vName, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vContact, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(vID)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(vName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel3))
                                    .addComponent(vContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vendor", jPanel3);

        jScrollPane3.setViewportView(jTabbedPane1);

        update.setBackground(new java.awt.Color(68, 108, 179));
        update.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Restart_20px_1.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(68, 108, 179));
        delete.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Multiply_20px.png"))); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 764, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rb_vnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_vnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_vnActionPerformed

    private void rslt_TblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rslt_TblMouseClicked

        int row=rslt_Tbl.getSelectedRow();

        String aId=rslt_Tbl.getValueAt(row, 0).toString();
        String vname=rslt_Tbl.getValueAt(row, 3).toString();
        String prDt=rslt_Tbl.getValueAt(row, 4).toString();

        fillForm(aId,vname);
        
        functions f1=new functions();
        
       double rate= f1.calcDeprRate(Double.parseDouble(drate.getText()),prDt );

       dprTotR.setText(String.valueOf(rate));
       
    }//GEN-LAST:event_rslt_TblMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

         catgr=S_cat.getSelectedItem().toString();
         depart=S_dept.getSelectedItem().toString();
         vdr=S_vend.getSelectedItem().toString();

        findSearchKeys(catgr, depart, vdr);

        rslt_Tbl.setModel(DbUtils.resultSetToTableModel(rs));
        
        int x=rslt_Tbl.getRowCount();
        num.setText(String.valueOf(x));

    }//GEN-LAST:event_jButton1ActionPerformed

    private void mpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mpActionPerformed

    private void useActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useActionPerformed

    private void totDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totDepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totDepActionPerformed

    private void depBasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depBasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depBasActionPerformed

    private void drateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drateActionPerformed

    private void ppriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ppriceActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        functions f1=new functions();
        
        String id=asNo.getText();
        
        int opt=JOptionPane.showConfirmDialog(null,"Do you want to delete this record?");
        
        if(opt==0)
        {
            f1.delete(id);
            
            findSearchKeys(catgr, depart, vdr);

           rslt_Tbl.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
       
        
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        functions upd=new functions();
        String Dt = ((JTextField)dtAq.getDateEditor().getUiComponent()).getText();
        
        
        
        getStatus(sts,stDate);
        
        System.out.println(sts+","+stDate);
        
        
        if(upd.update(asNo.getText(),catg.getSelectedItem().toString(),vName.getText(),descr.getText(),modl.getText(),Dt,wp.getSelectedItem().toString(),wt.getSelectedItem().toString(),prc.getText(),mp.getSelectedItem().toString(),mt.getSelectedItem().toString(),dept.getSelectedItem().toString(),drate.getText(),damnt.getText(),sts,stDate));
        {   
            findSearchKeys(catgr, depart, vdr);

           rslt_Tbl.setModel(DbUtils.resultSetToTableModel(rs));

           fillForm(asNo.getText(),vName.getText());
        }
    }//GEN-LAST:event_updateActionPerformed

    private void vNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vNameActionPerformed

    private void vContactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vContactKeyTyped
        // TODO add your handling code here:
        
         char enter=evt.getKeyChar();
        
        if(!(Character.isDigit(enter)))
        {
            evt.consume();
        }
        
        
    }//GEN-LAST:event_vContactKeyTyped

    private void vContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vContactActionPerformed

    private void mntButnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntButnActionPerformed
        
        String id=asNo.getText();
        functions f1= new functions();
            
        if(f1.updMaint(id))
        {
            f1.msgbox("Maintenance Updated");
            
            fillForm(id,vendr.getSelectedItem().toString());
            
            assetsMain am=new assetsMain();
            
            am.listMaints();
            
            am.setVisible(true);
            
            
            
        }
        
        
        
    }//GEN-LAST:event_mntButnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox S_cat;
    private javax.swing.JComboBox S_dept;
    private javax.swing.JComboBox S_vend;
    private javax.swing.JLabel asNo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox catg;
    private javax.swing.JTextField damnt;
    private javax.swing.JButton delete;
    private javax.swing.JTextField depBas;
    private javax.swing.JComboBox dept;
    private javax.swing.JTextArea descr;
    private javax.swing.JRadioButton dis;
    private com.toedter.calendar.JDateChooser disDt;
    private javax.swing.JTextField dlife;
    private javax.swing.JTextField dprTotR;
    private javax.swing.JTextField drate;
    private com.toedter.calendar.JDateChooser dtAq;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel lm;
    private javax.swing.JButton mntButn;
    private javax.swing.JTextField modl;
    private javax.swing.JComboBox mp;
    private javax.swing.JComboBox mt;
    private javax.swing.JLabel num;
    private javax.swing.JTextField pprice;
    private javax.swing.JTextField prc;
    private javax.swing.JRadioButton rb_ct;
    private javax.swing.JRadioButton rb_de;
    private javax.swing.JRadioButton rb_vn;
    private com.toedter.calendar.JDateChooser reDt;
    private javax.swing.JRadioButton reIns;
    private javax.swing.JTable rslt_Tbl;
    private javax.swing.JTextField totDep;
    private javax.swing.JButton update;
    private javax.swing.JRadioButton use;
    private javax.swing.JTextArea vAddress;
    private javax.swing.JTextField vContact;
    private javax.swing.JLabel vID;
    private javax.swing.JTextField vName;
    private javax.swing.JComboBox vendr;
    private javax.swing.JLabel warrLeft;
    private javax.swing.JComboBox wp;
    private javax.swing.JComboBox wt;
    // End of variables declaration//GEN-END:variables
}
