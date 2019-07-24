package cn.princebb.android_unit_test_demo.junit

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * author:  Allen <br>
 * date:  2019-07-23<br>
 * description:
 */
class CustomRule:TestRule {
    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
                //获取方法名
                val methodName = description?.methodName
                println("${methodName}测试开始")
                //实际运行的测试方法
                base?.evaluate()
                println("${methodName}测试结束")
            }
        }
    }
}