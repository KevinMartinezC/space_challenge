 open class Rocket : SpaceShip {
    var cost = 0
    var weight = 0
    var currentWeight = 0
    var maxWeight = 0
    var chanceOfLaunchFailure = 0.0
    var chanceOfLandingFailure = 0.0

    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }

    override fun canCarry(item: Item?): Boolean {
        return currentWeight + item!!.weight <= maxWeight
    }

    override fun carry(item: Item?) {
        currentWeight += item!!.weight
    }
}
