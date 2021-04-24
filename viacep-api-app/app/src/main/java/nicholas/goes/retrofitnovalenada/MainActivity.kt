package nicholas.goes.retrofitnovalenada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import nicholas.goes.retrofitnovalenada.model.Zipcode
import nicholas.goes.retrofitnovalenada.service.Retrofitinitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import nicholas.goes.retrofitnovalenada.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.progressBar.visibility = View.INVISIBLE

        binding.buttonFindZipcode.setOnClickListener {

            if (binding.editTextZipcode.text.isEmpty()) {
                Toast.makeText(baseContext, "Enter a valid zip code", Toast.LENGTH_LONG).show()
            } else {
                binding.progressBar.visibility = View.VISIBLE

                val zipcode = binding.editTextZipcode.text.toString()

                val call = Retrofitinitializer().zipcodeService().findAddressByZipcode(zipcode)

                call.enqueue(object : Callback<Zipcode> {

                    override fun onFailure(call: Call<Zipcode>, t: Throwable) {
                        binding.progressBar.visibility = View.INVISIBLE
                        Toast.makeText(baseContext, "Error!", Toast.LENGTH_LONG)
                            .show()
                    }

                    override fun onResponse(call: Call<Zipcode>, response: Response<Zipcode>) {
                        binding.progressBar.visibility = View.INVISIBLE
                        Toast.makeText(
                            baseContext,
                            "http status ${response.code()}",
                            Toast.LENGTH_LONG
                        ).show()

                        if (response.isSuccessful) {
                            val zipcode = response.body() as Zipcode
                            Toast.makeText(
                                baseContext,
                                "CEP:${zipcode}",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Toast.makeText(
                                baseContext,
                                "Error, it was not successful !!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                })


            }
        }

        binding.buttonFindZipcodeByAddress.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE

            val call = Retrofitinitializer().zipcodeService().findZipcodeByStateDistrictAndCity("domingos","RS","Porto Alegre")

            call.enqueue(object : Callback<List<Zipcode>> {

                override fun onFailure(call: Call<List<Zipcode>>, t: Throwable) {
                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(baseContext, "Error! ", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<List<Zipcode>>, response: Response<List<Zipcode>>) {
                    binding.progressBar.visibility = View.INVISIBLE

                    if (response.isSuccessful) {

                        val zipcodes: List<Zipcode>? = response.body()
                        Toast.makeText(baseContext, "${response.code()}", Toast.LENGTH_LONG)

                        zipcodes?.let {

                            for (zipcode in zipcodes) {
                                Toast.makeText(
                                    baseContext,
                                    "$zipcodes",
                                    Toast.LENGTH_LONG
                                )
                                    .show()
                            }
                        }
                    } else {
                        Toast.makeText(baseContext, "Error!", Toast.LENGTH_LONG)
                            .show()
                    }
                }

            })
        }

    }
}
