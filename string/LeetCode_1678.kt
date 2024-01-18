package string

class LeetCode_1678 {

    fun interpret(command: String) = command
        .replace("(al)", "al")
        .replace("()", "o")
}