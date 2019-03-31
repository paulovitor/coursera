package br.com.paulovitor;

import static br.com.paulovitor.Badge.BadgeType.PART_OF_THE_COMMUNITY;

public class ParticipationPointsObserver implements AchievementObserver {

    private AchievementStorage achievementStorage;

    public ParticipationPointsObserver(AchievementStorage achievementStorage) {
        this.achievementStorage = achievementStorage;
    }

    @Override
    public void achievementUpdate(String user, Achievement a) {
        if (a instanceof Points) {
            Points points = (Points) a;
            if (points.isParticipationType() && points.getValue() >= 100) {
                achievementStorage.addAchievement(user, new Badge(PART_OF_THE_COMMUNITY.getValue()));
            }
        }
    }
}
