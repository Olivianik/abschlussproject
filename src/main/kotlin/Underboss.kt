

class UnderBoss(name: String, maxHp: Int) : Opponent(name, maxHp) {

    init {
        actions = listOf(
            Action("Dark Magic", 30),
            Action("Shadow Strike", 60),
            Action("Fire Strike", 20),
            Action("Bricks Strike", 10),
        )
    }

    override fun doSomeAction(team: Team) {
        val randomAction: Action = actions.random()

        when (randomAction.name) {
            "Dark Magic" -> {
                team.heroes.forEach { hero ->
                    val damage = randomAction.damage
                    hero.takeDamage(damage)
                    println("Under Boss casts Dark Magic on ${hero.name} for $damage damage.")
                }
            }
            "Shadow Strike", "Fire Strike", "Bricks Strike" -> {
                val randomHero = team.heroes.random()
                val damage = randomAction.damage
                randomHero.takeDamage(damage)
                println("Under Boss uses ${randomAction.name} on ${randomHero.name} for $damage damage.")
            }
        }

    }

}






