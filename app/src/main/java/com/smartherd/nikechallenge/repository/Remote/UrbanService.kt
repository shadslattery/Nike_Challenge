package com.smartherd.nikechallenge.repository.Remote

import com.smartherd.nikechallenge.model.Response
import com.smartherd.nikechallenge.utils.DEFINE_PATH
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UrbanService{

    @Headers(
        "x-rapidapi-host:https://mashape-community-urban-dictionary.p.rapidapi.com",
        "x-rapidapi-key:957c300581msh26618c202f98780p14065fjsn9f59b06a0015")
    @GET(DEFINE_PATH)
    fun defineTerm(@Query("term")term:String):Observable<Response>
}