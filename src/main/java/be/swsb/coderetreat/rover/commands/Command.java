package be.swsb.coderetreat.rover.commands;

import be.swsb.coderetreat.rover.*;

public interface Command {
    Forwards FORWARDS = Forwards.instance;
    Backwards BACKWARDS = Backwards.instance;
    Right RIGHT = Right.instance;
    Left LEFT = Left.instance;

    Rover execute(Rover rover);

    interface MoveCommand extends Command {
    }

    interface RotateCommand extends Command {
    }
}
