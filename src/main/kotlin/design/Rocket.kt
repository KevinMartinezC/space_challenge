package design

open class Rocket : SpaceShip {
    var cost: Int = 0
    var weight: Int = 0
    var currentWeight: Int = 0
    var maxWeight: Int = 0
    var chanceOfLaunchFailure: Double = 0.0
    var chanceOfLandingFailure: Double = 0.0

    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }

    /***
     * The function checks whether the sum of the rocket's currentWeight
     * and the item's weight is less than or equal to the maxWeight of the rocket.
     */
    override fun canCarry(item: Item?): Boolean {
        return item?.let { currentWeight + it.weight <= maxWeight } ?: false
    }

    /***
     * The carry() function also takes a design.Item object as input
     * and updates the currentWeight property of the rocket by adding the item's weight to it.
     */
    override fun carry(item: Item?) {
        item?.let {
            currentWeight += item.weight
        }
    }
}
