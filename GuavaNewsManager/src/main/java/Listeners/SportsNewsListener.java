package Listeners;

import Events.TopicEvents.SportsNewsEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class SportsNewsListener extends ReaderListener{
    public SportsNewsListener(String readerName, EventBus bus) {
        super(readerName, bus);
    }

    @Subscribe
    private void receiveNews(SportsNewsEvent event){
        this.readNews(event.getNews());
    }
}
