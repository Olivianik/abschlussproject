import java.util.InputMismatchException
import java.util.Scanner
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
                println("Ungültige Eingabe. Bitte geben Sie eine gültige Ganzzahl ein.")
                scanner.nextLine()
            }
        }
    }
    fun consumeNewLine() {
        scanner.nextLine()
    }
}
















