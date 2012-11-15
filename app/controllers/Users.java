package controllers;

import is.ru.honn.rupin.domain.Follow;
import is.ru.honn.rupin.domain.FollowingUser;
import is.ru.honn.rupin.domain.User;
import is.ru.honn.rupin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.users.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jóhann
 * @version 1.0, 14.11.2012
 * @since 14.11.2012, 22:54
 */
@Security.Authenticated(Secured.class)
public class Users extends Controller {
    public static ApplicationContext dbctx = new
            FileSystemXmlApplicationContext("/conf/ApplicationContext.xml");
    public static UserService userServiceData =  (UserService)dbctx.getBean("userService");

    public static Result search(){
        User loginUser = userServiceData.getUserByEmail(request().username());
        List<User> users = userServiceData.getUsers();
        List<Follow> follows = userServiceData.getFollowing(request().username());

        List<FollowingUser> a = new ArrayList<FollowingUser>();
        for(User u : users) {
            Follow addFollow = null;
            for(Follow f : follows) {
                if (f.getUsername().equals(request().username()) && u.getEmail().equals(f.getFollow())){
                    addFollow = f;
                    break;
                }
            }
            a.add(new FollowingUser(u.getEmail(),u.getFullname(),u.getPassword(), addFollow));
        }
        return ok(search.render(loginUser, a));
    }

    public static Result addFollow(String followUsername) {
        userServiceData.addFollows(request().username(), followUsername);
        // Todo: redirect á viðkomandi notanda sem er verið að followa?
        return redirect(routes.Users.search());
    }

    public static Result unFollow(String followUsername) {
        userServiceData.unFollows(request().username(), followUsername);
        // Todo: redirect á viðkomandi notanda sem er verið að unfollowa eða kannski dashboard notanda?
        return redirect(routes.Users.search());
    }
}
