package br.com.paulovitor;

public class MockWithExceptionForumService implements ForumService {

    @Override
    public void addTopic(String user, String topic) {
        throw new RuntimeException();
    }

    @Override
    public void addComment(String user, String topic, String comment) {
        throw new RuntimeException();
    }

    @Override
    public void likeTopic(String user, String topic, String topicUser) {
        throw new RuntimeException();
    }

    @Override
    public void likeComment(String user, String topic, String comment, String commentUser) {
        throw new RuntimeException();
    }
}
