package com.example.kotlininterviewapp

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    var labelDataModels = ArrayList<LabelDataModel>()
    var imageLists = ArrayList<ImageListDataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager_view: ViewPager = findViewById(R.id.viewPager_view)
        val search_view: EditText = findViewById(R.id.search_view)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val sliderDots: TabLayout = findViewById(R.id.SliderDots)
        val scrollView: NestedScrollView = findViewById(R.id.scrollView)

        recyclerView.setNestedScrollingEnabled(false);


        onBirdsList()
        onImageList()

        val recyclerviewAdapter: RecyclerviewAdapter =
            RecyclerviewAdapter(labelDataModels, applicationContext)
        recyclerView.adapter = recyclerviewAdapter
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

        val viewPageAdapters: ViewPageAdapters = ViewPageAdapters(imageLists, applicationContext)
        viewPager_view.adapter = viewPageAdapters
        sliderDots.setupWithViewPager(viewPager_view)



        search_view.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    val labelName = search_view.text.toString()
                    val tempList = ArrayList<LabelDataModel>()
                    for (name in labelDataModels) {
                        if (name.name.toLowerCase().contains(labelName)) {
                            tempList.add(name)
                        }else  if (name.name.contains(labelName)) {
                            tempList.add(name)
                        }
                    }
                    val recyclerviewAdapter = RecyclerviewAdapter(tempList, applicationContext)
                    recyclerView.adapter = recyclerviewAdapter

                    val linearLayoutManager =
                        LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                    recyclerView.layoutManager = linearLayoutManager
                }
            })

    }

    fun onBirdsList() {
        var labelDataModel: LabelDataModel =
            LabelDataModel("https://homepages.cae.wisc.edu/~ece533/images/airplane.png", "Airplane")
        labelDataModels.add(labelDataModel)
        labelDataModel =
            LabelDataModel("https://homepages.cae.wisc.edu/~ece533/images/fruits.png", "Fruit")
        labelDataModels.add(labelDataModel)
        labelDataModel =
            LabelDataModel("https://homepages.cae.wisc.edu/~ece533/images/cat.png", "Cat")
        labelDataModels.add(labelDataModel)
        labelDataModel =
            LabelDataModel("https://homepages.cae.wisc.edu/~ece533/images/tulips.png", "Tulips")
        labelDataModels.add(labelDataModel)
    }

    fun onImageList() {
        var imageListDataModel: ImageListDataModel =
            ImageListDataModel("https://homepages.cae.wisc.edu/~ece533/images/monarch.png")
        imageLists.add(imageListDataModel)
        imageListDataModel =
            ImageListDataModel("https://homepages.cae.wisc.edu/~ece533/images/mountain.png")
        imageLists.add(imageListDataModel)
        imageListDataModel =
            ImageListDataModel("https://homepages.cae.wisc.edu/~ece533/images/frymire.png")
        imageLists.add(imageListDataModel)
    }
}