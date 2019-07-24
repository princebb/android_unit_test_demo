package cn.princebb.android_unit_test_demo.bean

/**
 * author:  Allen <br>
 * date:  2019-07-23<br>
 * description:
 */
open class Coworker {

    open var name: String? = null
    open var nickname: String? = null
    open val height:String
        get() = "我的身高有2米"
    open fun hobby(thing: String): String {
        return thing
    }
}