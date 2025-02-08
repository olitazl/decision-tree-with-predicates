package dev.olitazl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class DecisionEngine<T> {
    private final List<Group<T>> groups;

    public DecisionEngine() {
        this.groups = new ArrayList<>();
    }

    public void addGroup(Group<T> group) {
        groups.add(group);
        // Sort by priority (higher first)
        groups.sort(Comparator.comparingInt((Group g) -> g.getPriority()).reversed());
    }

    public String decide(T item) {
        return groups.stream()
                     .filter(group -> group.matches(item))
                     .map(Group::getName)
                     .findFirst()
                     .orElse("No Match");
    }
}
