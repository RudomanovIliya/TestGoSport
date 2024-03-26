package com.example.testgosport.di

import com.example.testgosport.presentation.DeliveryApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiServiceModule::class,
        FragmentModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        AndroidSupportInjectionModule::class,
    ]
)
interface ApplicationComponent : AndroidInjector<DeliveryApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: DeliveryApplication): ApplicationComponent
    }
}