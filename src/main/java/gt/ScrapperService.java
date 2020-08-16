package gt;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ScrapperService {
    public static void main(String[] args) {
        for (Source source : Source.values()) {
            try {
                Optional<QuoteScrapper> scraper = QuoteScrapper.getInstance(source);
                if (!scraper.isPresent()) {
                    System.out.println("Scrapper not implemented for " + source);
                    continue;
                }

                List<Quote> quotes = scraper.get().getQuotes();
                System.out.println("Found  " + quotes.size() + " quotes from  " + source);

            } catch (IOException e) {
                System.err.println("Failed to read quotes " + e);
                e.printStackTrace();
            }
        }

    }
}
