package com.example.kotlininterviewapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide

class ViewPageAdapters(
    val imageListDataModel: ArrayList<ImageListDataModel>,
    var context: Context
) : PagerAdapter() {

    private var inflater: LayoutInflater? = null

    override fun getCount(): Int {
        return imageListDataModel.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflater!!.inflate(R.layout.ic_image_viewpage_view, null)

        val imageView: ImageView = itemView.findViewById<View>(R.id.imageView) as ImageView
        val progressBar: ProgressBar = itemView.findViewById<View>(R.id.progressBar) as ProgressBar



        Glide.with(context).load(imageListDataModel[position].image).into(imageView);
        container.addView(itemView)

        return itemView

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}


