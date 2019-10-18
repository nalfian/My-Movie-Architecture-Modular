package id.nalfian.base.util

import android.content.Context
import android.content.Intent

object Actions {

    fun openUpcoming(context: Context) = internalIntent(
        context,
        "id.nalfian.upcoming.list.UpcomingActivity"
    )

    private fun internalIntent(context: Context, action: String) = Intent().setClassName(context, action)
}