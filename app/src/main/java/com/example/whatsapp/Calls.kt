package com.example.whatsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CallReceived
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun callCard(callContent: callContent) {
    Card(modifier = Modifier
        .height(70.dp)
        .fillMaxWidth()
        .clickable { },
        colors = CardDefaults.cardColors(Color.White)) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "",
                modifier = Modifier
                    .size(70.dp)
                    .padding(8.dp)
                    .clip(CircleShape)
                    .clickable { }
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column(modifier = Modifier
                .padding(8.dp)
                .weight(0.3f)) {
                Text(
                    text = "Sarthak Shrivastava",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.W400)
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.CallReceived, contentDescription = "", tint = Color.Red)
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = "October 27, 12:13 AM", style = MaterialTheme.typography.bodyMedium)
                }
            }
            IconButton(onClick = { /*TODO*/ },

                modifier = Modifier.size(50.dp),
                colors = IconButtonDefaults.iconButtonColors(MaterialTheme.colorScheme.primaryContainer,)
            ) {

                Icon(imageVector = Icons.Default.Phone, contentDescription = "")

            }
        }
    }
}
data class callContent(
    val name :String,
    val date_time : String,
    val painterResourceId: Int,
)

@Composable
fun callLog(modifier: Modifier = Modifier) {

    val PhoneLog = remember {
        mutableListOf(
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
            callContent("Sarthak","October 26, 10:23 PM",R.drawable.img),
        )
    }
    LazyColumn {
        items(PhoneLog){
            phoneLog -> callCard(callContent = phoneLog)
        }
    }
}
