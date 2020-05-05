package sogeti.model;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    public int id;

    @Column (name = "title")
    public String title;

    @Column (name = "longDescription", length = 4096)
    public String longDescription;

    @Column (name = "shortDescription", length = 512)
    public String shortDescription;

    @Column (name = "img")
    public String img;


    public News() {
    }

    public News(String title, String longDescription, String shortDescription, String img) {
        this.title = title;
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
        this.img = img;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
