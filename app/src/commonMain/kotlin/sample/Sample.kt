package sample

expect class Database {
    fun store(value: String)
}

class Presenter(private val db:Database) {
    fun onSubmitClick(value: String?) {
        if (value?.isNotBlank() == true) {
            db.store(value)
        }
    }
}
