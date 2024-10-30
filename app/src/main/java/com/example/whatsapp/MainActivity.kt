//package com.example.whatsapp
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Camera
//import androidx.compose.material.icons.filled.CameraEnhance
//import androidx.compose.material.icons.filled.Message
//import androidx.compose.material.icons.filled.MoreVert
//import androidx.compose.material.icons.filled.People
//import androidx.compose.material.icons.filled.Phone
//import androidx.compose.material.icons.filled.QrCode
//import androidx.compose.material.icons.filled.Update
//import androidx.compose.material.icons.outlined.Message
//import androidx.compose.material.icons.outlined.People
//import androidx.compose.material.icons.outlined.Phone
//import androidx.compose.material.icons.outlined.Update
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.FloatingActionButton
//import androidx.compose.material3.FloatingActionButtonElevation
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
//import androidx.compose.material3.TopAppBarScrollBehavior
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableIntStateOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.whatsapp.ui.theme.WhatsAppTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            WhatsAppTheme {
//                val navController = rememberNavController()
//                NavHost(navController = navController, startDestination = "fiyahh" ) {
//                    composable("fiyahh") {
//                        Text(text = "hello")
//                    }
//                    composable("updates") {
//                        ScaffoldExample()
//                    }
//                    composable("chats") {
//                        Text(text = "yo")
//                    }
//                }
//                Scaffold(
//                    bottomBar = { NavBar(navController)}
//                ) {
//                    innerPadding ->
//                    Column(modifier = Modifier.padding(innerPadding)) {
//                    }
//                }
////                ScaffoldExample()
//            }
//        }
//    }
//}
//
//
//@Composable
//fun NavBar(navController: NavController) {
//var selectedItem by rememberSaveable {
//    mutableStateOf(0)
//}
//val barItems = listOf(
//    barItem("Chats",Icons.Filled.Message,Icons.Outlined.Message,"chats"),
//    barItem("Updates",Icons.Filled.Update,Icons.Outlined.Update,"updates"),
//    barItem("Communities",Icons.Filled.People,Icons.Outlined.People,"communities"),
//    barItem("Calls",Icons.Filled.Phone,Icons.Outlined.Phone,"calls")
//)
//
//    NavigationBar {
//        barItems.forEachIndexed{
//            index,barItem ->
//            NavigationBarItem(
//                selected = selectedItem==index,
//                onClick = {
//                    selectedItem = index
//                    navController.navigate(barItem.route)
//
//                          },
//                icon = {
//                    Icon(
//                        imageVector = if (selectedItem==index) barItem.SelectedIcon else barItem.unSelectedItem,
//                        contentDescription = "")
//                },
//                label = { Text(text = barItem.title)}
//            )
//        }
//    }
//
//}
//
//data class barItem(
//    val title: String,
//    val SelectedIcon: ImageVector,
//    val unSelectedItem: ImageVector,
//    val route: String
//)
//
//
//
//
//
//
//
//
//
//
//
//
//
package com.example.whatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Update
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp.ui.theme.WhatsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { NavBar(navController) }
                ) { innerPadding ->
                    NavHost(navController = navController, startDestination = "chats",
                        Modifier
                            .padding(innerPadding)
                            .consumeWindowInsets(innerPadding),) {
                        composable("chats") { ChatsScreen() }
                        composable("updates") { UpdatesScreen() }
                        composable("communities") { CommunitiesScreen() }
                        composable("calls") { CallsScreen() }
                    }
                }
            }
        }
    }
}

@Composable
fun NavBar(navController: NavController) {
    var selectedItem by rememberSaveable { mutableStateOf(0) }

    val barItems = listOf(
        BarItem("Chats", Icons.Filled.Message, Icons.Outlined.Message, "chats"),
        BarItem("Updates", Icons.Filled.Update, Icons.Outlined.Update, "updates"),
        BarItem("Communities", Icons.Filled.People, Icons.Outlined.People, "communities"),
        BarItem("Calls", Icons.Filled.Phone, Icons.Outlined.Phone, "calls")
    )

    NavigationBar {
        barItems.forEachIndexed { index, barItem ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(barItem.route) {
                        // Avoid multiple copies of the same destination in the back stack
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (selectedItem == index) barItem.selectedIcon else barItem.unSelectedIcon,
                        contentDescription = ""
                    )
                },
                label = { Text(text = barItem.title) }
            )
        }
    }
}

data class BarItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val route: String
)

@Composable
fun ChatsScreen() {
    ScaffoldExample()
}

@Composable
fun UpdatesScreen() {
    Text(text = "Updates Screen", fontWeight = FontWeight.Bold)
}

@Composable
fun CommunitiesScreen() {
    Text(text = "Communities Screen", fontWeight = FontWeight.Bold)
}

@Composable
fun CallsScreen() {
    callLog()


}