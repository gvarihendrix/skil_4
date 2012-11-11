package is.ru.honn.rupin.domain;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Jóhann
 * @version 1.0, 11.11.2012
 * @since 11.11.2012, 01:59
 */
public class UserRegistration extends User {

    @Constraints.Required
    @Formats.NonEmpty
    protected String repeatPassword;

    public UserRegistration(){
    }

    public UserRegistration(int id, String email, String fullname, String password, String repeatPassword) {
        super(id, email, fullname, password);
        this.repeatPassword = repeatPassword;
    }

    public UserRegistration(String email, String fullname, String password, String repeatPassword) {
        super(email, fullname, password);
        this.repeatPassword = repeatPassword;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
