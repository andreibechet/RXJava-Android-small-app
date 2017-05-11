package andreibechet.com.numbers;

import android.util.JsonReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        URL url = new URL("http://foo.bragi.net/numbers.json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(15001);
        conn.setConnectTimeout(15001);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");

        try {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(conn.getInputStream()));

            InputStream in = new BufferedInputStream(conn.getInputStream());
            byte[] bytes = new byte[1000];

            StringBuilder x = new StringBuilder();

            int numRead;
            while ((numRead = in.read(bytes)) >= 0) {
                x.append(new String(bytes, 0, numRead));
            }
//            System.out.println(x.toString());

            JSONObject jsonObject = new JSONObject(x.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("numbers");

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(jsonArray.getInt(i));
            }
            System.out.println(list);

        } finally {
            conn.disconnect();
        }

        assertEquals(4, 2 + 2);
    }

//    @Test
//    public void anything() {
//        Single<List<Integer>> tvShowSingle = Single.fromCallable(new Callable<List<Integer>>() {
//            @Override
//            public List<Integer> call() throws Exception {
//                return Arrays.asList(1, 2, 3);
//            }
//        });
//
//        Subscription mTvShowSubscription = tvShowSingle
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleSubscriber<List<Integer>>() {
//                    @Override
//                    public void onSuccess(List<Integer> tvShows) {
//                        System.out.println(tvShows);
//                    }
//
//                    @Override
//                    public void onError(Throwable error) {
//                        System.out.println("error " + error.toString());
//                    }
//                });
//
//
//        assertEquals(4, 2 + 2);
//    }
}