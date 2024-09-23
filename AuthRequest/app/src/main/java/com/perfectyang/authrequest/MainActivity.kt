package com.perfectyang.authrequest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import com.perfectyang.authrequest.ui.theme.AuthRequestTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentResolver = applicationContext.contentResolver



        val pickMedia = this.registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            // Callback is invoked after the user selects a media item or closes the
            // photo picker.
            if (uri != null) {


                lifecycleScope.launch(Dispatchers.IO) {
                    contentResolver.delete(uri, null, null)
                    Log.d("PhotoPicker", "Selected URI: $uri")
                }


            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            AuthRequestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                    }
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, onClick: () -> Unit) {

    Text(
        text = "Hello $name!",
        modifier = modifier.clickable {
            onClick()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AuthRequestTheme {
        Greeting("Android") {

        }
    }
}