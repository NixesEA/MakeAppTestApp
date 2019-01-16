package com.nixesea.makeapptestapp;

import android.os.Handler;
import android.view.MenuItem;

public class Presenter {
    private String PATH_TO_GAME1 = "file:///android_asset/game1/index.html";
    private String PATH_TO_GAME2 = "file:///android_asset/game2/index.html";

    private boolean doubleTapBackPressed = false;

    private View view;

    Presenter(View view) {
        this.view = view;
    }

    void navigationItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.game1) {
            view.loadWebView(PATH_TO_GAME1);
        } else {
            view.loadWebView(PATH_TO_GAME2);
        }
    }

    void backPressed() {
        if (doubleTapBackPressed) {
            view.exit();
        }

        doubleTapBackPressed = true;
        view.showToast("Нажмите еще раз для выхода");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleTapBackPressed = false;
            }
        }, 2000);
    }


    public interface View {
        void loadWebView(String path);

        void showToast(String message);

        void exit();
    }
}
