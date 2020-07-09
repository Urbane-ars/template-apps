package com.example.template.di;

import com.example.template.ui.FirstActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        StorageModule.class
        ,NetworkModule.class})
public interface AppComponent {
    void inject(FirstActivity firstActivity);
}
