
fun main() {
    val team = Team(
        listOf(
            Krieger("Kreiger", 200),
            Magician("Magician", 200),
            Warrior("warrior", 200)
        )
    )
    val bag = Bag(3,1)
    val finalBoss = FinalBoss("Final Boss", 500)
    val game = Game(team, finalBoss, bag)
    game.start()
}