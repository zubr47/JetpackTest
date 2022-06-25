package com.example.avtobuy

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column( modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFF007991),
                                    Color(0xFF78FFD6))))
                        .fillMaxSize())
                {
                        Text(modifier = Modifier.padding(start = 15.dp),
                            text = "Выкуп авто в спб ", fontSize = 30.sp, color = Color.Black)
                  Column {
                      Image(
                            modifier = Modifier
                                .size(180.dp)
                                .clickable {
                                    sendWhatsAppMessageTo()
                                }, painter = painterResource(id = R.drawable.whatsapp_button),
                            contentDescription = "sup")
                      Text( modifier = Modifier.clickable {
                            dialPhoneNumber()
                        }, text = "+79310066600"
                          , fontSize = 36.sp
                          , textDecoration = TextDecoration.Underline )
                      Image(painter = painterResource(id = R.drawable.car), contentDescription ="car" )
                      Column( modifier = Modifier.fillMaxSize(),
                          verticalArrangement = Arrangement.Center,
                          horizontalAlignment = Alignment.CenterHorizontally) {
                          Text(text = "Срочный", fontSize = 48.sp, modifier = Modifier.padding(4.dp))
                          Text(text = "Выкуп", fontSize = 40.sp, modifier = Modifier.padding(4.dp))
                          Text(text = "Подержаных", fontSize = 40.sp, modifier = Modifier.padding(4.dp))
                          Text(text = "Автомобилей", fontSize = 40.sp, modifier = Modifier.padding(4.dp))
                      }
                  }
                  }
            }
        }
    }
    private fun sendWhatsAppMessageTo() {
        val phoneNumberWithCountryCode ="+79310066600"
        val message = "Здраствуйте"
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(
                    String.format(
                        "https://api.whatsapp.com/send?phone=%s&text=%s",
                        phoneNumberWithCountryCode,
                        message
                    )
                )
            )
        )
    }
    
    private fun dialPhoneNumber() {
        val phone = "+79310066600"
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
        startActivity(intent)
    }
    }






