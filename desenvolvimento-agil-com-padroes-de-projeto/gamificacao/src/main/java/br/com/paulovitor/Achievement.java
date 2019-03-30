package br.com.paulovitor;

import java.util.List;

public abstract class Achievement {

    protected String name;

    public Achievement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void update(List<Achievement> achievements);
}
