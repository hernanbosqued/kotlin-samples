package hernanbosqued.modelado.steering

class Steering: SteeringWheel {

    override var directionPair: Pair<Direction, Direction> = Direction.NEUTRAL to Direction.POSITIVE

    fun steer(steeringWheelPosition: SteeringWheelPosition) {
        directionPair = when(steeringWheelPosition){
            SteeringWheelPosition.LEFT -> Direction.NEGATIVE to Direction.NEUTRAL
            SteeringWheelPosition.RIGHT -> Direction.POSITIVE to Direction.NEUTRAL
            SteeringWheelPosition.TOP -> Direction.NEUTRAL to Direction.POSITIVE
            SteeringWheelPosition.BOTTOM -> Direction.NEUTRAL to Direction.NEGATIVE
        }
    }
}