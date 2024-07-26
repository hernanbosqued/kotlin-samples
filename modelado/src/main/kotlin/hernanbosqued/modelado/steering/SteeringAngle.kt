package hernanbosqued.modelado.steering

class SteeringAngle: SteeringWheel {

    override var directionPair: Pair<Direction, Direction> = Direction.NEUTRAL to Direction.POSITIVE

    fun steer(steeringWheelPosition: Int) {
        directionPair = when(steeringWheelPosition){
            0  -> Direction.POSITIVE to Direction.NEUTRAL
            45  -> Direction.POSITIVE to Direction.POSITIVE
            90  -> Direction.NEUTRAL to Direction.POSITIVE
            135-> Direction.NEGATIVE to Direction.POSITIVE
            180-> Direction.NEGATIVE to Direction.NEUTRAL
            225-> Direction.NEGATIVE to Direction.NEGATIVE
            270-> Direction.NEUTRAL to Direction.NEGATIVE
            315-> Direction.POSITIVE to Direction.NEGATIVE
            else -> throw RuntimeException()
        }
    }
}