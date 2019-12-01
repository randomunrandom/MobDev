package com.random.lab03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goods = getListGoods(5000)

        val recyclerView: RecyclerView = findViewById(R.id.RecView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(goods)

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            Toast.makeText(this, "Mixing", Toast.LENGTH_SHORT).show()
            goods.shuffle()
            recyclerView.adapter = Adapter(goods)
        }
    }

    private fun getListGoods(n: Int): MutableList<Good> {
        val res = mutableListOf<Good>()
        for(i in 1..n) {
            res.add(Good(
                "good$i", "desc$i", "price$i"
            ))
        }
        return res
    }

    class Adapter(private val vals: List<Good>): RecyclerView.Adapter<Adapter.ViewHolder>() {
        override fun getItemCount(): Int = vals.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return ViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.text_name?.text = vals[position].name
            holder.text_desc?.text = vals[position].desc
            holder.text_price?.text = vals[position].price
        }

        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            var text_name: TextView? = null
            var text_desc: TextView? = null
            var text_price: TextView? = null
            init {
                text_name = itemView.findViewById(R.id.text_name)
                text_desc = itemView.findViewById(R.id.text_desc)
                text_price = itemView.findViewById(R.id.text_price)
            }
        }
    }
}
