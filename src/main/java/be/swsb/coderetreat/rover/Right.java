package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.rover.commands.Command;

public final class Right implements Command.RotateCommand {
    public static final Right instance = new Right();
    private Right() {
    }

    @Override
    public Rover execute(Rover rover) {
        return rover.rotateRight();
    }
}
