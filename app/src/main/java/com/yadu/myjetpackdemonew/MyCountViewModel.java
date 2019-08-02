package com.yadu.myjetpackdemonew;

import androidx.lifecycle.ViewModel;

public class MyCountViewModel extends ViewModel {
    public MutableLiveData<String> count;

    public MutableLiveData<String> getCount() {

        if(count==null){
            count = new MutableLiveData<>();
            count.setValue("0");
        }
        return count;
    }
}
