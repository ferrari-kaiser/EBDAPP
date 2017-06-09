package com.speedway.mobile.eclesiastico.controller;

import android.app.Activity;

/**
 * Created by ferrari on 21/04/2017.
 */

public abstract class BaseActivityController<T extends Activity> {

    protected T activity;


    protected BaseActivityController(T activity){
        this.activity = activity;
    }
}
