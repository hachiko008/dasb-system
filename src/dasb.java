import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dasb extends javax.swing.JFrame {
    String fetch = "select id from driver where driver_status_id = 1 order by name limit 1";
    public dasb() {
        initComponents();
        CurrentTimeStamp();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(0);
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            com.mysql.jdbc.Connection con= (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/booking","root","");
            Statement stmt=con.createStatement();
            
            //count available drivers
            String cunt = "select count(id) from driver where driver_status_id = 1";
            ResultSet rs = stmt.executeQuery(cunt);
            while(rs.next()){
            cunt = rs.getString(1);
            lblcount.setText(cunt);
        }
            //load passengers list
            String load="select A.name,A.time,A.quantity,A.origin,A.destination, "
            + "B.name,C.description from passenger A "
            + "inner join driver B on A.driver_id = B.id "
            + "inner join driver_status C on C.id = B.driver_status_id";
            ResultSet rs2 = stmt.executeQuery(load);
        while (rs2.next())
        {  
            String name = rs2.getString("name");
            String time = rs2.getString("time");
            String quantity = rs2.getString("quantity");
            String location = rs2.getString("origin");
            String destination = rs2.getString("destination");
            String drvname = rs2.getString("B.name");
            String drvstat = rs2.getString("C.description");

            model.addRow(new Object []{
            name,time,quantity,location,destination,drvname,drvstat});
        }
        //Generate driver id then passing for update
        ResultSet rs3 = stmt.executeQuery(fetch);
        while (rs3.next()){
         fetch = rs3.getString(1);
         System.out.println("Driver id: "+fetch);
        }
        //load cities from combobox
           String town = "select description from town order by description";
           ResultSet rs4 = stmt.executeQuery(town);
           while(rs4.next()){
               String desc = rs4.getString("description");
               txt4.addItem(desc);
               txt5.addItem(desc);
           }
    }
        catch(Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblTIme = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txt1 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        btn1 = new java.awt.Button();
        jLabel6 = new javax.swing.JLabel();
        txt4 = new javax.swing.JComboBox<>();
        txt5 = new javax.swing.JComboBox<>();
        lblcount = new javax.swing.JLabel();
        btn2 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DASBS | Booking");
        setName("frame"); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Name:");

        lblTIme.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTIme.setText("Time:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Quantity:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Origin:");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Destination:");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Time", "Qty", "Origin", "Destination", "Driver's Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(1).setPreferredWidth(40);
            table.getColumnModel().getColumn(2).setMinWidth(40);
            table.getColumnModel().getColumn(2).setPreferredWidth(40);
            table.getColumnModel().getColumn(2).setMaxWidth(40);
            table.getColumnModel().getColumn(3).setPreferredWidth(50);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(4).setPreferredWidth(50);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(6).setResizable(false);
            table.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1ActionPerformed(evt);
            }
        });

        txt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt2ActionPerformed(evt);
            }
        });

        btn1.setLabel("Save");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Available Driver(s):");

        txt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt4ActionPerformed(evt);
            }
        });

        txt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt5ActionPerformed(evt);
            }
        });

        btn2.setLabel("Back");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt5, javax.swing.GroupLayout.Alignment.LEADING, 0, 175, Short.MAX_VALUE)
                                    .addComponent(txt2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt4, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt1)))
                            .addComponent(lblTIme)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(lblcount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTIme)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblcount, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt2ActionPerformed

    }//GEN-LAST:event_txt2ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        try{
            if (txt1.getText().isEmpty() || txt2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill up all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if(txt4.getSelectedItem().toString().equals(txt5.getSelectedItem().toString())){
                JOptionPane.showMessageDialog(null, "Invalid desired Destination", "Error", JOptionPane.ERROR_MESSAGE);
            }
                else{
                int a = JOptionPane.showConfirmDialog(null, "Book this record?", "Message",  JOptionPane.YES_NO_OPTION);
                if(a==0){
                    Class.forName("com.mysql.jdbc.Driver");
                    com.mysql.jdbc.Connection con= (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/booking","root","");
                    Statement stmt=con.createStatement();

                    String name = txt1.getText();
                    Date date = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");  
                    String time = format.format(date);
                    System.out.println("time is: "+time);
                    int quantity = Integer.parseInt(txt2.getText());
                    String origin = txt4.getSelectedItem().toString();
                    String destination = txt5.getSelectedItem().toString();
                    
                    //fetch generated driver id then update
                    String update="UPDATE driver SET driver_status_id = 4 WHERE id = "+(fetch)+"";
                    System.out.println("Updating: "+update);
                    PreparedStatement prep = con.prepareStatement(update);
                    prep.executeUpdate(update);
                    
                    //book passengers
                    String sql="insert into passenger (name,time,quantity,origin,destination,driver_id) values ('"+(name)+"','"+(time)+"',"+(quantity)+",'"+(origin)+"','"+(destination)+"',"+(fetch)+")";
                    System.out.println("Executing: "+sql);
                    stmt.executeUpdate(sql);
                    
                    //book logs (hindi pa considered as book logs kase hindi pa filtered ung booking na tapos na)
                    SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");  
                    String date2 = format2.format(date);
                    String pid = "select id from passenger order by id desc limit 1";
                    System.out.println("Ref Date: "+date2);
                    ResultSet rs4 = stmt.executeQuery(pid);
                    while (rs4.next()){
                     pid = rs4.getString(1);
                     System.out.println("Passenger id: "+pid);
                    }
                    String history="insert into travel_history (driver_id,driver_name,passenger_id,passenger_name,time_in,ref_date) "
                        + "values("+(fetch)+",(select name from driver where id = "+(fetch)+"),'"+(pid)+"','"+(name)+"','"+(time)+"','"+(date2)+"')";
                    System.out.println("Executing: "+history);
                    stmt.executeUpdate(history);
                    JOptionPane.showMessageDialog(null, "Saved!","SAVE",JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new dasb().setVisible(true);
                    }
            }   
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void txt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1ActionPerformed

    private void txt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt4ActionPerformed

    }//GEN-LAST:event_txt4ActionPerformed

    private void txt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt5ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        Main main = new Main();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btn2ActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dasb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dasb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dasb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dasb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dasb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btn1;
    private java.awt.Button btn2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTIme;
    private javax.swing.JLabel lblcount;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JComboBox<String> txt4;
    private javax.swing.JComboBox<String> txt5;
    // End of variables declaration//GEN-END:variables
    public void CurrentTimeStamp() {
        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    java.util.Date time = new java.util.Date();
                    String TTimeDateFormat = "hh:mm:ss a";
                    SimpleDateFormat TTime = new SimpleDateFormat(TTimeDateFormat);
                    lblTIme.setText("Time:            " + TTime.format(time)); 
                }
            }
        };
        clock.start();
    }
    
}
