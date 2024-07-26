package hernanbosqued.modelado.car

import hernanbosqued.modelado.gear.GearBox
import hernanbosqued.modelado.Coordinate
import hernanbosqued.modelado.steering.Direction
import hernanbosqued.modelado.steering.SteeringWheel

class Car(
    private val gearBox: GearBox,
    private val steering: SteeringWheel
){

    private var coordinate = Coordinate(0, 0)

    fun go() {
        val deltaX = when(steering.directionPair.first){
            Direction.NEGATIVE -> -gearBox.getRelation()
            Direction.POSITIVE -> gearBox.getRelation()
            Direction.NEUTRAL -> 0
        }

        val deltaY = when(steering.directionPair.second){
            Direction.NEGATIVE -> -gearBox.getRelation()
            Direction.POSITIVE -> gearBox.getRelation()
            Direction.NEUTRAL -> 0
        }

        coordinate = coordinate.copy(
            x = coordinate.x + deltaX,
            y = coordinate.y + deltaY
        )
    }

    fun getPosition(): Coordinate = coordinate
}