package com.example.shoppingapp.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingapp.Adapters.CategoryRecycleAdapter
import com.example.shoppingapp.Adapters.ProductRecycleAdapter
import com.example.shoppingapp.R
import com.example.shoppingapp.Services.DataService
import com.example.shoppingapp.Utilities.EXTRA_CATEGORY
import com.example.shoppingapp.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType= intent.getStringExtra(EXTRA_CATEGORY)

        adapter= ProductRecycleAdapter(this, DataService.getProducts(categoryType!!)){product ->
            val productDetailIntent= Intent(this, ProductDetailActivity::class.java)
            productDetailIntent.putExtra(EXTRA_PRODUCT,product)
            startActivity(productDetailIntent)
        }

        var spanCount= 2
        val orientation= resources.configuration.orientation
        if (orientation==Configuration.ORIENTATION_LANDSCAPE){
            spanCount=3
        }

        //for tablets
        val screenSize= resources.configuration.screenWidthDp
        if (screenSize>720){
            spanCount=3
        }

        val layoutManager= GridLayoutManager(this,spanCount)
        productListView.layoutManager= layoutManager
        productListView.adapter= adapter
    }
}