package nicholas.goes.deathnote

import android.content.Context
import android.os.Build
import android.os.Build.VERSION_CODES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var textViewAnswer: TextView
    private lateinit var buttonVerify: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()

        //programar....
        buttonVerify.setOnClickListener {

            if (editTextName.text.toString().isEmpty()) {
                toast("Digite um nome!")
                return@setOnClickListener
            }

            if (editTextAge.text.toString().isEmpty()) {
                toast("Digite uma idade válida!")
                return@setOnClickListener
            }


            //var name: String = editTextName.text as String
            var name: String = editTextName.text.toString()
            var age: Int = editTextAge.text.toString().toInt()
            var random = (1..100).random()

            var answer = when (random) {
                in 1..30 -> "Ta deboa cara, ta Limpo."
                in 30..60 -> "Você ainda não é um caso perdido."
                in 60..90 -> "Você ainda pode ir no cartório trocar de nome"
                in 90..100 -> "Você é o próximo."
            else -> "error"
        }
        vibrate()

        toast("O seu nome é: $name\nA sua idade é: $age")
        textViewAnswer.text = "a porcentagem de você ser a próxima vitíma é ${random}%"
        toast(answer)


            clearFields()

        }
    }
        private fun vibrate(){

            val pattern = longArrayOf(0,200,100,300)

            val hardware = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

            if (Build.VERSION.SDK_INT >= VERSION_CODES.O) {
                hardware.vibrate(VibrationEffect.createWaveform(pattern,-1))
            }

        }

    private fun initializer() {

        editTextName = findViewById(R.id.editTextName)
        editTextAge = findViewById(R.id.editTextAge)
        textViewAnswer = findViewById(R.id.textViewAnswer)
        buttonVerify = findViewById(R.id.buttonVerify)
    }

    private fun toast(message: String) {
        Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
    }

    private fun clearFields() {
        editTextName.text = null
        editTextAge.text = null

    }


}


