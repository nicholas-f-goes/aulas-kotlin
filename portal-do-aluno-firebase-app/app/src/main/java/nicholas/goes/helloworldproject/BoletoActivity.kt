package nicholas.goes.helloworldproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_boleto.*
import nicholas.goes.helloworldproject.adapters.BoletosAdapter
import nicholas.goes.helloworldproject.model.Boleto

class BoletoActivity : AppCompatActivity() {
    private lateinit var adapter: BoletosAdapter
    private var boletos = arrayListOf<Boleto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boleto)

        initializer()

        buttonOk.setOnClickListener{
            var boletos = Boleto(editTextName.text.toString(), editTextValor.text.toString().toDouble(),editTextData.text.toString())

            this.boletos.add(boletos)

            adapter.notifyDataSetChanged()

            Toast.makeText(this@BoletoActivity,"Boleto Cadastrado com Sucesso!", Toast.LENGTH_SHORT).show()
        }
    }
    private fun initializer(){
        adapter = BoletosAdapter(boletos,this@BoletoActivity)
        recycler_Boletos.adapter = adapter

        recycler_Boletos.layoutManager = LinearLayoutManager(this@BoletoActivity)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_back, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.mainitem4 -> {
                val intent = Intent(this@BoletoActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}