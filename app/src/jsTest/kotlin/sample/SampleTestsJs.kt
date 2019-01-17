package sample

import kotlin.test.Test
import kotlin.test.assertTrue

class SampleTestsJs {
    @Test
    fun testHello() {
        assertTrue("JS" in hello())
    }
}