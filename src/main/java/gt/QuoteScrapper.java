package gt;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface QuoteScrapper {


    List<Quote> getQuotes() throws RuntimeException, IOException;

    static Optional<QuoteScrapper> getInstance(Source source) {
        switch (source) {
            case GOOD_READS:
                return Optional.of(new GoodReadsScrapper());

            //add other types
        }

        return Optional.empty();
    }

}
