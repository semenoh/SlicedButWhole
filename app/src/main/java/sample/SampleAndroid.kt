package sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import sample.R.id.submitButton

actual class Database {
    var firebase: FirebaseDatabase? = null
    actual fun store(value: String) {
        firebase?.let {
            it.reference.child("android").push().setValue(value)
        }
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)

        val db = Database()
        db.firebase = FirebaseDatabase.getInstance()
        val presenter = Presenter(db)

        submitButton.setOnClickListener {
            presenter.onSubmitClick(edittext.text.toString())
        }
    }
}