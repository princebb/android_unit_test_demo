package cn.princebb.android_unit_test_demo.rule

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.TestScheduler
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * author:  Allen <br>
 * date:  2019-07-29<br>
 * description:
 */
class RxJavaTestSchedulerRule : TestRule {
    val testScheduler = TestScheduler()
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                RxJavaPlugins.setIoSchedulerHandler { testScheduler }

                RxJavaPlugins.setNewThreadSchedulerHandler { testScheduler }

                RxJavaPlugins.setComputationSchedulerHandler { testScheduler }

                RxAndroidPlugins.setMainThreadSchedulerHandler { testScheduler }

                try {
                    base.evaluate()
                } finally {
                    RxJavaPlugins.reset()
                    RxAndroidPlugins.reset()
                }
            }
        }
    }
}
