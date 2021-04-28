package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.rover.commands.Command;

public final class Forwards implements Command.MoveCommand {
    public static final Forwards instance = new Forwards();
    private Forwards() {
    }

    @Override
    public Rover execute(Rover rover) {
        return rover.moveForwards();
    }
}
