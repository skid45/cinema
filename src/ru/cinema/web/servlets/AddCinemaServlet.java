package ru.cinema.web.servlets;

import ru.cinema.web.forms.CinemaList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddCinemaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = request.getParameter("address");
        address = new String(address.getBytes("ISO-8859-1"), "UTF-8");
        String number = request.getParameter("number");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        CinemaList cinemaList = new CinemaList();
        try {
            cinemaList.addCinema(address, number);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pw.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Кинотеатр добавлен</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<center>\n" +
                "    <p>Кинотеатр успешно добавлен!</p>\n" +
                "    <form action=\"addcinema.html\">\n" +
                "        <button>Добавить ещё один кинотеатр</button>\n" +
                "    </form>\n" +
                "    <form action=\"adminpage\">\n" +
                "        <button>Вернуться к списку функций</button>\n" +
                "    </form>\n" +
                "</center>\n" +
                "</body>\n" +
                "</html>");
    }
}
