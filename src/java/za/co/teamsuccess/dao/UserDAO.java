package za.co.teamsuccess.dao;

import java.util.List;
import za.co.teamsuccess.pojo.Person;

public interface UserDAO {

    boolean validatePerson(Person personBean);

    boolean registerPerson(Person person);

    Person getUser(String email, String password);

    boolean insertUser(Person user);

    Person selectUser(int id);

    boolean deleteUser(int id);

    List<Person> selectAllUsers();

    boolean updateUser(Person user);

}
