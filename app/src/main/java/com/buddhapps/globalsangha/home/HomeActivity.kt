package com.buddhapps.globalsangha.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.buddhapps.globalsangha.R
import com.buddhapps.globalsangha.login.LoginActivity
import com.buddhapps.globalsangha.register.RegisterActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val userGreeting: TextView = findViewById(R.id.user_greeting)
        val loginButton: Button = findViewById(R.id.login_button)
        val registerButton: Button = findViewById(R.id.register_button)
        val logoutButton: Button = findViewById(R.id.logout_button)

        if (isLoggedIn()) {
            // Si el usuario está logueado, mostrar su nombre y el botón de logout
            userGreeting.text = getString(R.string.welcome_message, getUserName()) // Asume que tienes un método getUserName()
            userGreeting.visibility = View.VISIBLE
            logoutButton.visibility = View.VISIBLE
        } else {
            // Si no está logueado, mostrar botones de login y registro
            loginButton.visibility = View.VISIBLE
            registerButton.visibility = View.VISIBLE

            loginButton.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

            registerButton.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }

        logoutButton.setOnClickListener {
            // Aquí lógica para limpiar datos de sesión si es necesario

            // Iniciar LoginActivity y limpiar la pila de actividades
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    private fun isLoggedIn(): Boolean {
        // Implementa esta función para verificar si el usuario está logueado
        return false
    }

    private fun getUserName(): String {
        // Implementa esta función para obtener el nombre del usuario
        return "Usuario"
    }
}
