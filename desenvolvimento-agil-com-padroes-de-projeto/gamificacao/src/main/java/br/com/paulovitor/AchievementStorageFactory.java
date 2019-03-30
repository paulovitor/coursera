package br.com.paulovitor;

public class AchievementStorageFactory {

    private static AchievementStorage achievementStorage;

    private AchievementStorageFactory() {

    }

    public static AchievementStorage getAchievementStorage() {
        if (achievementStorage == null) {
            achievementStorage = new MemoryAchievementStorage();
        }
        return achievementStorage;
    }

    public static void setAchievementStorage(AchievementStorage a) {
        achievementStorage = a;
    }
}
