package sample

import firebase.FIRDatabase

actual class Database {
    var firebase: FIRDatabase? = null
    actual fun store(value: String) {
        firebase?.let {
            it.reference().child("iOS").childByAutoId().setValue(value)
        }
    }
}
