package is.ru.honn.rupin.domain;

import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.validation.Constraint;

/**
 * @author Jóhann
 * @version 1.0, 11.11.2012
 * @since 11.11.2012, 01:04
 */
public class User {
    protected int id;

    @Constraints.Required
    @Constraints.Email
    @Formats.NonEmpty
    protected String email;

    @Constraints.Required
    @Formats.NonEmpty
    protected String fullname;

    @Constraints.Required
    @Formats.NonEmpty
    protected String password;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String email, String fullname, String password) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
    }

    public User(String email, String fullname, String password) {
        this.email = email;
        this.fullname = fullname;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
