import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class MyObject {
    private Integer id;
    private String author;
    private String name;
    private DurationTime duration;
    private Date publication; //==============to do (базу данных)============
    private Integer downloads = 0;
    private long popularity;

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

    public String getPublication() {
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        return format1.format(publication);
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public void incrementDownloads() {

        ++downloads;

        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = format1.parse(format1.format( new Date() ));
            date2 = format1.parse(format1.format( publication ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        long difference = date1.getTime() - date2.getTime();
        long days =  difference / (24 * 60 * 60 * 1000);
        try {
            this.popularity = downloads / days;
        } catch (ArithmeticException e) {
            this.popularity = downloads;
        }
    }

    public Integer getDownloads() {return downloads;}

    public void setPopularity() {

    }

    public long getPopularity() {
        return popularity;
    }
}
