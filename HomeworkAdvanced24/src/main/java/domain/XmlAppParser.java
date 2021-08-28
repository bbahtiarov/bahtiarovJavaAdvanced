package domain;

import domain.models.Article;
import domain.models.NewsResponse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;

public class XmlAppParser implements BaseParser {

    @Override
    public NewsResponse parse(String pathName) {

        NewsResponse newsResponse;
        try (FileReader reader = new FileReader(pathName)){

            JAXBContext context = JAXBContext.newInstance(NewsResponse.class, Article.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            newsResponse = (NewsResponse) unmarshaller.unmarshal(reader);

            return newsResponse;

        } catch (JAXBException | IOException e) {
            e.printStackTrace();

        }

        return null;
    }

}
