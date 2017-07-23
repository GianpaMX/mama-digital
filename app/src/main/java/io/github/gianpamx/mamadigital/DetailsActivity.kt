package io.github.gianpamx.mamadigital

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.details_activity.*

class DetailsActivity : AppCompatActivity() {

    companion object {
        val CLOTHES = "CLOTHES"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        setTitle(R.string.details_activity_title)

        val clothes = intent.extras[CLOTHES] as Clothes

        imageView.setImageResource(clothes.image)
        titleTextView.text = clothes.title
        descriptionTextView.text = clothes.description
    }
}
