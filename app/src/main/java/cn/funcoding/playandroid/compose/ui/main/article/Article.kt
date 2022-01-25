package cn.funcoding.playandroid.compose.ui.main.article

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import cn.funcoding.playandroid.compose.R
import cn.funcoding.playandroid.compose.utils.SnackbarManager
import cn.funcoding.playandroid.compose.ui.components.PlayAndroidSurface
import cn.funcoding.playandroid.compose.ui.theme.PlayAndroidTheme

@Composable
fun Article(
    onItemClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    PlayAndroidSurface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = stringResource(id = R.string.article),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = PlayAndroidTheme.colors.textPrimary,
                modifier = Modifier.clickable {
                    SnackbarManager.showMessage(R.string.article)
                }
            )
        }
    }
}