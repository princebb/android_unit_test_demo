package cn.princebb.android_unit_test_demo.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import cn.princebb.android_unit_test_demo.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import kotlinx.android.synthetic.main.activity_login.*
import java.util.concurrent.TimeUnit
import kotlin.math.abs

class LoginActivity : AppCompatActivity() {

    private var mDisposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tv_send_identify.setOnClickListener { getIdentify() }
    }

    private fun getIdentify() {
        tv_send_identify.isEnabled = false
        // interval隔一秒发一次，到120结束
        mDisposable = Observable
                .interval(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .take(120)
                .subscribeWith(object : DisposableObserver<Long>() {
                    override fun onComplete() {
                        tv_send_identify.setText(R.string.login_send_identify)
                        tv_send_identify.isEnabled = true
                    }

                    override fun onError(e: Throwable) {}

                    override fun onNext(aLong: Long) {
                        tv_send_identify.text = TextUtils.concat(abs(aLong - 120).toString(), "秒后重试")
                    }
                })
    }

    public override fun onDestroy() {
        super.onDestroy()
        if (mDisposable != null) {
            mDisposable!!.dispose()
        }
    }

}
