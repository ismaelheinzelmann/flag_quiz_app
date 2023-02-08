package ismael.example.quizapp

data class Question(
    val correct: String,
    val other_1: String,
    val other_2: String,
    val other_3: String
) {
    fun getOptions(): List<String> {
        return listOf(correct, other_1, other_2, other_3).shuffled()
    }
}
