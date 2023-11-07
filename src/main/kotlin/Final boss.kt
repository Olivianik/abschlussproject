
class FinalBoss(name: String, maxHp: Int) : Opponent(name, maxHp) {
    var isUsedUnderBoss: Boolean

    init {
        isUsedUnderBoss = false
        actions = listOf(
            Action("Fire ball", 70),
            Action("hunt", 10),
            Action("Use under boss", 0),
            Action("Snow ball", 40),
            Action("Curse", 40),
            Action("Poison", 40),
        )
    }

    override fun doSomeAction(team: Team) {

        val randomAction: Action = if (isUsedUnderBoss) {
            actions.filterNot { it.name == "UseUnderBoss" }.random()
        } else {
            actions.random()
        }
        when (randomAction.name) {
            "Fire ball" -> {
                team.heroes.forEach { hero ->
                    val damage = randomAction.damage
                    hero.takeDamage(damage)
                    println("Final boss attacks ${hero.name} with Fire ball for $damage damage.")
                }
            }
            "hunt" -> {
                val randomHero = team.heroes.random()
                val damage = (randomHero.getHp() * 0.10).toInt()
                randomHero.takeDamage(damage)
                println("Final boss attacks ${randomHero.name} with hunt for $damage damage.")
            }
            "Snow ball", "Curse", "Poison" -> {
                val randomHero = team.heroes.random()
                val damage = randomAction.damage
                randomHero.takeDamage(damage)
                println("Final boss attacks ${randomHero.name} with ${randomAction.name} for $damage damage.")
            }
            "Use under boss" -> {
                isUsedUnderBoss = true
            }
        }

    }

}
