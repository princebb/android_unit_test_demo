package cn.princebb.android_unit_test_demo.powermock

import cn.princebb.android_unit_test_demo.bean.BigHeadSon
import org.hamcrest.core.IsEqual
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.rule.PowerMockRule

/**
 * author:  Allen <br>
 * date:  2019-07-24<br>
 * description:
 */
class PowerMockFinalTest {
    @get:Rule
    val rule  = PowerMockRule()

    @Test
    @PrepareForTest(BigHeadSon::class)
    fun testFinalMethod() {
        val bigHeadSon = PowerMockito.mock(BigHeadSon::class.java)
        PowerMockito.`when`(bigHeadSon.sex).thenReturn("小男孩")
        Assert.assertThat("小男孩", IsEqual.equalTo(bigHeadSon.sex))
    }

}