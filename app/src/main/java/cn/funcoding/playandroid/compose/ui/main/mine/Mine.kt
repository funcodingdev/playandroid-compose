package cn.funcoding.playandroid.compose.ui.main.mine

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import cn.funcoding.playandroid.compose.R
import cn.funcoding.playandroid.compose.ui.theme.PlayAndroidTheme
import cn.funcoding.playandroid.compose.ui.theme.Typography

@Composable
fun Mine(
    onItemClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Profile()
    }
}

@Composable
fun Profile() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        val (avatarId, nicknameId, idId) = createRefs()
        Image(
            painter = painterResource(id = R.mipmap.ic_launcher),
            contentDescription = "avatar",
            modifier = Modifier
                .size(84.dp)
                .constrainAs(avatarId) {
                    start.linkTo(parent.start, margin = 32.dp)
                    top.linkTo(parent.top, margin = 8.dp)
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                },
            alignment = Alignment.CenterStart
        )
        Text(
            text = "nickname",
            fontSize = Typography.body1.fontSize,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .constrainAs(nicknameId) {
                    top.linkTo(avatarId.top)
                    start.linkTo(avatarId.end, margin = 16.dp)
                    bottom.linkTo(idId.top)
                }
        )
        Text(
            text = stringResource(id = R.string.mine_id, "12345"),
            fontSize = Typography.body2.fontSize,
            textAlign = TextAlign.Center,
            modifier = Modifier.constrainAs(idId) {
                top.linkTo(nicknameId.bottom)
                start.linkTo(avatarId.end, margin = 16.dp)
                bottom.linkTo(avatarId.bottom)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MinePreview() {
    PlayAndroidTheme {
        Mine(onItemClick = {

        })
    }
}