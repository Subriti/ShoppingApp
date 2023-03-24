package com.example.shoppingapp.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shoppingapp.Model.Product
import com.example.shoppingapp.R
import com.example.shoppingapp.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product= intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        val resourceID= resources.getIdentifier(product!!.image, "drawable", packageName)
        detailImageView.setImageResource(resourceID)
        detailProductName.text= product.title
        detailProductPrice.text= product.price


    }
}