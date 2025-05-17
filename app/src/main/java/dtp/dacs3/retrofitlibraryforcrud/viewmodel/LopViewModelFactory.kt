package dtp.dacs3.retrofitlibraryforcrud.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dtp.dacs3.retrofitlibraryforcrud.repository.LopRepository

class LopViewModelFactory(val lopRepository: LopRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LopViewModel::class.java)){
            return LopViewModel(lopRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}