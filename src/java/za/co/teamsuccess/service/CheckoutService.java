package za.co.teamsuccess.service;

import java.util.ArrayList;
import za.co.teamsuccess.pojo.CartItem;
import za.co.teamsuccess.pojo.Checkout;
import za.co.teamsuccess.pojo.PaymentCard;
import za.co.teamsuccess.pojo.Person;

public interface CheckoutService {
    boolean checkout(PaymentCard paymentCard, Person user, ArrayList<CartItem> cart);
    boolean checkout(Checkout checkout);
}
