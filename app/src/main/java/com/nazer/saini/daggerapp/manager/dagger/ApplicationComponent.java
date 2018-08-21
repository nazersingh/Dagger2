package com.nazer.saini.daggerapp.manager.dagger;

import com.nazer.saini.daggerapp.manager.dagger.module.AppModule;
import com.nazer.saini.daggerapp.manager.dagger.module.NetModule;
import com.nazer.saini.daggerapp.view.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class,NetModule.class})
public interface ApplicationComponent {

    void Inject(MainActivity mainActivity);

    void inject(MainActivity mainActivity);
//    void Inject(MainActivity mainActivity);
//    void inject(MainActivity mainActivity);
}
