package ru.cinema.web.servlets;

import ru.cinema.web.forms.FilmList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RemoveFilmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filmname = request.getParameter("filmname");
        filmname = new String(filmname.getBytes("ISO-8859-1"), "UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        FilmList filmList = new FilmList();
        try {
            filmList.removeFilm(filmname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pw.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Фильм удалён</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<center>\n" +
                "    <p>Фильм успешно удалён!</p>\n" +
                "    <form action=\"removefilm.html\">\n" +
                "        <button>Удалить ещё один фильм</button>\n" +
                "    </form>\n" +
                "    <form action=\"adminpage\">\n" +
                "        <button>Вернуться к списку функций</button>\n" +
                "    </form>\n" +
                "</center>\n" +
                "</body>\n" +
                "</html>");
    }
}
