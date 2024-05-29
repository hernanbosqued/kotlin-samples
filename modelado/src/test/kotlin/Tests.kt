import hernanbosqued.modelado.Coordinate
import hernanbosqued.modelado.car.Car
import hernanbosqued.modelado.gear.Gear
import hernanbosqued.modelado.gear.GearBox
import hernanbosqued.modelado.steering.Steering
import hernanbosqued.modelado.steering.SteeringWheelPosition
import org.junit.Assert
import org.junit.Test

class Tests {
    @Test
    fun test1() {
        //GIVEN
        val gearBox = GearBox.Builder().apply {
            addGearRelation(Gear.REVERSE, -1)
            addGearRelation(Gear.NEUTRAL, 0)
            addGearRelation(Gear.FIRST, 1)
            addGearRelation(Gear.SECOND, 2)
            addGearRelation(Gear.THIRD, 3)
            addGearRelation(Gear.FOURTH, 4)
        }.build()

        val steering = Steering()

        val car = Car(
            gearBox = gearBox,
            steering = steering
        )

        //WHEN
        car.apply {
            steer(SteeringWheelPosition.TOP)
            gear(Gear.FIRST)
            go()
            gear(Gear.SECOND)
            go()
            steer(SteeringWheelPosition.LEFT)
            go()
        }

        //THEN
        Assert.assertEquals(Coordinate(-2,3), car.getPosition())
    }
}
