package behavioral.observer.baeldung;

public class NewsChannel implements Channel {
    private String news;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @Override
    public void update(Object o) {
        this.setNews((String) o);
    }
}
