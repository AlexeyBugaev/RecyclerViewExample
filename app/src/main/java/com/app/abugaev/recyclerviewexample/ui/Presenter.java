package com.app.abugaev.recyclerviewexample.ui;


import com.app.abugaev.recyclerviewexample.model.JsonObject;
import com.app.abugaev.recyclerviewexample.remote.JsonObjectService;
import com.app.abugaev.recyclerviewexample.remote.RetrofitClient;

import java.util.List;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

public class Presenter {

    Retrofit retrofit;
    MainViewInterface mainViewInterface;

    public Presenter(MainViewInterface mainViewInterface) {
        retrofit = RetrofitClient.getClient();
        this.mainViewInterface = mainViewInterface;
    }


    public void loadData() {
        Observable<List<JsonObject>> observable = retrofit.create(JsonObjectService.class).getObjects();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<JsonObject>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<JsonObject> jsonObjects) {
                        mainViewInterface.displayObjects(jsonObjects);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mainViewInterface.displayError("Error: " + e.getMessage());
                        System.out.println(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        mainViewInterface.showToast("Load completed");
                    }
                });
    }
}
