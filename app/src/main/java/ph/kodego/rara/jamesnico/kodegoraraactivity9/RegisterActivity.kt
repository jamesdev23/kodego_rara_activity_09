package ph.kodego.rara.jamesnico.kodegoraraactivity9

import android.content.ContentProvider
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import ph.kodego.rara.jamesnico.kodegoraraactivity9.databinding.ActivityRegisterBinding
import ph.kodego.rara.jamesnico.kodegoraraactivity9.databinding.FragmentListBinding
import ph.kodego.rara.jamesnico.kodegoraraactivity9.tab_viewpager.ListFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val intent = Intent()
            intent.putExtra("firstname", binding.registerfirstnametext.text.toString())
            intent.putExtra("lastname", binding.registerlastnametext.text.toString())
            intent.putExtra("email", binding.registeremailtext.text.toString())
            intent.putExtra("password", binding.registerpasswordtext.text.toString())
            intent.putExtra("confirmpassword", binding.registerconfirmpasswordtext.text.toString())

            // showing result using full name
            val fullname = "${binding.registerfirstnametext.text.toString()} ${binding.registerlastnametext.text.toString()}"
            intent.putExtra("result","Registered ${fullname}.")

            setResult(1, intent)
            finish()

        }
    }
}