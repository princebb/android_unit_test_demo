package cn.princebb.android_unit_test_demo.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * author:  Allen <br>
 * date:  2019-07-23<br>
 * description:
 */
object DateUtil {
    var FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss"
    /**
     * 根据日期返回时间戳
     * @param time
     * @return 时间戳
     */
    @Throws(ParseException::class)
    fun dateToStamp(time: String): Long {
        val sdr = SimpleDateFormat(FORMAT_YMDHMS, Locale.CHINA)
        val date = sdr.parse(time)
        return date.time
    }

    /**
     * 将时间戳转换为时间
     */
    fun stampToDate(lt: Long): String {
        val res: String
        val simpleDateFormat = SimpleDateFormat(FORMAT_YMDHMS, Locale.CHINA)
        val date = Date(lt)
        res = simpleDateFormat.format(date)
        return res
    }
}