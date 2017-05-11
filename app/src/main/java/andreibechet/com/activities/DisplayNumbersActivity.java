package andreibechet.com.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import andreibechet.com.configuration.Configurations;
import andreibechet.com.numbers.R;
import andreibechet.com.sections.Sections;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DisplayNumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_numbers);


        final ProvideContent content = new ProvideContent(Configurations.BRAGI_TEST_ADDRESS);
        Subscription contentObserver = content.contentObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<Sections>() {
                    @Override
                    public void onSuccess(Sections sections) {
                        System.out.println(sections.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(Configurations.APP_LOG_TAG, Configurations.EXCEPTION_TAG, e);
                    }
                });
    }
}
