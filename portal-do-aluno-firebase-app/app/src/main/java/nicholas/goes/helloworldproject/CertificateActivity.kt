package nicholas.goes.helloworldproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_boleto.buttonOk
import kotlinx.android.synthetic.main.activity_boleto.editTextData
import kotlinx.android.synthetic.main.activity_boleto.editTextName
import kotlinx.android.synthetic.main.activity_certificate.*
import nicholas.goes.helloworldproject.adapters.CertificadosAdapter
import nicholas.goes.helloworldproject.model.Certificado

class CertificateActivity : AppCompatActivity() {

    private lateinit var adapter: CertificadosAdapter
    private var certificados = arrayListOf<Certificado>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certificate)

        initializer()

        buttonOk1.setOnClickListener{
            var certificados = Certificado(editTextName.text.toString(), editTextHora.text.toString().toInt(),editTextData.text.toString())

            this.certificados.add(certificados)

            adapter.notifyDataSetChanged()

            Toast.makeText(this@CertificateActivity,"Certificado Gerado com Sucesso!", Toast.LENGTH_SHORT).show()
        }
    }
    private fun initializer(){
        adapter = CertificadosAdapter(certificados,this@CertificateActivity)
        recycler_Certificados.adapter = adapter

        recycler_Certificados.layoutManager = LinearLayoutManager(this@CertificateActivity)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_back, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.mainitem4 -> {
                val intent = Intent(this@CertificateActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}