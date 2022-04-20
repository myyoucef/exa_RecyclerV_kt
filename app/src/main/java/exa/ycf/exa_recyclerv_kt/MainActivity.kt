package exa.ycf.exa_recyclerv_kt

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var nation: RecyclerView
    var countAdapter: myAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nation = findViewById(R.id.rv)

        // use a linear layout manager
        nation!!.layoutManager = LinearLayoutManager(this)

        var flags = arrayOf(
            R.drawable.alg,
            R.drawable.braz,
            R.drawable.can,
            R.drawable.ger,
            R.drawable.rus,
            R.drawable.tun,
            R.drawable.uk,
            R.drawable.us,
        )

        val countries = resources.getStringArray(R.array.Countries)
        val capitals = resources.getStringArray(R.array.Capitals)

        countAdapter = myAdapter(countries, capitals, flags)
        nation.adapter = countAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        // R.menu.menu est l'id de notre menu
        inflater.inflate(R.menu.mu2, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.modi) {
            val dia = AlertDialog.Builder(this)
                .setCancelable(true)
                .setTitle("dialog MODIFIER")
                .setIcon(android.R.drawable.ic_menu_manage)
                .setMessage("Dialogue à partir de menu..!")
                .setPositiveButton("Ok", null)
                .setNegativeButton("Fermer", null)
            dia.show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.pos) {
            Snackbar.make(
                nation,
                "Clicked on  ${countAdapter!!.position}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        return super.onContextItemSelected(item)
    }


}