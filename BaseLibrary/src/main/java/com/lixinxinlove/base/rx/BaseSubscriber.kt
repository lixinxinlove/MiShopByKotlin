package com.kotlin.base.rx


import io.reactivex.Observable
import io.reactivex.Observer
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription


/*
    Rx订阅者默认实现
 */
open class BaseSubscriber<T>: Observable<T>() {
    override fun subscribeActual(observer: Observer<in T>?) {

    }


}
