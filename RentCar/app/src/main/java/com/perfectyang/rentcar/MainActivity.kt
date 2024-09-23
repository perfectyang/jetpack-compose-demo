package com.perfectyang.rentcar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.perfectyang.rentcar.ui.theme.RentCarTheme
import dev.chrisbanes.haze.HazeState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.ui.Alignment
import androidx.compose.ui.input.nestedscroll.nestedScroll
import coil.compose.AsyncImage
import com.perfectyang.rentcar.ui.theme.Blur
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val url = "https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/03d7af2961d44835a05384fdafad6d17~tplv-k3u1fbpfcp-jj-mark:3024:0:0:0:q75.awebp#?w=1080&h=733&s=887950&e=png&b=c3c7ce"
            RentCarTheme {
                BtnDemo()
//                ImageDemo(url = url)

//                Dot()
//                MainPage()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(modifier: Modifier = Modifier) {
    val hazeState = remember{
        HazeState()
    }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .background(
                MaterialTheme.colorScheme.background
            ),
        containerColor = Color.Transparent,
        topBar = {
            Column {
                TopBar(
                    modifier = Modifier
                        .hazeChild(state = hazeState),
                    scrollBehavior = scrollBehavior,
                )
                Pager(modifier = Modifier
                    .fillMaxWidth()
                    .hazeChild(
                        state = hazeState,
                    )
                )
            }
        }
    ) { innerPadding ->
        HomeScreen(
            modifier = Modifier.fillMaxSize(),
            hazeState = hazeState,
            paddingValues = innerPadding
        )
    }
}


@Composable
fun HomeScreen(
    modifier: Modifier,
    hazeState: HazeState,
    paddingValues: PaddingValues
) {
   Box(modifier = modifier) {
       CartList(
           modifier = Modifier
               .fillMaxSize()
               .haze(
                   state = hazeState,
                   style = HazeStyle(
                       blurRadius = 13.dp,
                       tint = Blur
                   )
               ),
           paddingValues = paddingValues
       )
       BottomBar(
           modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = 26.dp)
               .align(Alignment.BottomStart)
               .padding(bottom = 46.dp)
               .hazeChild(
                   state = hazeState,
                   shape = RoundedCornerShape(26.dp)
               )
       )
   }
}

