package Entities;

import Listeners.*;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String name;
    private List<ReaderListener> listeners;

    public Reader(String name, List<Topic> topicsOfInterest, EventBus bus) {
        this.name = name;
        this.listeners = new ArrayList<>();

        for (Topic topic : topicsOfInterest) {
            registerSubscriber(topic, bus);
        }
    }

    private void registerSubscriber(Topic topic, EventBus bus){
        switch (topic){
            case Sports: listeners.add(new SportsNewsListener(this.name, bus)); break;
            case Science: listeners.add(new ScienceNewsListener(this.name, bus)); break;
            case Health: listeners.add(new HealthNewsListener(this.name, bus)); break;
            case Technology: listeners.add(new TechnologyNewsListener(this.name, bus)); break;
            case Medicine: listeners.add(new MedicineNewsListener(this.name, bus)); break;
        }
    }
}
