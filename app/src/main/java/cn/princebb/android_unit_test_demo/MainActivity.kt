package cn.princebb.android_unit_test_demo

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import cn.princebb.android_unit_test_demo.ui.fragment.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lifecycleState: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleState = "onCreate"
    }

    fun jump(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
        Log.d("MainActivity","jump to another activity")

    }

    fun showToast(view: View) {
        Toast.makeText(this, "我是吐司", Toast.LENGTH_SHORT).show()
    }

    fun showDialog(view: View) {
        val alertDialog = AlertDialog.Builder(this)
            .setMessage("我是对话框")
            .setTitle("提示")
            .setCancelable(true)
            .create()
        alertDialog.show()
    }

    fun inverse(view: View) {
        checkbox.isChecked = !checkbox.isChecked
    }

    override fun onStart() {
        super.onStart()
        lifecycleState = "onStart"
    }

    override fun onResume() {
        super.onResume()
        lifecycleState = "onResume"
    }

    override fun onPause() {
        super.onPause()
        lifecycleState = "onPause"
    }

    override fun onStop() {
        super.onStop()
        lifecycleState = "onStop"
    }

    override fun onRestart() {
        super.onRestart()
        lifecycleState = "onRestart"
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleState = "onDestroy"
    }
}
