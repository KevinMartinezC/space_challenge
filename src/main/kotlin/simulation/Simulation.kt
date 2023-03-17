package simulation

import design.Item
import design.Rocket
import design.U1
import design.U2
import java.io.File
import java.io.FileNotFoundException
import java.util.*

internal class Simulation {
    @Throws(FileNotFoundException::class)
    fun loadItems(filePath: String?): ArrayList<Item> {
        val itemCollection = ArrayList<Item>()
        try {
            val manifest = filePath?.let { File(it) }
            val manifestScanner = manifest?.let { Scanner(it) }
            var loadItem: Array<String>
            if (manifestScanner != null) {
                while (manifestScanner.hasNextLine()) { //to check if there is more input available to read from the file before attempting to read next line using nextLine()
                    val item = Item()
                    loadItem = manifestScanner.nextLine().split("=").toTypedArray()
                    item.name = loadItem[0]
                    item.weight = loadItem[1].toInt()
                    itemCollection.add(item)
                }
            }
            manifestScanner?.close()
        } catch (nfe: NumberFormatException) {
            println("Please enter weights in numeric format!")
        } catch (iob: IndexOutOfBoundsException) {
            println("Please separate item name and weight with '='")
        }
        return itemCollection
    }


    //takes an ArrayList of "item" object as input and returns an ArrayList of design.Rocket
    fun loadU1(itemsLoadList: ArrayList<Item>): ArrayList<Rocket> {
        val u1Rockets = ArrayList<Rocket>()
        var u1Rocket: Rocket = U1()
        for (item in itemsLoadList) {
            if (u1Rocket.canCarry(item)) {//it checks if the current "u1Rocket" can carry it using the 'canCarry' method of the design.U1 class
                u1Rocket.carry(item)       //if the rocket can carry the item, the item is added to the rocket using the 'carry' method
            } else {
                u1Rockets.add(u1Rocket)
                u1Rocket = U1()
                u1Rocket.carry(item)
            }
        }
        if (itemsLoadList.size != 0) {
            u1Rockets.add(u1Rocket)
        }
        return u1Rockets
    }

    fun loadU2(itemsLoadList: ArrayList<Item>): ArrayList<Rocket> {
        val u2Rockets = ArrayList<Rocket>()
        var u2Rocket: Rocket = U2()
        for (item in itemsLoadList) {
            if (u2Rocket.canCarry(item)) {
                u2Rocket.carry(item)
            } else {
                u2Rockets.add(u2Rocket)
                u2Rocket = U2()
                u2Rocket.carry(item)
            }
        }
        if (itemsLoadList.size != 0) {
            u2Rockets.add(u2Rocket)
        }
        return u2Rockets
    }

    fun runSimulation(rockets: ArrayList<Rocket>): Int {
        var totalBudget: Int = 0
        for (rocket in rockets) {
            do {
                totalBudget += rocket.cost
            } while (!(rocket.launch() && rocket.land()))
        }
        return totalBudget
    }
}