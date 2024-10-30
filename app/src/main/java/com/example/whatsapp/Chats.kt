package com.example.whatsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraEnhance
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "WhatsApp", fontSize = 32.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {},
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.QrCode, contentDescription = "Scan")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.CameraEnhance, contentDescription = "Camera")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "More options")
                    }
                },
                scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }, modifier = Modifier.size(60.dp)) {
                Icon(imageVector = Icons.Filled.Message, contentDescription = "Message")
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(top = innerPadding.calculateTopPadding())
                .padding(bottom = 0.dp)
                .consumeWindowInsets(innerPadding),
        ) {
            ChatList()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageCard(messageContent: MessageContent) {
    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = messageContent.profilePicResId),
                contentDescription = "ProfilePic",
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
                    .clip(CircleShape)
                    .clickable { }
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column(modifier = Modifier
                .padding(8.dp)
                .weight(0.4f)) {
                Text(
                    text = messageContent.Name,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = messageContent.subtext,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Column(
                modifier = Modifier
                    .weight(0.1f)
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = messageContent.time)
                Spacer(modifier = Modifier.size(8.dp))
                if (messageContent.badge > 0) {
                    Badge(containerColor = MaterialTheme.colorScheme.primaryContainer) {
                        Text(messageContent.badge.toString())
                    }
                }
            }
        }
    }
}

data class MessageContent(
    val Name: String,
    val profilePicResId: Int, // Store resource ID instead of Painter
    val subtext: String,
    val time: String,
    val badge: Int,
)

@Composable
fun ChatList(modifier: Modifier = Modifier) {
    // Sample list of messages with different profile picture resource IDs
    val messages = remember {
        mutableListOf(
            MessageContent(
                Name = "Sarthak",
                profilePicResId = R.drawable.img, // Different resources for each message
                subtext = "Call me honey please",
                time = "9:17",
                badge = 3
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            MessageContent(
                Name = "Aditi",
                profilePicResId = R.drawable.img, // Another resource for a different user
                subtext = "Hey, how are you?",
                time = "9:20",
                badge = 1
            ),
            // Add more messages as needed
        )
    }

    LazyColumn(modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(0.dp)
    ) {
        items(messages) { message ->
            MessageCard(message) // Pass each message to the MessageCard composable.
        }
    }
}