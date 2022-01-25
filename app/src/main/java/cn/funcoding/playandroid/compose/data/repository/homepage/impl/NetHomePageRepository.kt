package cn.funcoding.playandroid.compose.data.repository.homepage.impl

import cn.funcoding.playandroid.compose.data.Result
import cn.funcoding.playandroid.compose.data.datasource.remote.NetApi
import cn.funcoding.playandroid.compose.data.repository.homepage.HomePageRepository
import cn.funcoding.playandroid.compose.model.ArticleModel
import cn.funcoding.playandroid.compose.model.PaginationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetHomePageRepository : HomePageRepository {

    override suspend fun getHomeArticleList(pageIndex: Int): Result<PaginationModel<ArticleModel>> {
        return withContext(Dispatchers.IO) {
            val responseModel = NetApi.homePageService.getArticleList(pageIndex = pageIndex)
            if (responseModel.isSuccessful()) {
                Result.Success(responseModel.apiData())
            } else {
                Result.Error(responseModel.apiException())
            }
        }
    }

}