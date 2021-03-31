package be.swsb.coderetreat;



import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.Direction.EAST;
import static be.swsb.coderetreat.Direction.NORTH;
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

        final var updatedRover = marsRover.receiveForwards();

        assertThat(updatedRover).isEqualTo(new Rover(new Position(0, 1), NORTH));

    }
}
