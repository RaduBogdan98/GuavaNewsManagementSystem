package Listeners;

import Entities.News;
import Events.NewsReadEvent;
import com.google.common.eventbus.EventBus;

public abstract class ReaderListener {
    private EventBus bus;
    private String readerName;

    public ReaderListener(String readerName, EventBus bus){
        this.readerName = readerName;
        this.bus = bus;
        bus.register(this);
    }

    protected void readNews(News news){
        news.read();
        System.out.println(readerName + " a citit: " + news.getContent());

        bus.register(news.getAuthor());

        NewsReadEvent readEvent = new NewsReadEvent(news);
        bus.post(readEvent);

        bus.unregister(news.getAuthor());
    }
}
