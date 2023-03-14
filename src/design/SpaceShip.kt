
/**
 * SpaceShip interface containing methods to be implemented by Rocket class to
 * see the minimum set of operations that a spaceship must implement in order to be
 * considered functional
 */
interface SpaceShip {
    fun launch(): Boolean
    fun land(): Boolean
    fun canCarry(item: Item?): Boolean
    fun carry(item: Item?)
}