package ph.kodego.rara.jamesnico.kodegoraraactivity9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.kodego.rara.jamesnico.kodegoraraactivity9.databinding.ActivityForgetPasswordBinding

class ForgetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendpassword.setOnClickListener {
            val intent = Intent()
            val emailAddress = binding.forgetemailtext.text.toString()

            intent.putExtra("email", emailAddress)
            intent.putExtra("result", "Sent password to ${emailAddress}.")

            setResult(1, intent)
            finish()

        }
    }
}