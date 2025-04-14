package hernanbosqued.modelado.steering

class SteeringDiagonal: SteeringWheel() {

    fun steer(steeringWheelPosition: SteeringWheelDiagonal) {
        directionPair = when(steeringWheelPosition){
            SteeringWheelDiagonal.TOP_LEFT -> Direction.NEGATIVE to Direction.POSITIVE
            SteeringWheelDiagonal.TOP_RIGHT -> Direction.POSITIVE to Direction.POSITIVE
            SteeringWheelDiagonal.BOTTOM_LEFT -> Direction.NEGATIVE to Direction.NEGATIVE
            SteeringWheelDiagonal.BOTTOM_RIGHT -> Direction.POSITIVE to Direction.NEGATIVE
        }
    }
}