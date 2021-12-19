package cn.funcoding.playandroid.compose.logic.model

data class ArticleListModel(
    val curPage: Int,
    val articleModels: List<ArticleModel>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)