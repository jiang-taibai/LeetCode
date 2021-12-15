package com.coderjiang.DailyPractice.Monthly_2021_12;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Creation Time: 2021-12-15 10:18:27</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_12_15 {

    class Solution {
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            Person[] persons = new Person[quiet.length];
            for (int i = 0; i < quiet.length; i++) {
                persons[i] = new Person(i, quiet[i]);
            }
            for (int[] pair : richer) {
                persons[pair[1]].richer.add(persons[pair[0]]);
            }
            int[] res = new int[quiet.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = find(persons[i]).code;
            }
            return res;
        }

        private Person find(Person person) {
            if (person.minQuietInAllRicher != null) return person.minQuietInAllRicher;
            Person minPerson = person;
            for (Person richerPerson : person.richer) {
                Person temp = find(richerPerson);
                if (temp.quiet < minPerson.quiet) {
                    minPerson = temp;
                }
            }
            person.minQuietInAllRicher = minPerson;
            return minPerson;
        }

        class Person {
            int code;
            int quiet;
            List<Person> richer;
            Person minQuietInAllRicher;

            Person(int code, int quiet) {
                this.code = code;
                this.quiet = quiet;
                richer = new ArrayList<>();
                minQuietInAllRicher = null;
            }
        }
    }

}

/*

0
  1
    2
    3
      4
      5
      6
7
  3
* person.code = 0
person.quiet = 3
person.code = 1
person.quiet = 2
person.code = 2
person.quiet = 5
person.code = 3
person.quiet = 4
person.code = 4
person.quiet = 6
person.code = 5
person.quiet = 1
person.code = 6
person.quiet = 7

person.code = 1
person.quiet = 2
person.code = 2
person.quiet = 5
person.code = 3
person.quiet = 4
person.code = 4
person.quiet = 6
person.code = 5
person.quiet = 1
person.code = 6
person.quiet = 7

person.code = 2
person.quiet = 5

person.code = 3
person.quiet = 4
person.code = 4
person.quiet = 6
person.code = 5
person.quiet = 1
person.code = 6
person.quiet = 7

person.code = 4
person.quiet = 6

person.code = 5
person.quiet = 1

person.code = 6
person.quiet = 7

person.code = 7
person.quiet = 0
person.code = 3
person.quiet = 4
person.code = 4
person.quiet = 6
person.code = 5
person.quiet = 1
person.code = 6
person.quiet = 7


* */
