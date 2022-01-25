package cn.funcoding.playandroid.compose.data.repository.homepage

import cn.funcoding.playandroid.compose.data.Result
import cn.funcoding.playandroid.compose.model.ArticleModel
import cn.funcoding.playandroid.compose.model.PaginationModel

interface HomePageRepository {

    suspend fun getHomeArticleList(pageIndex: Int): Result<PaginationModel<ArticleModel>>

}