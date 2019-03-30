package br.com.paulovitor;

import static br.com.paulovitor.Badge.BadgeType.INVENTOR;

public class CreationAchievementObserver implements AchievementObserver {

    @Override
    public void achievementUpdate(String user, Achievement a) {
        if (a instanceof Points) {
            Points points = (Points) a;
            if (points.isCreationType() && points.isGreaterThanOneHundred()) {
                AchievementStorage achievementStorage = AchievementStorageFactory.getAchievementStorage();
                achievementStorage.addAchievement(user, new Badge(INVENTOR.getValue()));
            }
        }
    }
}
