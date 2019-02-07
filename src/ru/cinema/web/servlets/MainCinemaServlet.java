package ru.cinema.web.servlets;

import ru.cinema.logic.Cinema;
import ru.cinema.logic.Film;
import ru.cinema.logic.News;
import ru.cinema.web.forms.CinemaList;
import ru.cinema.web.forms.FilmList;
import ru.cinema.web.forms.NewsList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ListIterator;

public class MainCinemaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FilmList filmList = new FilmList();
        CinemaList cinemaList = new CinemaList();
        NewsList newsList = new NewsList();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        pw.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Сеть кинотеатров</title>\n" +
                "    <link rel = \"stylesheet\" href = \"style.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"header\">\n" +
                "        <a class=\"mainframe\" href=\"/cinema1_war_exploded/maincinema?page=main\">СЕТЬ КИНОТЕАТРОВ КИНОКУБ</a>\n" +
                "        <div class=\"login_link\">\n" +
                "            <a href=\"auth.html\">Вход</a>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"header_separator\"></div>\n" +
                "<div class=\"left_link\">\n" +
                "        <a href=\"/cinema1_war_exploded/maincinema?page=news\">НОВОСТИ</a>\n" +
                "    </div>\n" +
                "    <div class=\"left_link\">\n" +
                "        <a href=\"/cinema1_war_exploded/maincinema?page=affiche\">АФИША</a>\n" +
                "    </div>\n" +
                "    <div class=\"left_link\">\n" +
                "        <a href=\"/cinema1_war_exploded/maincinema?page=cinemalist\">КИНОТЕАТРЫ</a>\n" +
                "    </div>\n" +
                "    <div class=\"left_link\">\n" +
                "        <a href=\"/cinema1_war_exploded/maincinema?page=contacts\">КОНТАКТЫ</a>\n" +
                "    </div>\n" +
                "    <div class=\"left_link_continue\"></div>\n" +
                "    <div class=\"left_link_separator\"></div>");
        if(request.getParameter("page").equals("main")){
            String[] cssClasses = {"first", "second", "third"};
            int i = 0;
            ListIterator<Film> iterator = filmList.getFilmList().listIterator();
            while (iterator.hasNext()){
                Film film = iterator.next();
                pw.println("<div class=\"" + cssClasses[i] + "_film_img\">\n" +
                        "        <a href=\"/cinema1_war_exploded/maincinema?page=film&id=" + (i + 1) + "\">\n" +
                        "            <img class=\"size_film_img\" src=data/filmimage/" + film.getFilmName().replaceAll(" ", "%20") + ".jpg>\n" +
                        "        </a>\n" +
                        "    </div>");
                i++;
            }
            pw.println("<div class=\"promo\">Акции</div>\n" +
                    "    <div class=\"first_promo\"><img class=\"size_promo_img\" src=\"data/promo/promo1.jpg\"></div>\n" +
                    "    <div class=\"second_promo\"><img class=\"size_promo_img\" src=\"data/promo/promo2.jpg\"></div>\n" +
                    "    <div class=\"third_promo\"><img class=\"size_promo_img\" src=\"data/promo/promo3.jpg\"></div>");
        }
        if(request.getParameter("page").equals("news")){
            String[] cssClasses = {"first", "second"};
            int i = 0;
            ListIterator<News> iterator = newsList.getNewsList().listIterator();
            while (iterator.hasNext()){
                News news = iterator.next();
                pw.println("<div class=\"" + cssClasses[i] + "_news\">\n" +
                        "        <div><img class=\"size_news_img\" src=data/newsimage/" + news.getNewsName().replaceAll(" ", "%20") + ".jpg></div>\n" +
                        "        <div class=\"news_name\">" + news.getNewsName() + "</div>\n" +
                        "        <div class=\"news_description\">" + news.getNewsDescription() + "</div>\n" +
                        "    </div>");
                i++;
            }
        }
        if(request.getParameter("page").equals("affiche")){
            pw.println("<table class=\"table_affiche\">\n" +
                    "    <tr>\n" +
                    "        <td>Кинотеатр 1</td>\n" +
                    "        <td>Кинотеатр 2</td>\n" +
                    "        <td>Кинотеатр 3</td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td>12:00 - " + filmList.getFilmList().get(0).getFilmName() + "</td>\n" +
                    "        <td>12:00 - " + filmList.getFilmList().get(1).getFilmName() + "</td>\n" +
                    "        <td>12:00 - " + filmList.getFilmList().get(2).getFilmName() + "</td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td>16:00 - " + filmList.getFilmList().get(1).getFilmName() + "</td>\n" +
                    "        <td>16:00 - " + filmList.getFilmList().get(2).getFilmName() + "</td>\n" +
                    "        <td>16:00 - " + filmList.getFilmList().get(0).getFilmName() + "</td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td>20:00 - " + filmList.getFilmList().get(2).getFilmName() + "</td>\n" +
                    "        <td>20:00 - " + filmList.getFilmList().get(0).getFilmName() + "</td>\n" +
                    "        <td>20:00 - " + filmList.getFilmList().get(1).getFilmName() + "</td>\n" +
                    "    </tr>\n" +
                    "</table>");
        }
        if(request.getParameter("page").equals("cinemalist")){
            String[] cssClasses = {"first", "second", "third"};
            int i = 0;
            ListIterator<Cinema> iterator = cinemaList.getCinemaList().listIterator();
            while (iterator.hasNext()){
                Cinema cinema = iterator.next();
                pw.println("<div class=\"" + cssClasses[i] + "_cinema\">\n" +
                                "    Кинотеатр " + (i + 1) + "\n" +
                                "    <div class=\"arg_cinema_color\">Адрес: " + cinema.getAddress() + "</div>\n" +
                                "    <div class=\"arg_cinema_color\">Номер: " + cinema.getPhoneNumber() + "</div>\n" +
                                "</div>");
                i++;
            }
        }
        if(request.getParameter("page").equals("contacts")){
            pw.println("<div class=\"common_number\">Общий контактный номер: 81234567890</div>\n" +
                    "<div class=\"all_cinema_numbers\">\n" +
                    "    Контактные номера наших кинотеатров\n");
            int i = 0;
            ListIterator<Cinema> iterator = cinemaList.getCinemaList().listIterator();
            while (iterator.hasNext()) {
                Cinema cinema = iterator.next();
                pw.println("<div class=\"arg_contacts_color\">Кинотеатр 1: " + cinema.getPhoneNumber() + "</div>\n");
                i++;
            }
            pw.println("</div>");
        }
        if(request.getParameter("page").equals("film")){
            String id = request.getParameter("id");
            String fn = new String();
            String fd = new String();
            String fi = new String();
            if(id.equalsIgnoreCase("1")){
                fn = filmList.getFilmList().get(0).getFilmName();
                fd = filmList.getFilmList().get(0).getFilmDescription();
                fi = fn + ".jpg";
                fi = fi.replaceAll(" ", "%20");
            }
            if(id.equalsIgnoreCase("2")){
                fn = filmList.getFilmList().get(1).getFilmName();
                fd = filmList.getFilmList().get(1).getFilmDescription();
                fi = fn + ".jpg";
                fi = fi.replaceAll(" ", "%20");
            }
            if(id.equalsIgnoreCase("3")){
                fn = filmList.getFilmList().get(2).getFilmName();
                fd = filmList.getFilmList().get(2).getFilmDescription();
                fi = fn + ".jpg";
                fi = fi.replaceAll(" ", "%20");
            }

            pw.println("<div class=\"header_separator\"></div>\n" +
                    "<div class=\"filmpage_imgdiv\"><img class=\"size_film_img\" src=data/filmimage/"+ fi + "></div>\n" +
                    "<div class=\"filmpage_name\">" + fn + "</div>\n" +
                    "<div class=\"filmpage_description\">" + fd + "</div>");
        }

        pw.println("</body>\n" +
                "</html>");
    }
    
}
