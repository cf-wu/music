package com.cfwu.music5.api;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cfwu on 17-12-11.
 */
public abstract class NetCallBack<T> implements Callback<T> {

    public abstract void onSuccess(T t);

    public abstract void onFailure(String errorMsg);

    public void onFinish() {
    }

    ;

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        onSuccess(response.body());
        onFinish();
    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        onFailure(throwable.getMessage());
        onFinish();
    }

}
