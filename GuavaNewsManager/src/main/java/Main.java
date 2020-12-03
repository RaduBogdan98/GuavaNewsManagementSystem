import Entities.News;
import Entities.Publisher;
import Entities.Reader;

public class Main {
    public static void main(String args[]){
        Publisher radu = new Publisher("Radu");
        Publisher edy = new Publisher("Edy");

        Reader samy = new Reader("Samy", "sports");
        Reader david = new Reader("David", "sports");
        Reader iulia = new Reader("Iulia", "science");

        radu.createNews("S-a dat gol in Romania", "sports");
        News newsToModify = radu.createNews("A castigat Lakers NBA", "sports");
        radu.createNews("Descoperire noua in stiinta", "science");
        radu.createNews("Ochelarii 3D", "science");

        radu.modifyNews(newsToModify,"Defapt a castigat Heat");

        edy.createNews("S-a dat gol in Romania", "sports");

        radu.createNews("radom content","random");
    }
}
