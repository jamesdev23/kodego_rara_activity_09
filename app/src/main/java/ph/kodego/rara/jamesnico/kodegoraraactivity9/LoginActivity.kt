package ph.kodego.rara.jamesnico.kodegoraraactivity9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import ph.kodego.rara.jamesnico.kodegoraraactivity9.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var username: String
    private lateinit var password: String

    private val launchRegister = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val data = result.data

        Snackbar.make(binding.root,
            "${data!!.getStringExtra("result")}",
            Snackbar.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // on login button press
        binding.btnLogin.setOnClickListener {

            username = binding.usernametext.text.toString()
            password = binding.passwordtext.text.toString()


            var goToHome = Intent(this, MainActivity::class.java)


            val bundle = Bundle()
            bundle.putString("username",username)
            bundle.putString("password",password)
            goToHome.putExtras(bundle)

            goToHome.putExtra("source","from_login")

            startActivity(goToHome)
            finish()
        }

        // on register button press
        binding.btnRegister.setOnClickListener {
            var goToRegister = Intent(this, RegisterActivity::class.java)
            launchRegister.launch(goToRegister)
        }

        // on forgetpassword press
        binding.btnForgetpassword.setOnClickListener {
            var goToForgetPassword = Intent(this, ForgetPasswordActivity::class.java)
            launchRegister.launch(goToForgetPassword)
        }
    }

    override fun onBackPressed() {
        // no code executed to disable back press
    }
}