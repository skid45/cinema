package ru.cinema.web.forms;

import ru.cinema.logic.Film;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class FilmList {
    private LinkedList<Film> filmList;


    public FilmList() throws IOException {
        filmList = new LinkedList<Film>();
        this.readListFromFile();
    }

    public void setFilmList(LinkedList<Film> filmList) {
        this.filmList = filmList;
    }

    public LinkedList<Film> getFilmList() {
        return filmList;
    }

    public void addFilm(String name, String released, String filmDescription) throws Exception {
        if (filmList.size() == 3) {
            filmList.remove(2);
        }
        filmList.addFirst(new Film(name, released, filmDescription));
        this.writeListInFile();
    }

    public void removeFilm(String name) throws Exception{
        ListIterator<Film> iterator = filmList.listIterator();
        while (iterator.hasNext()) {
            Film film = iterator.next();
            if (film.getFilmName().equals(name)) {
                iterator.remove();
            }
        }
        this.writeListInFile();
    }

    public void writeListInFile() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream
                ("C:/Users/admin/IdeaProjects/cinema1/web/data/lists/filmlist.txt"), "UTF8"));
        ListIterator<Film> iterator = getFilmList().listIterator();
        while (iterator.hasNext()) {
            Film film = iterator.next();
            bw.write(film.getFilmName() + "\n");
            bw.write(film.getReleased() + "\n");
            bw.write(film.getFilmDescription() + "\n");
        }
        bw.close();
    }

    public void readListFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream
                ("C:/Users/admin/IdeaProjects/cinema1/web/data/lists/filmlist.txt"), "UTF8"));
        LinkedList<Film> films = new LinkedList<Film>();
        for (int i = 0; i < 3; i++){
            String filmName = br.readLine();
            String released = br.readLine();
            String description = br.readLine();
            if(filmName == null || released == null || description == null){
                break;
            }
            films.push(new Film(filmName, released, description));
        }
        this.setFilmList(films);
        br.close();
    }
}