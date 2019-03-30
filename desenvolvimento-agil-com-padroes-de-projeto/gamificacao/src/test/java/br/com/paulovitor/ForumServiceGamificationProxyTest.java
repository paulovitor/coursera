package br.com.paulovitor;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static br.com.paulovitor.Badge.BadgeType.*;
import static br.com.paulovitor.Points.PointsType.CREATION;
import static br.com.paulovitor.Points.PointsType.PARTICIPATION;
import static org.junit.Assert.*;

public class ForumServiceGamificationProxyTest {

    private AchievementStorage achievementStorage;
    private ForumService forumService;
    private String paulo = "Paulo";
    private String josé = "José";

    @Before
    public void setUp() {
        AchievementStorage memoryAchievementStorage = new MemoryAchievementStorage();
        memoryAchievementStorage.addObserver(new CreationAchievementObserver(memoryAchievementStorage));
        memoryAchievementStorage.addObserver(new ParticipationAchievementObserver(memoryAchievementStorage));

        AchievementStorageFactory.setAchievementStorage(memoryAchievementStorage);
        achievementStorage = AchievementStorageFactory.getAchievementStorage();
    }

    @Test
    public void shouldAddTopic() {
        // give
        forumService = new ForumServiceGamificationProxy(new MockForumService(), achievementStorage);

        // when
        forumService.addTopic(paulo, "Topic");

        // then
        assertAchievements(paulo, 2);
        assertPoints(paulo, CREATION.getValue(), 5);
        assertBadge(paulo, I_CAN_TALK.getValue());
    }

    @Test
    public void shouldAddComment() {
        // give
        forumService = new ForumServiceGamificationProxy(new MockForumService(), achievementStorage);

        // when
        forumService.addComment(paulo, "Topic", "Comment");

        // then
        assertAchievements(paulo, 2);
        assertPoints(paulo, PARTICIPATION.getValue(), 3);
        assertBadge(paulo, LET_ME_ADD.getValue());
    }

    @Test
    public void shouldLikeTopic() {
        // give
        forumService = new ForumServiceGamificationProxy(new MockForumService(), achievementStorage);

        // when
        forumService.likeTopic(paulo, "Topic", josé);

        // then
        assertAchievements(paulo, 1);
        assertPoints(paulo, CREATION.getValue(), 1);
    }

    @Test
    public void shouldLikeComment() {
        // give
        forumService = new ForumServiceGamificationProxy(new MockForumService(), achievementStorage);

        // when
        forumService.likeComment(paulo, "Topic", "Comment", josé);

        // then
        assertAchievements(paulo, 1);
        assertPoints(paulo, PARTICIPATION.getValue(), 1);
    }

    @Test
    public void shouldAddTopicAndPlusPointsAndHasOneBadge() {
        // give
        forumService = new ForumServiceGamificationProxy(new MockForumService(), achievementStorage);

        // when
        forumService.addTopic(paulo, "Topic");
        forumService.addTopic(paulo, "Topic2");

        // then
        assertAchievements(paulo, 2);
        assertPoints(paulo, CREATION.getValue(), 10);
        assertBadge(paulo, I_CAN_TALK.getValue());
    }

    @Test
    public void shouldAddTopicAddCommentAndLikes() {
        // give
        forumService = new ForumServiceGamificationProxy(new MockForumService(), achievementStorage);

        // when
        forumService.addTopic(paulo, "Topic");
        forumService.addComment(paulo, "Topic", "Comment");
        forumService.likeTopic(paulo, "Topic", josé);
        forumService.likeComment(paulo, "Topic", "Comment", josé);

        // then
        assertAchievements(paulo, 4);
        assertPoints(paulo, CREATION.getValue(), 6);
        assertPoints(paulo, PARTICIPATION.getValue(), 4);
        assertBadge(paulo, I_CAN_TALK.getValue());
        assertBadge(paulo, LET_ME_ADD.getValue());
    }

    @Test
    public void shouldThrowException() {
        // give
        forumService = new ForumServiceGamificationProxy(new MockWithExceptionForumService(), achievementStorage);

        // when
        try {
            forumService.addTopic(paulo, "Topic");
            fail();
        } catch (Exception e) {

            // then
            List<Achievement> achievements = achievementStorage.getAchievements(paulo);
            assertNull(achievements);
        }
    }

    @Test
    public void shouldAddTopicToOtherUsers() {
        // give
        forumService = new ForumServiceGamificationProxy(new MockForumService(), achievementStorage);

        // when
        forumService.addTopic(paulo, "Topic");
        forumService.addTopic(josé, "Topic");

        // then
        assertAchievements(paulo, 2);
        assertAchievements(josé, 2);
        assertPoints(paulo, CREATION.getValue(), 5);
        assertBadge(paulo, I_CAN_TALK.getValue());
        assertPoints(josé, CREATION.getValue(), 5);
        assertBadge(josé, I_CAN_TALK.getValue());
    }

    @Test
    public void shouldAddTopicUntilReachOneHundredPoints() {
        // give
        forumService = new ForumServiceGamificationProxy(new MockForumService(), achievementStorage);

        // when
        IntStream.range(0, 20).forEach(number -> forumService.addTopic(paulo, "Topic" + number));

        // then
        assertAchievements(paulo, 3);
        assertPoints(paulo, CREATION.getValue(), 100);
        assertBadge(paulo, I_CAN_TALK.getValue());
        assertBadge(paulo, INVENTOR.getValue());
    }

    @Test
    public void shouldAddCommentUntilReachOneHundredPoints() {
        // give
        forumService = new ForumServiceGamificationProxy(new MockForumService(), achievementStorage);

        // when
        IntStream.range(0, 34).forEach(number -> forumService.addComment(paulo, "Topic" + number, "Comment" + number));

        // then
        assertAchievements(paulo, 3);
        assertPoints(paulo, PARTICIPATION.getValue(), 102);
        assertBadge(paulo, LET_ME_ADD.getValue());
        assertBadge(paulo, PART_OF_THE_COMMUNITY.getValue());
    }

    private void assertAchievements(String user, int size) {
        List<Achievement> achievements = achievementStorage.getAchievements(user);
        assertNotNull(achievements);
        assertEquals(size, achievements.size());
    }

    private void assertPoints(String user, String topic, int expected) {
        Achievement points = achievementStorage.getAchievement(user, topic);
        assertNotNull(points);
        assertEquals(topic, points.getName());
        assertEquals(expected, ((Points) points).getValue());
    }

    private void assertBadge(String user, String badgeName) {
        Achievement badge = achievementStorage.getAchievement(user, badgeName);
        assertNotNull(badge);
        assertEquals(badgeName, badge.getName());
    }
}