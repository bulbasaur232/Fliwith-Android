package com.narae.fliwith.src.main

import android.os.Bundle
import android.view.View
import com.narae.fliwith.R
import com.narae.fliwith.config.BaseActivity
import com.narae.fliwith.databinding.ActivityMainBinding
import com.narae.fliwith.src.main.home.HomeFragment
import com.narae.fliwith.src.main.map.MapFragment
import com.narae.fliwith.src.main.mypage.MyPageFragment
import com.narae.fliwith.src.main.recommend.RecommendFragment
import com.narae.fliwith.src.main.review.ReviewFragment

enum class DESTINATION {
    HOME, REVIEW, MAP, MYPAGE, RECOMMEND
}

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.main_fragment, HomeFragment()).commitAllowingStateLoss()

        binding.mainBtmNav.setOnItemSelectedListener{ item ->
            when (item.itemId) {
                R.id.menu_main_btm_nav_home -> {
                    changeFragmentView(DESTINATION.HOME)
                }
                R.id.menu_main_btm_nav_review -> {
                    changeFragmentView(DESTINATION.REVIEW)
                }
                R.id.menu_main_btm_nav_map -> {
                    changeFragmentView(DESTINATION.MAP)
                }
                R.id.menu_main_btm_nav_my_page -> {
                    changeFragmentView(DESTINATION.MYPAGE)
                }
            }
            true
        }

    }
    fun changeFragmentView(destination: DESTINATION, dest: Int? = null) {
        val transaction = supportFragmentManager.beginTransaction()
        when (destination) {
            DESTINATION.HOME -> {
                val fragment = HomeFragment.newInstance("", "")
                transaction.replace(binding.mainFragment.id, fragment)
                viewVisible()
            }

            DESTINATION.REVIEW -> {
                val fragment = ReviewFragment.newInstance("", "")
                transaction.replace(binding.mainFragment.id, fragment)
                viewVisible()
            }

            DESTINATION.MAP -> {
                val fragment = MapFragment.newInstance("", "")
                transaction.replace(binding.mainFragment.id, fragment)
                viewVisible()
            }

            DESTINATION.MYPAGE -> {
                val fragment = MyPageFragment.newInstance("", "")
                transaction.replace(binding.mainFragment.id, fragment)
                viewVisible()
            }

            DESTINATION.RECOMMEND -> {
                val fragment = RecommendFragment.newInstance("", "")
                transaction.replace(binding.mainFragment.id, fragment)
                viewGone()
            }

        }
        transaction.commit()
    }

    fun viewGone() {
        binding.mainBtmNav.visibility = View.GONE
    }

    fun viewVisible() {
        binding.mainBtmNav.visibility = View.VISIBLE
    }

}