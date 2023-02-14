package ismael.example.quizapp

data class Question(
    val correct: String,
    val drawableFlag: Int
) {
    fun isCorrect(answer: String): Boolean {
        return answer == correct
    }
}
