package Listeners;

import Events.TopicEvents.TechnologyNewsEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class TechnologyNewsListener extends ReaderListener{
    public TechnologyNewsListener(String readerName, EventBus bus) {
        super(readerName, bus);
    }

    @Subscribe
    private void receiveNews(TechnologyNewsEvent event){
        this.readNews(event.getNews());
    }
}
