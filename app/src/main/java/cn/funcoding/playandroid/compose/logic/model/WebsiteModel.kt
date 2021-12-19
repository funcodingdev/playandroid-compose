package cn.funcoding.playandroid.compose.logic.model

data class WebsiteModel(
    val category: String,
    val icon: String,
    val id: Int,
    val link: String,
    val name: String,
    val order: Int,
    val visible: Int
)