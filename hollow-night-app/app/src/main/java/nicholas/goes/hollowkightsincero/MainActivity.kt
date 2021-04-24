package nicholas.goes.hollowkightsincero

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    lateinit var buttonConfessoraJiji: Button

    lateinit var buttonPequenoTolo: Button

    lateinit var buttonComePernas: Button

    lateinit var buttonZotePoderoso: Button

    lateinit var buttonIselda: Button

    lateinit var buttonHornet: Button

    lateinit var buttonSheo: Button

    lateinit var buttonCloth: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonConfessoraJiji = findViewById(R.id.buttonConfessoraJiji)

        buttonConfessoraJiji.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                resources.getText(R.string.ConfessoraJiji),
                Toast.LENGTH_SHORT
            ).show()

            buttonConfessoraJiji.setOnLongClickListener {
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle(getText(R.string.TitleJiji))
                alert.setMessage(getText(R.string.HistóriaJiji))
                alert.setIcon(ContextCompat.getDrawable(this@MainActivity, R.mipmap.ic_launcher))
                alert.setNeutralButton(getText(R.string.Sair), null)
                alert.show()
                true
            }
        }

        buttonPequenoTolo = findViewById(R.id.buttonPequenoTolo)

        buttonPequenoTolo.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                resources.getText(R.string.PequenoTolo),
                Toast.LENGTH_SHORT
            ).show()

            buttonPequenoTolo.setOnLongClickListener {
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle(getText(R.string.titletolo))
                alert.setMessage(getText(R.string.HistóriaTolo))
                alert.setIcon(ContextCompat.getDrawable(this@MainActivity, R.mipmap.ic_launcher))
                alert.setNeutralButton(getText(R.string.Sair), null)
                alert.show()
                true
            }

            buttonComePernas = findViewById(R.id.buttonComePernas)

            buttonComePernas.setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    resources.getText(R.string.ComePernas),
                    Toast.LENGTH_SHORT
                ).show()

                buttonComePernas.setOnLongClickListener {
                    val alert = AlertDialog.Builder(this@MainActivity)
                    alert.setTitle(getText(R.string.titlepernas))
                    alert.setMessage(getText(R.string.HistóriaPernas))
                    alert.setIcon(
                        ContextCompat.getDrawable(
                            this@MainActivity,
                            R.mipmap.ic_launcher
                        )
                    )
                    alert.setNeutralButton(getText(R.string.Sair), null)
                    alert.show()
                    true
                }

                buttonZotePoderoso = findViewById(R.id.buttonZotePoderoso)

                buttonZotePoderoso.setOnClickListener {
                    Toast.makeText(
                        this@MainActivity,
                        resources.getText(R.string.ZotePoderoso),
                        Toast.LENGTH_SHORT
                    ).show()

                    buttonZotePoderoso.setOnLongClickListener {
                        val alert = AlertDialog.Builder(this@MainActivity)
                        alert.setTitle(getText(R.string.titlezote))
                        alert.setMessage(getText(R.string.HistóriaZote))
                        alert.setIcon(
                            ContextCompat.getDrawable(
                                this@MainActivity,
                                R.mipmap.ic_launcher
                            )
                        )
                        alert.setNeutralButton(getText(R.string.Sair), null)
                        alert.show()
                        true
                    }

                    buttonIselda = findViewById(R.id.buttonIselda)

                    buttonIselda.setOnClickListener {
                        Toast.makeText(
                            this@MainActivity,
                            resources.getText(R.string.Iselda),
                            Toast.LENGTH_SHORT
                        ).show()

                        buttonIselda.setOnLongClickListener {
                            val alert = AlertDialog.Builder(this@MainActivity)
                            alert.setTitle(getText(R.string.titleiselda))
                            alert.setMessage(getText(R.string.Históriaiselda))
                            alert.setIcon(
                                ContextCompat.getDrawable(
                                    this@MainActivity,
                                    R.mipmap.ic_launcher
                                )
                            )
                            alert.setNeutralButton(getText(R.string.Sair), null)
                            alert.show()
                            true
                        }

                        buttonHornet = findViewById(R.id.buttonHornet)

                        buttonHornet.setOnClickListener {
                            Toast.makeText(
                                this@MainActivity,
                                resources.getText(R.string.Hornet),
                                Toast.LENGTH_SHORT
                            ).show()

                            buttonHornet.setOnLongClickListener {
                                val alert = AlertDialog.Builder(this@MainActivity)
                                alert.setTitle(getText(R.string.titlehornet))
                                alert.setMessage(getText(R.string.HistóriaHornet))
                                alert.setIcon(
                                    ContextCompat.getDrawable(
                                        this@MainActivity,
                                        R.mipmap.ic_launcher
                                    )
                                )
                                alert.setNeutralButton(getText(R.string.Sair), null)
                                alert.show()
                                true
                            }

                            buttonSheo = findViewById(R.id.buttonSheo)

                            buttonSheo.setOnClickListener {
                                Toast.makeText(
                                    this@MainActivity,
                                    resources.getText(R.string.Sheo),
                                    Toast.LENGTH_SHORT
                                ).show()

                                buttonSheo.setOnLongClickListener {
                                    val alert = AlertDialog.Builder(this@MainActivity)
                                    alert.setTitle(getText(R.string.titlesheo))
                                    alert.setMessage(getText(R.string.HistóriaSheo))
                                    alert.setIcon(
                                        ContextCompat.getDrawable(
                                            this@MainActivity,
                                            R.mipmap.ic_launcher
                                        )
                                    )
                                    alert.setNeutralButton(getText(R.string.Sair), null)
                                    alert.show()
                                    true
                                }

                                buttonCloth = findViewById(R.id.buttonCloth)

                                buttonCloth.setOnClickListener {
                                    Toast.makeText(
                                        this@MainActivity,
                                        resources.getText(R.string.Cloth),
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    buttonCloth.setOnLongClickListener {
                                        val alert = AlertDialog.Builder(this@MainActivity)
                                        alert.setTitle(getText(R.string.titlecloth))
                                        alert.setMessage(getText(R.string.HistóriaCloth))
                                        alert.setIcon(
                                            ContextCompat.getDrawable(
                                                this@MainActivity,
                                                R.mipmap.ic_launcher
                                            )
                                        )
                                        alert.setNeutralButton(getText(R.string.Sair), null)
                                        alert.show()
                                        true
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
