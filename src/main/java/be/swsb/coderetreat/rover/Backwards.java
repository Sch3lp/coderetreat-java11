package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.rover.commands.Command;

public final class Backwards implements Command.MoveCommand {
    public static final Backwards instance = new Backwards();
    private Backwards() {
    }

    @Override
    public Rover execute(Rover rover) {
        return rover.moveBackwards();
    }
}
