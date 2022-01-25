package cn.funcoding.playandroid.compose.ui.main.article

import cn.funcoding.playandroid.compose.model.ArticleModel
import cn.funcoding.playandroid.compose.model.PaginationModel
import cn.funcoding.playandroid.compose.data.network.PlayAndroidApi

class HomeArticleRepo {

    suspend fun getArticleList(pageIndex: Int): PaginationModel<ArticleModel> {
        val articleList = PlayAndroidApi.getArticleList(pageIndex)
        return articleList.apiModel()
    }

}