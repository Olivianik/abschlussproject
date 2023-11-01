class Bag(var healingPotions: Int = 3, var vitamins: Int = 1) {
    fun useHealingPotion(hero: Hero) {
        if (healingPotions > 0) {
            val halfOfMaxHp = hero.maxHp / 2
            if (hero.getHp() < halfOfMaxHp) {
                val remaingToHalf = halfOfMaxHp - hero.getHp()
                hero.heal(remaingToHalf)
            }
            healingPotions--
            println("${hero.name} uses a healing potion and restores half of his HP.")
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