package cn.princebb.android_unit_test_demo.mockito

import cn.princebb.android_unit_test_demo.bean.Coworker
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import java.lang.Exception
import java.lang.RuntimeException

/**
 * author:  Allen <br>
 * date:  2019-07-23<br>
 * description:
 */
class MockitoTest {
    @Mock
    lateinit var coworker: Coworker
    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    /**
     * 打桩mock返回值
     */
    @Test
    fun testReturn() {
        `when`(coworker.name).thenReturn("仁政")
        `when`(coworker.nickname).thenThrow(NullPointerException("我是仁政非暴政"))
        println(coworker.name)
        doReturn("我是东津不是京东").`when`(coworker).name
        println(coworker.name)
        coworker.nickname
    }

    /**
     * 测试应答
     */
    @Test
    fun testAnswer() {
        `when`(coworker.hobby(ArgumentMatchers.anyString())).thenAnswer {
            val arguments = it.arguments
            "仁政喜欢看《${arguments[0]}》"
        }
        println(coworker.hobby("一拳超人"))
    }

    /**
     * 调用真实的方法
     */
    @Test
    fun testReal() {
        doCallRealMethod().`when`(coworker).height
        println(coworker.height)
    }

    /**
     * 第一次执行时不做任何事
     */
    @Test
    fun testNothing() {
        doNothing().doThrow(RuntimeException()).`when`(coworker).nickname = "小均均"
        coworker.nickname = "小均均"
        //第二次抛出异常
        coworker.nickname = "小均均"
    }
}