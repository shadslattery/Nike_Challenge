package com.smartherd.nikechallenge.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlin.coroutines.coroutineContext

fun ViewGroup.inflate(layout: Int) : View {
    return LayoutInflater.from(context).inflate(layout,this,false)
}