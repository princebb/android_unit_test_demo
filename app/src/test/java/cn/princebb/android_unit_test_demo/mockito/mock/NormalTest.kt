package cn.princebb.android_unit_test_demo.mockito.mock

import cn.princebb.android_unit_test_demo.bean.Coworker
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito.mock

/**
 * author:  Allen <br>
 * date:  2019-07-23<br>
 * description:
 */
class NormalTest {
    @Test
    fun testIsNotNull() {
        val coworker = mock(Coworker::class.java)
        assertNotNull(coworker)
    }
}