package ru.cinema.web.servlets;

import ru.cinema.web.forms.NewsList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newsname = request.getParameter("newsname");
        newsname = new String(newsname.getBytes("ISO-8859-1"), "UTF-8");
        String newsdescription = request.getParameter("newsdescription");
        newsdescription = new String(newsdescription.getBytes("ISO-8859-1"), "UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        NewsList newsList = new NewsList();
        try {
            newsList.addNews(newsname, newsdescription);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pw.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Новость добавлена</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<center>\n" +
                "    <p>Новость успешно добавлена!</p>\n" +
                "    <form action=\"addnews.html\">\n" +
                "        <button>Добавить ещё одину новость</button>\n" +
                "    </form>\n" +
                "    <form action=\"adminpage\">\n" +
                "        <button>Вернуться к списку функций</button>\n" +
                "    </form>\n" +
                "</center>\n" +
                "</body>\n" +
                "</html>");
    }
}
