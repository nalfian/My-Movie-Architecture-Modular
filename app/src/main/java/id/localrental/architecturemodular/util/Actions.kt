package id.localrental.architecturemodular.util

import android.content.Context
import android.content.Intent

object Actions {

    fun openLoginIntent(context: Context) = internalIntent(context, "com.jeroenmols.modularization.login.open")

    fun openSharingIntent(context: Context) = internalIntent(context,"com.jeroenmols.modularization.sharing.open")

    private fun internalIntent(context: Context, action: String) = Intent(action).setPackage(context.packageName)
}