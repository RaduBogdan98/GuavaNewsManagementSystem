package Entities;

import Events.*;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.*;
import java.util.stream.Collectors;

public class BusManager {
    private static BusManager instance;

    private EventBus eventBus;
    private List<Reader> subscribedReaders;
    private List<Publisher> subscribedPublishers;

    private BusManager() {
        subscribedReaders = new ArrayList<>();
        subscribedPublishers = new ArrayList<>();
        this.eventBus = new EventBus();
        eventBus.register(this);
    }

    public static BusManager getInstance() {
        if (instance == null) {
            instance = new BusManager();
        }

        return instance;
    }

    public void subscribe(Reader reader) {
        subscribedReaders.add(reader);
    }

    public void subscribe(Publisher publisher) {
        subscribedPublishers.add(publisher);
    }

    public void postEvent(NewsEvent event){
        eventBus.post(event);
    }

    @Subscribe
    private void onNewsCreated(NewsCreatedEvent event) {
        if(subscribedReaders!=null) {
            sendNewsReceivedEvent(event.getNews());
        }
    }

    @Subscribe
    private void onNewsModified(NewsModifiedEvent event) {
        if(subscribedReaders!=null) {
            sendNewsReceivedEvent(event.getNews());
        }
    }

    @Subscribe
    private void onNewsRead(NewsReadEvent event) {
        eventBus.unregister(this);
        News readNews = event.getNews();

        Publisher interestedPublisher = subscribedPublishers.stream().filter((x) -> x.isInterestedInNews(readNews)).findFirst().orElse(null);
        if (interestedPublisher != null) {
            eventBus.register(interestedPublisher);
            eventBus.post(event);
            eventBus.unregister(interestedPublisher);
        }

        eventBus.register(this);
    }

    private void sendNewsReceivedEvent(News news){
        List<Reader> interestedReaders = subscribedReaders.stream()
                .filter((x) -> x.getTopicOfInterest().equals(news.getTopic()))
                .collect(Collectors.toList());

        for (Reader reader : interestedReaders) {
            eventBus.register(reader);
        }

        eventBus.post(new NewsReceivedEvent(news));

        for (Reader reader : interestedReaders) {
            eventBus.unregister(reader);
        }
    }
}
