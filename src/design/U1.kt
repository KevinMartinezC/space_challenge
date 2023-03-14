class U1 : Rocket() {

    init {
        cost = 100
        weight = 10000
        currentWeight = 10000
        maxWeight = 18000
    }

    override fun launch(): Boolean {
        chanceOfLaunchFailure = 0.05 * (currentWeight.toDouble() - weight) / (maxWeight - weight)
        return chanceOfLaunchFailure <= Math.random() * 0.1
    }

    override fun land(): Boolean {
        chanceOfLandingFailure = 0.01 * ((currentWeight - weight).toDouble() / (maxWeight - weight))
        return chanceOfLandingFailure <= Math.random() * 0.1
    }
}