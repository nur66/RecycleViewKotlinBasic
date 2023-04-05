BAGIAN 1

android 4.1 keatas kita akan mendapatkan parent layout constraint, jadi bedanya dengan Linear dan Relative layout
kita tidak mendapatkan tambahan attribut constraint, jadi ini dibutuhkan karena ada ConstraintLayout di parentnya

Recycle View kita gunakan untuk membuat list, dan setiap list ada item listnya, jadi ada masing2 itemnya yang perlu kita design dan kita lakukan layouting juga

Di Recycle View kita membuat design dair masing2 item ini menggunakan item terpisah, jadi kita perlu buat layout lagi

1. Untuk menambahkan Recycle view bisa langsung ketik <RecycleView kemudian auto complete dan enter
   attribut kita otomatis ada 2, yaitu width dan height
   karena kita menggunakan parent contraint maka kita membutuhkan attribut constraint, ConstraintStrat_toStartOf, ConstraintTop_toTopOf.
   kalo kita menggunakan constraint maka kewajiban kita ada 2, bagaimana caranya view yang kita gunakan berada di sudut constraint,
   jadi start (itu dimulai dari kiri) mau ditaro dimana, dan Top (itu dimulai dari atas)
   kalo constraint kita lengkap(Strat, End, Top, Bottom), kita bisa jadikan width dan height nya 0dp, jadi semuanya diatur constraint

2. Buat layout baru
   layout > new > Layout Resource File > File name : adapter_main / item_main
   karena nanti dikelas kotlin kita perlu menambahkan recycle view adapter untuk class itemnya,
   jadi untuk penamaan di item ini kita bisa gunakan nama item atau adapter diambil nama Recycle view adapter yang nantinya kita bikin juga class Kotlinnya
   jadi nama disesuaikan dengan data yang ingin dimunculkan, misalnya adapter_user, atau jika hanya ada 1 daftar biasanya disesuaikan dengan nama activitynya
   jadi layout ini kita akan gunakan didalam RecycleView yang kita buat di point 1.

3. adapater_main.xml
   untuk menggunakan item kita harus membuat heightnya menjadi wrap_content, karena dia berupa list kebawah, jangan sampai 1 item menghabiskan 1 screen/ 1 layar
   kita akan menambahkan TextView sederhana dengan memberikan id nya textView

Jadi sekarang dibagian adapter kita punya TextView dan dibagian activity kita punya RecycleView yang masing2 sudah kita kasih id/nama variabel.

4. Untuk preview biasanya kita membutuhkan text untuk mengetahui text nya munculnya seperti apa
   Untuk adapter biasanya kita wajib memberikan padding misal 10dp
   jika kita gunakan prefix android maka jika tidak di set datanya dari Kotlin atau Java maka datanya akan muncul di emulator
   jika hanya untuk preview bentuk design dan tidak akan dieksekusi di emulator, kita bisa gunakan tools, jangan lupa di import dengan cara alt+enter

5. Untuk melihat adapter_main / listnya di RecycleView, kita bisa juga gunakan tools:listitem="@layout/adapter_main"
   sekarang akan nampak preview bentuk design data antara RecycleView dan Adapternya,
   dan kita juga bisa set apabila itemnya ada berapa dengan tools:itemCount="5" dan ini hanya untuk preview
   dan juga layoutManager yang bersifat wajib dan opsional(bisa ditulis di xml ini atau di Kotlin nya langsung)
   ada 3 pilihan, Linear, Grid dan Staggered(random)
   untuk LinearLayout dia berbentuk statis dari atas ke bawah
   kalau kita gunakan grid manager maka kita bisa melakukan set spanCount, artinya kolom yang akan dibuat mau berapa


Bagian 2

Sebelumnya kita baru buat adapter di layoutnya dan ini belum selesai, kita harus membuatnya di kotlinnya juga

1. Buat class Kotlin di java(sejajar dengan MainActivity) dengan nama MainAdapter, biasanya sesuai dengan nama layoutnya yaitu main_activity
      jadi adapter ini adalah punya main_activity
2. MainAdapter
      kita harus buat implement ke RecycleView,
      Ketika kita ketik .Adapter maka akan ada <VH> yang artinya ViewHolder, yang artinya nantinya kita harus melakukan implement view holder di bawah ini, jangan lupa tambahkan () sebagai constructor
      MainAdapter.ViewHolder, sehingga dibawah nanti kita akan buat class ViewHoder
      Nantinya ada garis merah pesan error dan lihat pada bagian icon lampu, maka kita diarahkan untuk implement member, pilih semuanya dan tekan ok
      sehingga kita akan dibuatkan membernya, dan yang terakhir kita harus buat implement ViewHolder, ini untuk id yang ada di layout adapter_main
      didalam view holder kita tambahkan param view dengan return View, jangan lupa di import
3. onCreateViewHolder : adalah tempat kita taro layout yang akan kita gunakan, dalam hal ini adalah adapter_main
4. onBindViewHolder : biasanya digunakan untuk kita mengambil data dari constructornya, dan juga biasanya digunakan untuk memberikan Listener atau Aksi seperti onClick, dll
5. getItemCount : untuk set ada berapa data yang akan kita munculkan di recycle view ini 
6. Data yang akan kita gunakan adalah data teks sesuai dengan ketersediaan di adapter_main
      jadi di bagian constructor class MainAdapter kita set datanya berupa private val listName : List<String>, jadi tipe yang akan digunakan adalah List berupa String, data namanya nanti akan kita buat random di bagian MainActivity
      kenapa kita gunakan List, sebenernya kita butuh data yang mempunya index dan valuenya,
      karena pada bagain getItemCount kita harus me return int sehingga kita dapat membuat nya return listName.size
7. onCreateViewHolder akan mereturn ViewHolder, maka kita akan mengambil class yang ada dibawah yang telah kita buat
      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
         return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
         )
      }
      sehingga sekarang kita bisa gunakan semua item/component yang ada di adapter_main
8. set id yang ada di adapter_main kedalam class Viewholder
      buat variabel text, kemudian gunakan class view untuk mencari by id dengan tipenya apa dan idnya apa
      dengan seperti ini kita sudah mewakili textView yang ada di adapter_main
   class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
      val text = view.findViewById<TextView>(R.id.textView)
   }
9. set datanya di onBindViewHolder karena di onBindViewHolder kita punya holder yang mewakili ViewHolder
      jadi disini dia akan menggunakan variabel text yang ada di class ViewHolder dan di convert menjadi text, yang isinya adalah listName dengan position,
      kalau di set position, maka sebanyak apapun data yang ada di listName maka dia akan melakukan loop ke viewHolder berdasarkan position dari listName makanya ada getCount untuk menghitung ada berapa banyak list yang harus kita munculkan
   override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
      holder.text.text = listName[position]
   }
10. Sekarang kita ke MainActivity untuk membuat datanya
    val names = listOf<String>(
       "Nur",
       "Lisa",
       "Uwais",
       "Umar",
       "Iswanto",
       "Mufia",
       "Abdurrahman",
       "Alfarisiy",
    )
      sekarang kita akan menggunakan adapter kita dengan cara
      val mainAdapter = MainAdapter( names )
      kalo recycleView nya mau langsung digunakan kita bisa langsung set menjadi findViewById<RecyclerView>(R.id.recycleView).adapter = mainAdapter
      sekarang kita tes apakah nama diatas akan muncul atau tidak


Bagian 3

1. Jika data di RycecleView tidak tampil maka kita harus mengecek apakah datanya ada dengan cara log dan lihat hasilnya di logcat
    Log.e("MainActivity", "size {${names.size}}")
2. Jika ada maka kita harus mengecek datanya berdasarkan index dari List kita, yang terjadi sebenarnya adalah kita memanggil function onBindViewHolder
    Log.e("MainActivity", names[1])
3. Jika ada datanya coba kita looping menggunakan foreach, bisa menggunakan 2 cara
   names.forEach {
       Log.e("MainActivity", it)
   }
   names.forEach {name ->
       Log.e("MainActivity", name)
   }
4. Jika constructor/ list yang di passing ke Adapter kita berupa integer, maka di onBindViewHolder kita harus mengconvert nya kembali menjadi string dengan menggunakan method toString()
    

Bagian 4

Menampilkan gambar, dan untuk itu kita harus mempunyai assetnya terlebih dahulu dan meletakannya di drawable

1. Untuk review kita dapat melakukannya dengan membuatnya langsung di activity main sebelum nantinya akan kita pindahkan ke ke layout adapternya
2. Karena kita melakukan review langsung tanpa recycle view, maka component recycle view dapat kita set visibility nya menjadi gone
3. Pada saat membuat component / attribut ImageView hal yang paling penting adalah src, dan jangan lupa juga adjustViewBounds = true, agar tidak ada spasi disisi-sisi gambar
    width dan height nya dapat kita set menjadi wrap_content agar dia fokus dengan image tersebut, dan kita tidak butuh constraintBottom agar dia nempel diatas
4. Dan karena ini hanya untuk review maka kita dapat menggunakan tools, karena datanya nanti akan kita buat dinamis dari drawable
5. Sekarang kita dapat memanggilnya di MainActivity untuk memastikan bahwa ini berjalan
    gunakan findViewById kemudian kita masukan tipenya apa, untuk image kita dapat menggunakan ImageView kemudian masukan id nya kedalam constructor di findViewById
    untuk menampilkan gambar kita bisa gunakan setImageResource, misalnya saat ini kita akan memanggilnya dengan mengambilnya dari drawable tanpa di looping, sehingga hanya 1 photo, ini digunakan hanya untuk melihat hasilnya
    jika kita running maka dia akan tampil
    pada saat kita akan menggunakan setImageView kita dapat lihat tipe data pada argumen adalah Integer, maka untuk Adapternya kita gunakan integer
6. Buat layout adapter image dan kita cut ImageView yang ada di activity main(point no 1) dan kita ganti TextView nya menjadi ImageView, sekarang layout adapter image telah selesai
7. Sekarang buat adapter menjadi ImageAdapter yang di copas dari AdapterNumber
        view holdernya yang sebelumnya TextView diganti menjadi ImageView, dan variabelnya diganti val image
        onCreateViewHoldernya di set menjadi adapter_image
        onBindViewHolder nya kita bisa gunakan image sesuai dengan nama variable di ViewHolder dan gunakan setImageResource kita set sesuai denan constrractornya listImage menjadi listImage[position]
8. di MainActivity kita buat list yang kita ambil dari drawable
        Komen terlebih dahulu findViewById yang sebelumnya dibuat
        Selebihnya proses yang dilakaukan sama


bagian 5

Scroll Horizontal, Vertical, Membuat GRID

1. Error yang sangat umum pada bagian image adalah ketika kita tidak men-set datanya dengan layoutManager
2. Secara default layout manager memiliki nilai attribut vertical, sehingga seharusnya jika kita ingin listnya tampil vertical kita tidak perlu menambahkan attribut vertical
        namun apabila kita mau menampilkan viewnya secara horizontal, maka gunakan attribut orientation="Horizontal"
3. layoutManager dapat kita tulis di 2 tempat, di layout adapter_image nya atau langsung di MainActivity
        jika di MainActivity sebenarnya kita dapat memanggilnya dengan sederhana yaitu findViewById<RecyclerView>(R.id.recycleView).layoutManager = LinearLayoutManager(this), this disini mewakili class MainActivity
        atau jika kita ingin menggabungkannya maka kita bisa gunakan apply
        
        findViewById<RecyclerView>(R.id.recycleView).apply {
           layoutManager = LinearLayoutManager(this@MainActivity)     // ini untuk Linear
           layoutManager = GridLayoutManager(this@MainActivity, 2)    // ini untuk Grid
           adapter = imageAdapter
        }

Bagian 6

OnClick

1. Untuk melakukan listener atau aksi kita membutuhkan sebuah view untuk men-set listenernya
        untuk membuat listener tentunya kita butuh id di layout constraintnya, yang saat ini saya beri nama container
2. Kita pergi ke TextAdapter untuk menampilkan namanya, pada onBindViewHolder kita tambahkan setOnClickListener dan kurung kurawal, dimana ini adalah tempat aksi yang akan dilakukan
3. Karena kita menggunakan textview maka agar dia dapat diklik di luar tulisa yang sejajar dengan row, kita bisa set component Textview dengan menjadikan width menjadi match parent,
        atau kita sebenarnya dapat set dengan constraint dengan mengisi lengkap constraintStart dan constraintEnd menjadi parent
        kita coba lakukan log, jika di ketik, kita dapat melakukannya di TextAdapter pada fun onBindViewHolder di dalam setOnClickListener
4. Sekarang kita akan tambahkan id class recycleView di ViewHoldernya pada Class TextAdapter, id recycleView = container ini sudah mewakili seluruh recycleView dan layout adapter yang berkaitan
5. Sehingga sekarang kita bisa buat onClick pada container tersebut
        
