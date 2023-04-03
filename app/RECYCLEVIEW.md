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