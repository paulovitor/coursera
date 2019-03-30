package br.com.paulovitor;

import static br.com.paulovitor.Badge.BadgeType.I_CAN_TALK;
import static br.com.paulovitor.Badge.BadgeType.LET_ME_ADD;
import static br.com.paulovitor.Points.PointsType.CREATION;
import static br.com.paulovitor.Points.PointsType.PARTICIPATION;

public class ForumServiceGamificationProxy implements ForumService {

    private ForumService forumService;
    private AchievementStorage achievementStorage;

    public ForumServiceGamificationProxy(ForumService forumService, AchievementStorage achievementStorage) {
        this.forumService = forumService;
        this.achievementStorage = achievementStorage;
    }

    @Override
    public void addTopic(String user, String topic) {
        forumService.addTopic(user, topic);
        achievementStorage.addAchievement(user, new Points(CREATION.getValue(), 5));
        achievementStorage.addAchievement(user, new Badge(I_CAN_TALK.getValue()));
    }

    @Override
    public void addComment(String user, String topic, String comment) {
        forumService.addComment(user, topic, comment);
        achievementStorage.addAchievement(user, new Points(PARTICIPATION.getValue(), 3));
        achievementStorage.addAchievement(user, new Badge(LET_ME_ADD.getValue()));
    }

    @Override
    public void likeTopic(String user, String topic, String topicUser) {
        forumService.likeTopic(user, topic, topicUser);
        achievementStorage.addAchievement(user, new Points(CREATION.getValue(), 1));
    }

    @Override
    public void likeComment(String user, String topic, String comment, String commentUser) {
        forumService.likeComment(user, topic, comment, commentUser);
        achievementStorage.addAchievement(user, new Points(PARTICIPATION.getValue(), 1));
    }
}
