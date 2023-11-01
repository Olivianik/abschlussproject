class Game(private val team: Team, private val opponent: Opponent, private val bag: Bag) {
    fun start() {

        println("Welcome to the Game!")
        team.printHeroesHp()
        opponent.printOpponentHp()
        println("Let the battle begin!")

        while (team.isAnyHeroAlive() && opponent.isAlive()) {
            team.heroes.forEach { hero ->
                if (hero.isAlive()) {
                    println("${hero.name}'s turn:")
                    hero.doSomeAction(opponent, bag, team)
                }
            }

            if (opponent.isAlive()) {
                opponent.doSomeAction(team)
            }

            println()
            team.printHeroesHp()
            opponent.printOpponentHp()
        }

        if (team.isAnyHeroAlive()) {
            println("Congratulations! You defeated ${opponent.name}.")
        } else {
            println("You were defeated by ${opponent.name}. Game Over!")
        }

    }
}












