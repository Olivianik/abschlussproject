class Warrior(name: String, maxHp: Int) : Hero(name, maxHp) {
    init {
        actions = listOf(
            Action("Hit", 30),
            Action("UltimateHit", 60)
        )
    }
}