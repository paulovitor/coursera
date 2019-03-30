package br.com.paulovitor;

import java.util.List;
import java.util.Optional;

public class Badge extends Achievement {

    public Badge(String name) {
        super(name);
    }

    @Override
    public void update(List<Achievement> achievements) {
        Optional<Achievement> optional = achievements.stream()
                .filter(achievement -> achievement instanceof Badge && achievement.getName().equals(name))
                .findFirst();

        if (!optional.isPresent()) {
            achievements.add(this);
        }
    }

    public enum BadgeType {

        I_CAN_TALK("I CAN TALK"),
        LET_ME_ADD("LET ME ADD"),
        INVENTOR("INVENTOR"),
        PART_OF_THE_COMMUNITY("PART OF THE COMMUNITY");

        private String value;

        BadgeType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
