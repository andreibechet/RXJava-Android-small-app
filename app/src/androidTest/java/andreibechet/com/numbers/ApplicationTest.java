package andreibechet.com.numbers;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    Logger logger = Logger.getLogger("foo");

    public ApplicationTest() {
        super(Application.class);

        logger.info("test");

        Single<List<Integer>> tvShowSingle = Single.fromCallable(new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                return Arrays.asList(1, 2, 3);
            }
        });

        Subscription mTvShowSubscription = tvShowSingle
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<List<Integer>>() {
                    @Override
                    public void onSuccess(List<Integer> numbers) {
                        logger.info(numbers.toString());
                    }

                    @Override
                    public void onError(Throwable error) {
                        logger.info("error " + error.toString());
                    }
                });


        assertEquals(4, 2 + 2);
    }
}