import pojo.Notification;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class NotificationServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = request.getParameter("token");
        if (Objects.equals(token, LoginServlet.LOGIN_TOKEN)) {
            response.setStatus(200);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            List<Notification> notifications = new ArrayList<>();
            Notification tea = Notification.builder()
                    .title("tea")
                    .bedNumber("301.1")
                    .created(LocalDateTime.now())
                    .painIndex(0)
                    .localisation("")
                    .build();
            notifications.add(tea);
            Notification banana = Notification.builder()
                    .title("banana")
                    .bedNumber("301.2")
                    .created(LocalDateTime.now())
                    .painIndex(0)
                    .localisation("")
                    .build();
            notifications.add(banana);
            Notification backPain = Notification.builder()
                    .title("backPain")
                    .bedNumber("302.1")
                    .created(LocalDateTime.now())
                    .painIndex(9)
                    .localisation("back")
                    .build();
            notifications.add(backPain);
            Notification toilet = Notification.builder()
                    .title("toilet")
                    .bedNumber("302.2")
                    .created(LocalDateTime.now())
                    .painIndex(0)
                    .localisation("")
                    .build();
            notifications.add(toilet);
            out.print(getNotificationsJson(notifications));
            out.flush();
        } else {
            response.setStatus(401);
        }
    }

    private String getNotificationsJson(List<Notification> notifications) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        StringJoiner stringJoiner = new StringJoiner(",");
        notifications.forEach(notification -> stringJoiner.add(getNotificationJson(notification)));
        json.append(stringJoiner.toString());
        json.append("]");
        return json.toString();
    }

    private String getNotificationJson(Notification notification) {
        return "{" +
                createJsonAttribute("title", notification.getTitle()) +
                "," +
                createJsonAttribute("created", notification.getCreated().toString()) +
                "," +
                createJsonAttribute("localisation", notification.getLocalisation()) +
                "," +
                createJsonAttribute("bedNumber", notification.getBedNumber()) +
                "," +
                createJsonAttribute("painIndex", String.valueOf(notification.getPainIndex())) +
                "}";
    }

    private String createJsonAttribute(String label, String value) {
        return "\"" + label + "\":\"" + value + "\"";
    }
}
