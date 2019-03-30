package br.com.paulovitor;

import static br.com.paulovitor.Badge.BadgeType.INVENTOR;

public class CreationAchievementObserver implements AchievementObserver {

    private AchievementStorage achievementStorage;

    public CreationAchievementObserver(AchievementStorage achievementStorage) {
        this.achievementStorage = achievementStorage;
    }

    @Override
    public void achievementUpdate(String user, Achievement a) {
        if (a instanceof Points) {
            Points points = (Points) a;
            if (points.isCreationType() && points.isGreaterThanOneHundred()) {
                achievementStorage.addAchievement(user, new Badge(INVENTOR.getValue()));
            }
        }
    }
}
