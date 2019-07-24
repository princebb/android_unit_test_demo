package cn.princebb.android_unit_test_demo.junit

import org.junit.Assert.assertNotEquals
import org.junit.Rule
import org.junit.Test

/**
 * author:  Allen <br>
 * date:  2019-07-23<br>
 * description:
 */
class RuleTest {
    @get:Rule
    val rule = CustomRule()

    @Test
    fun testEqual() {
        assertNotEquals(3,2)
    }
}