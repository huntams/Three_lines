package com.example.three_lines

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import com.example.three_lines.databinding.ViewContactBinding

class ViewContact @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defAttrsSet: Int = 0
) : ConstraintLayout(context, attributeSet, defAttrsSet) {
    private lateinit var binding: ViewContactBinding

    init {
        binding = ViewContactBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
        context.withStyledAttributes(
            attributeSet,
            R.styleable.ViewContact, defAttrsSet, 0
        ) {
            val title = getString(R.styleable.ViewContact_title)?.let {
                title ->binding.head.text = title
            }
            val subtitle = getString(R.styleable.ViewContact_subtitle)?.let {
                subtitle -> binding.subhead.text = subtitle
            }
            val image = getDrawable(R.styleable.ViewContact_image)?.let {
                image -> binding.image.setImageDrawable(image)
            }
        }
    }

    fun setTitle(text: String) {
        binding.head.text = text
    }

    fun setSubTitle(text: String) {
        binding.subhead.text = text
    }

    fun setImage(@DrawableRes imagesRes: Int) {
        binding.image.setImageDrawable(
            ContextCompat.getDrawable(context, imagesRes)
        )
    }
}