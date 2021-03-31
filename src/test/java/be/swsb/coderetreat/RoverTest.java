package be.swsb.coderetreat;

import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

    /*
     * 1. Passes tests
     * 2. Express intent (intention revealing)
     * 3. No duplication (of concepts!)
     * 4. Least amount of elements
     */

    @Test
    void aRoverCanBeInitializedWithAPositionAndDirection() {
        var marsRover = defaultRoverFacing(NORTH);

        assertThat(marsRover).isEqualTo(defaultRoverFacing(NORTH));
    }

    @Test
    void aRoverMovesForwardsUpTheYAxisWhenReceivesForwards() {
        final var marsRover = defaultRoverFacing(NORTH);

        final var updatedRover = marsRover.receiveForwards().receiveForwards();

        assertThat(updatedRover).isEqualTo(new Rover(new Position(0, 2), NORTH));
    }

    @Test
    void aRoverMovesForwardsUpTheXAxisWhenReceivesForwardsAndFacingEast() {
        final var marsRover = defaultRoverFacing(EAST);

        final var updatedRover = marsRover.receiveForwards().receiveForwards();

        assertThat(updatedRover).isEqualTo(new Rover(new Position(2, 0), EAST));
    }

    @Test
    void aRoverMovesForwardsDownTheYAxisWhenReceivesForwardsAndFacingSouth() {
        final var marsRover = defaultRoverFacing(SOUTH);

        final var updatedRover = marsRover.receiveForwards().receiveForwards();

        assertThat(updatedRover).isEqualTo(new Rover(new Position(0, -2), SOUTH));
    }

    @Test
    void aRoverMovesForwardsDownTheXAxisWhenReceivesForwardsAndFacingWest() {
        final var marsRover = defaultRoverFacing(WEST);

        final var updatedRover = marsRover.receiveForwards().receiveForwards();

        assertThat(updatedRover).isEqualTo(new Rover(new Position(-2, 0), WEST));
    }

    @Test
    void aRoverMovesBackwardsUpTheYAxisWhenReceivesBackwardsTwiceAndFacingSouth() {
        final var marsRover = defaultRoverFacing(SOUTH);

        final var updatedRover = marsRover.receiveBackwards().receiveBackwards();

        assertThat(updatedRover).isEqualTo(new Rover(new Position(0, 2), SOUTH));
    }

    @Test
    void aRoverMovesBackwardsDownTheXAxisWhenReceivesBackwardsAndFacingEast() {
        final var marsRover = defaultRoverFacing(EAST);

        final var updatedRover = marsRover.receiveBackwards().receiveBackwards();

        assertThat(updatedRover).isEqualTo(new Rover(new Position(-2, 0), EAST));
    }

    @Test
    void aRoverMovesBackwardsDownTheYAxisWhenReceivesBackwardsAndFacingNorth() {
        final var marsRover = defaultRoverFacing(NORTH);

        final var updatedRover = marsRover.receiveBackwards().receiveBackwards();

        assertThat(updatedRover).isEqualTo(new Rover(new Position(0, -2), NORTH));
    }

    @Test
    void aRoverMovesBackwardsUpTheXAxisWhenReceivesBackwardsAndFacingWest() {
        final var marsRover = defaultRoverFacing(WEST);

        final var updatedRover = marsRover.receiveBackwards().receiveBackwards();

        assertThat(updatedRover).isEqualTo(new Rover(new Position(2, 0), WEST));
    }

    @Test
    void aRoverCanReceiveASeriesOfMoveCommands() {
        final var marsRover = defaultRoverFacing(NORTH);

        final var updatedRover = marsRover.receive(Command.FORWARDS, Command.FORWARDS, Command.BACKWARDS);

        assertThat(updatedRover).isEqualTo(new Rover(new Position(0, 1), NORTH));
    }

    private Rover defaultRoverFacing(Direction direction) {
        return new Rover(new Position(0, 0), direction);
    }
}
