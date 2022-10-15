package ru.mertech.sbpskb.ui.adapters

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.animation.doOnEnd
import androidx.core.view.ViewCompat.animate
import com.google.android.material.card.MaterialCardView
import ru.mertech.sbpskb.R
import ru.mertech.sbpskb.pojo.BankModel

class BankGVAdapter(context: Context, bankModelArrayList: ArrayList<BankModel?>?) :
    ArrayAdapter<BankModel?>(context, 0, bankModelArrayList!!) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listItemView =
                LayoutInflater.from(context).inflate(R.layout.bank_card_item, parent, false)
        }
        val bankModel = getItem(position)
        val bankTV = listItemView!!.findViewById<TextView>(R.id.id_TV_bank)
        val bankIV = listItemView.findViewById<ImageView>(R.id.id_IV_bank)
        val cardView = listItemView.findViewById<MaterialCardView>(R.id.card_view)
        bankTV.text = bankModel!!.bankName
        bankIV.setImageResource(bankModel.imgid)
        listItemView.setOnClickListener {
            Toast.makeText(context, "clicked!!", Toast.LENGTH_SHORT).show()

         animate(cardView)
            // cardView.setStrokeColor(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.red)));
        }
        return listItemView
    }


    private fun animate(materialCardView: MaterialCardView,reverse: Boolean = false) {
        val colorTo = if (!reverse) Color.RED else Color.BLUE

        ObjectAnimator.ofArgb(materialCardView, "strokeColor", colorTo).apply {
            duration = 1000
            addUpdateListener {
                materialCardView.invalidate()
            }

            if (!reverse) {
                doOnEnd {
                    animate(materialCardView,reverse = true)
                }
            }
            start()
        }
    }
}