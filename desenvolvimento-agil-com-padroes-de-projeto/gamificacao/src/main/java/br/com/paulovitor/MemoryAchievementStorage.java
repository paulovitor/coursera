package br.com.paulovitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryAchievementStorage implements AchievementStorage {

    private Map<String, List<Achievement>> achievements = new HashMap<>();
    private List<AchievementObserver> observers = new ArrayList<>();

    @Override
    public void addAchievement(String user, Achievement a) {
        if (!achievements.containsKey(user)) {
            achievements.put(user, new ArrayList<>());
        }

        List<Achievement> saved = achievements.get(user);
        a.update(saved);

        achievements.put(user, saved);
        observers.forEach(achievementObserver -> achievementObserver.achievementUpdate(user, a));
    }

    @Override
    public List<Achievement> getAchievements(String user) {
        return achievements.get(user);
    }

    @Override
    public Achievement getAchievement(String user, String achievementName) {
        return achievements.get(user).stream()
                .filter(achievement -> achievement.getName().equals(achievementName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addObserver(AchievementObserver achievementObserver) {
        observers.add(achievementObserver);
    }
}
