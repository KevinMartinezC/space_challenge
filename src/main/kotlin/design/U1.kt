package design

class U1 : Rocket() {

    init {
        cost = COST
        weight = WEIGHT
        currentWeight = CURRENT_WEIGHT
        maxWeight = MAX_WEIGHT
    }

    override fun launch(): Boolean {
        chanceOfLaunchFailure = CHANCE_LAUNCH_EXPL0TION * (currentWeight.toDouble() - weight) / (maxWeight - weight)
        return chanceOfLaunchFailure <= Math.random() * MAX_FAILURE_RATE
    }

    override fun land(): Boolean {
        chanceOfLandingFailure = CHANCE_LANDING_EXPLOTION * ((currentWeight - weight).toDouble() / (maxWeight - weight))
        return chanceOfLandingFailure <= Math.random() * MAX_FAILURE_RATE
    }

    companion object {
        const val CHANCE_LAUNCH_EXPL0TION: Double = 0.05
        const val CHANCE_LANDING_EXPLOTION: Double = 0.01
        const val MAX_FAILURE_RATE: Double = 0.1
        const val COST: Int = 100
        const val WEIGHT: Int = 1000
        const val CURRENT_WEIGHT: Int = 10000
        const val MAX_WEIGHT: Int = 18000
    }
}