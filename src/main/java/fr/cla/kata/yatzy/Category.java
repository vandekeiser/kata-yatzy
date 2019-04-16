package fr.cla.kata.yatzy;

/**
 * A Yatzy category into which the player must place his roll.
 */
public enum Category {

    CHANCE {
        @Override public int score(Roll roll) {
            return roll.sumOfAllDice();
        }
    },

    YATZY {
        @Override public int score(Roll roll) {
            return roll.allDiceHaveTheSameNumber() ? 50 : 0;
        }
    },

    ONES {
        @Override public int score(Roll roll) {
            return roll.weightedCount(1);
        }
    },

    TWOS {
        @Override public int score(Roll roll) {
            return roll.weightedCount(2);
        }
    },

    THREES {
        @Override public int score(Roll roll) {
            return roll.weightedCount(3);
        }
    },

    FOURS {
        @Override public int score(Roll roll) {
            return roll.weightedCount(4);
        }
    },

    FIVES {
        @Override public int score(Roll roll) {
            return roll.weightedCount(5);
        }
    },

    SIXES {
        @Override public int score(Roll roll) {
            return roll.weightedCount(6);
        }
    },

    ONE_PAIR {
        @Override public int score(Roll roll) {
            return roll.highestPair().map(Pair::value).orElse(0);
        }
    },

    TWO_PAIRS {
        @Override public int score(Roll roll) {
            return roll.twoPairs().map(TwoPairs::value).orElse(0);
        }
    },

    THREE_OF_A_KIND {
        @Override public int score(Roll roll) {
            return roll.threeOfAKind().map(ThreeOfAKind::value).orElse(0);
        }
    },

    FOUR_OF_A_KIND {
        @Override public int score(Roll roll) {
            return roll.fourOfAKind().map(FourOfAKind::value).orElse(0);
        }
    },

    SMALL_STRAIGHT {
        @Override public int score(Roll roll) {
            return roll.isSmallStraight() ? 15 : 0;
        }
    },

    LARGE_STRAIGHT {
        @Override public int score(Roll roll) {
            return roll.isLargeStraight() ? 20 : 0;
        }
    },

    FULL_HOUSE {
        @Override public int score(Roll roll) {
            return roll.isFullHouse() ? roll.sumOfAllDice() : 0;
        }
    },

    ;

    public abstract int score(Roll roll);

}