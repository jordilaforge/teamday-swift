import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class LoginServlet extends HttpServlet {

    static final String LOGIN_TOKEN = "";
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (Objects.equals(username, VALID_USERNAME) && Objects.equals(password, VALID_PASSWORD)) {
            response.setStatus(200);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print("{\"username\":\"" + VALID_USERNAME + "\",\"token\":\"" + LOGIN_TOKEN + "\"}");
            out.flush();
        } else {
            response.setStatus(401);
        }
    }
}
