package dev.olitazl;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Main {
    public static void main(String[] args) {
        DecisionEngine<Person> engine = new DecisionEngine<>();

        engine.addGroup(new Group<>("Young & Low Income", 
            Arrays.asList(p -> p.getAge() < 30, p -> p.getIncome() < 50000),
            1)); // Lower priority

        engine.addGroup(new Group<>("Young & High Income", 
            Arrays.asList(p -> p.getAge() < 30, p -> p.getIncome() >= 50000),
            2)); // Higher priority

        engine.addGroup(new Group<>("Old & Low Income", 
            Arrays.asList(p -> p.getAge() >= 30, p -> p.getIncome() < 50000),
            1)); // Lower priority

        engine.addGroup(new Group<>("Old & High Income", 
            Arrays.asList(p -> p.getAge() >= 30, p -> p.getIncome() >= 50000),
            2)); // Higher priority

        // Test case: 28-year-old earning $60,000
        Person person = new Person(28, 60000);
        String category = engine.decide(person);
        log.info("Person belongs to: " + category);
        // Output: "Young & High Income"
    }
}
