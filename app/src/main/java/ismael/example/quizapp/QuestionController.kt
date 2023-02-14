package ismael.example.quizapp


import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.ArrayList


class QuestionController(private val ctx: AppCompatActivity) {
    private var questions = mutableListOf<Question>()
    var countriesList = mutableListOf<String>()

    init {
        countriesList = getCountries()
        this.newQuestions(10)
    }

    private fun getCountries(): ArrayList<String> {
        val locales: Array<out Locale> = Locale.getAvailableLocales()
        var countries = ArrayList<String>()

        for (locale in locales) {
            val country = locale.displayCountry
            if (country.isNotEmpty()) {
                countries.add(country)
            }
        }
        return countries
    }

    fun getQuestion(n: Int): Question {
        return questions[n]
    }

    private fun getCountryCode(countryName: String): String {
        val locales: Array<out Locale> = Locale.getAvailableLocales()
        for (locale in locales) {
            if (countryName == locale.displayCountry) {
                return locale.country
            }
        }
        return ""
    }

    private fun newQuestions(n: Int) {
        countriesList.shuffle()

        val answerList: List<String> = countriesList.subList(0, n)
        countriesList = countriesList.subList(n, countriesList.size)

        for (answer in answerList) {
            getCountryCode(answer)
            Log.d("COUNTRYCODE", "${getCountryCode(answer).lowercase()}.png")
            val resourceId: Int = ctx.resources.getIdentifier(
                "${getCountryCode(answer).lowercase()}",
                "drawable", ctx.packageName
            )
            Log.d("RESOURCEID", resourceId.toString())
            questions.add(Question(answer, resourceId))

        }
    }
}