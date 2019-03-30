package br.com.paulovitor;

import static br.com.paulovitor.Badge.BadgeType.PART_OF_THE_COMMUNITY;

public class ParticipationAchievementObserver implements AchievementObserver {

    @Override
    public void achievementUpdate(String user, Achievement a) {
        if (a instanceof Points) {
            Points points = (Points) a;
            if (points.isParticipationType() && points.getValue() >= 100) {
                AchievementStorage achievementStorage = AchievementStorageFactory.getAchievementStorage();
                achievementStorage.addAchievement(user, new Badge(PART_OF_THE_COMMUNITY.getValue()));
            }
        }
    }
}
