package Events.TopicEvents;

import Entities.News;
import Events.NewsEvent;

public class SportsNewsEvent extends NewsEvent {
    public SportsNewsEvent(News news) {
        super(news);
    }
}
