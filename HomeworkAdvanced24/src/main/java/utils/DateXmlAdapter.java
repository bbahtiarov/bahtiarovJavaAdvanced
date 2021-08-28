package utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateXmlAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyy-MM-dd HH:mm:ss zzz", Locale.ENGLISH);

    @Override
    public Date unmarshal(final String v) throws Exception {
        return dateFormat.parse(v);
    }

    @Override
    public String marshal(final Date v) throws Exception {
        return dateFormat.format(v);
    }

}


