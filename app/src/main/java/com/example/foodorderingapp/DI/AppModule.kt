package com.example.foodorderingapp.DI

import com.example.foodorderingapp.Data.Repository.FoodListDaoRepository
import com.example.foodorderingapp.Retrofit.ApiUtils
import com.example.foodorderingapp.Retrofit.FoodListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFoodListDaoRepository(kdao:FoodListDao): FoodListDaoRepository{
        return FoodListDaoRepository(kdao)
    }

    @Provides
    @Singleton
    fun FoodListDao() : FoodListDao{
        return ApiUtils.getFoodListDao()
    }
}