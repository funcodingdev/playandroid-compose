package cn.funcoding.playandroid.compose.ui.main.article

import cn.funcoding.playandroid.compose.logic.model.ArticleModel
import cn.funcoding.playandroid.compose.logic.network.PlayAndroidApi

object ArticleRepo {

    suspend fun getHomeArticleList(pageIndex: Int): List<ArticleModel> {
        val homeArticleList = PlayAndroidApi.getHomeArticleList(pageIndex)
        return homeArticleList.apiModel().articleModels
    }

}