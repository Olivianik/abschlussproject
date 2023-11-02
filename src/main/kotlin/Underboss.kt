

class UnderBoss(name: String, maxHp: Int) : Opponent(name, maxHp) {
    init {
        actions = listOf(
            Action("Dark Magic", 30),
            Action("Shadow Strike", 60),
        )
    }
    override fun doSomeAction(team: Team) {
        val randomAction: Action = actions.random()
        if (randomAction.name == "Dark Magic") {
            team.heroes.forEach { hero ->
                hero.takeDamage(randomAction.damage)
            }
        } else if (randomAction.name == "Shadow Strike") {
            val randomHero = team.heroes.random()
            randomHero.takeDamage(randomAction.damage)
        }
    }
}







