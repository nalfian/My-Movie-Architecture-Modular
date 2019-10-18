package id.nalfian.base.data.network.response

import com.google.gson.annotations.SerializedName

data class ResponseError(

    @field:SerializedName("Errors")
    val errors: List<String?>? = null,

    @field:SerializedName("StatusCode")
    val statusCode: Int? = null
)