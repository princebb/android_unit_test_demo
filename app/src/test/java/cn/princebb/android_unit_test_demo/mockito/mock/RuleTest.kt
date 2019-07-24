package cn.princebb.android_unit_test_demo.mockito.mock

import cn.princebb.android_unit_test_demo.bean.Coworker
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

/**
 * author:  Allen <br>
 * date:  2019-07-23<br>
 * description:
 */
class RuleTest {
    @Mock
    lateinit var coworker: Coworker
    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    @Test
    fun testIsNotNull() {
        assertNotNull(coworker)
    }

}