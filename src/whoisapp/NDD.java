/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whoisapp;

/**
 *
 * @author khadija ait al kadi
 */
public class NDD {
           private String Domain_Name;
            private String Creation_Date;
            private String Expiry_Date;
            private String Domain_Status;
            private String Admin_Name;
            private String Admin_Phone;
            private String Admin_Email;
            
              public NDD(String Domain_Name, String Creation_Date, String Expiry_Date, String Domain_Status,String Admin_Name, String Admin_Phone,String Admin_Email)
   {
     this.Domain_Name=Domain_Name;
    this.Creation_Date=Creation_Date;
    this.Expiry_Date=Expiry_Date;
    this. Domain_Status= Domain_Status;
    this.Admin_Name=Admin_Name;
    this.Admin_Phone=Admin_Phone;
    this.Admin_Email=Admin_Email;
    
   }
public NDD(){
    
}

    NDD(String string, String string0, String string1, String string2, String string3, String string4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*
    NDD(String dalal, String ait, String al, String kadi, String afaf, String banidal, String gi, String deux) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  */
//=============getting ===============
    public String getDomain_Name(){
        return Domain_Name;
    }
    public String getCreation_Date(){
        return Creation_Date;
    }
    public String getExpiry_Date(){
        return Expiry_Date;
    }
    public String getDomain_Status(){
        return Domain_Status;
    }
    public String getAdmin_Name(){
        return Admin_Name;
    }
    public String getAdmin_Phone(){
        return Admin_Phone;
    }
    public String getAdmin_Email(){
        return Admin_Email;
    }

}
