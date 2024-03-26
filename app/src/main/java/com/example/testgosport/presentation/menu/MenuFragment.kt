package com.example.testgosport.presentation.menu

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testgosport.R
import com.example.testgosport.databinding.FragmentMenuBinding
import com.example.testgosport.presentation.BaseFragment
import com.example.testgosport.presentation.State
import com.example.testgosport.presentation.menu.recyclerView.AddsAdapter
import com.example.testgosport.presentation.menu.recyclerView.CategoriesAdapter
import com.example.testgosport.presentation.menu.recyclerView.CategoryListener
import com.example.testgosport.presentation.menu.recyclerView.MealListener
import com.example.testgosport.presentation.menu.recyclerView.MealsAdapter
import com.example.testgosport.presentation.model.CategoryInfo
import com.example.testgosport.presentation.model.Meal
import java.io.File

private const val FILE_CATEGORY = "file_category"
private const val FILE_MEAL = "file_meal"

class MenuFragment : BaseFragment(R.layout.fragment_menu) {
    private val binding by viewBinding(FragmentMenuBinding::bind)

    private val viewModel: MenuViewModel by appViewModels()
    private val mealsAdapter = MealsAdapter()
    private val categoriesAdapter = CategoriesAdapter()
    private val addsAdapter = AddsAdapter()
    private val mealList = mutableListOf<Meal>()
    private val filterList = mutableListOf<Meal>()
    private val filenameCategory = FILE_CATEGORY
    private val filenameMeal = FILE_MEAL
    private val categoryListSave = mutableListOf<CategoryInfo>()
    private val mealListSave = mutableListOf<Meal>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (isOnline(binding.root.context)) {
            viewModel.loadMeals()
            viewModel.loadCategories()
        } else {
            var categorySaveString = ""

            val fileCategory = File(context?.filesDir, filenameCategory)
            if (fileCategory.exists()) {
                categorySaveString = fileCategory.readText()
                var categories = categorySaveString.split("\\s+".toRegex())
                categories = categories.dropLast(1)
                categories.forEach { category ->
                    categoryListSave.add(CategoryInfo(category))
                }
                categoriesAdapter.setList(categoryListSave)

                var mealSaveString = ""
                val fileMeal = File(context?.filesDir, filenameMeal)
                mealSaveString = fileMeal.readText()
                val meals = mealSaveString.split(",").toList()
                var i = 0
                while (i < meals.size - 7) {
                    mealListSave.add(
                        Meal(
                            meals[i],
                            meals[i + 1],
                            meals[i + 2],
                            meals[i + 3],
                            meals[i + 4],
                            meals[i + 5],
                            meals[i + 6],
                            meals[i + 7]
                        )
                    )
                    i += 8
                }
                mealsAdapter.setList(mealListSave)
                mealList.addAll(mealListSave)
            }
        }
        binding.recycleViewAdd.adapter = addsAdapter
        binding.recycleViewMeals.adapter = mealsAdapter.apply {
            mealListener = MealListener { meal ->
                Toast.makeText(binding.root.context, "${meal.titleMeal} info", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.recycleViewCategory.adapter = categoriesAdapter.apply {
            categoryListener = CategoryListener { category ->
                mealList.forEach { meal ->
                    if (meal.category == category.titleCategory) {
                        filterList.add(meal)
                    }
                }
                mealsAdapter.setList(filterList)
                filterList.clear()
            }
        }
        viewModel.mealsLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.Data -> {

                    if (state.data.isNotEmpty()) {
                        mealsAdapter.setList(state.data)
                        mealList.clear()
                        mealList.addAll(state.data)

                        var mealString = ""
                        val file = File(context?.filesDir, filenameMeal)
                        state.data.forEach { meal ->
                            mealString =
                                mealString + meal.titleMeal + "," + meal.imgUrl + "," + meal.category + "," +
                                        meal.ingridient1 + "," + meal.ingridient2 + "," + meal.ingridient3 +
                                        "," + meal.ingridient4 + "," + meal.ingridient5 + ","
                        }
                        file.writeText(mealString)
                    }

                }

                is State.Error -> {
                    Log.i("Error", state.toString())
                }
            }
        }
        viewModel.categoriesLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.Data -> {

                    if (state.data.isNotEmpty()) {
                        categoriesAdapter.setList(state.data)

                        var categoryString = ""
                        val file = File(context?.filesDir, filenameCategory)
                        state.data.forEach { category ->
                            categoryString = categoryString + category.titleCategory + " "
                        }
                        file.writeText(categoryString)
                    }
                }

                is State.Error -> {
                    Log.i("Error", state.toString())
                }
            }
        }

    }

    fun isOnline(context: Context?): Boolean {
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }
}