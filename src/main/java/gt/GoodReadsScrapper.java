package gt;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class GoodReadsScrapper {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.goodreads.com/quotes?page=1").get();

        Elements quoteElements = doc.select(".quoteText");

        for (Element e : quoteElements) {

            //read quote text and the author from the body of quoteText css
            //e.text() returns all the visible text inside this element which also includes the author... use ownText to not look at child elements
            String qStr = e.ownText();
            String quoteText = qStr.replaceAll("“", "").replaceAll("”", "");

            //author is inside span inside authorOrTitle class within the current element
            String author = e.select(".authorOrTitle").text();

            //Tags: read sibling element of div with class 'quoteText', choose the one with class 'quoteFooter' and read the  a tags
            Elements tagElements = e.nextElementSiblings().select(".quoteFooter").select(".greyText").select("a");
            List<String> tags = tagElements.stream().map(Element::text).collect(Collectors.toList());

            System.out.println(quoteText + " By:" + author + " , Tags:" + tags);
        }
    }

}