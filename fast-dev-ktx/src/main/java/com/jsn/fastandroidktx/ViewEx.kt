package com.jsn.fastandroidktx

import android.content.Context
import android.view.View
import android.widget.TextView

object ViewEx {
    @JvmStatic
    fun View.safeClick(clickInterval:Long=1500L,action:(View) -> Unit){
        var lastClick: Long =0L
        setOnClickListener {
            val now=System.currentTimeMillis()
            val pass=now-lastClick
            if(pass>clickInterval){
                lastClick=now
                action.invoke(it)
            }
        }
    }

    internal fun safeClickSamle(context: Context){
        TextView(context).safeClick(clickInterval = 3000L) {
            //
        }
    }
}