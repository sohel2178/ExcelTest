package com.baudiabatash.exceltest.Volley;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.concurrent.CountDownLatch;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Sohel on 1/29/2017.
 */

public class RxRequestAdapter<T> implements Response.Listener<T>,Response.ErrorListener{

    private final CountDownLatch mLatch;
    private final Observable<T> mObservable;

    private VolleyError mVolleyError;
    private T mResponse;

    public RxRequestAdapter() {
        mLatch = new CountDownLatch(1);
        mObservable = Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    mLatch.await();
                } catch (InterruptedException e) {
                    mVolleyError = new VolleyError(e);
                }

                if (mVolleyError != null) {
                    subscriber.onError(mVolleyError);
                } else {
                    subscriber.onNext(mResponse);
                    subscriber.onCompleted();
                }
            }
        });
    }

    public Observable<T> getObservable() {
        return mObservable;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

        mVolleyError = error;
        mLatch.countDown();

    }

    @Override
    public void onResponse(T response) {
        mResponse = response;
        mLatch.countDown();
    }
}
