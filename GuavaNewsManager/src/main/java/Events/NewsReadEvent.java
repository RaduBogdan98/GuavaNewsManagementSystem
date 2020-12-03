package Events;

import Entities.News;

public class NewsReadEvent extends NewsEvent{
    public NewsReadEvent(News news) {
        super(news);
    }
}
