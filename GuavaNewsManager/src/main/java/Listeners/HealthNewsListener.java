package Listeners;

import Events.TopicEvents.HealthNewsEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class HealthNewsListener extends ReaderListener{
    public HealthNewsListener(String readerName, EventBus bus) {
        super(readerName, bus);
    }

    @Subscribe
    private void receiveNews(HealthNewsEvent event){
        this.readNews(event.getNews());
    }
}
