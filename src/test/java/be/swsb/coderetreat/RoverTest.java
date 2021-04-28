package be.swsb.coderetreat;


import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.Command.*;
import static be.swsb.coderetreat.Direction.*;
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

        assertThat(rover).isEqualTo(new Rover(at(0, 0), NORTH));
    }

    @Test
    void aRoverCanReceiveForwardsTwoTimesWhenFacingNorth_YIsIncreasedByTwo() {
        final var position = at(0, 0);
        final var rover = new Rover(position, NORTH);
        final var roverAfterForwards = rover.receive(FORWARDS).receive(FORWARDS);

        assertThat(roverAfterForwards).isEqualTo(new Rover(at(0, 2), NORTH));
    }

    @Test
    void aRoverCanReceiveForwardsTwoTimesWhenFacingEast_XIsIncreasedByTwo() {
        final var position = at(0, 0);
        final var rover = new Rover(position, EAST);
        final var roverAfterForwards = rover.receive(FORWARDS).receive(FORWARDS);

        assertThat(roverAfterForwards).isEqualTo(new Rover(at(2, 0), EAST));
    }

    @Test
    void aRoverCanReceiveForwardsTwoTimesWhenFacingSouth_YIsDecreasedByTwo() {
        final var position = at(0, 0);
        final var rover = new Rover(position, SOUTH);
        final var roverAfterForwards = rover.receive(FORWARDS).receive(FORWARDS);

        assertThat(roverAfterForwards).isEqualTo(new Rover(at(0, -2), SOUTH));
    }

    @Test
    void aRoverCanReceiveForwardsTwoTimesWhenFacingWest_XIsDecreasedByTwo() {
        final var position = at(0, 0);
        final var rover = new Rover(position, WEST);
        final var roverAfterForwards = rover.receive(FORWARDS).receive(FORWARDS);

        assertThat(roverAfterForwards).isEqualTo(new Rover(at(-2, 0), WEST));
    }

    @Test
    void aRoverCanReceiveBackwardsTwoTimesWhenFacingNorth_YIsDecreasedByTwo() {
        final var position = at(0, 0);
        final var rover = new Rover(position, NORTH);
        final var roverAfterBackwards = rover.receive(BACKWARDS).receive(BACKWARDS);

        assertThat(roverAfterBackwards).isEqualTo(new Rover(at(0, -2), NORTH));
    }

    @Test
    void aRoverCanReceiveBackwardsTwoTimesWhenFacingEast_XIsDecreasedByTwo() {
        final var position = at(0, 0);
        final var rover = new Rover(position, EAST);
        final var roverAfterBackwards = rover.receive(BACKWARDS).receive(BACKWARDS);

        assertThat(roverAfterBackwards).isEqualTo(new Rover(at(-2, 0), EAST));
    }

    @Test
    void aRoverCanReceiveBackwardsTwoTimesWhenFacingSouth_YIsIncreasedByTwo() {
        final var position = at(0, 0);
        final var rover = new Rover(position, SOUTH);
        final var roverAfterBackwards = rover.receive(BACKWARDS).receive(BACKWARDS);

        assertThat(roverAfterBackwards).isEqualTo(new Rover(at(0, 2), SOUTH));
    }

    @Test
    void aRoverCanReceiveBackwardsTwoTimesWhenFacingWest_XIsIncreasedByTwo() {
        final var position = at(0, 0);
        final var rover = new Rover(position, WEST);
        final var roverAfterBackwards = rover.receive(BACKWARDS).receive(BACKWARDS);

        assertThat(roverAfterBackwards).isEqualTo(new Rover(at(2, 0), WEST));
    }

    @Test
    void aRoverCanReceiveLeftWhenFacingNorth_RoverIsFacingWest() {
        final var position = at(0, 0);
        final var rover = new Rover(position, NORTH);
        final var roverAfterLeft = rover.receive(LEFT);

        assertThat(roverAfterLeft).isEqualTo(new Rover(at(0,0), WEST));
    }
}
