package com.example.shoppingapp.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.Adapters.CategoryAdapter
import com.example.shoppingapp.Adapters.CategoryRecycleAdapter
import com.example.shoppingapp.R
import com.example.shoppingapp.Services.DataService
import com.example.shoppingapp.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories){ category ->
            val productIntent= Intent(this, ProductsActivity::class.java)
            Toast.makeText(this,category.title,Toast.LENGTH_SHORT).show()
            productIntent.putExtra(EXTRA_CATEGORY,category.title)
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

       val layoutManager= LinearLayoutManager(this)
        categoryListView.layoutManager= layoutManager
        categoryListView.setHasFixedSize(true)
       }
    }








//only for listView
/*
//lateinit var adapter: ArrayAdapter<Category>

adapter= ArrayAdapter(this, android.R.layout.simple_list_item_1, DataService.categories)
categoryListView.adapter=adapter

categoryListView.setOnItemClickListener { adapterView, view, i, l ->
    val category= DataService.categories[i]
    Toast.makeText(this, "You clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show()
}
}
 */