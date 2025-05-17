package dtp.dacs3.retrofitlibraryforcrud.repository

import dtp.dacs3.retrofitlibraryforcrud.model.Lop
import dtp.dacs3.retrofitlibraryforcrud.rest.RetrofitClient
import retrofit2.Response

class LopRepository {
    suspend fun getLops():Response<List<Lop>>{
        return RetrofitClient.apiService.getLops()
    }
}