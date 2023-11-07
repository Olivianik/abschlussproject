class Bag(var healingPotions: Int = 3, var vitamins: Int = 3, var isUsedThisRound: Boolean = false) {
    fun useHealingPotion(hero: Hero) {
        if (healingPotions > 0) {
            val halfOfMaxHp = hero.maxHp / 2
            if (hero.getHp() < halfOfMaxHp) {
                val remainToHalf = halfOfMaxHp - hero.getHp()
                hero.heal(remainToHalf)
            }
            healingPotions--
            println("${hero.name} uses a healing potion and restores half of his HP if his hp was under the half.")
        } else {
            println("No healing potions left.")
        }
    }

    fun takeVitamin(hero: Hero) {
        if (vitamins > 0) {
            hero.takeVitamin()
            vitamins--
            println("${hero.name} uses a vitamin.")
        } else {
            println("No vitamins left.")
        }
    }
}