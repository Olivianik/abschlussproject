


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

    fun doSomeAction(opponent: Opponent, bag: Bag) {
        println("Choose an action for $name:")

        var actionNumber: Int
        while (true) {
            for ((index, action) in actions.withIndex()) {
                println("${index + 1}. ${action.name}")
            }

            val canUseBag = !bag.isUsedThisRound

            if (canUseBag) {
                println("${actions.size + 1}. Use Bag")
            } else {
                println("${actions.size + 1}. Use Bag (Unavailable)")
            }

            actionNumber = userInput.getInt("Enter your choice: ")
            userInput.consumeNewLine()

            if (actionNumber in 1..(actions.size + 1)) {
                if (actionNumber <= actions.size) {
                    val selectedActionIndex = actionNumber - 1
                    val action = actions[selectedActionIndex]
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
                    break
                } else {
                    if (canUseBag) {
                        println("1. Use a healing potion : ${bag.healingPotions}")
                        println("2. Use a vitamin : ${bag.vitamins}")
                        var bagActionNumber: Int
                        while (true) {
                            bagActionNumber = userInput.getInt("Enter your choice: ")
                            userInput.consumeNewLine()
                            if (bagActionNumber in 1..2) {
                                when (bagActionNumber) {
                                    1 -> {
                                        bag.useHealingPotion(this)
                                    }

                                    2 -> {
                                        bag.takeVitamin(this)
                                    }
                                }
                                break
                            }
                            println("Invalid choice. Please select 1 or 2 only.")
                        }
                        bag.isUsedThisRound = true
                        break
                    } else {
                        println("The bag cannot be used in this round. Please select a valid action.")
                    }
                }
            } else {
                println("Invalid choice. Please select a valid action.")
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
