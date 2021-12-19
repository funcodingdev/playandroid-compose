package cn.funcoding.playandroid.compose.logic.network

object PlayAndroidApi {
    /**
     * 账号相关接口
     */
    private val accountService: AccountService = ServiceCreator.create()

    suspend fun login(username: String, password: String) =
        accountService.login(username, password)

    suspend fun register(username: String, password: String, repassword: String) =
        accountService.register(username, password, repassword)

    suspend fun logout() = accountService.logout()

    private val articleService: ArticleService = ServiceCreator.create()

    suspend fun getHomeArticleList(pageIndex: Int) = articleService.getHomeArticleList(pageIndex)
}