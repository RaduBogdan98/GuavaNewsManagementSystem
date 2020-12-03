package Entities;

import Events.NewsReadEvent;
import Events.NewsReceivedEvent;
import com.google.common.eventbus.Subscribe;

public class Reader {
    private String name;
    private String topicOfInterest;

    public Reader(String name, String topicOfInterest) {
        this.name = name;
        this.topicOfInterest = topicOfInterest;
        BusManager.getInstance().subscribe(this);
    }

    @Subscribe
    private void receiveNews(NewsReceivedEvent event) {
        NewsReadEvent readEvent = new NewsReadEvent(event.getNews());

        System.out.println(this.name + " a citit stirea: "+event.getNews().getContent());
        BusManager.getInstance().postEvent(readEvent);
    }

    public String getTopicOfInterest() {
        return topicOfInterest;
    }
}
