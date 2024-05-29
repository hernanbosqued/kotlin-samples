package hernanbosqued.modelado.gear

class GearBox private constructor(
    private val relationMap: Map<Gear, Int>
): GearStick, GearRelation {
    private var currentGear: Gear = Gear.NEUTRAL

    override fun getRelation(): Int = relationMap[currentGear]?:throw RuntimeException()

    override fun gear(gear: Gear) {
        currentGear = gear
    }

    class Builder{
        private val gearRelationMap: MutableMap<Gear,Int> = mutableMapOf()

        fun addGearRelation(gear: Gear, relation: Int): Builder {
            gearRelationMap[gear] = relation
            return this
        }

        fun build(): GearBox = GearBox(gearRelationMap)
    }
}