package fr.cla.kata.yatzy;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static fr.cla.kata.yatzy.Roll.roll;
import static org.assertj.core.api.Assertions.assertThat;

public class RollTest {

    @Test
    public void sumOfAllDice() {
        assertThat(
            roll(2,3,4,5,1).sumOfAllDice()
        ).isEqualTo(15);
    }

    @Test
    public void allDiceHaveTheSameNumber() {
        assertThat(
            roll(1,1,1,1,1).allDiceHaveTheSameNumber()
        ).isTrue();

        assertThat(
            roll(1,1,2,1,1).allDiceHaveTheSameNumber()
        ).isFalse();
    }

    @Test
    public void count() {
        assertThat(
            roll(1,1,2,1,1).count(1)
        ).isEqualTo(4);

        assertThat(
            roll(1,3,2,1,5).count(1)
        ).isEqualTo(2);

        assertThat(
            roll(4,3,2,4,5).count(1)
        ).isEqualTo(0);
    }

    @Test
    public void highestPair() {
        assertThat(
            roll(1,1,2,5,2).highestPair()
        ).isEqualTo(
            Optional.of(new Pair(2))
        );

        assertThat(
            roll(1,2,3,4,5).highestPair()
        ).isEmpty();
    }

    @Test
    public void twoPairs() {
        assertThat(
            roll(1,1,3,5,3).twoPairs()
        ).isEqualTo(Optional.of(new TwoPairs(1, 3)));

        assertThat(
            roll(1,1,3,5,4).twoPairs()
        ).isEmpty();

        assertThat(
            roll(1,2,3,4,5).twoPairs()
        ).isEmpty();
    }

    @Test
    public void threeOfAKind() {
        assertThat(
            roll(1,1,3,1,3).threeOfAKind()
        ).isEqualTo(
            Optional.of(new ThreeOfAKind(1))
        );

        assertThat(
            roll(1,1,3,4,3).threeOfAKind()
        ).isEmpty();
    }

    @Test
    public void fourOfAKind() {
        assertThat(
            roll(1,1,3,1,1).fourOfAKind()
        ).isEqualTo(Optional.of(new FourOfAKind(1)));

        assertThat(
            roll(1,1,1,4,3).fourOfAKind()
        ).isEmpty();
    }

    @Test
    public void isSmallStraight() {
        assertThat(
            roll(1,2,3,4,5).isSmallStraight()
        ).isTrue();

        assertThat(
            roll(2,1,5,3,4).isSmallStraight()
        ).isTrue();

        assertThat(
            roll(2,1,5,3,2).isSmallStraight()
        ).isFalse();
    }

    @Test
    public void isLargeStraight() {
        assertThat(
            roll(2,3,4,5,6).isLargeStraight()
        ).isTrue();

        assertThat(
            roll(6,4,5,2,3).isLargeStraight()
        ).isTrue();

        assertThat(
            roll(6,4,5,2,1).isLargeStraight()
        ).isFalse();

    }

    @Test
    public void isFullHouse() {
        assertThat(
            roll(3,3,2,2,2).isFullHouse()
        ).isTrue();

        assertThat(
            roll(3,3,2,2,1).isFullHouse()
        ).isFalse();
    }


}