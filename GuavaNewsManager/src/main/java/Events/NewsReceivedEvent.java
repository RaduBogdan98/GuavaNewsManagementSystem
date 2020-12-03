package Events;

import Entities.News;

public class NewsReceivedEvent extends NewsEvent {
    public NewsReceivedEvent(News news) {
        super(news);
    }
}
