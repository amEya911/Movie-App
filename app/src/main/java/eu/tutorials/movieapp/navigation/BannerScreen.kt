package eu.tutorials.movieapp.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import eu.tutorials.movieapp.R


@Composable
fun BannerScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.hangover_movie), contentDescription = "Batman",
        Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(color = Color.White.copy(0.4f), RoundedCornerShape(20.dp))
                .border(0.5.dp, Color.White, RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Lights, Camera, Action!",
                modifier = Modifier.padding(vertical = 25.dp),
                color = Color.Yellow,
                fontSize = 34.sp,
                textAlign = TextAlign.Center
            )
            
            Button(
                onClick = { navController.navigate(Screen.HomeScreen.route) },
                modifier = Modifier
                    .padding(bottom = 55.dp, start = 20.dp, end = 20.dp)
                    .wrapContentSize()
                    .background(color = Color.White.copy(0.4f), RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                    .border(BorderStroke(2.dp, Color.Transparent), shape = RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(text = "Hop In", fontSize = 30.sp, color = Color.Black, textAlign = TextAlign.Center)
            }


        }
    }
    
}

