package Listeners;

import Events.TopicEvents.MedicineNewsEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class MedicineNewsListener extends ReaderListener{
    public MedicineNewsListener(String readerName, EventBus bus) {
        super(readerName, bus);
    }

    @Subscribe
    private void receiveNews(MedicineNewsEvent event){
        this.readNews(event.getNews());
    }
}
