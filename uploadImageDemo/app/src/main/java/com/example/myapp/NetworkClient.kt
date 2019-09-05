package com.example.myapp


import android.util.Log
import okhttp3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import java.io.File

private val BASE_URL = "http://Nguyens-iMac:3000"
private val okHttpClient = OkHttpClient.Builder().build()
public val retrofit:Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

public interface UploadAPIs {
    @Multipart
    @POST("/products/uploads")
    fun uploadImage(@Part file: MultipartBody.Part, @Part("name") requestBody: RequestBody) : Call<ResponseBody>
}
fun uploadToServer(filePath: String) {
    val uploadAPIs = retrofit.create(UploadAPIs::class.java)
    val file = File(filePath)
    val fileReqBody = RequestBody.create(MediaType.parse("image/*"), file)
    val part = MultipartBody.Part.createFormData("upload", file.getName(), fileReqBody)
    val requestBody = RequestBody.create(MediaType.parse("text/plain"), "image-type")
    val call = uploadAPIs.uploadImage(part, requestBody)
    call.enqueue(object : Callback<ResponseBody> {
        override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
            println("failed")
        }

        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            //data.value = response!!.body()!!.articles
            println("success")
        }
    })
}
