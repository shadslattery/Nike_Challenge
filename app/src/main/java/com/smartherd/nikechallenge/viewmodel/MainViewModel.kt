package com.smartherd.nikechallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.smartherd.nikechallenge.model.Response
import com.smartherd.nikechallenge.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val disposables: CompositeDisposable = CompositeDisposable()
    val responseList:MutableLiveData<Response> = MutableLiveData()


    fun definTerm(term: String) {
        disposables.add(Repository.defineTerm(term)
            .subscribe({
            //Success
            responseList.value = it
        }, {
            //Failure
            it.printStackTrace()
        }))
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

}