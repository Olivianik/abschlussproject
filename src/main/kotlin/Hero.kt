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
        println("Wahl einer Aktion für $name:")
        println("1. Führen Sie eine Aktion aus")
        println("2. Benutze einen Heilkraft")
        println("3. Verwenden Sie ein Vitamin")

        val action: Action?
        var actionNumber : Int
        while (true) {
            actionNumber = userInput.getInt("Geben Sie Ihre Wal ein (1, 2, or 3):")
            userInput.consumeNewLine()
            if(actionNumber in 1..3)
                break
            println("Ungültige Auswahl. Please select 1, 2, or 3.")
        }
        when (actionNumber) {
            1 -> {
                println("$name's verfürgbar actions:")
                for ((index, action) in actions.withIndex()) {
                    println("${index + 1}. ${action.name}")
                }

                var selectedActionIndex: Int

                while (true) {
                    selectedActionIndex = userInput.getInt("Wählen Sie eine Aktionsmummer:")
                    userInput.consumeNewLine()

                    if (selectedActionIndex in 1..actions.size) {
                        action = actions[selectedActionIndex - 1]
                        break
                    }
                    println("Ungültige Auswahl. Bitte wählen Sie eine gültige Aktion aus.")
                }

                if (action != null) {
                    var damage = action.damage

                    // CÜberprüfen Sie, ob der Held Vitamine einnimmt, und erhöhen Sie in diesem Fall den Schaden um 10 %.
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
                    println("Ungültige Aktion. Wählen Sie aus den verfügbaren Aktionen.")
                }
            }

            2 -> {
                val heroToHeal =
                    userInput.getString("Geben Sie den Namen des Helden ein, dem Sie den Heiltrank geben möchten: ")
                val targetHero = team.findHeroByName(heroToHeal)
                if (targetHero != null) {
                    bag.useHealingPotion(targetHero)
                } else {
                    println("Ungültiger  hero name.")
                }
            }

            3 -> {
                val heroToGiveVitamin =
                    userInput.getString("Geben Sie den Namen des Helden ein, dem Sie das Vitamin geben möchten: ")
                val targetHero = team.findHeroByName(heroToGiveVitamin)
                if (targetHero != null) {
                    bag.takeVitamin(targetHero)
                } else {
                    println("Ungültig hero name.")
                }
            }

            else -> {
                println("Ungültige Auswahl. Bitte auswählen 1, 2, or 3.")
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





