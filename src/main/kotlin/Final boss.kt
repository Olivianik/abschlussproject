class FinalBoss(name: String, maxHp: Int) : Opponent(name, maxHp) {
    var isUsedUnderBoss: Boolean

    init {
        isUsedUnderBoss = false
        actions = listOf(
            Action("FireBall", 70), // dmg all heroes
            Action("hunt", 10), // chose one hero and dmg him by 10% of his hp
            Action("UseUnderBoss", 0)
        )
    }

    override fun doSomeAction(team: Team) {

        val randomAction: Action = if (isUsedUnderBoss) {
            actions.filterNot { it.name == "UseUnderBoss" }.random()
        } else {
            actions.random()
        }
        if (randomAction.name == "FireBall") {
            team.heroes.forEach { hero ->
                hero.takeDamage(randomAction.damage)
            }
        } else if (randomAction.name == "hunt") {
            val randomHero = team.heroes.random()
            val dmgBy10Percent = (randomHero.getHp() * 0.10).toInt()
            randomHero.takeDamage(dmgBy10Percent)
        } else if (randomAction.name == "UseUnderBoss") {
            isUsedUnderBoss = true
        }

    }

}











