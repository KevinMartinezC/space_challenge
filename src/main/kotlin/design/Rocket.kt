package design

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
        return currentWeight + item!!.weight <= maxWeight // The function checks whether the sum of the rocket's currentWeight
        // and the item's weight is less than or equal to the maxWeight of the rocket.
    }

    override fun carry(item: Item?) {
        currentWeight += item!!.weight //The carry() function also takes an design.Item object as input
        // and updates the currentWeight property of the rocket by adding the item's weight to it.

    }
}
