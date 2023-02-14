package ismael.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import ismael.example.quizzapp.R

class QuizAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_app)

        val questionController = QuestionController(this)
        val ivFlag = findViewById<ImageView>(R.id.ivFlag)
        ivFlag.setBackgroundResource(questionController.getQuestion(0).drawableFlag)
    }

}