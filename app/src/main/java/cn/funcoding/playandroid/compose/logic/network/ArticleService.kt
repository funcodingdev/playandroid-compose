package cn.funcoding.playandroid.compose.logic.network

import cn.funcoding.playandroid.compose.logic.model.ArticleListModel
import cn.funcoding.playandroid.compose.logic.model.BaseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleService {

    /**
     * 首页文章列表
     */
    @GET("article/list/{pageIndex}/json")
    suspend fun getHomeArticleList(
        @Path("pageIndex") pageIndex: Int
    ): BaseModel<ArticleListModel>


}