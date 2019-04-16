package fr.cla.kata.yatzy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YatzyCategoryTest {

    @Test//donner nom lisible avec ju5
    public void chance_category_should_score_roll_to_the_sum_of_all_dice() {
        assertEquals(15, Yatzy.chance(2,3,4,5,1));
        assertEquals(16, Yatzy.chance(3,3,4,5,1));
    }

    @Test public void yatzy_category_should_score_compatible_roll_to_50() {
        assertEquals(50, Yatzy.yatzy(4,4,4,4,4));
        assertEquals(50, Yatzy.yatzy(6,6,6,6,6));
    }

    @Test public void yatzy_category_should_score_incompatible_roll_to_0() {
        assertEquals(0, Yatzy.yatzy(6,6,6,6,3));
    }

    @Test public void ones_category_should_score_roll_to_the_sum_of_ones() {
        assertEquals(1, Yatzy.ones(1,2,3,4,5));
        assertEquals(2, Yatzy.ones(1,2,1,4,5));
        assertEquals(4, Yatzy.ones(1,2,1,1,1));
        assertEquals(0, Yatzy.ones(6,2,2,4,5));
    }

    @Test public void twos_category_should_score_roll_to_the_sum_of_twos() {
        assertEquals(4, Yatzy.twos(1,2,3,2,6));
        assertEquals(10, Yatzy.twos(2,2,2,2,2));
    }

    @Test public void threes_category_should_score_roll_to_the_sum_of_threes() {
        assertEquals(6, Yatzy.threes(1,2,3,2,3));
        assertEquals(12, Yatzy.threes(2,3,3,3,3));
    }

    @Test
    public void fours_category_should_score_roll_to_the_sum_of_fours()
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
    }

    @Test
    public void fives_category_should_score_roll_to_the_sum_of_fives() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    public void sixes_category_should_score_roll_to_the_sum_of_sixes() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }

    @Test
    public void one_pair_category_should_score_compatible_roll_to_the_sum_of_the_highest_pair() {
        assertEquals(6, Yatzy.score_pair(3,4,3,5,6));
        assertEquals(10, Yatzy.score_pair(5,3,3,3,5));
        assertEquals(12, Yatzy.score_pair(5,3,6,6,5));
    }

    @Test
    public void one_pair_category_should_score_incompatible_roll_to_0() {
        assertEquals(0, Yatzy.score_pair(3,2,1,5,6));
    }

    @Test
    public void two_pair_category_should_score_compatible_roll_to_the_sum_of_the_two_pairs() {
        assertEquals(16, Yatzy.two_pair(3,3,5,4,5));
        assertEquals(16, Yatzy.two_pair(3,3,5,5,5));
    }

    @Test
    public void two_pair_category_should_score_incompatible_roll_to_0() {
        assertEquals(0, Yatzy.two_pair(3,3,1,4,5));
    }

    @Test
    public void three_of_a_kind_category_should_score_compatible_roll_to_the_sum_of_the_three_of_a_kind()
    {
        assertEquals(9, Yatzy.three_of_a_kind(3,3,3,4,5));
        assertEquals(15, Yatzy.three_of_a_kind(5,3,5,4,5));
        assertEquals(9, Yatzy.three_of_a_kind(3,3,3,3,5));
    }

    @Test
    public void three_of_a_kind_category_should_score_compatible_roll_to_0() {
        assertEquals(0, Yatzy.three_of_a_kind(3,3,1,4,5));
    }

    @Test
    public void four_of_a_kind_category_should_score_compatible_roll_to_the_sum_of_the_four_of_a_kind() {
        assertEquals(12, Yatzy.four_of_a_kind(3,3,3,3,5));
        assertEquals(20, Yatzy.four_of_a_kind(5,5,5,4,5));
        assertEquals(12, Yatzy.four_of_a_kind(3,3,3,3,3));
    }

    @Test
    public void four_of_a_kind_category_should_score_incompatible_roll_to_0() {
        assertEquals(0, Yatzy.four_of_a_kind(3,3,3,1,2));
    }

    @Test
    public void small_straight_category_should_score_compatible_roll_to_15() {
        assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
    }

    @Test
    public void small_straight_category_should_score_incompatible_roll_to_0() {
        assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
    }

    @Test
    public void large_straight_category_should_score_compatible_roll_to_20() {
        assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
    }

    @Test
    public void large_straight_category_should_score_incompatible_roll_to_0() {
        assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
    }

    @Test
    public void full_shouse_category_should_score_compatible_roll_to_the_sum_of_all_dice() {
        assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
    }

    @Test
    public void full_shouse_category_should_score_incompatible_roll_to_0() {
        assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
    }

}