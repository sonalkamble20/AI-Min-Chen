import java.util.Map;

public class Meme {
    private final String caption;
    private final String imageUrl;
    private final Map<String, Integer> keywords; // key = keyword, value = relevance weight

    public Meme(String caption, String imageUrl, Map<String, Integer> keywords) {
        this.caption = caption;
        this.imageUrl = imageUrl;
        this.keywords = keywords;
    }

    public String getCaption() {
        return caption;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Map<String, Integer> getKeywords() {
        return keywords;
    }
}
