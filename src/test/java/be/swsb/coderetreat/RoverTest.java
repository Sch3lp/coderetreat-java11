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
        var marsRover = new Rover(new Position(0, 0), NORTH);

        assertThat(marsRover).isEqualTo(new Rover(new Position(0, 0), NORTH));
    }

    @Test
    void aRoverMovesForwardsUpTheYAxisWhenReceivesForwards() {
        final var marsRover = new Rover(new Position(0, 0), NORTH);

        final var updatedRover = marsRover.receiveForwards().receiveForwards();

        assertThat(updatedRover).isEqualTo(new Rover(new Position(0, 2), NORTH));
    }

    @Test
    void aRoverMovesBackwardsUpTheYAxisWhenReceivesBackwardsTwiceAndFacingSouth() {
        final var marsRover = new Rover(new Position(0, 0), SOUTH);

        final var updatedRover = marsRover.receiveBackwards().receiveBackwards();

        assertThat(updatedRover).isEqualTo(new Rover(new Position(0, 2), SOUTH));
    }

    @Test
    void aRoverMovesForwardsUpTheXAxisWhenReceivesForwardsAndFacingEast() {
        final var marsRover = new Rover(new Position(0, 0), EAST);

        final var updatedRover = marsRover.receiveForwards().receiveForwards();

        assertThat(updatedRover).isEqualTo(new Rover(new Position(2, 0), EAST));
    }
}
