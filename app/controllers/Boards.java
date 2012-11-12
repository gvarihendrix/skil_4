package controllers;

import is.ru.honn.rupin.domain.Board;
import is.ru.honn.rupin.domain.User;
import is.ru.honn.rupin.service.BoardService;
import is.ru.honn.rupin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.boards.*;

import java.util.Date;

/**
 * @author Jóhann
 * @version 1.0, 11.11.2012
 * @since 11.11.2012, 22:44
 */
@Security.Authenticated(Secured.class)
public class Boards extends Controller {

    public static ApplicationContext dbctx = new
            FileSystemXmlApplicationContext("/conf/ApplicationContext.xml");
    public static UserService userServiceData =  (UserService)dbctx.getBean("userService");
    public static BoardService boardServiceData = (BoardService)dbctx.getBean("boardService");

    public static Result create(){
        User loginUser = userServiceData.getUserByEmail(request().username());
        return ok(create.render(loginUser, form(Board.class)));
    }

    public static Result submitCreate() {
        Form<Board> boardForm = form(Board.class).bindFromRequest();

        if(boardForm.hasErrors()) {
            User loginUser = userServiceData.getUserByEmail(request().username());
            return badRequest(create.render(loginUser, boardForm));
        } else {
            Board created = boardForm.get();

            created.setCreated(new Date());
            created.setCreator(request().username());

            boardServiceData.create(created);

            return redirect(routes.Dashboard.index());
        }
    }
}
