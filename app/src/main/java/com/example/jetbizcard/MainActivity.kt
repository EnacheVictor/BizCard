package com.example.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetBizCardTheme {
                Surface (color = MaterialTheme.colorScheme.background){
                    CreateBizCard()
                }
                }
            }
        }
    }

@Composable
fun CreateBizCard() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        Card(
            modifier = Modifier.width(200.dp).height(390.dp).padding(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateProfileImage()
                HorizontalDivider()
                CreateInfo()
                Button(
                    onClick = {
                        buttonClickedState.value = !buttonClickedState.value
                    }
                ) {
                    Text( text = "My Portofolio")
                }
                if (buttonClickedState.value){
                    Content()
                } else{
                    Box()
                    {}
                }
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(15.dp)) {
        Text(
            text = "Miles Petrov",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Student in a college",
            Modifier.padding(5.dp),
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = "My email address:",
            Modifier.padding(5.dp),
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
private fun CreateProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.LightGray),
        tonalElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {

        Image(
            painter = painterResource(id = R.drawable.img), contentDescription = "Profile Image",
            modifier = modifier.size(135.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}

@Preview
@Composable
fun Content(){
    Box(modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(5.dp)){
        Surface(modifier = Modifier.padding(5.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp , color = Color.Gray)
        ) {
            Portofolio(data = listOf("Project 1", "Project 2", "Project 3","Project 4"))
        }
    }
}

@Composable
fun Portofolio(data: List<String>) {
    LazyColumn{
        items(data) { item ->
            Card(modifier = Modifier.padding(13.dp)
                .fillMaxWidth()
                .size(120.dp),
                elevation = CardDefaults.cardElevation(2.dp),
                shape = RectangleShape){

                Row(modifier = Modifier.background(Color.White)
                    .padding(10.dp)
                    .fillMaxWidth()) {

                    CreateProfileImage(modifier = Modifier.width(100.dp))
                    Text(text = item, color = Color.Black)

                }

            }

        }
    }
}
