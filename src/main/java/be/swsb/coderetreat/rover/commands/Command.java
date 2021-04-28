package be.swsb.coderetreat.rover.commands;

public interface Command {
    MoveCommand.Forwards FORWARDS = new MoveCommand.Forwards();
    MoveCommand.Backwards BACKWARDS = new MoveCommand.Backwards();
    RotateCommand.Right RIGHT = new RotateCommand.Right();
    RotateCommand.Left LEFT = new RotateCommand.Left();

    interface MoveCommand extends Command {
        default boolean isForwards() {
            return this.equals(FORWARDS);
        }
        default boolean isBackwards() {
            return this.equals(BACKWARDS);
        }

        final class Forwards implements MoveCommand {
            private Forwards() {
            }
        }

        final class Backwards implements MoveCommand {
            private Backwards() {
            }
        }
    }

    interface RotateCommand extends Command {
        default boolean isRight() {
            return this.equals(RIGHT);
        }
        default boolean isLeft() {
            return this.equals(LEFT);
        }

        final class Left implements RotateCommand {
            private Left() {
            }
        }

        final class Right implements RotateCommand {
            private Right() {
            }
        }
    }
}
