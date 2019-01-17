package sample

import kotlin.browser.document
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement

external fun require(name: String): dynamic

actual class Database {
    var firebase: dynamic = null
    actual fun store(value: String) {
        firebase?.ref("js")?.push()?.set(value)
    }
}

fun main(args: Array<String>) {
    if (document.body != null) {
        init()
    } else {
        document.addEventListener("DOMContentLoaded", { init() })
    }
}

const val iid = "valueInput"

fun init() {
    val firebase = require("firebase").initializeApp(firConfigDynamic)

    val db = Database()
    db.firebase = firebase.database()
    val presenter = Presenter(db)

    document.body!!.append.div {
        label {
            htmlFor = iid
            text("Enter text")
        }
        textInput {
            this.id = iid
            type = InputType.text
        }
        button {
            + "Submit"
            onClickFunction = { event ->
                val inputField = document.getElementById(iid) as HTMLInputElement
                presenter.onSubmitClick(inputField.value)
                inputField.value = ""
            }
        }
    }

}