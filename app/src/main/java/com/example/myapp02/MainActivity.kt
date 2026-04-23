package com.example.myapp02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtAno = findViewById<EditText>(R.id.txt_Ano)
        val txtMes = findViewById<EditText>(R.id.txt_Mes)
        val txtDia = findViewById<EditText>(R.id.txt_Dia)
        val txtResultado = findViewById<TextView>(R.id.txt_Resultado)
        val btnConverter = findViewById<Button>(R.id.btn_Converter)

        btnConverter.setOnClickListener {
            if (txtAno.text.isEmpty()) {
                txtAno.error = "Digite a quantidade de ano(s)"
            } else if (txtMes.text.isEmpty()) {
                txtMes.error = "Digite a quantidade de mes(es)"
            } else if (txtDia.text.isEmpty()) {
                txtDia.error = "Digite a quantidade de dia(s)"
            } else {
                val ano = txtAno.text.toString().toInt()
                val mes = txtMes.text.toString().toInt()
                val dia = txtDia.text.toString().toInt()
                val resultado = ano * 360 + mes * 30 + dia

                txtResultado.text = "Voce tem $resultado dia(s)"
            }
        }
    }
}