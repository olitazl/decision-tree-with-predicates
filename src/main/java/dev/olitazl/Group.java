package dev.olitazl;

import lombok.Getter;

import java.util.List;
import java.util.function.Predicate;

@Getter
class Group<T> {
    private String name;
    private List<Predicate<T>> conditions;
    private int priority;

    public Group(String name, List<Predicate<T>> conditions, int priority) {
        this.name = name;
        this.conditions = conditions;
        this.priority = priority;
    }

    public boolean matches(T item) {
        return conditions.stream().allMatch(cond -> cond.test(item));
    }

}
