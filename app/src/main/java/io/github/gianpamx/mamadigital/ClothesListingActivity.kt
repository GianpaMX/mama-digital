package io.github.gianpamx.mamadigital

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.clothes_listing_activity.*
import java.util.*

class ClothesListingActivity : AppCompatActivity(), ClothesAdapter.OnClothesSelected {
    val categories = ArrayList<Clothes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.clothes_listing_activity)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        setTitle(R.string.clothes_activity_title)

        categories.add(Clothes("Sweater", R.drawable.baby1, ""))
        categories.add(Clothes("Pants", R.drawable.baby2, ""))
        categories.add(Clothes("Jacket", R.drawable.baby3, ""))
        categories.add(Clothes("Pants", R.drawable.baby1, ""))

        categoryRecyclerView.setHasFixedSize(true)
        categoryRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        categoryRecyclerView.adapter = ClothesAdapter(categories, this)
    }

    override fun onCategorySelected(clothes: Clothes) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.CLOTHES, clothes)
        startActivity(intent)
    }
}
