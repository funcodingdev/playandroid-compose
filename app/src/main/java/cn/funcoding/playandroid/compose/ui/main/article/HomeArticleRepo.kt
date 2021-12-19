package cn.funcoding.playandroid.compose.ui.main.article

import cn.funcoding.playandroid.compose.logic.model.ArticleModel
import cn.funcoding.playandroid.compose.logic.model.PaginationModel
import cn.funcoding.playandroid.compose.logic.network.PlayAndroidApi

class HomeArticleRepo {

    suspend fun getArticleList(pageIndex: Int): PaginationModel<ArticleModel> {
        val articleList = PlayAndroidApi.getArticleList(pageIndex)
        return articleList.apiModel()
    }

}