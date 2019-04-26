package model;

public class Album {

    private long id;
    private String title;

    public Album(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public long getId() {
        return this.id;
    }
}
