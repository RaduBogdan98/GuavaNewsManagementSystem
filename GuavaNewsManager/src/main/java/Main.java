import Entities.News;
import Entities.Publisher;
import Entities.Reader;
import Entities.Topic;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        EventBus bus = new EventBus();
        ArrayList<Topic> topics1 = new ArrayList<>(Arrays.asList(Topic.Sports, Topic.Science));
        ArrayList<Topic> topics2 = new ArrayList<>(Arrays.asList(Topic.Science));

        Publisher radu = new Publisher("Radu", bus);
        Publisher edy = new Publisher("Edy", bus);

        Reader samy = new Reader("Samy", topics1, bus);
        Reader david = new Reader("David", topics1, bus);
        Reader iulia = new Reader("Iulia", topics2, bus);

        radu.createNews("S-a dat gol in Romania", Topic.Sports);
        News newsToModify = radu.createNews("A castigat Lakers NBA", Topic.Sports);
        radu.createNews("Descoperire noua in stiinta", Topic.Science);
        radu.createNews("Ochelarii 3D", Topic.Science);

        radu.modifyNews(newsToModify,"Defapt a castigat Heat");

        edy.createNews("S-a dat gol in Romania", Topic.Sports);

        radu.createNews("Covid vaccine found!",Topic.Health);
    }
}
