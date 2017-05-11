package andreibechet.com.activities;

import java.util.concurrent.Callable;

import andreibechet.com.network.GetsNumbers;
import andreibechet.com.numbers.ParseNumber;
import andreibechet.com.sections.Item;
import andreibechet.com.sections.Section;
import andreibechet.com.sections.Sections;
import rx.Single;

public class ProvideContent {
    public final Single<Sections> contentObservable;

    public ProvideContent(final String httpAddress) {
        contentObservable = Single.fromCallable(new Callable<Sections>() {
            @Override
            public Sections call() throws Exception {
                Sections sections = new Sections();
                GetsNumbers numbersProvider = new GetsNumbers(httpAddress);

                for (Integer number: numbersProvider.numbers) {
                    ParseNumber parser = new ParseNumber(number);
                    Section newSection = new Section(parser.sectionNumber);
                    newSection.add(new Item(parser.itemNumber, parser.checked));
                    sections.add(newSection);
                }

                return new Sections();
            }
        });
    }
}
