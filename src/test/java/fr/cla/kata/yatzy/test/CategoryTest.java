package fr.cla.kata.yatzy.test;

import org.junit.jupiter.api.Test;

import static fr.cla.kata.yatzy.Category.*;
import static fr.cla.kata.yatzy.Roll.roll;
import static org.assertj.core.api.Assertions.assertThat;

public class CategoryTest {

    @Test
    public void chance_category_should_score_roll_to_the_sum_of_all_dice() {
        assertThat(
            CHANCE.score(roll(2,3,4,5,1))
        ).isEqualTo(15);

        assertThat(
            CHANCE.score(roll(3,3,4,5,1))
        ).isEqualTo(16);

    }

    @Test
    public void yatzy_category_should_score_compatible_roll_to_50() {
        assertThat(
            YATZY.score(roll(4,4,4,4,4))
        ).isEqualTo(50);

        assertThat(
            YATZY.score(roll(6,6,6,6,6))
        ).isEqualTo(50);
    }

    @Test
    public void yatzy_category_should_score_incompatible_roll_to_0() {
        assertThat(
            YATZY.score(roll(6,6,6,6,3))
        ).isEqualTo(0);
    }

    @Test
    public void ones_category_should_score_roll_to_the_sum_of_ones() {
        assertThat(
            ONES.score(roll(1,2,3,4,5))
        ).isEqualTo(1);

        assertThat(
            ONES.score(roll(1,2,1,4,5))
        ).isEqualTo(2);

        assertThat(
            ONES.score(roll(1,2,1,1,1))
        ).isEqualTo(4);

        assertThat(
            ONES.score(roll(6,2,2,4,5))
        ).isEqualTo(0);

    }

    @Test
    public void twos_category_should_score_roll_to_the_sum_of_twos() {
        assertThat(
            TWOS.score(roll(1,2,3,2,6))
        ).isEqualTo(4);

        assertThat(
            TWOS.score(roll(2,2,2,2,2))
        ).isEqualTo(10);
    }

    @Test
    public void threes_category_should_score_roll_to_the_sum_of_threes() {
        assertThat(
            THREES.score(roll(1,2,3,2,3))
        ).isEqualTo(6);

        assertThat(
            THREES.score(roll(2,3,3,3,3))
        ).isEqualTo(12);
    }

    @Test
    public void fours_category_should_score_roll_to_the_sum_of_fours() {
        assertThat(
            FOURS.score(roll(4,4,4,5,5))
        ).isEqualTo(12);

        assertThat(
            FOURS.score(roll(4,4,5,5,5))
        ).isEqualTo(8);

        assertThat(
            FOURS.score(roll(4,5,5,5,5))
        ).isEqualTo(4);
    }

    @Test
    public void fives_category_should_score_roll_to_the_sum_of_fives() {
        assertThat(
            FIVES.score(roll(4,4,4,5,5))
        ).isEqualTo(10);

        assertThat(
            FIVES.score(roll(4,4,5,5,5))
        ).isEqualTo(15);

        assertThat(
            FIVES.score(roll(4,5,5,5,5))
        ).isEqualTo(20);
    }

    @Test
    public void sixes_category_should_score_roll_to_the_sum_of_sixes() {
        assertThat(
            SIXES.score(roll(4,4,4,5,5))
        ).isEqualTo(0);

        assertThat(
            SIXES.score(roll(4,4,6,5,5))
        ).isEqualTo(6);

        assertThat(
            SIXES.score(roll(6,5,6,6,5))
        ).isEqualTo(18);
    }

    @Test
    public void one_pair_category_should_score_compatible_roll_to_the_sum_of_the_highest_pair() {
        assertThat(
            ONE_PAIR.score(roll(3,4,3,5,6))
        ).isEqualTo(6);

        assertThat(
            ONE_PAIR.score(roll(5,3,3,3,5))
        ).isEqualTo(10);

        assertThat(
            ONE_PAIR.score(roll(5,3,6,6,5))
        ).isEqualTo(12);
    }

    @Test
    public void one_pair_category_should_score_incompatible_roll_to_0() {
        assertThat(
            ONE_PAIR.score(roll(3,2,1,5,6))
        ).isEqualTo(0);
    }

    @Test
    public void two_pairs_category_should_score_compatible_roll_to_the_sum_of_the_two_pairs() {
        assertThat(
            TWO_PAIRS.score(roll(3,3,5,4,5))
        ).isEqualTo(16);

        assertThat(
            TWO_PAIRS.score(roll(3,3,5,5,5))
        ).isEqualTo(16);
    }

    @Test
    public void two_pairs_category_should_score_incompatible_roll_to_0() {
        assertThat(
            TWO_PAIRS.score(roll(3,3,1,4,5))
        ).isEqualTo(0);
    }

    @Test
    public void three_of_a_kind_category_should_score_compatible_roll_to_the_sum_of_the_three_of_a_kind() {
        assertThat(
            THREE_OF_A_KIND.score(roll(3,3,3,4,5))
        ).isEqualTo(9);

        assertThat(
            THREE_OF_A_KIND.score(roll(5,3,5,4,5))
        ).isEqualTo(15);

        assertThat(
            THREE_OF_A_KIND.score(roll(3,3,3,3,5))
        ).isEqualTo(9);
    }

    @Test
    public void three_of_a_kind_category_should_score_compatible_roll_to_0() {
        assertThat(
            THREE_OF_A_KIND.score(roll(3,3,1,4,5))
        ).isEqualTo(0);
    }

    @Test
    public void four_of_a_kind_category_should_score_compatible_roll_to_the_sum_of_the_four_of_a_kind() {
        assertThat(
            FOUR_OF_A_KIND.score(roll(3,3,3,3,5))
        ).isEqualTo(12);

        assertThat(
            FOUR_OF_A_KIND.score(roll(5,5,5,4,5))
        ).isEqualTo(20);

        assertThat(FOUR_OF_A_KIND.score(roll(3,3,3,3,3))).isEqualTo(12);
    }

    @Test
    public void four_of_a_kind_category_should_score_incompatible_roll_to_0() {
        assertThat(
            FOUR_OF_A_KIND.score(roll(3,3,3,1,2))
        ).isEqualTo(0);
    }

    @Test
    public void small_straight_category_should_score_compatible_roll_to_15() {
        assertThat(
            SMALL_STRAIGHT.score(roll(1,2,3,4,5))
        ).isEqualTo(15);

        assertThat(
            SMALL_STRAIGHT.score(roll(2,3,4,5,1))
        ).isEqualTo(15);
    }

    @Test
    public void small_straight_category_should_score_incompatible_roll_to_0() {
        assertThat(
            SMALL_STRAIGHT.score(roll(1,2,2,4,5))
        ).isEqualTo(0);
    }

    @Test
    public void large_straight_category_should_score_compatible_roll_to_20() {
        assertThat(
            LARGE_STRAIGHT.score(roll(6,2,3,4,5))
        ).isEqualTo(20);

        assertThat(
            LARGE_STRAIGHT.score(roll(2,3,4,5,6))
        ).isEqualTo(20);
    }

    @Test
    public void large_straight_category_should_score_incompatible_roll_to_0() {
        assertThat(
            LARGE_STRAIGHT.score(roll(1,2,2,4,5))
        ).isEqualTo(0);
    }

    @Test
    public void full_shouse_category_should_score_compatible_roll_to_the_sum_of_all_dice() {
        assertThat(
            FULL_HOUSE.score(roll(6,2,2,2,6))
        ).isEqualTo(18);
    }

    @Test
    public void full_shouse_category_should_score_incompatible_roll_to_0() {
        assertThat(
            FULL_HOUSE.score(roll(2,3,4,5,6))
        ).isEqualTo(0);
    }

}