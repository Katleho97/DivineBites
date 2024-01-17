package za.co.teamsuccess.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.Checkout;
import za.co.teamsuccess.pojo.Person;
import za.co.teamsuccess.dao.CheckoutDAO;

public class CheckoutDAOImpl implements CheckoutDAO {

    private PreparedStatement ps;
    private Connection con;
    final private DBPoolManagerBasic dbManager;

    Checkout payment = new Checkout();
    Person person = new Person();

    public CheckoutDAOImpl(DBPoolManagerBasic dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public boolean paymentDetails(Checkout payment) {
        boolean retVal = false;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("insert into payment(paymentid,invoiceid,cardholder,creditcardno,cvc,paymentdate,amount) values(null,null,?,?,?,now(),null)");
            ps.setString(1, payment.getCardHolder());
            ps.setString(2, payment.getCreditCard());
            ps.setInt(3, payment.getCvc());

            retVal = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error processing the payment : " + ex.getMessage());
        }

        return retVal;
    }
    
}
