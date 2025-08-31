package com.example.cadastroprodutofirebase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cadastroprodutofirebase.model.Product

class MainActivity : AppCompatActivity() {

    private lateinit var etProductName: EditText
    private lateinit var etProductDescription: EditText
    private lateinit var etProductPrice: EditText
    private lateinit var etProductQuantity: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etProductName = findViewById(R.id.et_product_name)
        etProductDescription = findViewById(R.id.et_product_description)
        etProductPrice = findViewById(R.id.et_product_price)
        etProductQuantity = findViewById(R.id.et_product_quantity)
        btnSave = findViewById(R.id.btn_save)

        btnSave.setOnClickListener {
            saveProduct()
        }
    }

    private fun saveProduct() {
        val name = etProductName.text.toString().trim()
        val description = etProductDescription.text.toString().trim()
        val priceStr = etProductPrice.text.toString().trim()
        val quantityStr = etProductQuantity.text.toString().trim()

        if (name.isEmpty() || description.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()
            return
        }

        val price = priceStr.toDoubleOrNull() ?: 0.0
        val quantity = quantityStr.toIntOrNull() ?: 0

        // Cria um objeto Product
        val product = Product(name, description, price, quantity)
    }

    private fun clearFields() {
        etProductName.text.clear()
        etProductDescription.text.clear()
        etProductPrice.text.clear()
        etProductQuantity.text.clear()
        etProductName.requestFocus() // Coloca o foco no primeiro campo
    }
}