package com.rarvs.basico

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.parceler.Parcels

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("NGVL","Tela1::onCreate")

        buttonToast.setOnClickListener{
            val text = editText.text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
        buttonTela2.setOnClickListener{
            val intent = Intent(this, Tela2Activity::class.java)
            intent.putExtra("nome","Rafael")
            intent.putExtra("idade",22)
            startActivity(intent)
        }

        buttonParcelable.setOnClickListener {
            val cliente = Cliente(1, "Vitoria")
            val intent = Intent(this, Tela2Activity::class.java)
            intent.putExtra("cliente", cliente)
            startActivity(intent)
        }

        buttonParcel.setOnClickListener{
            val individuo = Individuo(1, "João")
            val intent = Intent(this, Tela2Activity::class.java)
            intent.putExtra("individuo", Parcels.wrap(individuo))
            startActivity(intent)
        }

        buttonSerialize.setOnClickListener {
            val pessoa = Pessoa("Téo", 1)
            val intent = Intent(this, Tela2Activity::class.java)
            intent.putExtra("pessoa", pessoa)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("NGVL","Tela1::onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.i("NGVL", "Tela1::onResume")
    }
    override fun onRestart() {
        super.onRestart()
        Log.i("NVGL","Tela1::onRestart")
    }
    override fun onPause() {
        super.onPause()
        Log.i("NGVL","Tela1::onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i("NGVL","Tela1::onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("NGVL","Tela1::onDestroy")
    }
}