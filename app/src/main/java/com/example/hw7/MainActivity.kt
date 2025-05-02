package com.example.hw7

import android.os.Bundle
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import com.example.hw7.databinding.ActivityMainBinding
import com.example.hw7.presentation.mvvm.GameFragment
import com.example.hw7.presentation.mvi.GameMviFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showArchitectureChooser()
    }

    private fun showArchitectureChooser() {
        val options = arrayOf("MVVM", "MVI")
        AlertDialog.Builder(this)
            .setTitle("Выбери архитектуру")
            .setItems(options) { _: DialogInterface, which: Int ->
                val fragment = when (which) {
                    0 -> GameFragment()
                    1 -> GameMviFragment()
                    else -> GameFragment()
                }
                supportFragmentManager.beginTransaction()
                    .replace(binding.fragmentContainer.id, fragment)
                    .commit()
            }
            .show()
    }
}
