package data.dateAdapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static data.utils.Consts.DATE_FORMAT;

public class DateXmlAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat dateFormat =
            new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);

    @Override
    public Date unmarshal(final String v) throws Exception {
        return dateFormat.parse(v);
    }

    @Override
    public String marshal(final Date v) throws Exception {
        return dateFormat.format(v);
    }

}


