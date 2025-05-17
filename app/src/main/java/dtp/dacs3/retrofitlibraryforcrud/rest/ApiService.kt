package dtp.dacs3.retrofitlibraryforcrud.rest

import dtp.dacs3.retrofitlibraryforcrud.model.Lop
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("apiserver")
    suspend fun getLops():Response<List<Lop>>
}
