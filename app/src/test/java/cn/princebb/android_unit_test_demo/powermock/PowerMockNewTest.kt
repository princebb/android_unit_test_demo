package cn.princebb.android_unit_test_demo.powermock

import cn.princebb.android_unit_test_demo.bean.BigHeadSon
import cn.princebb.android_unit_test_demo.bean.Coworker
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
class PowerMockNewTest {
    @get:Rule
    val rule = PowerMockRule()

    @Test
    @PrepareForTest(Coworker::class)
    fun testNewClass() {
        val coworker = PowerMockito.mock(Coworker::class.java)
        val name = "东津不是京东"
        PowerMockito.`when`(coworker.name).thenReturn(name)
        PowerMockito.whenNew(Coworker::class.java).withNoArguments().thenReturn(coworker)
        val newInstance = Coworker()
        Assert.assertThat(name,IsEqual.equalTo(newInstance.name))
    }
}