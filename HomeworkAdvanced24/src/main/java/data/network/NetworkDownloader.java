//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package data.network;

import javax.net.ssl.HttpsURLConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class NetworkDownloader {

    public static void downloadFile(String pathName, String url) {

        File file = new File(pathName);
        InputStream inputStream = null;

        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            URL apiUrl = new URL(url);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) apiUrl.openConnection();
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode == 200) {
                inputStream = httpsURLConnection.getInputStream();
                byte[] buffer = new byte[1024];

                int byteRead;
                while ((byteRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, byteRead);
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
