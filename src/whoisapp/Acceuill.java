/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whoisapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Acceuill extends javax.swing.JFrame {

    /**
     * Creates new form Acceuill
     */
    public Acceuill() throws SQLException, ParseException, ClassNotFoundException {
          parcour();
        initComponents();
       }
    public static void parcour() throws SQLException, ParseException{
     try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Acceuill.class.getName()).log(Level.SEVERE, null, ex);
         }
         Connection con = null;
         try {
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ndd?autoReconnect=true&useSSL=false","root","");
         } catch (SQLException ex) {
             Logger.getLogger(Acceuill.class.getName()).log(Level.SEVERE, null, ex);
         }
  
    String req="select * from allndd";
      Statement st = null;
         try {
             st = con.createStatement();
         } catch (SQLException ex) {
             Logger.getLogger(Acceuill.class.getName()).log(Level.SEVERE, null, ex);
         }
    ResultSet rs=st.executeQuery(req);
    while(rs.next()){
    String s1=rs.getString("Domain_Name"),s2=rs.getString("Creation_Date"),s3=rs.getString("Expiry_Date"),s4=rs.getString("Domain_Status");
                    String s5=rs.getString("Admin_Name"),s6=rs.getString("Admin_Phone"),s7=rs.getString("Admin_Email");
                    NDD ndd=new NDD(s1,s2,s3,s4,s5,s6,s7);
                    //String datexp=rs.getString("Expiry_Date");
                    if(Status(rs.getString("Expiry_Date"))){
                        Sendemail mailSender1 = new Sendemail("afaf.ben.kech@gmail.com","iii","dalal");
                        JOptionPane jop1 = new JOptionPane();
                        jop1.showMessageDialog(null, "Le Nom de Domaine"+rs.getString("Domain_Name")+" va bientot expiré ", "Notification",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
   
    }
    
    }
    
    
   
         public static boolean Status(String dateExpiry) throws ParseException{
       
       
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date DateToday = new Date();
        Date DateExpiry=dateFormat.parse(dateExpiry);
       
        if (DateToday.equals(DateExpiry)){ return true;} //SEND MAIL 
      
       else if(DateToday.after(DateExpiry)){

                                    // convert date to calendar type 
                                    Calendar c = Calendar.getInstance();
                                    c.setTime(DateExpiry);

                                    // manipulate date
                                    c.add(Calendar.YEAR, 0);
                                    c.add(Calendar.MONTH, 0);
                                    c.add(Calendar.DATE, 30); //les jours 
                                    c.add(Calendar.HOUR, 0);
                                    c.add(Calendar.MINUTE, 0);
                                    c.add(Calendar.SECOND, 0);

                                    // convert calendar to date
                                    Date DateTodayAfter30j = c.getTime();
        
        
                        if(DateExpiry.after(DateTodayAfter30j))  return true;
                         
       }
        return true;
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
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 400));
        setPreferredSize(new java.awt.Dimension(550, 400));

        jPanel1.setMinimumSize(new java.awt.Dimension(550, 400));
        jPanel1.setLayout(null);

        jButton2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton2.setText("Quitter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(190, 280, 180, 30);

        jButton1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton1.setText("Consultation");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(190, 190, 180, 30);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WhoisApp");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(110, 50, 340, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\S 2\\s 3\\JAVA\\whois\\acceuil.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 550, 420);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Consu consul=new Consu();
        consul.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Acceuill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acceuill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acceuill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acceuill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Acceuill().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Acceuill.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Acceuill.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Acceuill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
