package com.example.myaugustapp3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.myaugustapp3.ui.theme.MyAugustApp3Theme
import com.example.myaugustapp3.ui.theme.kim
import com.example.myaugustapp3.ui.theme.kimathi
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        The onCreate() method is used here to provide a bridge between the containing activity and
//        the Compose-based user interfaces that are to appear within it:
        super.onCreate(savedInstanceState)
        setContent {
//            method declares that the content of the activity’s user
//            interface will be provided by a composable function named MyAugustApp3Theme
            MyAugustApp3Theme {
                // A surface container using the 'background' color from the theme
//                Surface is a built-in Compose component designed to provide a background for other composables:
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    Register()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun Register(){
    Column(modifier = androidx.compose.ui.Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var context = LocalContext.current
        Text(
            text = "Register here",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = kim,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .fillMaxWidth()
        )

        Image(
            painter = painterResource(id = R.drawable.schoolicon),
            contentDescription = null,
            modifier = Modifier
                .width(180.dp)
                .height(180.dp)
        )

        var name by mutableStateOf(TextFieldValue(""))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Enter name...")})

        Spacer(modifier = Modifier.height(16.dp))

        var password by mutableStateOf(TextFieldValue(""))
        OutlinedTextField(
            value = name,
            onValueChange = { password = it },
            label = { Text(text = "Enter password...")})

        Spacer(modifier = Modifier.height(16.dp))

        var email by mutableStateOf(TextFieldValue(""))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Enter email...")})

        Spacer(modifier = Modifier.height(16.dp))

        var idNumber by mutableStateOf(TextFieldValue(""))
        OutlinedTextField(
            value = idNumber,
            onValueChange = { idNumber = it },
            label = { Text(text = "Enter idNumber...")})

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /*TODO*/
                Toast.makeText(context, "You have registered as ${name.text}", Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(kimathi),
            shape = CutCornerShape(10.dp)
        ) {
            Text(text = "Register")
            
        }
        Spacer(modifier = Modifier.height(16.dp))

        ClickableText(
            text = AnnotatedString("Login instead"),
            onClick = {
                      context.startActivity(
                          Intent(context,SecondActivity2::class.java)
                      )

            },
            style = TextStyle(
                color = Color.Red,
                fontSize = 25.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold

            )

        )







    }
}

//Preview panel allows us to see how the user interface will appear without having to compile and run the app.
//a single activity can contain multiple preview composable functions configured to preview specific
// sections of a user interface using different data values
//Preview panel also includes an interactive mode that allows you to trigger events on the user interface components
// (for example clicking buttons, moving sliders, scrolling through lists, etc.).
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAugustApp3Theme {
//        Greeting("Android")
        Register()
    }
}