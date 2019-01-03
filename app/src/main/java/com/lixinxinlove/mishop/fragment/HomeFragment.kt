package com.lixinxinlove.mishop.fragment


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.graphics.Palette
import com.lixinxinlove.mishop.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 *
 * 首页
 */
class HomeFragment : BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun setListener() {

    }

    override fun _onCreateView() {

        var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.mipmap.img)
        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener {
            override fun onGenerated(palette: Palette?) {
                if (palette != null) {

                    var vibrant = palette!!.vibrantSwatch//有活力的

                    var vibrantDark = palette!!.darkVibrantSwatch//有活力的，暗色

                    var vibrantLight = palette!!.lightVibrantSwatch//有活力的，亮色

                    var muted = palette!!.mutedSwatch//柔和的

                    var mutedDark = palette!!.darkMutedSwatch//柔和的，暗色

                    var mutedLight = palette!!.lightMutedSwatch//柔和的,亮色

                    var vibrantColor = muted!!.rgb

                    textView1.setBackgroundColor(vibrantColor)
                }
            }
        })

    }

}
