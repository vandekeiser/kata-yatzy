package fr.cla.kata.yatzy;

import java.util.Objects;
import java.util.stream.IntStream;

public abstract class RepeatHand {

    private final int repeat;
    private final int height;

    public RepeatHand(int repeat, int height) {
        this.repeat = repeat;
        this.height = height;
        validate();
    }

    public int value() {
        return repeat * height;
    }

    @Override
    public final boolean equals(Object obj) {
        if(obj == this) return true;

        if(!(obj instanceof RepeatHand)) return false;
        RepeatHand that = (RepeatHand) obj;

        return
            this.repeat == that.repeat
            &&
            this.height == that.height
        ;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(repeat, height);
    }

    @Override
    public String toString() {
        return String.format(
            "%s(%d)",
            getClass().getSimpleName(), height
        );
    }




    private IntStream diceRolls() {
        return IntStream.of(height);
    }

    private void validate() {
        validateRepeat();
        diceRolls().forEach(this::validate);
    }

    private void validate(int dieRoll) {
        if(dieRoll<1 || dieRoll>6) throw new IllegalArgumentException(String.format(
            "Expected parameter dieRoll in [1,6], was %d", dieRoll
        ));
    }

    private void validateRepeat() {
        if(repeat<2 || repeat>4) throw new IllegalArgumentException(String.format(
            "Expected parameter repeat in [2,4], was %d", repeat
        ));
    }

}
