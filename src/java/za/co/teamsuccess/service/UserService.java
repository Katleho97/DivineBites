
package za.co.teamsuccess.service;

import za.co.teamsuccess.pojo.Person;

public interface UserService {
    boolean isValid(Person person);
    public boolean registerPerson(Person person);    
    void populatePerson(Person person);   //or Person populatePerson(Person person);    
    Person getUser(String email, String password);
}
