package be.swsb.coderetreat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void incrementY() {
        assertThat(new Position(0,0).incrementY()).isEqualTo(new Position(0,1));

    }
}