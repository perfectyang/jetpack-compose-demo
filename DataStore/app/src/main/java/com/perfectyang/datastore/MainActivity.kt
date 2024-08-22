package com.perfectyang.datastore

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.perfectyang.datastore.ui.theme.DataStoreTheme
import com.perfectyang.datastore.utils.DataStoreManager
import com.perfectyang.datastore.utils.DataStoreManager.Companion.USERNAME
import com.perfectyang.datastore.utils.UserDetail
import com.perfectyang.datastore.utils.preferenceDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DataStoreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppEntry(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                                preferenceDataStore = preferenceDataStore
                    )
                }
            }
        }
    }
}

suspend fun check(preferenceDataStore: DataStore<Preferences>, onResult: (Boolean) -> Unit) {
    val preferences = preferenceDataStore.data.first()
    val username = preferences[USERNAME]
    onResult(username !== null)
}

@Composable
fun AppEntry(name: String, modifier: Modifier = Modifier, preferenceDataStore: DataStore<Preferences>) {
    val context = LocalContext.current
    val userManager = DataStoreManager(context)
    val scope = rememberCoroutineScope()




    val user by userManager.getDataStore().collectAsState(initial = null)

    var name by remember {
        mutableStateOf("")
    }


    var isRegister by remember {
        mutableStateOf(false)
    }


    LaunchedEffect(user?.username) {
       check(preferenceDataStore =preferenceDataStore) {
           isRegister = it
       }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (isRegister) {
            Text("已登录")
        } else {
            Text("未登录")
        }


        Text(text = user?.username?: "")

        OutlinedTextField(value = name, onValueChange = {
            name = it
        })

        Button(onClick = {
            scope.launch {
                userManager.saveToDataStore(UserDetail(
                    username = name
                ))
            }
                        Toast.makeText(context, "good", Toast.LENGTH_LONG).show()

        }) {
            Text(text = "saveData")
        }


        Button(onClick = {
            scope.launch {
                userManager.clearDataStore()
            }
        }) {
            Text(text = "clearData")
        }




















    }




}





