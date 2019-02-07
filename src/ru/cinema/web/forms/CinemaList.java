package ru.cinema.web.forms;

import ru.cinema.logic.Cinema;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class CinemaList {
    LinkedList<Cinema> cinemaList;

    public CinemaList() throws IOException {
        cinemaList = new LinkedList<Cinema>();
        this.readListFromFile();
    }

    public void setCinemaList(LinkedList<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    public LinkedList<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void addCinema(String address, String phone) throws Exception {
        if (cinemaList.size() == 3) {
            cinemaList.remove(2);
        }
        cinemaList.addFirst(new Cinema(address, phone));
        this.writeListInFile();
    }

    public void removeCinema(String phone) throws Exception{
        ListIterator<Cinema> iterator = cinemaList.listIterator();
        while (iterator.hasNext()) {
            Cinema cinema = iterator.next();
            if (cinema.getPhoneNumber().equals(phone)) {
                iterator.remove();
            }
        }
        this.writeListInFile();
    }

    public void writeListInFile() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream
                ("C:/Users/admin/IdeaProjects/cinema1/web/data/lists/cinemalist.txt"), "UTF8"));
        ListIterator<Cinema> iterator = getCinemaList().listIterator();
        while (iterator.hasNext()) {
            Cinema cinema = iterator.next();
            bw.write(cinema.getAddress() + "\n");
            bw.write(cinema.getPhoneNumber() + "\n");
        }
        bw.close();
    }

    public void readListFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream
                ("C:/Users/admin/IdeaProjects/cinema1/web/data/lists/cinemalist.txt"), "UTF8"));
        LinkedList<Cinema> cinemas = new LinkedList<Cinema>();
        for (int i = 0; i <3; i++){
            String address = br.readLine();
            String phone = br.readLine();
            if(address == null || phone == null){
                break;
            }
            cinemas.push(new Cinema(address, phone));
        }
        this.setCinemaList(cinemas);
        br.close();
    }
}
