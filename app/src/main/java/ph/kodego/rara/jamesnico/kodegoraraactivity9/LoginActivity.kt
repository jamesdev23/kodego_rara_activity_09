package ph.kodego.rara.jamesnico.kodegoraraactivity9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import ph.kodego.rara.jamesnico.kodegoraraactivity9.dao.*
import ph.kodego.rara.jamesnico.kodegoraraactivity9.databinding.ActivityLoginBinding
import ph.kodego.rara.jamesnico.kodegoraraactivity9.tab_viewpager.ViewPagerActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var username: String
    private lateinit var password: String
    private lateinit var dao: UserDAO

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
            var userExist: Boolean = false
            var passMatched: Boolean = false

            username = binding.usernametext.text.toString()
            password = binding.passwordtext.text.toString()

            dao = UserDAOSQLImpl(it.context)
            userExist = dao.checkUser(username)
            passMatched = dao.checkPass(password)

            if(userExist && passMatched) {
                val goToViewPager = Intent(this, ViewPagerActivity::class.java)

                startActivity(goToViewPager)
                finish()
            }
            Snackbar.make(binding.root,
                "Invalid username or password.",
                Snackbar.LENGTH_SHORT
            ).show()

        }

        // on register button press
        binding.btnRegister.setOnClickListener {
            var goToRegister = Intent(this, RegisterActivity::class.java)
            launchRegister.launch(goToRegister)
        }

        // on forget password press
        binding.btnForgetpassword.setOnClickListener {
            var goToForgetPassword = Intent(this, ForgetPasswordActivity::class.java)
            launchRegister.launch(goToForgetPassword)
        }
    }

    override fun onBackPressed() {
        // no code executed to disable back press
    }
}