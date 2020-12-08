package Events;

import Entities.News;

public abstract class NewsEvent{
    private News news;

    public NewsEvent(News news) {
        this.news = news;
    }

    public News getNews() {
        return news;
    }
}
