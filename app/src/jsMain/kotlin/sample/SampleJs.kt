package sample

import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.p
import kotlin.browser.document
import kotlin.browser.window

actual class Sample {
    actual fun checkMe() = 7
}

actual object Platform {
    actual val name: String = "JS"
}

fun main(args: Array<String>) {
    if (document.body != null) {
        init()
    } else {
        document.addEventListener("DOMContentLoaded", { init() })
    }
}

fun init() {
    document.body!!.append.p {
        + hello()
        onClickFunction = { window.alert(hello()) }
    }
}