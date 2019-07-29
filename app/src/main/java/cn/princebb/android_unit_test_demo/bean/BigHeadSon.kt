package cn.princebb.android_unit_test_demo.bean

/**
 * author:  Allen <br></br>
 * date:  2019-07-24<br></br>
 * description:
 */
object BigHeadSon : SmallHeadDad() {
    private val NAME = "我是大头"

    val sex:String
    get() = "男生"

    @JvmStatic
    fun name(): String {
        return NAME
    }
    fun getSonTag(): String {
        return NAME + tag()
    }

    private fun tag():String{
        return "大头大头下雨不愁，人家有伞我有大头"
    }
}
