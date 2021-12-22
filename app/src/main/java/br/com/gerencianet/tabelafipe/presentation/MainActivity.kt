package br.com.gerencianet.tabelafipe.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.gerencianet.tabelafipe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
