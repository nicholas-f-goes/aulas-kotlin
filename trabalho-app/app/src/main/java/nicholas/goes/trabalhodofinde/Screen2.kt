package nicholas.goes.trabalhodofinde
//Android Studio ta crashando o emulador sozinho//
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import nicholas.goes.trabalhodofinde.Model.Horas
import nicholas.goes.trabalhodofinde.Model.Meses
import nicholas.goes.trabalhodofinde.Model.Minutos

class Screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        val minutos = intent.getParcelableExtra<Minutos>("minutos") as Minutos

        Toast.makeText(baseContext, "Sua idade em Minutos é: ${minutos.age}", Toast.LENGTH_LONG).show()

        val horas = intent.getParcelableExtra<Horas>("horas") as Horas

        Toast.makeText(baseContext, "Sua idade em Horas é: ${horas.age}", Toast.LENGTH_LONG).show()

        val meses = intent.getParcelableExtra<Meses>("meses") as Meses

        Toast.makeText(baseContext, "Sua idade em Meses é: ${meses.age}", Toast.LENGTH_LONG).show()

    }
}