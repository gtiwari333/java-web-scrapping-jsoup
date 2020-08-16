package gt;

import java.util.List;

public class Quote {

    public Source source;

    public String author;

    public String content;

    public List<String> tags;

    public Quote(Source source, String author, String content, List<String> tags) {
        this.source = source;
        this.author = author;
        this.content = content;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "source=" + source +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", tags=" + tags +
                "}\n";
    }
}
