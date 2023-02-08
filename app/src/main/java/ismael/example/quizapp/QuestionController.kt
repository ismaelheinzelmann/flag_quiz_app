package ismael.example.quizapp

import java.util.*
import kotlin.collections.ArrayList

class QuestionController {
    var question: Question? = null
    var countriesList = mutableListOf<String>()

    init {
        countriesList = getCountries()
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

    fun newQuestion() {

        //
        var countriesNames = mutableListOf<String>()
        countriesList.shuffle()
        countriesNames.add(countriesList[0])
        countriesList.removeFirst()

        repeat(3) {
            countriesNames.add(countriesList[0])
        }
        this.question =
            Question(countriesNames[0], countriesNames[1], countriesNames[2], countriesNames[3])
        TODO(
            "Implement the options activy which will have the flag and four options.+" +
                    "Implement the logic to get the flag from the country name. from the api (link below).+" +
                    "https://countryflagsapi.com/#flagSelection+" +
                    "https://www.geeksforgeeks.org/how-to-load-svg-from-url-in-android-imageview-with-kotlin/+" +
                    "https://countryflagsapi.com/svg/${this.question!!.correct.lowercase()}"
        )
    }
}