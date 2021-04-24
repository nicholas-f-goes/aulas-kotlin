package nicholas.goes.helloworldproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {

    private var delayedHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000

    private val runnable = Runnable {
        if(!isFinishing){
            val intent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        delayedHandler = Handler()
        delayedHandler!!.postDelayed(runnable,SPLASH_DELAY)
    }
    override fun onDestroy(){
        super.onDestroy()

        delayedHandler?.removeCallbacks(runnable)
    }
}