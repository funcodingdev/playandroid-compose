package cn.funcoding.playandroid.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.navigation
import cn.funcoding.playandroid.compose.ui.components.PlayAndroidScaffold
import cn.funcoding.playandroid.compose.ui.components.PlayAndroidbar
import cn.funcoding.playandroid.compose.ui.main.MainSections
import cn.funcoding.playandroid.compose.ui.main.PlayAndroidButtonBar
import cn.funcoding.playandroid.compose.ui.main.addMainGraph
import cn.funcoding.playandroid.compose.ui.theme.PlayAndroidTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.systemBarsPadding

@Composable
fun PlayAndroidApp() {
    ProvideWindowInsets {
        PlayAndroidTheme {
            val appStateHolder = rememberAppStateHolder()
            PlayAndroidScaffold(
                bottomBar = {
                    if (appStateHolder.shouldShowBottomBar) {
                        PlayAndroidButtonBar(
                            tabs = appStateHolder.bottomBarTabs,
                            currentRoute = appStateHolder.currentRoute!!,
                            navigateToRoute = appStateHolder::navigateToBottomBarRoute
                        )
                    }
                },
                snackbarHost = {
                    SnackbarHost(hostState = it,
                        modifier = Modifier.systemBarsPadding(),
                        snackbar = { snackbarData ->
                            PlayAndroidbar(snackbarData = snackbarData)
                        })
                },
                scaffoldState = appStateHolder.scaffoldState
            ) { innerPaddingModifier ->
                NavHost(
                    navController = appStateHolder.navController,
                    startDestination = MainDestinations.MAIN_ROUTE,
                    modifier = Modifier.padding(innerPaddingModifier)
                ) {
                    playAndroidNavGraph(
                        onItemSelected = appStateHolder::navigateToArticleDetail,
                        upPress = appStateHolder::upPress
                    )
                }
            }
        }
    }
}

private fun NavGraphBuilder.playAndroidNavGraph(
    onItemSelected: (Long, NavBackStackEntry) -> Unit,
    upPress: () -> Unit
) {
    navigation(
        route = MainDestinations.MAIN_ROUTE,
        startDestination = MainSections.MINE.route
    ) {
        addMainGraph(onItemSelected)
    }
    composable(
        "${MainDestinations.ARTICLE_DETAIL_ROUTE}/{${MainDestinations.ARTICLE_ID_KEY}}",
        arguments = listOf(navArgument(MainDestinations.ARTICLE_ID_KEY) { type = NavType.LongType })
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val articleId = arguments.getLong(MainDestinations.ARTICLE_ID_KEY)
//        SnackDetail(snackId, upPress)
    }
}

@Preview
@Composable
private fun PlayAndroidAppPreview() {
    PlayAndroidApp()
}