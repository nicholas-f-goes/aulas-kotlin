package nicholas.goes.helloworldproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import nicholas.goes.helloworldproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private var mAuth: FirebaseAuth? = null
    private var mAuthStateListener: FirebaseAuth.AuthStateListener? = null
    private var mUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()
        FirebaseApp.initializeApp(this)
        mUser = mAuth?.currentUser

        mAuthStateListener = FirebaseAuth.AuthStateListener {
            if(mUser != null){
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        binding.ButtonLogin.setOnClickListener(this)
        binding.ButtonRegister.setOnClickListener(this)
        binding.ButtonForgotPassword.setOnClickListener(this)
        }

    override fun onStart() {
        super.onStart()
        mAuth?.addAuthStateListener(mAuthStateListener!!)
    }

    override fun onStop() {
        super.onStop()
        if(mAuthStateListener!= null) {
            mAuth?.removeAuthStateListener(mAuthStateListener!!)
        }
    }

    override fun onClick(p0: View?){
        when(p0?.id) {
            R.id.ButtonLogin -> {
                login()

            }
            R.id.ButtonRegister ->{
                register()

            }
            R.id.ButtonForgotPassword ->{
                forgotPassword()
            }
        }
    }
    private fun forgotPassword(){
        if(loginEditTextEmail.text.toString().isEmpty()){
            Toast.makeText(this@LoginActivity,"Digite somente o seu email!" , Toast.LENGTH_SHORT).show()
            return

    }
        mAuth?.sendPasswordResetEmail(
                loginEditTextEmail.text.toString())
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@LoginActivity,"Email com redefinição de senha enviado com sucesso!" , Toast.LENGTH_SHORT).show()

                    }
                }
    }

    private fun login(){
        if(loginEditTextEmail.text.toString().isEmpty() || loginEditTextPassword.text.toString().isEmpty()){
            Toast.makeText(this@LoginActivity,"Digite Usuario ou senha" , Toast.LENGTH_SHORT).show()

            return
        }
        var user = nicholas.goes.helloworldproject.model.User()
        user.email = loginEditTextEmail.text.toString()
        user.password = loginEditTextPassword.text.toString()

        mAuth?.signInWithEmailAndPassword(user.email.toString(),
                user.password.toString())
                ?.addOnCompleteListener(object: OnCompleteListener<AuthResult> {
                    //task

                    override fun onComplete(p0: Task<AuthResult>) {
                        if(!p0.isSuccessful) {
                            Toast.makeText(this@LoginActivity,"Usuário e/ou senha inválido(s)!" , Toast.LENGTH_SHORT).show()
                            return
                        }

                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                })
    }

    private fun register(){
        if(loginEditTextEmail.text.toString().isEmpty() || loginEditTextPassword.text.toString().isEmpty()){
            Toast.makeText(this@LoginActivity,"Digite Um Email e senha para efetuar o cadastro" , Toast.LENGTH_SHORT).show()
            return
        }
        var user = nicholas.goes.helloworldproject.model.User()
        user.email = loginEditTextEmail.text.toString()
        user.password = loginEditTextPassword.text.toString()

        mAuth?.createUserWithEmailAndPassword(user.email.toString(),
                user.password.toString())
                ?.addOnCompleteListener(object: OnCompleteListener<AuthResult> {
                    //task

                    override fun onComplete(p0: Task<AuthResult>) {
                        if(!p0.isSuccessful) {
                            Toast.makeText(this@LoginActivity,"Não foi possivel criar o usuário!" , Toast.LENGTH_SHORT).show()
                            return
                        }
                        Toast.makeText(this@LoginActivity,"Usuário criado com sucesso!" , Toast.LENGTH_SHORT).show()

                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.fragment_about -> {
                val intent = Intent(this@LoginActivity, AboutActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}