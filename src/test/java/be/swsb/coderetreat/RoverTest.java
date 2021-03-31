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

        assertThat(marsRover.getPosition()).isEqualTo(new Position(0,0));
        assertThat(marsRover.getDirection()).isEqualTo(NORTH);
    }
}
