package za.co.teamsuccess.pojo;

import java.util.Objects;

/**
 *
 * @author student07
 */

public class Person extends PersonRole {

    private int personId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int role;
    private int addressId;
    private String subject;
    private String message;
    private String userName;
    private String cellPhone;

    public Person() {
    }

    public Person(int personId, String firstName, String lastName, String email, String password, int role, int addressId, String subject, String message, String userName) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.addressId = addressId;
        this.subject = subject;
        this.message = message;
        this.userName = userName;
    }
    
    public Person(int personId, String firstName, String lastName, String email, String password, int role, int address, String subject, String message) {
        this(personId, firstName, lastName, email, password, role, address, subject, message, "");
    }
    
    public Person(int personId, String firstName, String lastName, String email, String password, int role) {
       this(personId, firstName, lastName, email, password, role, 0, "", "", "");
    }
    
    public Person(String firstName, String lastName, String email, int address, String password, String username) {
       this(0, firstName, lastName, email, password, 0, 0, "", "", username);
    }

    public Person(String email, String password) {
     this(0, "", "", email, password, 0, 0, "", "", "");
    }

    public Person(String firstName, String lastName, String email, String password, int role) {
       this(0, firstName, lastName, email, password, role, 0, "", "", "");
    }
   
    
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Person{" + "personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", role=" + role + ", addressId=" + addressId + ", subject=" + subject + ", message=" + message + ", userName=" + userName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.personId;
        hash = 37 * hash + Objects.hashCode(this.firstName);
        hash = 37 * hash + Objects.hashCode(this.lastName);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.password);
        hash = 37 * hash + this.role;
      
        hash = 37 * hash + Objects.hashCode(this.subject);
        hash = 37 * hash + Objects.hashCode(this.message);
        hash = 37 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.personId != other.personId) {
            return false;
        }
        if (this.role != other.role) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return Objects.equals(this.userName, other.userName);
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}
