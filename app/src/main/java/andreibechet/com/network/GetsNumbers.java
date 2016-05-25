package andreibechet.com.network;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import andreibechet.com.configuration.Configurations;

public class GetsNumbers {
    public final List<Integer> numbers = new ArrayList<>();

    public GetsNumbers(final String httpAddress) {
        try {
            extractNumbersFrom(httpConnectionFrom(new URL(httpAddress)));
        } catch (Exception e) {
            Log.e(Configurations.APP_LOG_TAG, Configurations.EXCEPTION_TAG, e);
        }
    }

    private void extractNumbersFrom(final HttpURLConnection connection) throws IOException, JSONException {
        try {
            JSONArray jsonArray = new JSONObject(jsonStringFrom(connection.getInputStream())).getJSONArray("numbers");
            for (int i = 0; i < jsonArray.length(); i++) {
                numbers.add(jsonArray.getInt(i));
            }
        } finally {
            connection.disconnect();
        }
    }

    private String jsonStringFrom(final InputStream in) throws IOException {
        byte[] bytes = new byte[1000];
        StringBuilder jsonStringBuilder = new StringBuilder();
        int numRead;
        while ((numRead = in.read(bytes)) >= 0) {
            jsonStringBuilder.append(new String(bytes, 0, numRead));
        }
        return jsonStringBuilder.toString();
    }

    private HttpURLConnection httpConnectionFrom(final URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setReadTimeout(15001);
        connection.setConnectTimeout(15001);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("GET");
        return connection;
    }

}
