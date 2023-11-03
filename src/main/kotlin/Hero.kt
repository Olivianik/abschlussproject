// open class means that other clases can inhirite from it otherwise you've got compliation error

open class Hero(val name: String, val maxHp: Int) {
    var actions: List<Action>
    private var hp: Int
    private val userInput: UserInput
    private var isProtectiveSpell: Boolean // to prevent the hero from taking dmg in the next attack
    private var isTakingVitamin: Boolean // to increase the dmg of the hero by 10%

    init {
        hp = maxHp
        userInput = UserInput()
        isProtectiveSpell = false
        isTakingVitamin = false
        actions = listOf()
    }

    fun doSomeAction(opponent: Opponent, bag: Bag, team: Team) {
        println("Choose an action for $name:")
        println("1. Perform an action")
        println("2. Use a healing potion")
        println("3. Use a vitamin")

        val action: Action?
        var actionNumber : Int
        while (true) {
            actionNumber = userInput.getInt("Enter your choice (1, 2, or 3):")
            userInput.consumeNewLine()
            if(actionNumber in 1..3)
                break
            println("Invalid choice. Please select 1, 2, or 3.")
        }
        when (actionNumber) {
            1 -> {
                println("$name's available actions:")
                for ((index, action) in actions.withIndex()) {
                    println("${index + 1}. ${action.name}")
                }

                var selectedActionIndex: Int

                while (true) {
                    selectedActionIndex = userInput.getInt("Choose an action by number:")
                    userInput.consumeNewLine()

                    if (selectedActionIndex in 1..actions.size) {
                        action = actions[selectedActionIndex - 1]
                        break
                    }
                    println("Invalid choice. Please select a valid action.")
                }

                if (action != null) {
                    var damage = action.damage

                    // Check if the hero is taking vitamin, and if so, increase damage by 10%
                    if (isTakingVitamin) {
                        damage = (damage * 1.10).toInt()
                    }

                    if (damage == 0) {
                        isProtectiveSpell = true
                    } else if (damage > 0) {
                        if ((0..100).random() >= 30) {
                            damage = (damage * 1.5).toInt()
                            opponent.takeDamage(damage)
                            println("$name attacks ${opponent.name} for $damage damage (Critical Hit)!")
                        } else {
                            opponent.takeDamage(damage)
                            println("$name attacks ${opponent.name} for $damage damage.")
                        }
                    } else {
                        heal(-1 * damage)
                        println("$name heals for $damage HP.")
                    }
                } else {
                    println("Invalid action. Choose from available actions.")
                }
            }

            2 -> {
                val heroToHeal =
                    userInput.getString("Enter the name of the hero to give the healing potion to: ")
                val targetHero = team.findHeroByName(heroToHeal)
                if (targetHero != null) {
                    bag.useHealingPotion(targetHero)
                } else {
                    println("Invalid hero name.")
                }
            }

            3 -> {
                val heroToGiveVitamin =
                    userInput.getString("Enter the name of the hero to give the vitamin to: ")
                val targetHero = team.findHeroByName(heroToGiveVitamin)
                if (targetHero != null) {
                    bag.takeVitamin(targetHero)
                } else {
                    println("Invalid hero name.")
                }
            }

            else -> {
                println("Invalid choice. Please select 1, 2, or 3.")
            }
        }
    }















    fun isAlive(): Boolean = hp > 0

    fun heal(healing: Int) {
        hp = minOf(hp + healing, maxHp)
    }

    fun takeVitamin() {
        isTakingVitamin = true
    }

    fun takeDamage(damage: Int) {
        if (isProtectiveSpell) {
            isProtectiveSpell = false
            return
        }
        hp -= damage
    }

    fun getHp(): Int = hp

}





