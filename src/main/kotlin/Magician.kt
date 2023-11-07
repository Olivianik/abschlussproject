
class Magician(name: String, maxHp: Int) : Hero(name, maxHp) {
    init {
        actions = listOf(
            Action("Ball of snow", 40),
            Action("Ball of fire", 40),
            Action("Heal", -20)
        )
    }
}

