package Events;

import Entities.News;

public class NewsCreatedEvent extends NewsEvent {
    public NewsCreatedEvent(News news) {
        super(news);
    }
}
