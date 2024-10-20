package com.ergegananputra.jetpack_compose.di

import android.content.Context
import com.ergegananputra.jetpack_compose.data.database.AppDatabase
import com.ergegananputra.jetpack_compose.data.remote.SlingAcademyApi
import com.ergegananputra.jetpack_compose.domain.repository.PhotosRepository
import com.ergegananputra.jetpack_compose.data.repository.PhotosRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOKHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideSlingAcademyApi(client: OkHttpClient): SlingAcademyApi {
        return Retrofit.Builder()
            .baseUrl("https://api.slingacademy.com/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SlingAcademyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context : Context): AppDatabase {
        return AppDatabase.getDatbase(
            context = context
        )
    }

    @Provides
    @Singleton
    fun providePhotosRepository(
        database: AppDatabase,
        api: SlingAcademyApi
    ): PhotosRepository {
        return PhotosRepositoryImpl(database.photoDao(), api)
    }
}