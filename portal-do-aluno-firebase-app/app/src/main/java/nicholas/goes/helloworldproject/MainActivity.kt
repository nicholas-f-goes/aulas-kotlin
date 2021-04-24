package nicholas.goes.helloworldproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        buttonBoletos.setOnClickListener{
            val intent = Intent(this@MainActivity, BoletoActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonCertificates.setOnClickListener{
            val intent = Intent(this@MainActivity, CertificateActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonNotes.setOnClickListener{
            val intent = Intent(this@MainActivity, NoteActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonTimesheet.setOnClickListener{
            val intent = Intent(this@MainActivity, TimesheetActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonHistóric.setOnClickListener{
            val intent = Intent(this@MainActivity, HistoricActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonWork.setOnClickListener{
            val intent = Intent(this@MainActivity, WorkActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.NotificatioItem -> {
                Toast.makeText(baseContext, "Não ha novas notificações.", Toast.LENGTH_LONG).show()
            }
            R.id.PerfilItem ->{
                Toast.makeText(baseContext, "Bem-vindo:", Toast.LENGTH_LONG).show()
            }
            R.id.SignOutItem -> {
                mAuth?.signOut()
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
        return super.onOptionsItemSelected(item)
    }
}