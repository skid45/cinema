package ru.cinema.web.forms;

import ru.cinema.logic.News;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class NewsList {
    LinkedList<News> newsList;

    public NewsList() throws IOException {
        newsList = new LinkedList<News>();
        this.readListFromFile();
    }

    public void setNewsList(LinkedList<News> newsList) {
        this.newsList = newsList;
    }

    public LinkedList<News> getNewsList() {
        return newsList;
    }

    public void addNews(String name, String description) throws Exception {
        if (newsList.size() == 2) {
            newsList.remove(1);
        }
        newsList.addFirst(new News(name, description));
        this.writeListInFile();

    }

    public void removeNews(String name) throws Exception{
        ListIterator<News> iterator = newsList.listIterator();
        while (iterator.hasNext()) {
            News news = iterator.next();
            if (news.getNewsName().equals(name)) {
                iterator.remove();
            }
        }
        this.writeListInFile();
    }

    public void writeListInFile() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream
                ("C:/Users/admin/IdeaProjects/cinema1/web/data/lists/newslist.txt"), "UTF8"));
        ListIterator<News> iterator = getNewsList().listIterator();
        while (iterator.hasNext()) {
            News news = iterator.next();
            bw.write(news.getNewsName() + "\n");
            bw.write(news.getNewsDescription() + "\n");
        }
        bw.close();
    }

    public void readListFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream
                ("C:/Users/admin/IdeaProjects/cinema1/web/data/lists/newslist.txt"), "UTF8"));
        LinkedList<News> news = new LinkedList<News>();
        for (int i = 0; i <2; i++){
            String name = br.readLine();
            String description = br.readLine();
            if(name == null || description == null){
                break;
            }
            news.push(new News(name, description));
        }
        this.setNewsList(news);
        br.close();
    }
}
