



        fun main() {
            val team = Team(
                listOf(
                    Krieger("Kreiger", 100),
                    Magician("Magician", 100),
                    Warrior("warrior", 100)
                )
            )
            val bag = Bag(3,1)
            val finalBoss = FinalBoss("Final Boss", 200)
            val game = Game(team, finalBoss, bag)
            game.start()
        }


