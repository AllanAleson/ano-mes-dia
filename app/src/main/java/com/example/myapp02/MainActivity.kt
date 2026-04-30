package com.example.myapp02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
        val btnLimpar = findViewById<Button>(R.id.btn_Limpar)

        btnConverter.setOnClickListener {
            val ano = txtAno.text.toString().toIntOrNull()
            val mes = txtMes.text.toString().toIntOrNull()
            val dia = txtDia.text.toString().toIntOrNull()

            txtAno.error = null
            txtMes.error = null
            txtDia.error = null

            when {
                ano == null -> txtAno.error = getString(R.string.error_ano)
                mes == null -> txtMes.error = getString(R.string.error_mes)
                dia == null -> txtDia.error = getString(R.string.error_dia)
                ano < 0 -> txtAno.error = getString(R.string.error_valor_negativo)
                mes !in 0..11 -> txtMes.error = getString(R.string.error_intervalo_mes)
                dia !in 0..30 -> txtDia.error = getString(R.string.error_intervalo_dia)
                else -> {
                    val resultado = ano * 360 + mes * 30 + dia
                    txtResultado.text = getString(
                        R.string.resultado_detalhado,
                        ano,
                        mes,
                        dia,
                        resultado
                    )
                }
            }
        }

        btnLimpar.setOnClickListener {
            txtAno.text.clear()
            txtMes.text.clear()
            txtDia.text.clear()
            txtAno.error = null
            txtMes.error = null
            txtDia.error = null
            txtResultado.text = getString(R.string.resultado_inicial)
            txtAno.requestFocus()
            Toast.makeText(this, R.string.campos_limpos, Toast.LENGTH_SHORT).show()
        }
    }
}
