package cn.princebb.android_unit_test_demo.mockito

import cn.princebb.android_unit_test_demo.bean.Coworker
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit

/**
 * author:  Allen <br>
 * date:  2019-07-23<br>
 * description:
 */
class MockitoVerifyTest {
    @Mock
    lateinit var coworker: Coworker
    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    @Test
    fun testVerifyAfter() {
        `when`(coworker.name).thenReturn("东京很热")
        println(coworker.name)
        println(System.currentTimeMillis())
        //2秒后再执行后续操作，默认验证次数是atMost(1)
//        verify(coworker,after(2000)).name
        println(System.currentTimeMillis())
        //至少验证了2次，此时会抛出异常
        verify(coworker, atLeast(2)).name
    }
    @Test
    fun testTimes() {
        coworker.name
        reset(coworker)
        coworker.name
        verify(coworker, timeout(100).times(1)).name
    }
}