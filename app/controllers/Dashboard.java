package controllers;

import is.ru.honn.rupin.domain.User;
import is.ru.honn.rupin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import views.html.dashboard.*;

/**
 * @author Jóhann
 * @version 1.0, 10.11.2012
 * @since 10.11.2012, 20:25
 */
@Security.Authenticated(Secured.class)
public class Dashboard extends Controller {

    public static ApplicationContext dbctx = new
            FileSystemXmlApplicationContext("/conf/ApplicationContext.xml");
    public static UserService userServiceData = (UserService) dbctx.getBean("userService");

    public static Result index() {
        User loginUser = userServiceData.getUserByEmail(request().username());
        return ok(index.render(loginUser));
    }
}
