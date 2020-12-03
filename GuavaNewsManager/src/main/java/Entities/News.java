package Entities;

public class News {
    private String author;
    private String content;
    private String topic;

    public News(String author, String content, String topic) {
        this.author = author;
        this.content = content;
        this.topic = topic;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getTopic() {
        return topic;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
