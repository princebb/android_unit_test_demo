package cn.princebb.android_unit_test_demo.robolectric

import android.os.Build
import android.widget.TextView
import cn.princebb.android_unit_test_demo.R
import cn.princebb.android_unit_test_demo.rule.RxJavaTestSchedulerRule
import cn.princebb.android_unit_test_demo.ui.fragment.LoginActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.util.concurrent.TimeUnit

/**
 * author:  Allen <br>
 * date:  2019-07-29<br>
 * description:
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class LoginActivityTest {
    private lateinit var mLoginActivity: LoginActivity
    private lateinit var mTvSendIdentify: TextView

    @get:Rule
    val rule = RxJavaTestSchedulerRule()

    @Before
    fun setUp() {
        mLoginActivity = Robolectric.setupActivity(LoginActivity::class.java)
        mTvSendIdentify = mLoginActivity.findViewById(R.id.tv_send_identify) as TextView
    }

    @Test
    fun testLoginActivity() {
        Assert.assertNotNull(mLoginActivity)
    }

    @Test
    @Throws(Exception::class)
    fun testGetIdentify() {
        val application = RuntimeEnvironment.application
        Assert.assertEquals(
            mTvSendIdentify.text.toString(),
            application.getString(R.string.login_send_identify)
        )
        // 触发按钮点击
        mTvSendIdentify.performClick()
        // 时间到10秒
        rule.testScheduler.advanceTimeTo(10, TimeUnit.SECONDS)
        Assert.assertEquals(mTvSendIdentify.isEnabled, false)
        Assert.assertEquals(mTvSendIdentify.text.toString(), "111秒后重试")
        // 时间到120秒
        rule.testScheduler.advanceTimeTo(120, TimeUnit.SECONDS)
        Assert.assertEquals(
            mTvSendIdentify.text.toString(),
            application.getString(R.string.login_send_identify)
        )
        Assert.assertEquals(mTvSendIdentify.isEnabled, true)
    }
}