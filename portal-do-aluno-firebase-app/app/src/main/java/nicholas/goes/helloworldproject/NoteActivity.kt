package nicholas.goes.helloworldproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        ButtonCancelado.setOnClickListener{
            Toast.makeText(this@NoteActivity,"Cancelado apenas 1 vez na disciplina do Cury.", Toast.LENGTH_SHORT).show()
        }
        ButtonBadge.setOnClickListener{
            Toast.makeText(this@NoteActivity,"Aluno destaque...", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_back, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.mainitem4 -> {
                val intent = Intent(this@NoteActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}