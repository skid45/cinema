package ru.cinema.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminPageServlet extends HttpServlet {

     private String correctPassword = "admin";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("pass");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        if(correctPassword.equals(password)){
            doGet(request, response);
        }
        else{
            PrintWriter pw = response.getWriter();
            pw.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Неправильный пароль</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "   <center>\n" +
                    "       <p>Неправильно введён пароль.</p>\n" +
                    "       <p>Вернитесь назад и попробуйте заново.</p>\n" +
                    "       <form action=\"auth.html\">\n" +
                    "           <button>Назад</button>\n" +
                    "       </form>\n" +
                    "   </center>\n" +
                    "</body>\n" +
                    "</html>");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Страница администратора</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <center>\n" +
                "        <div>Фильмы\n" +
                "            <form action=\"addfilm.html\">\n" +
                "                <button \">Добавить</button>\n" +
                "            </form>\n" +
                "            <form action=\"removefilm.html\">\n" +
                "                <button>Удалить</button>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "        <div>Кинотеатры\n" +
                "            <form action=\"addcinema.html\">\n" +
                "                <button>Добавить</button>\n" +
                "            </form>\n" +
                "            <form action=\"removecinema.html\">\n" +
                "                <button>Удалить</button>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "        <div>Новости\n" +
                "            <form action=\"addnews.html\">\n" +
                "                <button>Добавить</button>\n" +
                "            </form>\n" +
                "            <form action=\"removenews.html\">\n" +
                "                <button>Удалить</button>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "    </center>\n" +
                "</body>\n" +
                "</html>");
    }
}
