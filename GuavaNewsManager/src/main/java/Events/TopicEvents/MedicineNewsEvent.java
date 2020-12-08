package Events.TopicEvents;

import Entities.News;
import Events.NewsEvent;

public class MedicineNewsEvent extends NewsEvent {
    public MedicineNewsEvent(News news) {
        super(news);
    }
}
