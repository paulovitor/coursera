package br.com.paulovitor;

import java.util.List;
import java.util.Optional;

import static br.com.paulovitor.Points.PointsType.CREATION;
import static br.com.paulovitor.Points.PointsType.PARTICIPATION;

public class Points extends Achievement {

    private int value;

    public Points(String name, int value) {
        super(name);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void plusValue(int newValue) {
        this.value += newValue;
    }

    public boolean isGreaterThanOneHundred() {
        return value >= 100;
    }

    public boolean isCreationType() {
        return name.equals(CREATION.getValue());
    }

    public boolean isParticipationType() {
        return name.equals(PARTICIPATION.getValue());
    }

    @Override
    public void update(List<Achievement> achievements) {
        Optional<Achievement> optional = achievements.stream()
                .filter(achievement -> achievement instanceof Points && achievement.getName().equals(name))
                .findFirst();

        if (optional.isPresent()) {
            Points points = (Points) optional.get();
            plusValue(points.getValue());
            achievements.remove(points);
        }
        achievements.add(this);
    }

    public enum PointsType {

        CREATION("CREATION"),
        PARTICIPATION("PARTICIPATION");

        private String value;

        PointsType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
