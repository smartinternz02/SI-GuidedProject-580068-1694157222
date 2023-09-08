package com.example.loginpage
import androidx.compose.foundation.layout.fillMaxSize
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview

class LoginActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = Color.White) {
                LoginScreen()
            }
        }
    }
    private fun logged(username: String, password: String) {
        if (username.isNotEmpty() && password.isNotEmpty()) {
            Toast.makeText(this, "logged", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "please enter valid credentials", Toast.LENGTH_SHORT).show()
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun LoginScreen(){
        val username= remember {
            mutableStateOf("")
        }
        val password= remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier.fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally
        )  {
            Text(text="Login please //Sidharth Ghai", color = Color.Blue, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text="Please enter your", color = Color.Blue, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text="Details", color = Color.Blue, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value =username.value ,
                    onValueChange ={
                        username.value=it
                    },
                    leadingIcon = {
                        Icon(Icons.Default.Person,contentDescription = "person")
                    },
                    label = {
                        Text(text = "Username")
                    },
                    placeholder = {
                        Text(text = "Enter username")
                    }
                )
                OutlinedTextField(
                    value =password.value ,
                    onValueChange ={
                        password.value=it
                    },
                    leadingIcon = {
                        Icon(Icons.Default.Info,contentDescription = "password")
                    },
                    label = {
                        Text(text = "Password")
                    },
                    placeholder = {
                        Text(text = "Enter password")
                    }
                )
                OutlinedButton(onClick = {logged(username.value,password.value) }) {
                    Text(text = "Login")
                }
            }
        }
    }
}