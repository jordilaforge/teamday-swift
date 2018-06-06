import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (Objects.equals(username, "admin") && Objects.equals(password, "password")) {
            response.setStatus(200);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print("{\"username\":\"admin\"}");
            out.flush();
        } else {
            response.setStatus(401);
        }
    }
}
