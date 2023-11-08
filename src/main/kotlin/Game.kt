
class Game(private val team: Team, private val finalBoss: FinalBoss, private val bag: Bag) {
    private var underBoss: Opponent? = null
    private val userInput = UserInput()
    fun start() {

        println("Welcome to the Game!")
        team.printHeroesHp()
        finalBoss.printOpponentHp()
        println("Let the battle begin!")

        while (team.isAnyHeroAlive() && (finalBoss.isAlive() || (underBoss != null && underBoss!!.isAlive()))) {
            team.heroes.forEach { hero ->
                if (hero.isAlive()) {
                    println("${hero.name}'s turn:")
                    val actionTarget = if (underBoss != null && underBoss!!.isAlive()) {
                        println("Choose a target:")
                        println("1. Final Boss")
                        println("2. Under Boss")
                        val targetChoice = userInput.getInt("Enter your choice (1 or 2): ")
                        userInput.consumeNewLine()
                        if (targetChoice == 1) finalBoss else underBoss!!
                    } else {
                        finalBoss
                    }
                    hero.doSomeAction(actionTarget, bag)
                }
            }
            bag.isUsedThisRound = false
            if (finalBoss.isAlive()) {
                finalBoss.doSomeAction(team)
            }

            // Überprüfen Sie, ob der UnderBoss erstellt werden muss

            finalBoss.isUsedUnderBoss=true
            if (finalBoss.isUsedUnderBoss && underBoss == null) {
                underBoss = UnderBoss("UnderBoss", 100)
                println("The Final Boss created the UnderBoss!")
                underBoss!!.printOpponentHp()
            }

            if (underBoss != null && underBoss!!.isAlive()) {
                underBoss!!.doSomeAction(team)
            }

            println()
            team.printHeroesHp()
            finalBoss.printOpponentHp()
            if (underBoss != null) {
                underBoss!!.printOpponentHp()
            }
        }

        if (team.isAnyHeroAlive()) {
            println("Congratulations! You defeated Them.")
        } else {
            println("You were defeated by Them. Game Over!")
        }

    }
}