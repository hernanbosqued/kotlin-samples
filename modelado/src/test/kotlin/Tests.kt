import hernanbosqued.modelado.Coordinate
import hernanbosqued.modelado.car.Car
import hernanbosqued.modelado.gear.Gear
import hernanbosqued.modelado.gear.GearBox
import hernanbosqued.modelado.steering.Steering
import hernanbosqued.modelado.steering.SteeringAngle
import hernanbosqued.modelado.steering.SteeringDiagonal
import hernanbosqued.modelado.steering.SteeringWheelDiagonal
import hernanbosqued.modelado.steering.SteeringWheelPosition
import org.junit.Assert
import org.junit.Test

class Tests {
    @Test
    fun test1() {
        // GIVEN
        val gearBox =
            GearBox.Builder().apply {
                addGearRelation(Gear.REVERSE, -1)
                addGearRelation(Gear.NEUTRAL, 0)
                addGearRelation(Gear.FIRST, 1)
                addGearRelation(Gear.SECOND, 2)
                addGearRelation(Gear.THIRD, 3)
                addGearRelation(Gear.FOURTH, 4)
            }.build()

        val steering = Steering()

        val car =
            Car(
                gearBox = gearBox,
                steering = steering,
            )

        // WHEN
        car.apply {
            steering.steer(SteeringWheelPosition.TOP)
            gearBox.gear(Gear.FIRST)
            go()
            gearBox.gear(Gear.SECOND)
            go()
            steering.steer(SteeringWheelPosition.LEFT)
            go()
        }

        // THEN
        Assert.assertEquals(Coordinate(-2, 3), car.getPosition())
    }

    @Test
    fun test2() {
        // GIVEN
        val gearBox =
            GearBox.Builder().apply {
                addGearRelation(Gear.REVERSE, -1)
                addGearRelation(Gear.NEUTRAL, 0)
                addGearRelation(Gear.FIRST, 1)
                addGearRelation(Gear.SECOND, 2)
                addGearRelation(Gear.THIRD, 3)
                addGearRelation(Gear.FOURTH, 4)
            }.build()

        val steering = SteeringDiagonal()

        val car =
            Car(
                gearBox = gearBox,
                steering = steering,
            )

        // WHEN
        car.apply {
            gearBox.gear(Gear.FIRST)
            steering.steer(SteeringWheelDiagonal.TOP_LEFT)
            go()
            steering.steer(SteeringWheelDiagonal.BOTTOM_LEFT)
            go()
        }

        // THEN
        Assert.assertEquals(Coordinate(-2, 0), car.getPosition())
    }

    @Test
    fun test3() {
        // GIVEN
        val gearBox =
            GearBox.Builder().apply {
                addGearRelation(Gear.REVERSE, -1)
                addGearRelation(Gear.NEUTRAL, 0)
                addGearRelation(Gear.FIRST, 1)
                addGearRelation(Gear.SECOND, 2)
                addGearRelation(Gear.THIRD, 3)
                addGearRelation(Gear.FOURTH, 4)
            }.build()

        val steering = SteeringAngle()

        val car =
            Car(
                gearBox = gearBox,
                steering = steering,
            )

        // WHEN
        car.apply {
            gearBox.gear(Gear.FIRST)
            steering.steer(90)
            go()
            steering.steer(180)
            go()
        }

        // THEN
        Assert.assertEquals(Coordinate(-1, 1), car.getPosition())
    }
}
