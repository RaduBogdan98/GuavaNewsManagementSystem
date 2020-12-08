package Listeners;

import Events.TopicEvents.ScienceNewsEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class ScienceNewsListener extends ReaderListener{
    public ScienceNewsListener(String readerName, EventBus bus) {
        super(readerName, bus);
    }

    @Subscribe
    private void receiveNews(ScienceNewsEvent event){
        this.readNews(event.getNews());
    }
}
