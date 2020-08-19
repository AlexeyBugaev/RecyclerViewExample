package com.app.abugaev.recyclerviewexample.ui;

import com.app.abugaev.recyclerviewexample.model.JsonObject;

import java.util.List;

public interface MainViewInterface {

    void showToast(String s);
    void displayObjects(List<JsonObject> objects);
    void displayError(String s);
}
