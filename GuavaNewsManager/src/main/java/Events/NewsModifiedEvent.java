package Events;

import Entities.News;

public class NewsModifiedEvent extends NewsEvent{
    public NewsModifiedEvent(News news) {
        super(news);
    }
}
