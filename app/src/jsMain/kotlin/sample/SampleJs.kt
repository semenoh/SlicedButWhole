package sample

import kotlin.browser.document
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement

actual class Database {
    actual fun store(value: String) {
        //todo
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

    val db = Database()
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
            }
        }
    }

}