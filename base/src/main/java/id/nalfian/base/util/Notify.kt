package id.nalfian.base.util

import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.nalfian.base.R
import id.nalfian.base.data.network.response.ResponseError

import java.io.Reader

object Notify {

    fun getMessageError(charStream: Reader): String? {
        val gson = Gson()
        val type = object : TypeToken<ResponseError>() {}.type
        val errorResponse: ResponseError? = gson.fromJson(charStream, type)
        return errorResponse?.errors?.get(0)
    }
    
    fun showOnFailureConnection(view: View, context: Context){
        Snackbar.make(view, context.getString(R.string.error_message_connection), Snackbar.LENGTH_LONG).show()
    }

    fun showOnFailure(view: View, message: String){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }
}