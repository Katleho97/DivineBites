package za.co.teamsuccess.service.impl;

import java.util.ArrayList;
import za.co.teamsuccess.dao.CheckoutDAO;
import za.co.teamsuccess.dao.OrderDAO;
import za.co.teamsuccess.dao.impl.CheckoutDAOImpl;
import za.co.teamsuccess.dao.impl.OrderDAOImpl;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.CartItem;
import za.co.teamsuccess.pojo.Checkout;
import za.co.teamsuccess.pojo.Order;
import za.co.teamsuccess.pojo.PaymentCard;
import za.co.teamsuccess.pojo.Person;
import za.co.teamsuccess.service.CheckoutService;

public class CheckoutServiceImpl implements CheckoutService {

    private CheckoutDAO checkoutDAO;
    private OrderDAO orderDAO;

    public CheckoutServiceImpl(DBPoolManagerBasic dbpm) {
        orderDAO = new OrderDAOImpl(dbpm);
        checkoutDAO = new CheckoutDAOImpl(dbpm);
    }

    @Override
    public boolean checkout(Checkout checkout) {
        return checkoutDAO.paymentDetails(checkout);
    }

    @Override
    public boolean checkout(PaymentCard paymentCard, Person user, ArrayList<CartItem> cart) {
        boolean retVal = false;
        if (!isCardValid(paymentCard.getCardNumber())) {
            //throw exception or return false;
        }
        
         // make payment - if successful continue, else try again/exit?
        
        int orderNumber = orderDAO.getLastOrderId();
        orderNumber += 1;
        orderDAO.updateLastOrderId(orderNumber);
        //public Order(int addresid, int personid, String orderdate) {

        boolean res = orderDAO.insertOrder(new Order(orderNumber, user.getAddressId(), user.getPersonId(), null));
        createOrderLineItems(orderNumber, cart);

        //create invoice
        //email
        
        return res;
    }

    private boolean isCardValid(String cardNumber) {
        //todo: LUHN card check
        return true;
    }

    private void createOrderLineItems(int orderId, ArrayList<CartItem> cart) {
        cart.forEach(item -> {
            orderDAO.updateOrderLineItem(orderId, item.getProduct().getProductid(), item.getQuantity());
        });
    }
}
