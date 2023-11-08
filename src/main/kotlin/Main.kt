import kotlin.system.exitProcess


class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            while (true) {

                val gameName = """
                   ||| --- --- --- --- --- |||
                   ||| --- G O L D E N --- |||
                   ||| --- S Y N T A X --- |||
                   ||| --- --- --- --- --- |||
    """.trimIndent()
                println(gameName)
                println("1. Play")
                println("2. Exit")
                when (readlnOrNull()?.toIntOrNull()) {
                    1 -> {
                        val team = Team(
                            listOf(
                                Krieger("Kreiger", 100),
                                Magician("Magician", 100),
                                Warrior("warrior", 100)
                            )
                        )
                        val bag = Bag(3, 1)
                        val finalBoss = FinalBoss("Final Boss", 500)
                        val game = Game(team, finalBoss, bag)
                        game.start()
                    }

                    2 -> {
                        exitProcess(0)
                    }
                }
            }
        }
    }

}
