package is.ru.honn.rupin.domain;

import is.ru.honn.rupin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.data.format.Formats;
import play.data.validation.Constraints.*;
import play.mvc.Http;

/**
 * @author Jóhann
 * @version 1.0, 10.11.2012
 * @since 10.11.2012, 20:09
 *
 * Login class used by Login Form
 */
public class Login {

    @Required
    @Email
    @Formats.NonEmpty
    public String email;

    @Required
    @Formats.NonEmpty
    public String password;

    /**
     * Validate the authentication.
     *
     * @return null if validation ok, string with details otherwise
     */
    public String validate() {
        ApplicationContext dbctx = new
                FileSystemXmlApplicationContext("/conf/ApplicationContext.xml");
        UserService userServiceData =  (UserService)dbctx.getBean("userService");

        if (userServiceData.authenticate(email,password) != null) return null;
        return "Invalid user or Password";
    }

    private boolean isBlank(String input){
        return input == null || input.isEmpty() || input.trim().isEmpty();
    }

}