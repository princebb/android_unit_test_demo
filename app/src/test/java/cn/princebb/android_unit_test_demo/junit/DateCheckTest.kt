package cn.princebb.android_unit_test_demo.junit

import cn.princebb.android_unit_test_demo.utils.DateUtil
import cn.princebb.android_unit_test_demo.utils.DateUtil.stampToDate
import org.hamcrest.core.IsEqual.equalTo
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import java.text.ParseException
import java.util.*

/**
 * author:  Allen <br>
 * date:  2019-07-23<br>
 * description:
 */
class DateCheckTest {
    private lateinit var mDate: Date
    private val timeStamp = 1563863678000
    private val time = "2019-07-23-14:34:38"
    @Before//在每个测试方法前执行，可做初始化操作
    fun setUp() {
        println("测试开始")
        mDate = Date()
        mDate.time = timeStamp
    }

    @After//在每个测试方法后执行，可做释放资源操作
    fun tearDown() {
        println("测试结束")
    }

    @Test
    fun currentDate() {
        println(stampToDate(mDate.time))
    }
    @Test //表示此方法为测试方法
    fun testEqual() {
        assertEquals(time, stampToDate(timeStamp))
    }
    @Test
    fun testAssertThat() {
        assertThat(time, equalTo(stampToDate(timeStamp)))
    }

    @Test(expected = ParseException::class)
    fun testException() {//传入错误的时间
        DateUtil.dateToStamp("2019-07-23")
    }
}