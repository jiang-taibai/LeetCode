package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Creation Time: 2024/4/7</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_07 {

    public static void main(String[] args) {
    }

    static class ThroneInheritance {

        static class Person {
            String name;
            boolean alive;
            List<Person> children = new ArrayList<>();

            Person(String name) {
                this.name = name;
                this.alive = true;
            }
        }

        private final Person king;
        private final Map<String, Person> persons = new HashMap<>();

        public ThroneInheritance(String kingName) {
            this.king = new Person(kingName);
            persons.put(kingName, this.king);
        }

        public void birth(String parentName, String childName) {
            Person child = new Person(childName);
            persons.get(parentName).children.add(child);
            persons.put(childName, child);
        }

        public void death(String name) {
            persons.get(name).alive = false;
        }

        public List<String> getInheritanceOrder() {
            return getInheritanceOrder(king);
        }

        private List<String> getInheritanceOrder(Person person) {
            List<String> res = new ArrayList<>();
            if(person.alive) res.add(person.name);
            if (!person.children.isEmpty()) {
                for (Person child : person.children) {
                    res.addAll(getInheritanceOrder(child));
                }
            }
            return res;
        }
    }

}
