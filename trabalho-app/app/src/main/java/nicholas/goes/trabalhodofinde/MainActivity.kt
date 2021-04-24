package nicholas.goes.trabalhodofinde

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*
import nicholas.goes.trabalhodofinde.Model.Student


class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var buttonSendObject: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()

        buttonSendObject.setOnClickListener {

            val student = Student(editTextName.text.toString())

            val intent = Intent(this@MainActivity, Screen1::class.java)
            intent.putExtra("student", student)
            startActivity(intent)
        }

    }

    private fun initializer() {
        editTextName = findViewById(R.id.editTextName)
        buttonSendObject = findViewById(R.id.buttonSendObject)
    }
}