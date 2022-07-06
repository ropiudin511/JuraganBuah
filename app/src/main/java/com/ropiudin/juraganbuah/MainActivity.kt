package com.ropiudin.juraganbuah

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.ropiudin.juraganbuah.adapter.AdapterMacamBuah
import com.ropiudin.juraganbuah.model.Buah
import com.ropiudin.juraganbuah.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getData = intent.getParcelableExtra<ModelLogin>("data")


        val listBuah = ArrayList<Buah>()
        listBuah.add(Buah("Apel", R.drawable.apel,"Flavonoid, Serat, Vitamin C, Vitamin A, Vitamin K, Kalium, Asam ursolat, Asam folat", "4-5 bulan dari setelah bunga mekar"))
        listBuah.add(Buah("Semangka", R.drawable.semangka,"Karbohidrat, Serat, Protein, Kalsium, Magnesium, Kalium, Berbagai jenis vitamin, seperti vitamin A, vitamin B1, vitamin B2, vitamin B3, dan vitamin C.","70-100 hari setelah penanaman."))
        listBuah.add(Buah("Jeruk", R.drawable.jeruk,"vitamin C. Vitamin B1, folat, hingga potassium.", "4-5 bulan dari setelah bunga mekar"))
        listBuah.add(Buah("Strawberry", R.drawable.strawberry,"Karbohidrat, Serat, Protein, Kalsium, Folat, Vitamin C, Vitamin B6", "sudah dapat dipanen pada usia 2 sampai 4 bulan. Setelah panen pertama, Anda dapat melakukan panen selanjutnya di setiap 3 hari atau 2 kali dalam sepekan."))
        listBuah.add(Buah("Duku", R.drawable.duuku,"vitamin B, seperti thiamin, riboflavin, dan niasin.", "akan berbuah lebat pada tiga bulan awal tahun masehi lalu berbuah sedikit pada bulan April hingga akhir tahun."))

        binding.List.adapter = AdapterMacamBuah(this, listBuah, object : AdapterMacamBuah.onClickListener{
            override fun detailData(item: Buah) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_buah)

                    val image = this.findViewById<ImageView>(R.id.image_buah)
                    val nama = this.findViewById<TextView>(R.id.txtNamaBuah)
                    val nutrisi = this.findViewById<TextView>(R.id.txtNutrisiBuah)
                    val panen = this.findViewById<TextView>(R.id.txtPanenBuah)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    nutrisi.text = "${item?.nutrisi}"
                    panen.text = "${item?.panen}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }

                }.show()
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode : Int) {
        when (selectedMode) {
            R.id.myprofile -> {
                val intent = Intent(this, ContactsContract.Profile::class.java)
                startActivity(intent)

            }
        }

    }


}