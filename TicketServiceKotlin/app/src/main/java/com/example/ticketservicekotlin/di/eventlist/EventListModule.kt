package com.example.ticketservicekotlin.di.eventlist

import com.example.ticketservicekotlin.data.eventlist.EventListRepository
import com.example.ticketservicekotlin.data.eventlist.EventListRepositoryImpl
import com.example.ticketservicekotlin.data.source.local.database.EventsDatabase
import com.example.ticketservicekotlin.data.source.remote.RetrofitService
import com.example.ticketservicekotlin.domain.eventlist.EventListInteractor
import com.example.ticketservicekotlin.domain.eventlist.EventListInteractorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object EventDatabaseModule {

    @Provides
    @ActivityRetainedScoped
    internal fun provideEventListRepository(database: EventsDatabase, retrofitService: RetrofitService): EventListRepository {
        return EventListRepositoryImpl(database, retrofitService)
    }

    @Provides
    @ActivityRetainedScoped
    internal fun providesEventListInteractor(eventListRepository: EventListRepository): EventListInteractor {
        return EventListInteractorImpl(eventListRepository)
    }

}