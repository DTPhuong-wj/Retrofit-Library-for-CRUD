package dtp.dacs3.retrofitlibraryforcrud.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dtp.dacs3.retrofitlibraryforcrud.repository.LopRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
class LopViewModel(val lopRepository: LopRepository):ViewModel() {
    var _tenlop: MutableLiveData<String> = MutableLiveData<String>()
    val tenlop: LiveData<String>
        get() = _tenlop
    fun getLops(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                try {
                    val response = lopRepository.getLops()
                    withContext(Dispatchers.Main) {
                        if (response.isSuccessful) {
                            val lops = response.body()
                            _tenlop.value = lops?.firstOrNull()?.tenlop?: "No Data"
                        } else
                            Toast.makeText(
                                context,
                                "Error Http: ${response.code()}",
                                Toast.LENGTH_LONG
                            ).show()
                    }
                } catch (e: HttpException) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, "Error Http: ${e.message()}",
                            Toast.LENGTH_LONG)
                            .show()
                    }
                }
            } catch (e: IOException) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Error Network: ${e.message}",
                        Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
