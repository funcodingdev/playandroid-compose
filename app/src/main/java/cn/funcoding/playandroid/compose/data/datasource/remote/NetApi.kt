package cn.funcoding.playandroid.compose.data.datasource.remote

object NetApi {
    /**
     * 账号相关接口
     */
    val accountService: AccountService = RetrofitCreator.create()

    /**
     * 首页相关
     */
    val homePageService: HomePageService = RetrofitCreator.create()
}