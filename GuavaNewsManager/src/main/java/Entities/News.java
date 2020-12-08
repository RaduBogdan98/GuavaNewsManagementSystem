package Entities;

public class News {
    private Publisher author;
    private String content;
    private Topic topic;
    private int numberOfReads;

    public News(Publisher author, String content, Topic topic) {
        this.author = author;
        this.content = content;
        this.topic = topic;
        this.numberOfReads = 0;
    }

    public Publisher getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void read(){
        numberOfReads++;
    }

    public int getNumberOfReads(){
        return  numberOfReads;
    }
}


