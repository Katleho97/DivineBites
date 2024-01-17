package za.co.teamsuccess.dao;

import za.co.teamsuccess.pojo.Checkout;

public interface CheckoutDAO {

    boolean paymentDetails(Checkout payment);
}
