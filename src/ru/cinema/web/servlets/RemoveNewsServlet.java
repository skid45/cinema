package ru.cinema.web.servlets;

import ru.cinema.web.forms.NewsList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RemoveNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newsname = request.getParameter("newsname");
        newsname = new String(newsname.getBytes("ISO-8859-1"), "UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        NewsList newsList = new NewsList();
        try {
            newsList.removeNews(newsname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pw.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Новость удалена</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<center>\n" +
                "    <p>Новость успешно удалена!</p>\n" +
                "    <form action=\"removenews.html\">\n" +
                "        <button>Удалить ещё одину новость</button>\n" +
                "    </form>\n" +
                "    <form action=\"adminpage\">\n" +
                "        <button>Вернуться к списку функций</button>\n" +
                "    </form>\n" +
                "</center>\n" +
                "</body>\n" +
                "</html>");
    }
}
