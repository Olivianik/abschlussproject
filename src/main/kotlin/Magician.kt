class Magician(name: String, maxHp: Int) : Hero(name, maxHp) {
    init {
        actions = listOf(
            Action("BallOfSnow", 40),
            Action("Heal", -20)
        )
    }
}


