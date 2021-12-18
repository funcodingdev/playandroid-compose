package cn.funcoding.playandroid.compose

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import cn.funcoding.playandroid.compose.ui.theme.PlayAndroidTheme
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun PlayApp() {
    ProvideWindowInsets {
        PlayAndroidTheme {
            Surface(color = MaterialTheme.colors.background) {

            }
        }
    }
}