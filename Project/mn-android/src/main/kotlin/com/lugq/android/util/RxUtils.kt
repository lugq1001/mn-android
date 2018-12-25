package com.lugq.android.util

import io.reactivex.subjects.BehaviorSubject

class Variable<T>(defaultValue: T) {

    var value: T = defaultValue
        set(value) {
            field = value
            asObservable.onNext(value)
        }

    val asObservable = BehaviorSubject.createDefault(value)
}

class VariableNullable<T>(obj: NullableObj<T>) {

    var obj: NullableObj<T> = obj
        set(value) {
            field = value
            asObservable.onNext(value)
        }

    val asObservable = BehaviorSubject.createDefault(obj)
}


data class NullableObj<T>(val value: T?)