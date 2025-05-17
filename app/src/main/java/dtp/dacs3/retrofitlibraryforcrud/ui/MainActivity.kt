package dtp.dacs3.retrofitlibraryforcrud.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dtp.dacs3.retrofitlibraryforcrud.R
import dtp.dacs3.retrofitlibraryforcrud.repository.LopRepository
import dtp.dacs3.retrofitlibraryforcrud.viewmodel.LopViewModel
import dtp.dacs3.retrofitlibraryforcrud.viewmodel.LopViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var viewModel:LopViewModel
    lateinit var lopRepository: LopRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lopRepository = LopRepository()
        val factory = LopViewModelFactory(lopRepository)
        viewModel = ViewModelProvider(this@MainActivity,factory).get(LopViewModel::class.java)
        //Quan sat LiveData tu ViewModel
        viewModel.tenlop.observe(this){
                tenlop->
            binding!!.edtName.text = tenlop
        }
        binding!!.btnFetch.setOnClickListener {
            fetchLops()
        }
    }

    private fun fetchLops() {
        viewModel.getLops(this@MainActivity)
    }

}