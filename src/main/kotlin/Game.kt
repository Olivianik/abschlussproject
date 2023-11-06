import kotlin.system.exitProcess

class Game(private val team: Team, private val finalBoss: FinalBoss, private val bag: Bag) {
    private var underBoss: Opponent? = null
    private val userInput = UserInput()
    fun start() {
        val gameName = """
        ||| --- --- --- --- --- -- ---- -- -- --   |||
        ||| ---------- Grendizer ---------------   |||
        ||| ---------- The Battle Arena --------   |||
        ||| --- --- --- --- --- -- -- -- -- -- --  |||
    """.trimIndent()
        println(gameName)

        println("Welcome to the Game!")
        while (true) {
            println("Geben Sie 1 zum Abspielen oder 2 zum Beenden ein: ")
            val input = readlnOrNull()
            if (input != null) {
                if (input.toIntOrNull() == 1) {
                    team.printHeroesHp()
                    finalBoss.printOpponentHp()
                    println("Lasst den Kampf beginnen!")

                    while (team.isAnyHeroAlive() && (finalBoss.isAlive() || (underBoss != null && underBoss!!.isAlive()))) {

                        team.heroes.forEach { hero ->
                            if (hero.isAlive()) {
                                println("${hero.name}'s turn:")
                                val actionTarget = if (underBoss != null && underBoss!!.isAlive()) {
                                    println("Wählen Sie ein Ziel:")
                                    println("1. Final Boss")
                                    println("2. Under Boss")
                                    val targetChoice = userInput.getInt("Geben Sie Ihre Wahl ein (1 or 2): ")
                                    userInput.consumeNewLine()
                                    if (targetChoice == 1) finalBoss else underBoss!!
                                } else {
                                    finalBoss
                                }
                                hero.doSomeAction(actionTarget, bag, team)
                            }
                        }

                        if (finalBoss.isAlive()) {
                            finalBoss.doSomeAction(team)
                        }

                        // Check if the UnderBoss needs to be created
                        if (finalBoss.isUsedUnderBoss && underBoss == null) {
                            underBoss = UnderBoss("UnderBoss", 100)
                            println("The Final Boss erstellt the UnderBoss!")
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
                        println("Glückwunsch! Du hast sie besiegt..")
                    } else {
                        println("Ich habe sie besiegt. Game Over!")
                    }
                } else if (input.toIntOrNull() == 2) {
                    exitProcess(0)
                } else {
                    println("bitte auswählen 1 or 2 ")
                }
            } else {
                println("bitte auswählen 1 or 2 ")
            }
        }

    }
}



















