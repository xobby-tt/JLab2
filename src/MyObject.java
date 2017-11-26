import java.util.Date;

public class MyObject {
    private Integer id;
    private String author;
    private String name;
    private DurationTime duration;
    private Date publication; //==============to do (базу данных)============
    private Integer downloads = 0;
    private String popularity; //=======================to do ()=============================



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DurationTime getDuration() {
        return duration;
    }

    public void setDuration(DurationTime duration) {
        this.duration = duration;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public void incrementDownloads() {
        ++downloads;
    }

    public Integer getDownloads() {return downloads;}

}
