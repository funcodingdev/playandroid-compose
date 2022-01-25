package cn.funcoding.playandroid.compose.data.network

import cn.funcoding.playandroid.compose.model.*
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 首页相关
 */
interface HomeArticleService {

    /**
     * 首页文章列表
     */
    @GET("article/list/{pageIndex}/json")
    suspend fun getArticleList(
        @Path("pageIndex") pageIndex: Int
    ): BaseModel<PaginationModel<ArticleModel>>

    /**
     * 首页banner
     */
    @GET("banner/json")
    suspend fun getHomeBannerList(): BaseModel<List<BannerModel>>

    /**
     * 常用网站
     */
    @GET("friend/json")
    suspend fun getCommonUsedWebsiteList(): BaseModel<List<WebsiteModel>>

    /**
     * 搜索热词
     */
    @GET("hotkey/json")
    suspend fun getHotkeyList(): BaseModel<List<HotkeyModel>>

    /**
     * 置顶文章
     */
    @GET("article/top/json")
    suspend fun getTopArticleList(): BaseModel<List<ArticleModel>>
}