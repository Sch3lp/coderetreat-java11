package be.swsb.coderetreat;


import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.Command.*;
import static be.swsb.coderetreat.Direction.*;
import static be.swsb.coderetreat.Position.at;
import static be.swsb.coderetreat.Rover.aRover;
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
        final var rover = aRover(position, NORTH);

        assertThat(rover).isEqualTo(aRover(at(0, 0), NORTH));
    }

    @Test
    void aRoverCanReceiveForwardsTwoTimesWhenFacingNorth_YIsIncreasedByTwo() {
        final var position = at(0, 0);
        final var rover = aRover(position, NORTH);
        final var roverAfterForwards = rover.receive(FORWARDS).receive(FORWARDS);

        assertThat(roverAfterForwards).isEqualTo(aRover(at(0, 2), NORTH));
    }

    @Test
    void aRoverCanReceiveForwardsTwoTimesWhenFacingEast_XIsIncreasedByTwo() {
        final var position = at(0, 0);
        final var rover = aRover(position, EAST);
        final var roverAfterForwards = rover.receive(FORWARDS).receive(FORWARDS);

        assertThat(roverAfterForwards).isEqualTo(aRover(at(2, 0), EAST));
    }

    @Test
    void aRoverCanReceiveForwardsTwoTimesWhenFacingSouth_YIsDecreasedByTwo() {
        final var position = at(0, 0);
        final var rover = aRover(position, SOUTH);
        final var roverAfterForwards = rover.receive(FORWARDS).receive(FORWARDS);

        assertThat(roverAfterForwards).isEqualTo(aRover(at(0, -2), SOUTH));
    }

    @Test
    void aRoverCanReceiveForwardsTwoTimesWhenFacingWest_XIsDecreasedByTwo() {
        final var position = at(0, 0);
        final var rover = aRover(position, WEST);
        final var roverAfterForwards = rover.receive(FORWARDS).receive(FORWARDS);

        assertThat(roverAfterForwards).isEqualTo(aRover(at(-2, 0), WEST));
    }

    @Test
    void aRoverCanReceiveBackwardsTwoTimesWhenFacingNorth_YIsDecreasedByTwo() {
        final var position = at(0, 0);
        final var rover = aRover(position, NORTH);
        final var roverAfterBackwards = rover.receive(BACKWARDS).receive(BACKWARDS);

        assertThat(roverAfterBackwards).isEqualTo(aRover(at(0, -2), NORTH));
    }

    @Test
    void aRoverCanReceiveBackwardsTwoTimesWhenFacingEast_XIsDecreasedByTwo() {
        final var position = at(0, 0);
        final var rover = aRover(position, EAST);
        final var roverAfterBackwards = rover.receive(BACKWARDS).receive(BACKWARDS);

        assertThat(roverAfterBackwards).isEqualTo(aRover(at(-2, 0), EAST));
    }

    @Test
    void aRoverCanReceiveBackwardsTwoTimesWhenFacingSouth_YIsIncreasedByTwo() {
        final var position = at(0, 0);
        final var rover = aRover(position, SOUTH);
        final var roverAfterBackwards = rover.receive(BACKWARDS).receive(BACKWARDS);

        assertThat(roverAfterBackwards).isEqualTo(aRover(at(0, 2), SOUTH));
    }

    @Test
    void aRoverCanReceiveBackwardsTwoTimesWhenFacingWest_XIsIncreasedByTwo() {
        final var position = at(0, 0);
        final var rover = aRover(position, WEST);
        final var roverAfterBackwards = rover.receive(BACKWARDS).receive(BACKWARDS);

        assertThat(roverAfterBackwards).isEqualTo(aRover(at(2, 0), WEST));
    }

    @Test
    void aRoverCanReceiveLeft_andRotateCounterClockwise() {
        final var position = at(0, 1);
        final var rover = aRover(position, NORTH);

        final var roverAfterFirstLeft = rover.receive(LEFT);
        assertThat(roverAfterFirstLeft).isEqualTo(aRover(at(0, 1), WEST));

        final var roverAfterSecondLeft = roverAfterFirstLeft.receive(LEFT);
        assertThat(roverAfterSecondLeft).isEqualTo(aRover(at(0, 1), SOUTH));

        final var roverAfterThirdLeft = roverAfterSecondLeft.receive(LEFT);
        assertThat(roverAfterThirdLeft).isEqualTo(aRover(at(0, 1), EAST));

        final var roverAfterFourthLeft = roverAfterThirdLeft.receive(LEFT);
        assertThat(roverAfterFourthLeft).isEqualTo(aRover(at(0, 1), NORTH));
    }

    @Test
    void aRoverCanReceiveRight_andRotateClockwise() {
        final var position = at(1, 0);
        final var rover = aRover(position, NORTH);

        final var roverAfterFirstRight = rover.receive(RIGHT);
        assertThat(roverAfterFirstRight).isEqualTo(aRover(at(1, 0), EAST));

        final var roverAfterSecondRight = roverAfterFirstRight.receive(RIGHT);
        assertThat(roverAfterSecondRight).isEqualTo(aRover(at(1, 0), SOUTH));

        final var roverAfterThirdRight = roverAfterSecondRight.receive(RIGHT);
        assertThat(roverAfterThirdRight).isEqualTo(aRover(at(1, 0), WEST));

        final var roverAfterFourthRight = roverAfterThirdRight.receive(RIGHT);
        assertThat(roverAfterFourthRight).isEqualTo(aRover(at(1, 0), NORTH));
    }
}
