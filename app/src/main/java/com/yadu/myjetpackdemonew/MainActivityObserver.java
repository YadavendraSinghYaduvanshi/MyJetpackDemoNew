package com.yadu.myjetpackdemonew;


import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;


public class MainActivityObserver implements LifecycleObserver {

    private String TAG = this.getClass().getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void OnCreateEvent(){
        Log.i(TAG, "Observer On Create");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void OnStartEvent(){
        Log.i(TAG, "Observer On Start");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void OnResumeEvent(){
        Log.i(TAG, "Observer On Resume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void OnPauseEvent(){
        Log.i(TAG, "Observer On Pause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void OnStopEvent(){
        Log.i(TAG, "Observer On Stop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void OnDestroyEvent(){
        Log.i(TAG, "Observer On Destroy");
    }

}
