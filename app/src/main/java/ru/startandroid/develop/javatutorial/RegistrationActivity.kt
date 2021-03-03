package ru.startandroid.develop.javatutorial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.registration.*

class RegistrationActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)
        loginButton.setOnClickListener {
            val intent = Intent(this, AuthorizationActivity::class.java)
            startActivity(intent)
        }
        registrButton.setOnClickListener {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            if (editTextEmail.text.toString().isEmpty() || editTextPassword.text.toString().isEmpty()) {
                Toast.makeText(this, "Email address or password is not provided",Toast.LENGTH_SHORT).show()
            }
            else {
                auth.createUserWithEmailAndPassword(
                    editTextEmail.text.toString(),
                    editTextPassword.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(applicationContext, "вы успешно зарегистрировались", Toast.LENGTH_SHORT).show()
                            val user = auth.currentUser
                            updateUI(user)
                            val intent = Intent(this, AuthorizationActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Ошибка при регистрации",
                                Toast.LENGTH_SHORT
                            ).show()
                            updateUI(null)
                        }
                    }
            }


        }

    }

    private fun updateUI(currentUser: FirebaseUser?){

    }
}
