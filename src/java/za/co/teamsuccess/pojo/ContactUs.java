package za.co.teamsuccess.pojo;

import java.sql.Date;
import java.util.Objects;

public class ContactUs {

    private int queryId;
    private String name;
    private String email;
    private String subject;
    private String message;
    private Date localDateTime;

    public ContactUs(int queryId, String name, String email, String subject, String message) {
        this.queryId = queryId;
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public ContactUs(int queryId, String name, String email, String subject, String message, Date localDateTime) {
        this.queryId = queryId;
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public ContactUs() {
    }

    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "ContactUs{" + "queryId=" + queryId + ", name=" + name + ", email=" + email + ", subject=" + subject + ", message=" + message + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.queryId;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.subject);
        hash = 29 * hash + Objects.hashCode(this.message);
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
        final ContactUs other = (ContactUs) obj;
        if (this.queryId != other.queryId) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        return Objects.equals(this.message, other.message);
    }
    public Date getLocalDateTime() {
        return localDateTime;
    }
    public void setLocalDateTime(Date localDateTime) {
        this.localDateTime = localDateTime;
    }
}
