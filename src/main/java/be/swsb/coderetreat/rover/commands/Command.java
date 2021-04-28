package be.swsb.coderetreat.rover.commands;

import be.swsb.coderetreat.rover.*;

public interface Command {
    Rover.Forwards FORWARDS = Rover.Forwards.instance;
    Rover.Backwards BACKWARDS = Rover.Backwards.instance;
    Rover.Right RIGHT = Rover.Right.instance;
    Rover.Left LEFT = Rover.Left.instance;

    Rover execute(Rover rover);

    interface MoveCommand extends Command {
    }

    interface RotateCommand extends Command {
    }
}
