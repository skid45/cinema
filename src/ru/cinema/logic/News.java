package ru.cinema.logic;

public class News {
    private String newsName;
    private String newsDescription;

    public News(String newsName, String newsDescription) {
        this.newsName = newsName;
        this.newsDescription = newsDescription;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }
}
