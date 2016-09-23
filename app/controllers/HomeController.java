package controllers;

import com.google.inject.Inject;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import views.VoteBlock;
import views.html.*;

import java.util.Arrays;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    FormFactory formFactory;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        Form<Vote> voteForm = formFactory.form(Vote.class);
        Vote vote = voteForm.bindFromRequest().get();
        return ok(index.render("Your new application is ready.", "", ""));
    }

    public Result post() {
        Arrays.asList("");
        DynamicForm requestData = formFactory.form().bindFromRequest();
        requestData.get("email");
        requestData.get("vote");
        requestData.get("g-recaptcha-response");
        return ok(index.render("Your new application is ready.", requestData.get("vote"), requestData.get("email")));
    }


}
