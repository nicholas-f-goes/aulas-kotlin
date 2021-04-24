package nicholas.goes.trabalhodofinde

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_screen1.*
import nicholas.goes.trabalhodofinde.Model.Horas
import nicholas.goes.trabalhodofinde.Model.Meses
import nicholas.goes.trabalhodofinde.Model.Minutos
import nicholas.goes.trabalhodofinde.Model.Student

class Screen1 : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var buttonMinutos: Button
    private lateinit var buttonHoras: Button
    private lateinit var buttonMeses: Button
    private lateinit var editTextYear: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        initializer()

        buttonMinutos.setOnClickListener {

            val minutos = Minutos(editTextName.text.toString(), editTextYear.text.toString().toInt())

            val intent = Intent(this@Screen1, Screen2::class.java)
            intent.putExtra("minutos", minutos)
            startActivity(intent)
        }

        buttonHoras.setOnClickListener {

            val horas = Horas(editTextName.text.toString(), editTextYear.text.toString().toInt())

            val intent = Intent(this@Screen1, Screen2::class.java)
            intent.putExtra("horas", horas)
            startActivity(intent)
        }
        buttonMeses.setOnClickListener {

            val meses = Meses(editTextName.text.toString(), editTextYear.text.toString().toInt())

            val intent = Intent(this@Screen1, Screen2::class.java)
            intent.putExtra("meses", meses)
            startActivity(intent)
        }

        val student = intent.getSerializableExtra("student") as Student

        Toast.makeText(baseContext, "Bem-Vindo(a): ${student.name}",Toast.LENGTH_LONG).show()
    }
    private fun initializer() {
        editTextName = findViewById(R.id.editTextName)
        buttonMinutos = findViewById(R.id.buttonMinutos)
        buttonHoras = findViewById(R.id.buttonHoras)
        buttonMeses = findViewById(R.id.buttonMeses)
        editTextYear = findViewById(R.id.editTextYear)

    }

}




