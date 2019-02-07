package ru.cinema.logic;


public class Film {
    private String filmName;
    private String released;
    private String filmDescription;


    public Film(String filmName, String released, String filmDescription) {
        this.filmName = filmName;
        this.released = released;
        this.filmDescription = filmDescription;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getReleased() {
        return released;
    }

    public String getFilmDescription() {
        return filmDescription;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }
}
