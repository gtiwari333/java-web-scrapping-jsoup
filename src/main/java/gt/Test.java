package gt;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import static java.lang.System.out;

public class Test {


    public static void main(String[] args) {

        String html = "<rootElement> " +
                "   <aTag width='10' height='20' color='RED' class='C1'>  " +
                "        <content>Hello</content> " +
                "    </aTag>" +
                "   <aTag width='10' height='20' color='GREEN' class='C1'>  " +
                "        <content class = 'small-font'>Hello Again small font</content> " +
                "    </aTag>" +
                "    <summary>" +
                "       <content class = 'small-font'> This is summary in small font </content>" +
                "    </summary> " +
                "</rootElement>";

        Document doc = Jsoup.parse(html);

        //print all content element
        /*
        it prints:
            Hello
            Hello Again small font
            This is summary in small font
         */
        Elements els = doc.select("content");
        for (Element e : els) {
            out.println(e.text());
        }

        //text inside content element under aTag
        /*
        it prints:
            Hello
            Hello Again small font
         */
        for (Element e : doc.select("aTag > content")) {
            out.println(e.text());
        }

        //get all elements that have a color attribute and display the value of the attribute
        /*
        int prints
            RED
            GREEN
         */
        for (Element e : doc.getElementsByAttribute("color")) {
            out.println(e.attributes().get("color"));
        }

        //get all elements that have a attribute class = C1 attribute and display the value of the attribute
        /*
        int prints
            RED
            GREEN
         */
        for (Element e : doc.select(".C1")) {
            out.println(e.attributes().get("color"));
        }

        //read text inside a tag
                /*
        it prints:
            Hello Again small font
            This is summary in small font
         */
        for (Element e : doc.select(".small-font")) {
            out.println(e.text());
        }

    }
}
