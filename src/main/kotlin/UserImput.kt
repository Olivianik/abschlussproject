import java.util.*

class UserInput {
    private val scanner = Scanner(System.`in`)

    fun getString(prompt: String): String {
        print(prompt)
        return scanner.nextLine()
    }

    fun getInt(prompt: String): Int {
        while (true) {
            try {
                print(prompt)
                return scanner.nextInt()
            } catch (e: InputMismatchException) {
                println("Invalid input. Please enter a valid integer.")
                scanner.nextLine()
            }
        }
    }

    fun consumeNewLine() {
        scanner.nextLine()
    }
}