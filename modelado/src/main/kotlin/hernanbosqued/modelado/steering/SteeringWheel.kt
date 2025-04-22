package hernanbosqued.modelado.steering

abstract class SteeringWheel {
    open var directionPair: Pair<Direction, Direction> = Direction.NEUTRAL to Direction.POSITIVE
}
