package ui.smartpro.geekbrainskursovoimvp.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ui.smartpro.geekbrainskursovoimvp.api.Api
import ui.smartpro.geekbrainskursovoimvp.api.GitHubApiInterceptor
import javax.inject.Named

@Module
class ApiModule {
    @Named("api")
    @Provides
    fun provideBaseUrlProd(): String = "https://api.citybik.es/"

    @Provides
    fun provideGitHubApi(@Named("api") baseUrl: String): Api =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(
                            OkHttpClient.Builder()
                                    .addInterceptor(GitHubApiInterceptor)
                                    .addInterceptor(HttpLoggingInterceptor().apply {
                                        level = HttpLoggingInterceptor.Level.BODY
                                    })
                                    .build()
                    )
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(Api::class.java)

    private val gson: Gson =
            GsonBuilder()
                    .create()
}
