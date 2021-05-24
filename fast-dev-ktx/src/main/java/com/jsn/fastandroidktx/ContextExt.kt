package com.jsn.fastandroidktx

import android.content.Context
import android.widget.Toast

fun Context.showToast(s:String,
                      duration:Int=Toast.LENGTH_SHORT)=
        Toast.makeText(this,s,duration).show()

