package cn.funcoding.playandroid.compose.logic.model

data class PaginationModel<T>(
    val offset: Int,
    val size: Int,
    val total: Int,
    val pageCount: Int,
    val curPage: Int,
    val over: Boolean,
    val dataList: MutableList<T>
)