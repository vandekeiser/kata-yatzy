package fr.cla.kata.yatzy;

public enum Category {

    CHANCE {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int total = 0;
            total += d1;
            total += d2;
            total += d3;
            total += d4;
            total += d5;
            return total;
        }
    },
    YATZY {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int[] roll = roll(d1, d2, d3, d4, d5);
            int[] counts = new int[6];
            for (int die : roll)
                counts[die-1]++;
            for (int i = 0; i != 6; i++)
                if (counts[i] == 5)
                    return 50;
            return 0;
        }
    },
    ONES {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int sum = 0;
            if (d1 == 1) sum++;
            if (d2 == 1) sum++;
            if (d3 == 1) sum++;
            if (d4 == 1) sum++;
            if (d5 == 1)
                sum++;

            return sum;
        }
    },
    TWOS {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int sum = 0;
            if (d1 == 2) sum += 2;
            if (d2 == 2) sum += 2;
            if (d3 == 2) sum += 2;
            if (d4 == 2) sum += 2;
            if (d5 == 2) sum += 2;
            return sum;
        }
    },
    THREES {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int s;
            s = 0;
            if (d1 == 3) s += 3;
            if (d2 == 3) s += 3;
            if (d3 == 3) s += 3;
            if (d4 == 3) s += 3;
            if (d5 == 3) s += 3;
            return s;
        }
    },
    FOURS {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int[] dice = roll(d1, d2, d3, d4, d5);
            int sum;
            sum = 0;
            for (int at = 0; at != 5; at++) {
                if (dice[at] == 4) {
                    sum += 4;
                }
            }
            return sum;
        }
    },
    FIVES {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int[] dice = roll(d1, d2, d3, d4, d5);
            int s = 0;
            int i;
            for (i = 0; i < dice.length; i++)
                if (dice[i] == 5)
                    s = s + 5;
            return s;
        }
    },
    SIXES {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int[] dice = roll(d1, d2, d3, d4, d5);
            int sum = 0;
            for (int at = 0; at < dice.length; at++)
                if (dice[at] == 6)
                    sum = sum + 6;
            return sum;
        }
    },
    ONE_PAIR {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int[] counts = new int[6];
            counts[d1-1]++;
            counts[d2-1]++;
            counts[d3-1]++;
            counts[d4-1]++;
            counts[d5-1]++;
            int at;
            for (at = 0; at != 6; at++)
                if (counts[6-at-1] >= 2)
                    return (6-at)*2;
            return 0;
        }
    },
    TWO_PAIRS {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int[] counts = new int[6];
            counts[d1-1]++;
            counts[d2-1]++;
            counts[d3-1]++;
            counts[d4-1]++;
            counts[d5-1]++;
            int n = 0;
            int score = 0;
            for (int i = 0; i < 6; i += 1)
                if (counts[6-i-1] >= 2) {
                    n++;
                    score += (6-i);
                }
            if (n == 2)
                return score * 2;
            else
                return 0;
        }
    },
    THREE_OF_A_KIND {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int[] t;
            t = new int[6];
            t[d1-1]++;
            t[d2-1]++;
            t[d3-1]++;
            t[d4-1]++;
            t[d5-1]++;
            for (int i = 0; i < 6; i++)
                if (t[i] >= 3)
                    return (i+1) * 3;
            return 0;
        }
    },
    FOUR_OF_A_KIND {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int[] tallies;
            tallies = new int[6];
            tallies[d1-1]++;
            tallies[d2-1]++;
            tallies[d3-1]++;
            tallies[d4-1]++;
            tallies[d5-1]++;
            for (int i = 0; i < 6; i++)
                if (tallies[i] >= 4)
                    return (i+1) * 4;
            return 0;
        }
    },
    SMALL_STRAIGHT {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int[] tallies;
            tallies = new int[6];
            tallies[d1-1] += 1;
            tallies[d2-1] += 1;
            tallies[d3-1] += 1;
            tallies[d4-1] += 1;
            tallies[d5-1] += 1;
            if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
                return 15;
            return 0;
        }
    },
    LARGE_STRAIGHT {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int[] tallies;
            tallies = new int[6];
            tallies[d1-1] += 1;
            tallies[d2-1] += 1;
            tallies[d3-1] += 1;
            tallies[d4-1] += 1;
            tallies[d5-1] += 1;
            if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
                return 20;
            return 0;
        }
    },
    FULL_HOUSE {
        @Override
        public int score(int d1, int d2, int d3, int d4, int d5) {
            int[] tallies;
            boolean _2 = false;
            int i;
            int _2_at = 0;
            boolean _3 = false;
            int _3_at = 0;




            tallies = new int[6];
            tallies[d1-1] += 1;
            tallies[d2-1] += 1;
            tallies[d3-1] += 1;
            tallies[d4-1] += 1;
            tallies[d5-1] += 1;

            for (i = 0; i != 6; i += 1)
                if (tallies[i] == 2) {
                    _2 = true;
                    _2_at = i+1;
                }

            for (i = 0; i != 6; i += 1)
                if (tallies[i] == 3) {
                    _3 = true;
                    _3_at = i+1;
                }

            if (_2 && _3)
                return _2_at * 2 + _3_at * 3;
            else
                return 0;
        }
    },
    ;



    public abstract int score(int d1, int d2, int d3, int d4, int d5);

    private static int[] roll(int d1, int d2, int d3, int d4, int d5) {
        return new int[]{d1, d2, d3, d4, d5};
    }

}