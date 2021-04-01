package be.swsb.coderetreat;



import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

    /*
     * 4 Rules of Simple Design
     * 1. Passes tests
     * 2. Reveals intent
     * 3. No duplication (of concepts)
     * 4. Least amount of elements / KISS
     */

    @Test
    void aRoverCanBeInitializedWithAPositionAndADirection() {
        final var position = new Position(0, 0);
        final var direction = Direction.NORTH;
        final var rover = new Rover(position, direction);

        assertThat(rover.getPosition()).isEqualTo(new Position(0,0));
        assertThat(rover.getDirection()).isEqualTo(Direction.NORTH);
    }
}
