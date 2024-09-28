package com.dorjear.training.fundamental.hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;


/*
 * Create the Filter and Mapper classes here.
 */

class Filter {

    public static Predicate<String> nameStartingWithPrefix(String prefix) {
        return name -> name.startsWith(prefix);
    }
}
class Mapper {

    public static Function<String, CharactersCount> getDistinctCharactersCount() {
        return name -> {
            Set<Character> distinctChars = new HashSet<>();
            for (char c : name.toCharArray()) {
                distinctChars.add(c);
            }
            return new CharactersCount(name, distinctChars.size());
        };
    }
}
class CharactersCount {
    private final String name;
    private final Integer distinctCharacterCount;

    public CharactersCount(String name, Integer distinctCharacterCount) {
        this.name = name;
        this.distinctCharacterCount = distinctCharacterCount;
    }

    @Override
    public String toString() {
        return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
    }
}

public class FilterAndMapper {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "aaryanna",
                "aayanna",
                "airianna",
                "alassandra",
                "allanna",
                "allannah",
                "allessandra",
                "allianna",
                "allyanna",
                "anastaisa",
                "anastashia",
                "anastasia",
                "annabella",
                "annabelle",
                "annebelle"
        );

        names.stream()
                .filter(Filter.nameStartingWithPrefix(scanner.nextLine()))
                .map(Mapper.getDistinctCharactersCount())
                .forEachOrdered(System.out::println);
    }
}