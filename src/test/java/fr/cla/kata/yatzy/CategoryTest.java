package fr.cla.kata.yatzy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    @Test//donner nom lisible avec ju5
    public void chance_category_should_score_roll_to_the_sum_of_all_dice() {
        assertEquals(15, Category.CHANCE.score(2,3,4,5,1));
        assertEquals(16, Category.CHANCE.score(3,3,4,5,1));
    }

    @Test
    public void yatzy_category_should_score_compatible_roll_to_50() {
        assertEquals(50, Category.YATZY.score(4,4,4,4,4));
        assertEquals(50, Category.YATZY.score(6,6,6,6,6));
    }

    @Test
    public void yatzy_category_should_score_incompatible_roll_to_0() {
        assertEquals(0, Category.YATZY.score(6,6,6,6,3));
    }

    @Test
    public void ones_category_should_score_roll_to_the_sum_of_ones() {
        assertEquals(1, Category.ONES.score(1,2,3,4,5));
        assertEquals(2, Category.ONES.score(1,2,1,4,5));
        assertEquals(4, Category.ONES.score(1,2,1,1,1));
        assertEquals(0, Category.ONES.score(6,2,2,4,5));
    }

    @Test
    public void twos_category_should_score_roll_to_the_sum_of_twos() {
        assertEquals(4, Category.TWOS.score(1,2,3,2,6));
        assertEquals(10, Category.TWOS.score(2,2,2,2,2));
    }

    @Test
    public void threes_category_should_score_roll_to_the_sum_of_threes() {
        assertEquals(6, Category.THREES.score(1,2,3,2,3));
        assertEquals(12, Category.THREES.score(2,3,3,3,3));
    }

    @Test
    public void fours_category_should_score_roll_to_the_sum_of_fours() {
        assertEquals(12, Category.FOURS.score(4,4,4,5,5));
        assertEquals(8, Category.FOURS.score(4,4,5,5,5));
        assertEquals(4, Category.FOURS.score(4,5,5,5,5));
    }

    @Test
    public void fives_category_should_score_roll_to_the_sum_of_fives() {
        assertEquals(10, Category.FIVES.score(4,4,4,5,5));
        assertEquals(15, Category.FIVES.score(4,4,5,5,5));
        assertEquals(20, Category.FIVES.score(4,5,5,5,5));
    }

    @Test
    public void sixes_category_should_score_roll_to_the_sum_of_sixes() {
        assertEquals(0, Category.SIXES.score(4,4,4,5,5));
        assertEquals(6, Category.SIXES.score(4,4,6,5,5));
        assertEquals(18, Category.SIXES.score(6,5,6,6,5));
    }

    @Test
    public void one_pair_category_should_score_compatible_roll_to_the_sum_of_the_highest_pair() {
        assertEquals(6, Category.ONE_PAIR.score(3,4,3,5,6));
        assertEquals(10, Category.ONE_PAIR.score(5,3,3,3,5));
        assertEquals(12, Category.ONE_PAIR.score(5,3,6,6,5));
    }

    @Test
    public void one_pair_category_should_score_incompatible_roll_to_0() {
        assertEquals(0, Category.ONE_PAIR.score(3,2,1,5,6));
    }

    @Test
    public void two_pairs_category_should_score_compatible_roll_to_the_sum_of_the_two_pairs() {
        assertEquals(16, Category.TWO_PAIRS.score(3,3,5,4,5));
        assertEquals(16, Category.TWO_PAIRS.score(3,3,5,5,5));
    }

    @Test
    public void two_pairs_category_should_score_incompatible_roll_to_0() {
        assertEquals(0, Category.TWO_PAIRS.score(3,3,1,4,5));
    }

    @Test
    public void three_of_a_kind_category_should_score_compatible_roll_to_the_sum_of_the_three_of_a_kind()
    {
        assertEquals(9, Category.THREE_OF_A_KIND.score(3,3,3,4,5));
        assertEquals(15, Category.THREE_OF_A_KIND.score(5,3,5,4,5));
        assertEquals(9, Category.THREE_OF_A_KIND.score(3,3,3,3,5));
    }

    @Test
    public void three_of_a_kind_category_should_score_compatible_roll_to_0() {
        assertEquals(0, Category.THREE_OF_A_KIND.score(3,3,1,4,5));
    }

    @Test
    public void four_of_a_kind_category_should_score_compatible_roll_to_the_sum_of_the_four_of_a_kind() {
        assertEquals(12, Category.FOUR_OF_A_KIND.score(3,3,3,3,5));
        assertEquals(20, Category.FOUR_OF_A_KIND.score(5,5,5,4,5));
        assertEquals(12, Category.FOUR_OF_A_KIND.score(3,3,3,3,3));
    }

    @Test
    public void four_of_a_kind_category_should_score_incompatible_roll_to_0() {
        assertEquals(0, Category.FOUR_OF_A_KIND.score(3,3,3,1,2));
    }

    @Test
    public void small_straight_category_should_score_compatible_roll_to_15() {
        assertEquals(15, Category.SMALL_STRAIGHT.score(1,2,3,4,5));
        assertEquals(15, Category.SMALL_STRAIGHT.score(2,3,4,5,1));
    }

    @Test
    public void small_straight_category_should_score_incompatible_roll_to_0() {
        assertEquals(0, Category.SMALL_STRAIGHT.score(1,2,2,4,5));
    }

    @Test
    public void large_straight_category_should_score_compatible_roll_to_20() {
        assertEquals(20, Category.LARGE_STRAIGHT.score(6,2,3,4,5));
        assertEquals(20, Category.LARGE_STRAIGHT.score(2,3,4,5,6));
    }

    @Test
    public void large_straight_category_should_score_incompatible_roll_to_0() {
        assertEquals(0, Category.LARGE_STRAIGHT.score(1,2,2,4,5));
    }

    @Test
    public void full_shouse_category_should_score_compatible_roll_to_the_sum_of_all_dice() {
        assertEquals(18, Category.FULL_HOUSE.score(6,2,2,2,6));
    }

    @Test
    public void full_shouse_category_should_score_incompatible_roll_to_0() {
        assertEquals(0, Category.FULL_HOUSE.score(2,3,4,5,6));
    }

}