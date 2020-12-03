package Entities;

import Events.NewsCreatedEvent;
import Events.NewsModifiedEvent;
import Events.NewsReadEvent;
import com.google.common.eventbus.Subscribe;

import java.util.*;

public class Publisher {
    private String name;
    private Map<News, Integer> createdNewsMap;

    public Publisher(String name) {
        this.name = name;
        createdNewsMap = new HashMap<>();
        BusManager.getInstance().subscribe(this);
    }

    public News createNews(String content, String topic) {
        News news = new News(this.name, content, topic);
        NewsCreatedEvent event = new NewsCreatedEvent(news);

        createdNewsMap.put(news, 0);
        BusManager.getInstance().postEvent(event);

        return news;
    }

    public void modifyNews(News newsToEdit, String content) {
        if (createdNewsMap.containsKey(newsToEdit)) {
            newsToEdit.setContent(content);
            NewsModifiedEvent event = new NewsModifiedEvent(newsToEdit);

            BusManager.getInstance().postEvent(event);
        }
    }

    public boolean isInterestedInNews(News news) {
        return createdNewsMap.containsKey(news);
    }

    @Subscribe
    private void newsReadEvent(NewsReadEvent event) {
        News newsRead = event.getNews();
        createdNewsMap.put(newsRead, createdNewsMap.get(newsRead) + 1);

        System.out.println(this.name + " stirea ta: " + newsRead.getContent() + " a fost citita de " + createdNewsMap.get(newsRead) + " ori.");
    }
}
