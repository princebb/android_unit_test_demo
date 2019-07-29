package cn.princebb.android_unit_test_demo.robolectric

import android.os.Build
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.testing.launchFragmentInContainer
import cn.princebb.android_unit_test_demo.MainActivity
import cn.princebb.android_unit_test_demo.R
import cn.princebb.android_unit_test_demo.ui.fragment.LoginActivity
import cn.princebb.android_unit_test_demo.ui.fragment.SampleFragment
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowAlertDialog
import org.robolectric.shadows.ShadowLog
import org.robolectric.shadows.ShadowToast

/**
 * author:  Allen <br>
 * date:  2019-07-24<br>
 * description:
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class MainActivityTest {
    private val TAG = "test"
    private lateinit var mainActivity: MainActivity
    private lateinit var mJumpBtn: Button
    private lateinit var mToastBtn: Button
    private lateinit var mDialogBtn: Button
    private lateinit var mInverseBtn: Button
    private lateinit var mCheckBox: CheckBox

    @Before
    fun setUp() {
        //输出日志
        ShadowLog.stream = System.out
        // 默认会调用Activity的生命周期: onCreate->onStart->onResume
        mainActivity = Robolectric.setupActivity(MainActivity::class.java)
        mJumpBtn = mainActivity.findViewById(R.id.activity_jump) as Button
        mToastBtn = mainActivity.findViewById(R.id.verify_toast) as Button
        mDialogBtn = mainActivity.findViewById(R.id.verify_dialog) as Button
        mInverseBtn = mainActivity.findViewById(R.id.check_tips) as Button
        mCheckBox = mainActivity.findViewById(R.id.checkbox) as CheckBox
    }

    /**
     * 创建Activity测试
     */
    @Test
    fun testMainActivity() {
        Assert.assertNotNull(mainActivity)
        Log.d(TAG, "测试Log输出")
    }


    /**
     * 验证点击事件是否触发了页面跳转，验证目标页面是否预期页面
     *
     * @throws Exception
     */
    @Test
    @Throws(Exception::class)
    fun testJump() {
        Assert.assertEquals(mJumpBtn.text.toString(), "Activity跳转")
        // 触发按钮点击
        mJumpBtn.performClick()
        // 获取对应的Shadow类
        val shadowActivity = Shadows.shadowOf(mainActivity)
        // 借助Shadow类获取启动下一Activity的Intent
        val nextIntent = shadowActivity.nextStartedActivity
        // 校验Intent的正确性
        Assert.assertEquals(nextIntent.component?.className, LoginActivity::class.java.name)
    }

    /**
     * 验证Toast是否正确弹出
     *
     * @throws Exception
     */
    @Test
    @Throws(Exception::class)
    fun testToast() {
        var toast = ShadowToast.getLatestToast()
        // 判断Toast尚未弹出
        Assert.assertNull(toast)

        mToastBtn.performClick()
        toast = ShadowToast.getLatestToast()
        // 判断Toast已经弹出
        Assert.assertNotNull(toast)
        // 获取Shadow类进行验证
        val shadowToast = Shadows.shadowOf(toast)
//        Assert.assertEquals(Toast.LENGTH_LONG.toLong(), shadowToast.duration.toLong())
        Assert.assertEquals("Hello UT!", ShadowToast.getTextOfLatestToast())
    }

    /**
     * 验证Dialog是否正确弹出
     *
     * @throws Exception
     */
    @Test
    @Throws(Exception::class)
    fun testDialog() {
        var dialog = ShadowAlertDialog.getLatestAlertDialog()
        // 判断Dialog尚未弹出
        Assert.assertNull(dialog)
        mDialogBtn.performClick()
        dialog = ShadowAlertDialog.getLatestAlertDialog()
        // 判断Dialog已经弹出
        Assert.assertNotNull(dialog)
        // 获取Shadow类进行验证
        val shadowDialog = Shadows.shadowOf(dialog)
        Assert.assertEquals("我是对话框", shadowDialog.message)
    }

    /**
     * 验证UI组件状态
     *
     * @throws Exception
     */
    @Test
    @Throws(Exception::class)
    fun testCheckBoxState() {
        // 验证CheckBox初始状态
        Assert.assertFalse(mCheckBox.isChecked)
        // 点击按钮反转CheckBox状态
        mInverseBtn.performClick()
        // 验证状态是否正确
        Assert.assertTrue(mCheckBox.isChecked)
        // 点击按钮反转CheckBox状态
        mInverseBtn.performClick()
        // 验证状态是否正确
        Assert.assertFalse(mCheckBox.isChecked)
    }

    /**
     * 验证Fragment
     */
    @Test
    fun testFragment() {
        val fragmentScenario = launchFragmentInContainer<SampleFragment>()
        fragmentScenario.onFragment {
            Assert.assertNotNull(it.view)
        }
    }

    /**
     * 资源文件访问测试
     */
    @Test
    fun testResources() {
        val application = RuntimeEnvironment.application
        val appName = application.getString(R.string.app_name)
        Assert.assertEquals("android_unit_test_demo", appName)
    }

    @Test
    @Throws(Exception::class)
    fun testLifecycle() {
        // 创建Activity控制器
        val controller = Robolectric.buildActivity(MainActivity::class.java)
        val activity = controller.get()
        Assert.assertNull(activity.lifecycleState)
        // 调用Activity的performCreate方法
        controller.create()
        Assert.assertEquals("onCreate", activity.lifecycleState)
        // 调用Activity的performStart方法
        controller.start()
        Assert.assertEquals("onStart", activity.lifecycleState)
        // 调用Activity的performResume方法
        controller.resume()
        Assert.assertEquals("onResume", activity.lifecycleState)
        // 调用Activity的performPause方法
        controller.pause()
        Assert.assertEquals("onPause", activity.lifecycleState)
        // 调用Activity的performStop方法
        controller.stop()
        Assert.assertEquals("onStop", activity.lifecycleState)
        // 调用Activity的performRestart方法
        controller.restart()
        // 注意此处应该是onStart，因为performRestart不仅会调用restart，还会调用onStart
        Assert.assertEquals("onStart", activity.lifecycleState)
        // 调用Activity的performDestroy方法
        controller.destroy()
        Assert.assertEquals("onDestroy", activity.lifecycleState)
    }
}