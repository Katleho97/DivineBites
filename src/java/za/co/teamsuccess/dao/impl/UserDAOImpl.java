package za.co.teamsuccess.dao.impl;

import java.sql.ResultSet;
import za.co.teamsuccess.dao.UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.Person;

/**
 * @author student07
 */
public class UserDAOImpl implements UserDAO {

    private PreparedStatement ps;
    private PreparedStatement ps1;
    private Connection con;
    private ResultSet rs;

    Person person = new Person();

    final private DBPoolManagerBasic dbManager;

    ///////////////////////////////////////Login////////////////////////////////////////////
    public UserDAOImpl(DBPoolManagerBasic dbManager) {
        this.dbManager = dbManager;
    }

    // *********************************************************************************
    @Override
    public boolean validatePerson(Person personBean) {
        boolean status = true;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("select * from person where email = ? and password = ? and active = 1");
            ps.setString(1, personBean.getEmail());
            ps.setString(2, personBean.getPassword());
            rs = ps.executeQuery();
            status = rs.next();
            if (status) {
                ps1 = con.prepareStatement("update person set logintimestamp = now()  where email = ? and password = ? and active = 1");
                ps1.setString(1, personBean.getEmail());
                ps1.setString(2, personBean.getPassword());
                ps1.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Oh dear. Error trying to login: " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return status;
    }

    ///////////////////////////////////////////////Registration///////////////////////////////////////////////////////////////////
    @Override
    public boolean registerPerson(Person person) {
        boolean result = false;
        try {

            con = dbManager.getConnection();
            ps = con.prepareStatement("insert into person(personid,firstname,lastname,password,email,logintimestamp,regitertimestamp) values(null,?,?,?,?,now(),now())");
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setString(3, person.getPassword());
            ps.setString(4, person.getEmail());
            int i = ps.executeUpdate();
            result = i > 0;

        } catch (SQLException e) {
            System.out.println("Error registering: " + e.getMessage());
        } finally {
            closeStreams();
        }
        return result;
    }//************************Returning the person object for the session**********************

    @Override
    public Person getUser(String email, String password) {
        Person user = null;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("SELECT p.personid, firstname,lastname,email,p.password,role,cellphonenumber,username, addressid from person AS p, address AS a "
                    + " WHERE p.email=? AND p.password = ? AND a.personid=p.personid");
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new Person();
                user.setPersonId(rs.getInt("personid"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getInt("role"));
                user.setUserName(rs.getString("username"));
                user.setCellPhone(rs.getString("cellphonenumber"));
                user.setAddressId(rs.getInt("addressid"));
            }
        } catch (SQLException e) {
            System.out.println("Error selecting user from database " + e.getMessage());
        }
        return user;
    }

    /////////////////////////Contact us form////////////////////////////////
    public boolean contactUsForm(Person user) {
        boolean retVal = false;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("insert into contactusform(queryid,name,email,subject,message,querytimestamp) values(null,?,?,?,?,now())");
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getEmail());
            ps.setString(3, person.getSubject());
            ps.setString(4, person.getMessage());

            retVal = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error processing the contact us form " + ex.getMessage());
        }

        return retVal;
    }

    //////////////////////////admin user acess//////////////////////////////
    @Override
    public boolean insertUser(Person user) {
        boolean retVal = false;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("insert into person(personid,firstname,lastname,password,email,role,logintimestamp,regitertimestamp) values(null,?,?,?,?,?,now(),now())");

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setInt(5, user.getAddressId());
            ps.setInt(6, user.getRole());
            System.out.println(ps);
            retVal = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Database Error unable to insert a user " + e.getMessage());
        }
        return retVal;
    }

    //****************************select user***********************************
    @Override
    public Person selectUser(int id) {
        Person user = null;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("select firstname,lastname,email,password, role from person where personid = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int role = rs.getInt("role");
                user = new Person(id, firstName, lastName, email, password, role);
            }
        } catch (SQLException e) {
            System.out.println("Error selecting user from database " + e.getMessage());
        }
        return user;
    }

    //************************delete user***************************************
    @Override
    public boolean deleteUser(int id) {
        boolean rowDeleted = false;

        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("update person set active = 0 where personid = ?");
            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting user from database " + e.getMessage());
        }
        return rowDeleted;
    }

    //****************************select all users*****************************
    @Override
    public List<Person> selectAllUsers() {
        List<Person> users = new ArrayList<>();
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("select personid, firstname,lastname, email, password, role from person where active = 1");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("personid");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int role = rs.getInt("role");
                users.add(new Person(id, firstName, lastName, email, password, role));
            }
        } catch (SQLException e) {
            System.out.println("Error selecting all users " + e.getMessage());
        }
        return users;
    }

    //*************************update a user************************************
    @Override
    public boolean updateUser(Person user) {
        boolean rowUpdated = false;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("update users set fisrtname = ?,lastname = ?,email= ?,pasword = ?,role = ?, where personid = ?");
            rs = ps.executeQuery();
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getPersonId());
            ps.setInt(6, user.getRole());
            rowUpdated = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating users " + e.getMessage());
        }
        return rowUpdated;
    }

    ////////////////////////////close stream/////////////////////////////////
    private void closeStreams() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Error closing ResultSet: " + ex.getMessage());
            }
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Error closing prepared statement: " + ex.getMessage());
            }
        }
        if (ps1 != null) {
            try {
                ps1.close();
            } catch (SQLException ex) {
                System.out.println("Error closing prepared statement 1: " + ex.getMessage());
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error closing connection: " + ex.getMessage());
            }
        }
        rs = null;
        ps = null;
        ps1 = null;
        con = null;
    }
}
