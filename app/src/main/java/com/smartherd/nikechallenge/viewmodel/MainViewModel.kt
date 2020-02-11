package com.smartherd.nikechallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.smartherd.nikechallenge.model.Definition
import com.smartherd.nikechallenge.model.Response
import com.smartherd.nikechallenge.repository.Repository
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val disposables: CompositeDisposable = CompositeDisposable()
    private val _responseList: MutableLiveData<List<Definition>> = MutableLiveData()
    val responseList: LiveData<List<Definition>> = _responseList

    fun defineTerm(term: String) {
        disposables.add(Repository.defineTerm(term)
            .subscribe({
                //Success
                _responseList.value = it.list
            }, {
                //Failure
                it.printStackTrace()
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}