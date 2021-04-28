package be.swsb.coderetreat.rover.commands;

import be.swsb.coderetreat.rover.Rover;

public interface Command {
    MoveCommand.Forwards FORWARDS = new MoveCommand.Forwards();
    MoveCommand.Backwards BACKWARDS = new MoveCommand.Backwards();
    RotateCommand.Right RIGHT = new RotateCommand.Right();
    RotateCommand.Left LEFT = new RotateCommand.Left();

    Rover execute(Rover rover);

    interface MoveCommand extends Command {
        final class Forwards implements MoveCommand {
            private Forwards() {
            }

            @Override
            public Rover execute(Rover rover) {
                return rover.moveForwards();
            }
        }

        final class Backwards implements MoveCommand {
            private Backwards() {
            }

            @Override
            public Rover execute(Rover rover) {
                return rover.moveBackwards();
            }
        }
    }

    interface RotateCommand extends Command {
        final class Left implements RotateCommand {
            private Left() {
            }

            @Override
            public Rover execute(Rover rover) {
                return rover.rotateLeft();
            }
        }

        final class Right implements RotateCommand {
            private Right() {
            }

            @Override
            public Rover execute(Rover rover) {
                return rover.rotateRight();
            }
        }
    }
}
