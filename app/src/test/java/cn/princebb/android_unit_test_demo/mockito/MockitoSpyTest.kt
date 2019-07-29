package cn.princebb.android_unit_test_demo.mockito

import cn.princebb.android_unit_test_demo.bean.Coworker
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Spy
import org.mockito.junit.MockitoJUnit

/**
 * author:  Allen <br>
 * date:  2019-07-24<br>
 * description:
 */
class MockitoSpyTest {
    @Spy//实现调用真实对象的实现
    lateinit var coworker: Coworker
    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    @Test
    fun testIsNotNull() {
        Assert.assertNotNull(coworker)
        println(coworker.height)
        println(coworker.name)
    }
}