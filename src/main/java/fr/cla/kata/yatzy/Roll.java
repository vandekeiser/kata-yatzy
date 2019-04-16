package fr.cla.kata.yatzy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Roll {
    private final int d1, d2, d3, d4, d5;

    private Roll(int d1, int d2, int d3, int d4, int d5) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.d4 = d4;
        this.d5 = d5;
        validate();
    }

    public static Roll roll(int d1, int d2, int d3, int d4, int d5) {
        return new Roll(d1, d2, d3, d4, d5);
    }

    public int sumOfAllDice() {
        return diceRolls().sum();
    }

    public boolean allDiceHaveTheSameNumber() {
        return diceRolls().boxed().collect(toSet()).size() == 1;
    }

    public int count(int needle) {
        return Collections.frequency(
            diceRolls().boxed().collect(toList()),
            needle
        );
    }




    private IntStream diceRolls() {
        return IntStream.of(d1, d2, d3, d4, d5);
    }

    private void validate() {
        diceRolls().forEach(this::validate);
    }

    private void validate(int dieRoll) {
        if(dieRoll<1 || dieRoll>6) throw new IllegalArgumentException(String.format(
            "Expected parameter dieRoll in [1,6], was %d", dieRoll
        ));
    }

    public Optional<Pair> highestPair() {
        return pairs().max(comparing(Pair::value));
    }

    public Optional<TwoPairs> twoPairs() {
        Stream<Pair> pairs = pairs();
        Set<Pair> pairs2 = pairs.collect(toSet());
        switch (pairs2.size()){
            case 0: return Optional.empty();
            case 1: return Optional.empty();
            case 2: return Optional.of(twoPairs0(pairs2));
            default: throw new AssertionError(String.format(
                "There were %d pairs in the roll! (shouldn't ever be > 2)"
            ));
        }
    }

    private static TwoPairs twoPairs0(Set<Pair> pairs) {
        if(pairs.size() != 2) throw new AssertionError(
            "Should only be passed 2 pairs, was: " + pairs
        );
        Iterator<Pair> it = pairs.iterator();
        Pair p1 = it.next();
        Pair p2 = it.next();
        return new TwoPairs(p1, p2);
    }

    public Optional<ThreeOfAKind> threeOfAKind() {
        Map<Integer, Long> countPerRoll = diceRolls().boxed().collect(groupingBy(
            Function.identity(),
            counting()
        ));
        Stream<Map.Entry<Integer, Long>> countPerRollEntries = countPerRoll.entrySet().stream();

        return countPerRollEntries
            .filter(e -> e.getValue() >= 3L)
            .map(e -> new ThreeOfAKind(e.getKey()))
            .findAny()
        ;
    }

    public Optional<FourOfAKind> fourOfAKind() {
        Map<Integer, Long> countPerRoll = diceRolls().boxed().collect(groupingBy(
            Function.identity(),
            counting()
        ));
        Stream<Map.Entry<Integer, Long>> countPerRollEntries = countPerRoll.entrySet().stream();

        return countPerRollEntries
            .filter(e -> e.getValue() >= 4L)
            .map(e -> new FourOfAKind(e.getKey()))
            .findAny()
        ;
    }

    public boolean isSmallStraight() {
        return diceRolls().sorted().boxed().collect(toList()).equals(
            List.of(1, 2, 3, 4, 5)
        );
    }

    public boolean isLargeStraight() {
        return diceRolls().sorted().boxed().collect(toList()).equals(
            List.of(2, 3, 4, 5, 6)
        );
    }

    public boolean isFullHouse() {
        return
            !pairs().collect(toSet()).isEmpty()
            &&
            !threeOfAKind().isEmpty()
        ;
    }

    @Override
    public String toString() {
        return String.format(
            "%s(%d, %d, %d, %d, %d)",
            getClass().getSimpleName(), d1, d2, d3, d4, d5
        );
    }




    private Stream<Pair> pairs() {
        Map<Integer, Long> countPerRoll = diceRolls().boxed().collect(groupingBy(
            Function.identity(),
            counting()
        ));
        Stream<Map.Entry<Integer, Long>> countPerRollEntries = countPerRoll.entrySet().stream();

        return countPerRollEntries
            .filter(e -> e.getValue() >= 2L)
            .map(e -> new Pair(e.getKey()))
        ;
    }

}
