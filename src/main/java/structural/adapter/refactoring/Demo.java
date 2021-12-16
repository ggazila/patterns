package structural.adapter.refactoring;

import structural.adapter.refactoring.adapters.SquarePegAdapter;
import structural.adapter.refactoring.round.RoundHole;
import structural.adapter.refactoring.round.RoundPeg;
import structural.adapter.refactoring.square.SquarePeg;

public class Demo {
    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);

        if (roundHole.fits(roundPeg)) {
            System.out.println("round peg fits round hole");
        }

        SquarePeg smallSquarePeg = new SquarePeg(2);
        SquarePeg largeSquarePeg = new SquarePeg(20);

        SquarePegAdapter smallAdapter = new SquarePegAdapter(smallSquarePeg);
        SquarePegAdapter largeAdapter = new SquarePegAdapter(largeSquarePeg);

        if (roundHole.fits(smallAdapter)) {
            System.out.println("square peg fits");
        }

        if (!roundHole.fits(largeAdapter)) {
            System.out.println("square peg doesn't fit");
        }
    }
}
