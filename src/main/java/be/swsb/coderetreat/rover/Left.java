package be.swsb.coderetreat.rover;

import be.swsb.coderetreat.rover.commands.Command;

public final class Left implements Command.RotateCommand {
    public static final Left instance = new Left();
    private Left() {
    }

    @Override
    public Rover execute(Rover rover) {
        return rover.rotateLeft();
    }
}
