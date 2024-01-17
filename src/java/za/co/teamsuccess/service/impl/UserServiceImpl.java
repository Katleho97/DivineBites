package za.co.teamsuccess.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import za.co.teamsuccess.dao.UserDAO;
import za.co.teamsuccess.dao.impl.UserDAOImpl;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.Person;
import za.co.teamsuccess.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(DBPoolManagerBasic dbManager) {
        this.userDAO = new UserDAOImpl(dbManager);
    }
    // *********************************************************************************  

    @Override
    public boolean isValid(Person person) {
        boolean retVal = false;
        if (person.getEmail().isEmpty()) {
            return retVal;
        }
        String regex = "^(.+)@(.+)$";
        Matcher match = Pattern.compile(regex).matcher(person.getEmail());
        if (match.matches()) {
            return userDAO.validatePerson(person);
        }
        return retVal;
    }

    // *********************************************************************************  
    @Override
    public boolean registerPerson(Person person) {

        boolean retval = false;

        if (isValid(person)) {
            return false;
        }

        if (person.getEmail().isEmpty() || person.getFirstName().isEmpty() || person.getLastName().isEmpty() || person.getPassword().isEmpty()) {
            return retval;
        }
        String regex = "^(.+)@(.+)$";
        Matcher match = Pattern.compile(regex).matcher(person.getEmail());
//        RegisterCheck checkreg;
//        checkreg = new RegisterCheck();

        //       if (match.matches() && checkreg.containnum(person.getFirstName(), person.getLastName())) {
        retval = userDAO.registerPerson(person);

//        }
        return retval;
    }

    @Override
    public void populatePerson(Person person) {
        //userDAO.populatePerson( person);   //or Person populatePerson(Person person);
    }

    @Override
    public Person getUser(String email, String password) {
       return userDAO.getUser(email, password);
    }
}
