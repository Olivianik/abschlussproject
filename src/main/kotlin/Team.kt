
    class Team(val heroes: List<Hero>) {
        fun isAnyHeroAlive(): Boolean {
            return heroes.any { it.isAlive() }
        }

        fun printHeroesHp() {
            heroes.forEach { hero ->
                val hp = maxOf(hero.getHp(), 0)
                println("${hero.name} - HP: $hp")
            }
        }

        fun findHeroByName(heroName: String): Hero? {
            return heroes.find { it.name == heroName }
        }
    }





