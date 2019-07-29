package cn.princebb.android_unit_test_demo.powermock

import cn.princebb.android_unit_test_demo.bean.BigHeadSon
import cn.princebb.android_unit_test_demo.utils.DateUtil
import org.hamcrest.core.IsEqual
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.reflect.Whitebox

/**
 * author:  Allen <br>
 * date:  2019-07-24<br>
 * description:
 * @link:https://github.com/powermock/powermock/wiki/Mockito
 */
@RunWith(PowerMockRunner::class)
@PrepareForTest(BigHeadSon::class)//必加，表示对哪个类进行测试
class PowerMockStaticTest {
    /**
     * 对静态方法进行测试
     */
    @Test
    fun testStaticMethod() {
        PowerMockito.mockStatic(BigHeadSon::class.java)
        PowerMockito.`when`(BigHeadSon.name()).thenReturn("我是大头儿子，我有一颗大脑袋")
        assertThat("我是大头儿子，我有一颗大脑袋", equalTo(BigHeadSon.name()))
    }

    /**
     * 对私有静态常量进行修改
     */
    @Test
    fun testStaticName() {
        Whitebox.setInternalState(BigHeadSon::class.java,"NAME","我是围裙妈妈的儿子")
        assertThat("我是围裙妈妈的儿子",equalTo(BigHeadSon.name()))
    }

}