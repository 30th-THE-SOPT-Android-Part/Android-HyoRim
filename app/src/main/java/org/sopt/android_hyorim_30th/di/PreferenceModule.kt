package org.sopt.android_hyorim_30th.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.sopt.android_hyorim_30th.data.local.SOPTSharedPreference
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferenceModule {
    @Provides
    @Singleton
    fun providePreferences(@ApplicationContext context: Context) = SOPTSharedPreference(context)
}
