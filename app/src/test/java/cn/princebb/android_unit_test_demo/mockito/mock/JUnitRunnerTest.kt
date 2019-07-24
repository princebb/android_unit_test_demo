package cn.princebb.android_unit_test_demo.mockito.mock

import cn.princebb.android_unit_test_demo.bean.Coworker
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * author:  Allen <br>
 * date:  2019-07-23<br>
 * description:
 */
@RunWith(MockitoJUnitRunner::class)
class JUnitRunnerTest {
    @Mock
    lateinit var coworker: Coworker

    @Test
    fun testIsNotNull() {
        assertNotNull(coworker)
    }
}