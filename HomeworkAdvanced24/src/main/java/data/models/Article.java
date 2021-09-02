package data.models;

import data.dateAdapters.DateXmlAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;

@XmlRootElement(name = "element")
@XmlType
public class Article {

    private int id;
    private String title;
    private String description;
    private Date date;

    @XmlElement(name = "element")
    @XmlElementWrapper
    ArrayList <String> keywords = new ArrayList <String>();

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id + "\n" +
                "title='" + title + "\n" +
                "description='" + description + "\n" +
                "date='" + date + "\n" +
                "keywords=" + keywords + "\n" +
                "visible=" + visible + "\n" +
                '}';
    }

    private boolean visible;


    // Getter Methods

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @XmlJavaTypeAdapter(DateXmlAdapter.class)
    public Date getDate() {
        return date;
    }

    public boolean getVisible() {
        return visible;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public boolean isVisible() {
        return visible;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
