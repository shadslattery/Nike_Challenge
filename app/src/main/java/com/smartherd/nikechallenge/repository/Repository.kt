package com.smartherd.nikechallenge.repository

import com.smartherd.nikechallenge.model.Response
import com.smartherd.nikechallenge.repository.Remote.RetrofitInstance
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object Repository {

    fun defineTerm(term: String):Observable<Response> {
        return RetrofitInstance
            .getUrbanService()
            .defineTerm(term)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}