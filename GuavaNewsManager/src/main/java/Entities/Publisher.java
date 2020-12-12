package Entities;

import Events.NewsEvent;
import Events.NewsReadEvent;
import Events.TopicEvents.*;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class Publisher {
    private EventBus bus;
    private String name;

    public Publisher(String name, EventBus bus) {
        this.name = name;
        this.bus = bus;
        bus.register(this.name);
    }

    public News createNews(String content, Topic topic) {
        News news = new News(this, content, topic);
        postNews(news);

        return news;
    }

    public void modifyNews(News newsToEdit, String content) {
        if (newsToEdit.getAuthor().equals(this)) {
            newsToEdit.setContent(content);
            postNews(newsToEdit);
        }
    }

    private void postNews(News news) {
        NewsEvent event = null;

        switch (news.getTopic()) {
            case Sports:
                event = new SportsNewsEvent(news);
                break;
            case Science:
                event = new ScienceNewsEvent(news);
                break;
            case Health:
                event = new HealthNewsEvent(news);
                break;
            case Technology:
                event = new TechnologyNewsEvent(news);
                break;
            case Medicine:
                event = new MedicineNewsEvent(news);
                break;
        }

        bus.post(event);
    }

    @Subscribe
    private void newsReadEvent(NewsReadEvent event) {
        News newsRead = event.getNews();
        if (newsRead.getAuthor().equals(this.name)) {
            System.out.println(this.name + " stirea ta: " + newsRead.getContent() + " a fost citita de " + newsRead.getNumberOfReads() + " ori.");
        }
    }
}
