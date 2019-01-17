package sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

actual class Database {
    actual fun store(value: String) {
        //todo
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Database()
        val presenter = Presenter(db)

        submitButton.setOnClickListener {
            presenter.onSubmitClick(edittext.text.toString())
        }
    }
}