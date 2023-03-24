package com.example.shoppingapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.Model.Product
import com.example.shoppingapp.R

class ProductRecycleAdapter(private val context: Context, private val products: List<Product>, val itemClick: (Product) -> Unit): RecyclerView.Adapter<ProductRecycleAdapter.ProductHolder>() {

    inner class ProductHolder(itemView: View, val itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val productImage= itemView?.findViewById<ImageView>(R.id.productImage)
        private val productName= itemView?.findViewById<TextView>(R.id.productName)
        private val productPrice= itemView?.findViewById<TextView>(R.id.productPrice)

        fun bindProduct(product: Product, context: Context){
            val resourceId= context.resources.getIdentifier(product.image, "drawable", context.packageName)
            productImage?.setImageResource(resourceId)
            productName?.text= product.title
            productPrice?.text= product.price

            itemView.setOnClickListener { itemClick(product) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder?.bindProduct(products[position],context)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

}