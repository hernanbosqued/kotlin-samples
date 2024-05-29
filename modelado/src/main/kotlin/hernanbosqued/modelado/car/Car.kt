package hernanbosqued.modelado.car

import hernanbosqued.modelado.gear.GearBox
import hernanbosqued.modelado.gear.GearStick
import hernanbosqued.modelado.Coordinate
import hernanbosqued.modelado.steering.SteeringWheelPosition
import hernanbosqued.modelado.steering.Steering
import hernanbosqued.modelado.steering.SteeringWheel

class Car(
    private val gearBox: GearBox,
    private val steering: Steering
): GearStick by gearBox, SteeringWheel by steering{

    private var coordinate = Coordinate(0, 0)

    fun go() {
        val (deltaX, deltaY) = when (steering.steeringWheelPosition) {
            SteeringWheelPosition.LEFT -> -gearBox.getRelation() to 0
            SteeringWheelPosition.RIGHT -> gearBox.getRelation() to 0
            SteeringWheelPosition.TOP -> 0 to gearBox.getRelation()
            SteeringWheelPosition.BOTTOM -> 0 to -gearBox.getRelation()
        }

        coordinate = coordinate.copy(x = coordinate.x + deltaX, y = coordinate.y + deltaY)
    }

    fun getPosition(): Coordinate = coordinate
}