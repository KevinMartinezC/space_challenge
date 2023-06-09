import simulation.Simulation

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val simulation = Simulation()

        var u1Budget = 0
        var u2Budget = 0

        // Load items for both phases from text files
        val itemPhaseFile1 = simulation.loadItems("spec_files/phase-1.txt")
        val itemPhaseFile2 = simulation.loadItems("spec_files/phase-2.txt")

        //Load items into design.U1 Rockets for both phases
        val u1RocketsPhaseOne = simulation.loadU1(ArrayList(itemPhaseFile1.plus(itemPhaseFile2)))
        val u1RocketsPhaseTwo = simulation.loadU1(itemPhaseFile2)

        //Run simulations and track budget required for design.U1 rocket
        u1Budget += simulation.runSimulation(u1RocketsPhaseOne)
        u1Budget += simulation.runSimulation(u1RocketsPhaseTwo)

        //Load items into design.U2 Rockets for both phases
        val u2RocketsPhaseOne = simulation.loadU2(itemPhaseFile1)
        val u2RocketsPhaseTwo = simulation.loadU2(itemPhaseFile2)

        //Run simulations and track budget required for design.U1 rocket
        u2Budget += simulation.runSimulation(u2RocketsPhaseOne)
        u2Budget += simulation.runSimulation(u2RocketsPhaseTwo)

        println("Budget required for sending design.U1 Rockets to Mars: $$u1Budget million.")
        println("Budget required for sending design.U2 Rockets to Mars: $$u2Budget million.")

        //Display which rocket type to use
        if (u1Budget < u2Budget) {

            println("\nIt is cheaper to use design.U1 Rockets, so it's better to use this one!!")
            println()
            print("**************************************")
            println("*                                     *")
            println("*                                     *")
            println("*       It's Time to Fly to Mars!!    *")
            println("*                                     *")
            println("*                                     *")
            println("***************************************")

        } else if (u2Budget < u1Budget) {

            println("\nIt is cheaper to use design.U2 Rockets, so it's better to use this one!!")
            println()
            print("**************************************")
            println("*                                     *")
            println("*                                     *")
            println("*       It's Time to Fly to Mars!!    *")
            println("*                                     *")
            println("*                                     *")
            println("***************************************")
        } else {
            println("Both cost the same. It is okay to use either.")
        }
    }
}