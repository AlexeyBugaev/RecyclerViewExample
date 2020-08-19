package com.app.abugaev.recyclerviewexample.remote;

import com.app.abugaev.recyclerviewexample.model.JsonObject;
import java.util.List;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface JsonObjectService {

    @GET("test.json")
    Observable<List<JsonObject>> getObjects();
}
