package hernanbosqued.modelado.steering

class Steering: SteeringWheel {
    var steeringWheelPosition: SteeringWheelPosition = SteeringWheelPosition.TOP

    override fun steer(steeringWheelPosition: SteeringWheelPosition) {
        this.steeringWheelPosition = steeringWheelPosition
    }
}