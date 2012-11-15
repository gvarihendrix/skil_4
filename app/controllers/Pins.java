package controllers;

import is.ru.honn.rupin.domain.Board;
import is.ru.honn.rupin.domain.Pin;
import is.ru.honn.rupin.domain.User;
import is.ru.honn.rupin.service.BoardService;
import is.ru.honn.rupin.service.PinService;
import is.ru.honn.rupin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.pins.*;

import java.util.Date;
import java.util.List;

/**
 * @author Jóhann
 * @version 1.0, 12.11.2012
 * @since 12.11.2012, 02:04
 */
@Security.Authenticated(Secured.class)
public class Pins extends Controller {
    public static ApplicationContext dbctx = new
            FileSystemXmlApplicationContext("/conf/ApplicationContext.xml");
    public static UserService userServiceData =  (UserService)dbctx.getBean("userService");
    public static BoardService boardServiceData = (BoardService)dbctx.getBean("boardService");
    public static PinService pinServiceData = (PinService)dbctx.getBean("pinService");

    public static Result add(){
        User loginUser = userServiceData.getUserByEmail(request().username());
        List<Board> boards = boardServiceData.getBoards(request().username());
        return ok(add.render(loginUser, form(Pin.class),  boards ));
    }

    public static Result submitAdd(){
        Form<Pin> pinForm = form(Pin.class).bindFromRequest();


        if(pinForm.hasErrors()) {
            User loginUser = userServiceData.getUserByEmail(request().username());
            List<Board> boards = boardServiceData.getBoards(request().username());
            return badRequest(add.render(loginUser, pinForm,  boards ));
        }  else {
            Pin created = pinForm.get();

            created.setCreated(new Date());
            created.setCreator(request().username());

            pinServiceData.add(created);

            return redirect(routes.Dashboard.index());
        }
    }
}
