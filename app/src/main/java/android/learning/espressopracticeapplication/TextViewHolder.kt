package android.learning.espressopracticeapplication

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView


class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  var textView: TextView = itemView as TextView
}