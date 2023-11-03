open class Opponent(val name: String, val maxHp: Int) {
    var hp: Int
    var actions: List<Action>

    init {
        hp = maxHp
        actions = listOf()
    }

    open fun doSomeAction(team: Team) {}

    fun takeDamage(damage: Int) {
        hp -= damage
    }

    fun isAlive(): Boolean = hp > 0

    fun printOpponentHp(){
        println("Boss: $name - HP: ${maxOf(0,hp)}")
    }

}





