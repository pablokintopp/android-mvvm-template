package com.kintopp.pablo.androidmvvmtemplate.di;

import android.app.Application;

import com.kintopp.pablo.androidmvvmtemplate.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;


@Component(modules = {
        ApiModule.class,
        DbModule.class,
        ViewModelModule.class,
        AndroidSupportInjectionModule.class,
        ActivityModule.class,

})
@Singleton
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder apiModule(ApiModule apiModule);

        @BindsInstance
        Builder dbModule(DbModule dbModule);

        AppComponent build();
    }
    void inject(App app);

}
