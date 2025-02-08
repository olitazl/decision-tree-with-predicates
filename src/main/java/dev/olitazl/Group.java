package dev.olitazl;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.function.Predicate;

@Getter
@AllArgsConstructor
class Group<T> {
    private String name;
    private List<Predicate<T>> conditions;
    private int priority;

    public boolean matches(T item) {
        return conditions.stream().allMatch(cond -> cond.test(item));
    }
}
