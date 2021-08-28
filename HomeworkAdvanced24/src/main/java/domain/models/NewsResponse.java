package domain.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlType()
@XmlRootElement(name = "root")
public class NewsResponse {

    private String name;
    private String location;

    @XmlElement(name = "element")
    @XmlElementWrapper
    ArrayList <Article> news = new ArrayList <Article>();


    // Getter Methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Article> getNews() {
        return news;
    }

    public String getLocation() {
        return location;
    }


    @Override
    public String toString() {
        return "NewsResponse{" + "\n" +
                "news=" + news + "\n" +
                "name='" + name + "\n" +
                "location='" + location + "\n" +
                '}';
    }
}