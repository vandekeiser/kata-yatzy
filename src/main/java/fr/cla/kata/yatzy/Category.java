package fr.cla.kata.yatzy;

import java.util.Optional;

public enum Category {

    CHANCE {
        @Override
        public int score(Roll roll) {
            return roll.sumOfAllDice();
        }
    },
    YATZY {
        @Override
        public int score(Roll roll) {
            return roll.allDiceHaveTheSameNumber() ? 50 : 0;
        }
    },
    ONES {
        @Override
        public int score(Roll roll) {
            return 1 * roll.count(1);
        }
    },
    TWOS {
        @Override
        public int score(Roll roll) {
            return 2 * roll.count(2);
        }
    },
    THREES {
        @Override
        public int score(Roll roll) {
            return 3 * roll.count(3);
        }
    },
    FOURS {
        @Override
        public int score(Roll roll) {
            return 4 * roll.count(4);
        }
    },
    FIVES {
        @Override
        public int score(Roll roll) {
            return 5 * roll.count(5);
        }
    },
    SIXES {
        @Override
        public int score(Roll roll) {
            return 6 * roll.count(6);
        }
    },
    ONE_PAIR {
        @Override
        public int score(Roll roll) {
            Optional<Pair> highestPair = roll.highestPair();
            return highestPair.map(Pair::value).orElse(0);
        }
    },
    TWO_PAIRS {
        @Override
        public int score(Roll roll) {
            Optional<TwoPairs> twoPairs = roll.twoPairs();
            return twoPairs.map(TwoPairs::value).orElse(0);
        }
    },
    THREE_OF_A_KIND {
        @Override
        public int score(Roll roll) {
            Optional<ThreeOfAKind> threeOfAKind = roll.threeOfAKind();
            return threeOfAKind.map(ThreeOfAKind::value).orElse(0);
        }
    },
    FOUR_OF_A_KIND {
        @Override
        public int score(Roll roll) {
            Optional<FourOfAKind> fourOfAKind = roll.fourOfAKind();
            return fourOfAKind.map(FourOfAKind::value).orElse(0);
        }
    },
    SMALL_STRAIGHT {
        @Override
        public int score(Roll roll) {
            return roll.isSmallStraight() ? 15 : 0;
        }
    },
    LARGE_STRAIGHT {
        @Override
        public int score(Roll roll) {
            return roll.isLargeStraight() ? 20 : 0;
        }
    },
    FULL_HOUSE {
        @Override
        public int score(Roll roll) {
            return roll.isFullHouse() ? roll.sumOfAllDice() : 0;
        }
    },
    ;



    public abstract int score(Roll roll);

}