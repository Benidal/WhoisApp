/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whoisapp;

import com.aspose.ocr.ImageStream;
import com.aspose.ocr.OcrEngine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khadija ait al kadi
 */
 
public class ResultatConsultation extends javax.swing.JFrame {

    /**
     * Creates new form ResultatConsultation
     */
    public ResultatConsultation() {
        initComponents();
    }
     public ResultatConsultation(String nom) {
        initComponents();
         String[] DataDomaine = new String[8];
        DataDomaine=info(nom);
        
       tf1.setText(DataDomaine[0]);
        tf2.setText(DataDomaine[1]);
          tf3.setText(DataDomaine[2]);
       // tf4.setText(DataDomaine[3]);
        tf4.setText(DataDomaine[3]);
        tf5.setText(DataDomaine[4]);
          tf6.setText(DataDomaine[5]);
        tf7.setText(DataDomaine[6]);
         
    }
     
     
    public  static String OCRCV(String url){
        
        OcrEngine ocr= new OcrEngine ();


            ocr . setImage ( ImageStream.fromUrl(url));
            String str= null;
// Traiter l'image
if (ocr . process ()) {
    
    str = ocr.getText ().toString() ;
    return str;
    
    }
return str;
    }
public  static String getMail ( String str){
       
       
       String[] tab1 = str.split(">");
      
      // String a = " \"";
       String[] tab2 = tab1[0].split("\"");
       
       
       String urlemail = "http://www.whois.com"+tab2[1]; // +tab1[1]
      //System.out.println(urlemail );
       String  email= OCRCV(urlemail)+tab1[1] ;
       
     return email;
      //http://www.whois.com/eimg/1/36/136d5a941331f35afdaf488b6609d040cd035183.png
       
       
       
        
        
    }
     
     
public static String[] info(String s){
    URL u1 = null;
        try {
            u1 = new URL("http://whois.com/whois/"+s+".ma");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Consu.class.getName()).log(Level.SEVERE, null, ex);
        }
		  URLConnection u2 = null;
        try {
            u2 = u1.openConnection();
        } catch (IOException ex) {
            Logger.getLogger(Consu.class.getName()).log(Level.SEVERE, null, ex);
        }
		  String line=null;
        String[] DataDomaine = {"","","","","","",""};
        BufferedReader buf = null;
        try {
            buf = new BufferedReader(new InputStreamReader(u2.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Consu.class.getName()).log(Level.SEVERE, null, ex);
        }
		 
        try {
            while(((line=buf.readLine()) != null )) {
                          if (line.contains("Domain Name:"))
				  DataDomaine[0]=line. split(":")[2];
			  
			  if (line.contains("Creation Date: "))
				  DataDomaine[1]=line.substring(line.indexOf(":") + 1,line.lastIndexOf("T"))+" "+line.substring(line.lastIndexOf("T")+1,line.lastIndexOf("."));
			  if (line.contains("Registry Expiry Date: "))
				  DataDomaine[2]=line.substring(line.indexOf(":") + 1,line.lastIndexOf("T"))+" "+line.substring(line.lastIndexOf("T")+1,line.lastIndexOf("."));
			 
			  if (line.contains("Domain Status:"))
				  DataDomaine[3]=line.split(":")[1];
			  if (line.contains("Admin Name:"))
				  DataDomaine[4]=line.split(":")[1];
			  if (line.contains("Admin Phone:"))
				  DataDomaine[5]=line.split(":")[1];
			 if (line.contains("Admin Email:")){
                       DataDomaine[6]=getMail(line.split(":")[1]);}
			
            }   } catch (IOException ex) {
            Logger.getLogger(Consu.class.getName()).log(Level.SEVERE, null, ex);
        }
  return DataDomaine;
    
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
        tf7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jButton2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton2.setText("Quitter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(550, 490, 110, 27);

        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setText("Precedant");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(120, 490, 120, 27);

        tf7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jPanel1.add(tf7);
        tf7.setBounds(270, 430, 410, 30);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Admin Email :");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(50, 430, 150, 23);

        tf6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        tf6.setText("\n");
        jPanel1.add(tf6);
        tf6.setBounds(270, 370, 410, 30);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Admin Phone :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(50, 370, 160, 23);

        tf5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        tf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf5ActionPerformed(evt);
            }
        });
        jPanel1.add(tf5);
        tf5.setBounds(270, 310, 410, 30);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Admin Name :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 320, 150, 20);

        tf4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        tf4.setText("\n");
        tf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf4ActionPerformed(evt);
            }
        });
        jPanel1.add(tf4);
        tf4.setBounds(270, 260, 410, 30);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Domain Status :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 260, 170, 23);

        tf3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        tf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf3ActionPerformed(evt);
            }
        });
        jPanel1.add(tf3);
        tf3.setBounds(270, 200, 410, 30);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Expiry Date :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 200, 160, 30);

        tf2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        tf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf2ActionPerformed(evt);
            }
        });
        jPanel1.add(tf2);
        tf2.setBounds(270, 140, 410, 30);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Creation Date :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 140, 160, 23);

        tf1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        jPanel1.add(tf1);
        tf1.setBounds(270, 90, 410, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Domain Name :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 90, 170, 20);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Info sur le Nom de Domaine");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(200, 34, 420, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\S 2\\s 3\\JAVA\\whois\\acceuil.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 830, 540);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf3ActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed

    private void tf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf2ActionPerformed

    private void tf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf4ActionPerformed

    private void tf5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
   dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Consu consul=new Consu();
        consul.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ResultatConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultatConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultatConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultatConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultatConsultation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    private javax.swing.JTextField tf6;
    private javax.swing.JTextField tf7;
    // End of variables declaration//GEN-END:variables
}
