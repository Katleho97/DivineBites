package za.co.teamsuccess.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.teamsuccess.dao.ContactUsFormDAO;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.ContactUs;

public class ContactUsFormDAOImpl implements ContactUsFormDAO{

    ContactUs contactUs;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    final private DBPoolManagerBasic dbManager;

    public ContactUsFormDAOImpl(DBPoolManagerBasic dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public boolean addContactUsForm(ContactUs contactUs) {
               boolean retVal = false;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("insert into contactusform(queryid,personname,email,subject,message,querytimestamp) values(null,?,?,?,?,now())");
           
            ps.setString(1, contactUs.getName());
            ps.setString(2, contactUs.getEmail());
            ps.setString(3, contactUs.getSubject());
            ps.setString(4, contactUs.getMessage());
            retVal = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error adding contact us form to database : " + ex.getMessage());
        }
        return retVal; 
    }
}
