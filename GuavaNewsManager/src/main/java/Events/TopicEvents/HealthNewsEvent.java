package Events.TopicEvents;

import Entities.News;
import Events.NewsEvent;

public class HealthNewsEvent extends NewsEvent {
    public HealthNewsEvent(News news) {
        super(news);
    }
}
