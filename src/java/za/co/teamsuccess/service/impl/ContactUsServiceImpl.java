
package za.co.teamsuccess.service.impl;

import za.co.teamsuccess.dao.ContactUsFormDAO;
import za.co.teamsuccess.dao.impl.ContactUsFormDAOImpl;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.ContactUs;
import za.co.teamsuccess.service.ContactUsService;

public class ContactUsServiceImpl implements ContactUsService{
    private ContactUsFormDAO contactUsFormDAO;
    boolean reVal = false;
    private final DBPoolManagerBasic dbpm;
    public ContactUsServiceImpl(DBPoolManagerBasic dbpm){
    this.dbpm = dbpm;
    }   

    @Override
    public boolean contactUs(ContactUs contactUs) {
         contactUsFormDAO = new ContactUsFormDAOImpl(dbpm);
        reVal = contactUsFormDAO.addContactUsForm(contactUs);
      return reVal; 
    }
}
