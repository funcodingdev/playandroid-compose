package cn.funcoding.playandroid.compose.ui.main.article

import cn.funcoding.playandroid.compose.logic.model.ArticleModel
import cn.funcoding.playandroid.compose.ui.components.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeArticleViewModel : BaseViewModel() {
    private val homeArticleRepo by lazy { HomeArticleRepo() }

    companion object {
        const val INITIAL_PAGE = 0
    }

    private val _articleModelList = MutableStateFlow<List<ArticleModel>>(emptyList())
    val articleModelList: StateFlow<List<ArticleModel>> get() = _articleModelList

    private var page = INITIAL_PAGE

    fun refreshArticleList() {
        launch(block = {
            val articleListPagination = homeArticleRepo.getArticleList(INITIAL_PAGE)
            page = articleListPagination.curPage
            _articleModelList.value = articleListPagination.dataList
        })
    }
}