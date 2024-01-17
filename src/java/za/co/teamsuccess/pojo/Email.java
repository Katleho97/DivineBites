
package za.co.teamsuccess.pojo;

/**
 *
 * @author New
 */
public class Email {
    private String subjectline;
    private String emailAddress;
    private String message;
    public Email(){
}

    public String getSubjectline() {
        return subjectline;
    }

    public void setSubjectline(String subjectline) {
        this.subjectline = subjectline;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        //validate before setting
        this.emailAddress = emailAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
   
    

