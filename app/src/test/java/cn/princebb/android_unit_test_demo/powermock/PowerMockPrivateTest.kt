package cn.princebb.android_unit_test_demo.powermock

import cn.princebb.android_unit_test_demo.bean.BigHeadSon
import org.hamcrest.core.IsEqual
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito
import org.powermock.api.support.membermodification.MemberModifier
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

/**
 * author:  Allen <br>
 * date:  2019-07-24<br>
 * description:
 */
@RunWith(PowerMockRunner::class)
@PrepareForTest(BigHeadSon::class)
class PowerMockPrivateTest {
    /**
     * 测试私有方法
     */
    @Test
    fun testPrivateMethod() {
        val bigHeadSon = PowerMockito.mock(BigHeadSon::class.java)
        PowerMockito.`when`(bigHeadSon.getSonTag()).thenCallRealMethod()
        PowerMockito.`when`<Any>(bigHeadSon,"tag").thenReturn("大头最好")
        Assert.assertThat("我是大头大头最好",IsEqual.equalTo(bigHeadSon.getSonTag()))
    }

    @Test
    fun testParentPrivateVariable() {
        MemberModifier.field(BigHeadSon::class.java,"head").set(BigHeadSon,"我是大头儿子，我有一颗大脑袋")
        Assert.assertThat("我是大头儿子，我有一颗大脑袋",IsEqual.equalTo(BigHeadSon.head))
    }
}