package be.swsb.coderetreat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

    @Test
    void RoverHasPositionAndFacingADirection() {

        Rover rover = new Rover();

        assertThat(rover).isEqualTo(new Rover(Direction.NORTH, new Position(0,0)));

    }
}
