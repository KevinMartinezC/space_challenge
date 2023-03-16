package design

class U2 : Rocket() {

    init {
        cost = 120
        weight = 18000
        currentWeight = 18000
        maxWeight = 29000
    }

    override fun launch(): Boolean {
        chanceOfLaunchFailure = 0.04 * (currentWeight.toDouble() - weight) / (maxWeight - weight)
        return chanceOfLaunchFailure <= Math.random() * 0.1
    }

    override fun land(): Boolean {
        chanceOfLandingFailure = 0.08 * (currentWeight.toDouble() - weight) / (maxWeight - weight)
        return chanceOfLandingFailure <= Math.random() * 0.1
    }
}