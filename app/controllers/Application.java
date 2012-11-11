package controllers;

import is.ru.honn.rupin.data.UserDataGateway;
import is.ru.honn.rupin.domain.Login;

import is.ru.honn.rupin.domain.User;
import is.ru.honn.rupin.domain.UserRegistration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.*;
import play.data.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static ApplicationContext ctx = new
            FileSystemXmlApplicationContext("/conf/ApplicationContext.xml");
    public static UserDataGateway userDataGateway = (UserDataGateway)ctx.getBean("userDataGateway");

    public static Result index() {
        String email = ctx().session().get("email");
        if(email != null) {
            return redirect(routes.Dashboard.index());
        }
        return ok(index.render());
    }

    public static Result signUp () {
        return ok(signup.render(form(UserRegistration.class)));
    }

    public static Result submitSignUp() {
        Form<UserRegistration> userform = form(UserRegistration.class).bindFromRequest();

        if (!"true".equals(userform.field("accept").value())) {
            userform.reject("accept", "You must accept the terms and conditions");
        }

        if (userDataGateway.getUserByEmail(userform.field("email").value()) != null) {
            userform.reject("email", userform.field("email").value()+" belongs to an existing account");
        }

        if (!userform.field("password").value().equals(userform.field("repeatPassword").value())) {
            userform.reject("repeatPassword", "Password does not match");
        }

        if(userform.hasErrors()) {
            return badRequest(signup.render(userform));
        } else {
            User created = userform.get();

            userDataGateway.addUser(created);

            session("email", userform.get().getEmail());
            return redirect(routes.Dashboard.index());
        }
    }

    public static Result login() {
        return ok(login.render(form(Login.class)));
    }

    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();

        if(loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session("email", loginForm.get().email);
            return redirect(routes.Dashboard.index());
        }

    }

    public static Result logout() {
        session().clear();
        // TODO: flash("success", Messages.get("youve.been.logged.out"));
        return redirect(routes.Application.index());
    }

    public static Result forgotpassword(){
        // TODO: :)
        return TODO;
    }

}