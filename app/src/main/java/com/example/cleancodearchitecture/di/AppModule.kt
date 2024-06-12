package com.example.cleancodearchitecture.di

import com.example.cleancodearchitecture.core.util.Constants.BASE_URL
import com.example.cleancodearchitecture.data.api.CharacterApi
import com.example.cleancodearchitecture.data.repository.CharacterRepositoryImpl
import com.example.cleancodearchitecture.domain.repository.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideCharacterApi(retrofit: Retrofit): CharacterApi =
        retrofit.create(CharacterApi::class.java)


    @Provides
    @Singleton
    fun provideCharacterRepository(
        api: CharacterApi
    ): CharactersRepository{
        return CharacterRepositoryImpl(api)
    }


}