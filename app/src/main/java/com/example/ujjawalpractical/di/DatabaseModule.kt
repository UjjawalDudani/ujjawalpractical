package com.example.ujjawalpractical.di

import android.content.Context
import androidx.room.Room
import com.example.ujjawalpractical.data.local.AppDatabase
import com.example.ujjawalpractical.data.local.dao.WatchlistDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "popflicks_db"
        ).build()
    }

    @Provides
    fun provideWatchlistDao(db: AppDatabase): WatchlistDao {
        return db.watchlistDao()
    }
}