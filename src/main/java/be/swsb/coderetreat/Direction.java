package be.swsb.coderetreat;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction opposite() {
        switch (this) {
            case NORTH: return SOUTH;
            case EAST: return WEST;
            case SOUTH: return NORTH;
            case WEST: return EAST;
            default: throw new IllegalArgumentException("Explosion!");
        }
    }

    public Direction rotateCounterClockwise() {
        switch (this) {
            case NORTH: return WEST;

            case WEST: return SOUTH;
            default: throw new IllegalArgumentException("Explosion!");
        }
    }
}
