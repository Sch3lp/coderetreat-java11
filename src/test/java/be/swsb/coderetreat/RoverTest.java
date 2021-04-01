package be.swsb.coderetreat;



import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.Direction.NORTH;
import static be.swsb.coderetreat.Position.at;
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
        final var position = at(0, 0);
        final var rover = new Rover(position, NORTH);

        assertThat(rover).isEqualTo(new Rover(at(0,0), NORTH));
    }

    @Test
    void aRoverCanReceiveForwards_YIsIncreasedByOne() {
        final var position = at(0, 0);
        final var rover = new Rover(position, NORTH);
        final var roverAfterForwards = rover.receive(Command.FORWARDS);

        assertThat(roverAfterForwards).isEqualTo(new Rover(at(0,1), NORTH));

    }
    @Test
    void aRoverCanReceiveForwardsTwoTimes_YIsIncreasedByTwo() {
        final var position = at(0, 0);
        final var rover = new Rover(position, NORTH);
        final var roverAfterForwards = rover.receive(Command.FORWARDS).receive(Command.FORWARDS);

        assertThat(roverAfterForwards).isEqualTo(new Rover(at(0,2), NORTH));

    }


}
