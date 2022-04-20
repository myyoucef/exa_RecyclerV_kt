package exa.ycf.exa_recyclerv_kt

import android.app.Activity
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnCreateContextMenuListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class myAdapter(
    private val Pays: Array<String>,
    private val Capital: Array<String>,
    private val im: Array<Int>
) : RecyclerView.Adapter<myAdapter.ViewHolder>() {

    var position = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.element_res, parent, false)
        return ViewHolder(view)
    }

    // Create new views (invoked by the layout manager)
    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView1.text = Pays[position]
        viewHolder.textView2.text = Capital[position]
        viewHolder.imageView.setImageResource(im[position])
        viewHolder.itemView.setOnLongClickListener {
            this.position = viewHolder.layoutPosition
            false
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return Pays.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {
        val textView1: TextView = view.findViewById(R.id.textView1)
        val textView2: TextView = view.findViewById(R.id.textView2)
        val imageView: ImageView = view.findViewById(R.id.imageView)

        init {
            view.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(
            menu: ContextMenu?,
            v: View?,
            p2: ContextMenuInfo?
        ) {

            (v?.context as Activity).menuInflater.inflate(R.menu.mu1, menu)

//            menu?.add(0, 1, 0, "pos")
        }
    }
}