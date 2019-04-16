package fr.cla.kata.yatzy;

import java.util.Objects;
import java.util.Set;

import static java.util.Objects.requireNonNull;

public class TwoPairs {

    private final Pair p1, p2;

    public TwoPairs(int p1, int p2) {
        this(new Pair(p1), new Pair(p2));
    }

    public TwoPairs(Pair p1, Pair p2) {
        this.p1 = requireNonNull(p1);
        this.p2 = requireNonNull(p2);
    }

    public int value() {
        return p1.value() + p2.value();
    }

    @Override
    public final boolean equals(Object obj) {
        if(obj == this) return true;

        if(!(obj instanceof TwoPairs)) return false;
        TwoPairs that = (TwoPairs) obj;

        return Objects.equals(
            Set.of(this.p1, this.p2),
            Set.of(that.p1, that.p2)
        );
    }

    @Override
    public final int hashCode() {
        return Objects.hash(p1, p2);
    }

    @Override
    public String toString() {
        return String.format(
            "%s(%s, %s)",
            getClass().getSimpleName(), p1, p2
        );
    }

}
