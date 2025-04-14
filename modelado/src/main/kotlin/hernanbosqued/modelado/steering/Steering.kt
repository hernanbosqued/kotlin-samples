package hernanbosqued.modelado.steering

class Steering: SteeringWheel() {

    fun steer(steeringWheelPosition: SteeringWheelPosition) {
        directionPair = when(steeringWheelPosition){
            SteeringWheelPosition.LEFT -> Direction.NEGATIVE to Direction.NEUTRAL
            SteeringWheelPosition.RIGHT -> Direction.POSITIVE to Direction.NEUTRAL
            SteeringWheelPosition.TOP -> Direction.NEUTRAL to Direction.POSITIVE
            SteeringWheelPosition.BOTTOM -> Direction.NEUTRAL to Direction.NEGATIVE
        }
    }
}