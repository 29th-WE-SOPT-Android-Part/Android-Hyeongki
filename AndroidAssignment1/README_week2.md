# ๐ขLEVEL 1

<img src="https://user-images.githubusercontent.com/37872134/138349204-03c0394c-1059-4ce2-8afe-e3a9c690cba3.gif"  width="270" height="570"/>



## ๐ฆPairData

```kotlin
class PairData (
    val name: String,
    val introduction: String
)
```

- ๋ ๊ฐ์ String ๊ฐ์ ๊ฐ์ง๋ ๋ฐ์ดํฐ ํด๋์ค์ด๋ค.
- ํ๋ก์ ๋ชฉ๋ก๊ณผ ๋ ํฌ์งํ ๋ฆฌ ๋ชฉ๋ก ๋ชจ๋ ์ด๋ฆ-์ค๋ช์ ํํ์ด๊ธฐ ๋๋ฌธ์ ๊ฐ์ ๋ฐ์ดํฐ ํด๋์ค๋ฅผ ์ฌ์ฉํ๋๋ก ํ์๋ค.



## ๐ฆFollowerFragment

- ํ๋ก์ ๋ชฉ๋ก์ ๋ณด์ฌ์ฃผ๋ ํ๋๊ทธ๋จผํธ๋ก, HomeActivity ํ๋ฉด์ ์ผ๋ถ๋ฅผ ๊ตฌ์ฑํ๋ค.
- ๋ฆฌ์ฌ์ดํด๋ทฐ๋ฅผ ์ด์ฉํด ์ฌ๋ฌ ํ๋ก์์ ๋ฆฌ์คํธ๋ฅผ ๋ณด์ฌ์ค๋ค.



### item_list_follower.xml ๋ ์ด์์

---

- ##### ๋ฆฌ์ฌ์ดํด ๋  ๋์์ธ ํ๋ก์ ํ ๋ช์ ํ์ํ๋ ๋ทฐ

  ```xml
      <TextView
          android:id="@+id/tv_repository_name"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:ems="6"
          android:textColor="#000000"
          android:textAlignment="center"
          android:textSize="14sp"
          android:textStyle="bold"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toTopOf="parent"
          tools:text="๋ ํฌ์งํ ๋ฆฌ ์ด๋ฆ" />
  
      <TextView
          android:id="@+id/tv_repository_introduction"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_marginTop="10dp"
          android:ellipsize="end"
          android:ems="8"
          android:maxLines="1"
          android:textAlignment="center"
          android:textColor="#000000"
          android:textSize="12sp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/tv_repository_name"
          tools:text="์ผ์ด์ผ์ฌ์ค์ก์น ํ๊ตฌ์ญ์์ผ์ด์ผ์ฌ" />
  ```

  - ๋ทฐ์ background๋ drawable์ ์ ์ํ ๋ฅ๊ทผ ๋ชจ์๋ฆฌ ์ง์ฌ๊ฐํ ์คํ์ผ์ ์ฌ์ฉํ์๋ค.



### fragment_follower.xml ๋ ์ด์์

---

- ##### ํ๋ก์ ๋ฆฌ์คํธ๋ฅผ ๋ด์ ๋ฆฌ์ฌ์ดํด๋ทฐ

  ```xml
      <androidx.recyclerview.widget.RecyclerView
          android:id="@+id/rv_follower"
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:padding="10dp"
          app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
          tools:itemCount="3"
          tools:listitem="@layout/item_list_follower"/>
  ```

  - LinearLayoutManager๋ก ์ค์ ํ์ฌ ํ๋ก์ ๋ฆฌ์คํธ๋ฅผ ์์ง์ผ๋ก ๋ณด์ด๋๋ก ํ์๋ค.
  - ๊ฐ ํ๋ก์ ์ ๋ณด๋ฅผ listitem์ ์ค์ ํ์ฌ item_list_follower์ ๋ ์ด์์์ผ๋ก ๋ณด์ด๋๋ก ํ์๋ค.



### FollowerFragment.kt ์ฝ๋

---

- ##### ํ๋๊ทธ๋จผํธ ๋ทฐ๋ฐ์ธ๋ฉ ๋ณ์

  ```kotlin
      private var _binding: FragmentFollowerBinding? = null
      private val binding get() = _binding!!
  ```

  - _binding์ nullable ๋ณ์๋ก ์ ์ธํ๊ณ , null๋ก ์ด๊ธฐํํ์๋ค.
  - binding์ Not null๋ก ๋จ์ธํ์๋ค.

- ##### onCreateView(LayoutInflater, ViewGroup?, Bundle?)

  ```kotlin
      override fun onCreateView(
          inflater: LayoutInflater, container: ViewGroup?,
          savedInstanceState: Bundle?
      ): View? {
          _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)
  
          initAdapter()
  
          return binding.root
      }
  ```

  - layoutInflater๋ฅผ ์ด์ฉํด ํ๋๊ทธ๋จผํธ์ view ๊ฐ์ฒด๋ฅผ ๋ง๋ค๊ณ , ๋ทฐ ๋ฐ์ธ๋ฉ์ ํ๋ค.
  - ๋ทฐ ์ด๋ํฐ ๊ฐ์ฒด๋ฅผ ์์ฑํ๊ณ , ๋ฐ์ธ๋ฉ์ ํตํด ์ด๋ํฐ๋ฅผ ์ ์ฉํ๋ ๋ฉ์๋์ธ initAdapter()๋ฅผ ํธ์ถํ๋ค. (์๋ ๊ธฐ์ ๋์ด ์๋ค.)

- ##### initAdapter()

  ```kotlin
      private fun initAdapter(){
          followerViewAdapter = FollowerViewAdapter()
  
          binding.rvFollower.adapter = followerViewAdapter
  
          followerViewAdapter.datalist.addAll(
              listOf(
                  PairData("๊นํ๊ธฐ", "YB 29๊ธฐ ๊นํ๊ธฐ"),
                  PairData("๊ณ ํ๋ฆฐ", "์ฝํ๋ฆฐ์ ๋ฌ์ธ"),
                  PairData("๊น์๋ฐ", "์๋ฐ๋ ๋ด ์ธ์"),
                  PairData("์ด์๋", "์๋๋ก์ด๋ ์ต๊ณ "),
                  PairData("๋ฐ์๊ณ ", "์๊ณ ๋ฆฌ์ฆ ๋ง์คํฐ")
              )
          )
          followerViewAdapter.notifyDataSetChanged()
      }
  ```

  - ๋ทฐ์ด๋ํฐ๋ฅผ ์์ํ FollowerViewAdapter ๊ฐ์ฒด๋ฅผ ์์ฑํ๋ค.
  - ๋ฐ์ธ๋ฉ์ ํตํด ๋ฆฌ์ฌ์ดํด๋ทฐ์ ์ด๋ํฐ๋ฅผ ์ฐ๊ฒฐํ๋ค.
  - ๋ทฐ์ด๋ํฐ์ ๋ฐ์ดํฐ๋ฅผ ์ถ๊ฐ์ํจ ํ ๋ฐ์ดํฐ๊ฐ ๋ณ๊ฒฝ๋์์์ ์๋ฆฐ๋ค.

- ##### onDestroyView()

  ```kotlin
      override fun onDestroyView() {
          super.onDestroyView()
          _binding = null
      }
  ```

  - ๋ฐ์ธ๋ฉ์ ํด์ ์์ผ์ ๋ฉ๋ชจ๋ฆฌ ๋์๋ฅผ ๋ฐฉ์งํ๋ค.



### FollowerViewAdapter.kt ์ฝ๋

โ	Adapter\<ViewHolder\>๋ฅผ ์์ํ์ฌ ๋ฆฌ์ฌ์ดํด๋ทฐ์ ๋ฐ์ดํฐ๋ฅผ ์ฐ๊ฒฐํ์ฌ ๋ฆฌ์คํธ๋ฅผ ๋ง๋ค ์ ์๋๋ก ํ๋ค.

---

- ##### onCreateViewHolder(ViewGroup, Int)

  ```kotlin
      override fun onCreateViewHolder(
          parent: ViewGroup,
          viewType: Int
      ): RepositoryViewAdapter.RepositoryViewHolder {
          var binding = ItemListRepositoryBinding.inflate(
              LayoutInflater.from(parent.context), parent, false)
          return RepositoryViewHolder(binding)
      }
  ```

- ##### onBindViewHolder(ViewHolder, Int)

  ```kotlin
      override fun onBindViewHolder(
          holder: RepositoryViewAdapter.RepositoryViewHolder,
          position: Int
      ) {
          holder.onBind(dataList[position])
      }
  ```

- ##### getItemCount()

  ```kotlin
  	override fun getItemCount(): Int = dataList.size
  ```

- ##### nested class : RepositoryViewHolder

  ```kotlin
      class RepositoryViewHolder(private val binding: ItemListRepositoryBinding): RecyclerView.ViewHolder(binding.root){
          fun onBind(data: PairData){
              binding.tvRepositoryName.text = data.name
              binding.tvRepositoryIntroduction.text = data.introduction
          }
      }
  ```

  - ์์ฑ์์์ ๋ฐ์ธ๋ฉ ๊ฐ์ฒด๋ฅผ ๋ฐ์์ ๋ถ๋ชจ ํด๋์ค์ธ ๋ทฐ ํ๋๋ฅผ ๋ง๋ค์ด๋ธ๋ค. onBind ๋ฉ์๋๊ฐ ํธ์ถ๋๋ฉด ์ ๋ฌ๋ ๋ฐ์ดํฐ๋ฅผ ๋ฐ์ธ๋ฉ์ ๊ฒฐํฉ์ํจ๋ค.



### fragment_follower.xml ๋ ์ด์์

---

- ##### ํ๋ก์ ๋ฆฌ์คํธ๋ฅผ ๋ด์ ๋ฆฌ์ฌ์ดํด๋ทฐ

  ```xml
      <androidx.recyclerview.widget.RecyclerView
          android:id="@+id/rv_follower"
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:padding="10dp"
          app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
          tools:itemCount="3"
          tools:listitem="@layout/item_list_follower"/>
  ```

  - LinearLayoutManager๋ก ์ค์ ํ์ฌ ํ๋ก์ ๋ฆฌ์คํธ๋ฅผ ์์ง์ผ๋ก ๋ณด์ด๋๋ก ํ์๋ค.
  - ๊ฐ ํ๋ก์ ์ ๋ณด๋ฅผ listitem์ ์ค์ ํ์ฌ item_list_follower์ ๋ ์ด์์์ผ๋ก ๋ณด์ด๋๋ก ํ์๋ค.





### fragment_follower.xml ๋ ์ด์์

---

- ##### ํ๋ก์ ๋ฆฌ์คํธ๋ฅผ ๋ด์ ๋ฆฌ์ฌ์ดํด๋ทฐ

  ```xml
      <androidx.recyclerview.widget.RecyclerView
          android:id="@+id/rv_follower"
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:padding="10dp"
          app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
          tools:itemCount="3"
          tools:listitem="@layout/item_list_follower"/>
  ```

  - LinearLayoutManager๋ก ์ค์ ํ์ฌ ํ๋ก์ ๋ฆฌ์คํธ๋ฅผ ์์ง์ผ๋ก ๋ณด์ด๋๋ก ํ์๋ค.
  - ๊ฐ ํ๋ก์ ์ ๋ณด๋ฅผ listitem์ ์ค์ ํ์ฌ item_list_follower์ ๋ ์ด์์์ผ๋ก ๋ณด์ด๋๋ก ํ์๋ค.



## ๐ฆRepositoryFragment

- ๋ ํฌ์งํ ๋ฆฌ ๋ชฉ๋ก์ ๋ณด์ฌ์ฃผ๋ ํ๋๊ทธ๋จผํธ๋ก, ๋ฆฌ์ฌ์ดํด๋ทฐ๋ก ๊ตฌ์ฑ๋์ด ์๋ค.

- ํ๋ก์ ํ๋๊ทธ๋จผํธ์ ๊ตฌ์ฑ์ด ์ ์ฌํ๋ฉฐ, Grid ๋ ์ด์์์ด๋ผ๋ ์ฐจ์ด์ ์ด ์๋ค.

  

### fragment_repository.xml ๋ ์ด์์

---

- ##### ๋ ํฌ์งํ ๋ฆฌ๋ฅผ ๋ด๋ ๋ฆฌ์ฌ์ดํด ๋ทฐ

  ```xml
      <androidx.recyclerview.widget.RecyclerView
          android:id="@+id/rv_repository"
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:paddingVertical="10dp"
          app:layoutManager="androidx.recyclerview.widget.GridLayoutManager"
          app:spanCount="2"
          android:orientation="vertical"
          tools:listitem="@layout/item_list_repository"
          tools:itemCount="6"/>
  ```

  - ํ๋ก์ ๋ชฉ๋ก๊ณผ๋ ๋ค๋ฅด๊ฒ GridLayout์ผ๋ก ์ค์ ๋์ด ์๋ค.
  - spanCount๋ฅผ 2๋ก ์ค์ ํ์ฌ ํ ์ค์ 2๊ฐ์ ๋ฆฌ์คํธ๋ฅผ ํ์ํ๋ค.



### item_list_repository.xml ๋ ์ด์์

---

- ##### ๋ ํฌ์งํ ๋ฆฌ ์ค๋ช ํ์คํธ์ ๊ธธ์ด๊ฐ ์ผ์  ์ด์ ๋์ด๊ฐ๋ฉด ์๋ต ํ์(...)์ ํ๋๋ก ellipsize ์ต์์ ์ค์ ํ์๋ค.

  ```xml
      <TextView
          android:id="@+id/tv_repository_introduction"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_marginTop="10dp"
          android:ellipsize="end"
          android:ems="8"
          android:maxLines="1"
                ...
  ```

  



## ๐ฆHomeActivity

- ๋ก๊ทธ์ธ ๋์์ ์ฌ์ง, ๊ฐ๋จํ ์ ๋ณด์ ํจ๊ป ํ๋ก์, ๋ ํฌ์งํ ๋ฆฌ ๋ชฉ๋ก์ ๋ณด์ฌ์ฃผ๋ ์กํฐ๋นํฐ์ด๋ค.

### activity_home.xml ๋ ์ด์์

---

- ##### Fragment๋ฅผ ๋ด์ ์ปจํ์ด๋ ๋ทฐ

  ```xml
      <androidx.fragment.app.FragmentContainerView
          android:id="@+id/home_fragment_container"
          android:layout_width="match_parent"
          android:layout_height="0dp"
          app:layout_constraintBottom_toBottomOf="parent"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/btn_follower"
          android:layout_marginTop="10dp" />
  ```

  - ํ๋ก์ ํ๋๊ทธ๋จผํธ์ ๋ ํฌ์งํ ๋ฆฌ ํ๋๊ทธ๋จผํธ ๋ทฐ๊ฐ ๋ณด์ฌ์ง ์ปจํ์ด๋์ด๋ค.

  

- ##### ํ๋๊ทธ๋จผํธ ๊ต์ฒด ๋ฒํผ

  ```xml
      <Button
          android:id="@+id/btn_follower"
          android:layout_width="135dp"
          android:layout_height="55dp"
          android:layout_marginLeft="45dp"
          android:layout_marginTop="10dp"
          android:background="@drawable/button_radius"
          android:paddingVertical="10dp"
          android:text="ํ๋ก์\n๋ชฉ๋ก"
          android:textColor="#FFFFFF"
          android:textStyle="bold"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/tv_introduce" />
  
      <Button
          android:id="@+id/btn_repository"
          android:layout_width="135dp"
          android:layout_height="55dp"
          android:layout_marginTop="10dp"
          android:layout_marginRight="45dp"
          android:background="@drawable/button_radius_orange"
          android:text="๋ ํฌ์งํ ๋ฆฌ\n๋ชฉ๋ก"
          android:textColor="#FFFFFF"
          android:textStyle="bold"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/tv_introduce" />
  ```

  - ๊ฐ๊ฐ ํ๋ก์ ํ๋๊ทธ๋จผํธ์ ๋ ํฌ์งํ ๋ฆฌ ํ๋๊ทธ๋จผํธ๋ก ๊ต์ฒด์ํฌ ๋ฒํผ์ด๋ค.
  - background ์คํ์ผ์ ๋ฅ๊ทผ ๋ชจ์๋ฆฌ๋ฅผ ๊ฐ์ง ์ฌ๊ฐํ์ผ๋ก, drawable์ ์ ์ํ์๋ค.



### HomeActivity.kt ์ฝ๋

---

- ##### ํ๋๊ทธ๋จผํธ ํธ๋์ญ์ ์ด๊ธฐํ

  ```kotlin
      private fun initFragmentTransactionEvent(){
          val fragment1 = FollowerFragment()
          val fragment2 = RepositoryFragment()
  
          supportFragmentManager.beginTransaction().add(R.id.home_fragment_container, fragment1).commit()
  
          binding.btnFollower.setOnClickListener {
              supportFragmentManager.beginTransaction().replace(R.id.home_fragment_container, fragment1).commit()
          }
          binding.btnRepository.setOnClickListener{
              supportFragmentManager.beginTransaction().replace(R.id.home_fragment_container, fragment2).commit()
          }
      }
  ```

  - supportFragmentManager์ beginTransaction() ๋ฉ์๋๋ฅผ ํตํด ํธ๋์ญ์์ ์์ํ๋ค.
  - fragment1๋ฅผ ํธ๋์ญ์์ ์ถ๊ฐํ๊ณ  commitํ์ฌ FollowerFragment๋ฅผ ๋ ์ด์์์์ ์ ์ํ ํ๋๊ทธ๋จผํธ ์ปจํ์ด๋ ๋ทฐ์ ๋ฃ๋๋ค.
  - ๊ฐ ๋ฒํผ์ onClickListener๋ฅผ ์ค์ ํ์ฌ ํด๋ฆญํ๋ฉด ๋ฒํผ์ ํด๋นํ๋ ํ๋๊ทธ๋จผํธ๋ก ๊ต์ฒดํ๋ ํธ๋์ญ์์ ์์ฑํ๊ณ , ์ปค๋ฐํ๊ฒ ๋ง๋ ๋ค.





## ๐ขLEVEL 2



### ๐ฆDetailActivity์์ ์์ธ ์ค๋ช

---

- ##### ์์ดํ์ ๋ฆฌ์ค๋ ์ถ๊ฐ

  ```kotlin
  			binding.itemFollower.setOnClickListener { v:View ->
                  val intent = Intent(v.context, DetailActivity::class.java)
                  intent.putExtra("name", data.name)
                  v.context.startActivity(intent)
              }
  ```

  FollowerViewHolder ํด๋์ค์์ ๊ฐ ์์ดํ๋ค์ onClickListener๋ฅผ ์ถ๊ฐํ๋ค.

  intent๋ฅผ ์์ฑํ๊ณ , ์์ดํ์ด ๊ฐ์ง ์ด๋ฆ์ DetailActivity๋ก ์ ๋ฌํ๋ค.



- ##### DetailActivity.kt์์ ์ธํํธ๋ฅผ ๋ฐ์ ์ฒ๋ฆฌํ๊ธฐ

  ```kotlin
      private fun initMatchName(){
          name = intent.getStringExtra("name").toString()
  
          binding.tvDetailName.text = name
  
          when(name){
              "๊นํ๊ธฐ"-> setDetail(R.drawable.profile_image, R.string.detail_khk)
              "๊ณ ํ๋ฆฐ"-> setDetail(R.drawable.img_kotlin, R.string.detail_kot)
              "๊น์๋ฐ"-> setDetail(R.drawable.img_java, R.string.detail_jav)
              "์ด์๋"-> setDetail(R.drawable.img_android, R.string.detail_and)
              "๋ฐ์๊ณ "-> setDetail(R.drawable.img_algorithm, R.string.detail_alg)
          }
      }
      
      private fun setDetail(img_src: Int, detail_text: Int){
          binding.ivProfile.setImageResource(img_src)
          binding.tvDetailContent.text = getString(detail_text)
      }
  ```

  ๋ทฐํ๋ ํด๋์ค๊ฐ ์ธํํธ๋ก ์ ๋ฌํ ์ด๋ฆ์ ๋ฐ์์ ์์ธ ์ค๋ช์ ํ์ํ ์ ๋ณด๋ก ๋ณํํ๋ค.

  ์ค๋ช ํ์คํธ๋ string์ ์ ์ฅ๋์ด ์๋ค.



### ๐ฆItemDecoration์ผ๋ก ๊ตฌ๋ถ์  ๋ง๋ค๊ธฐ

---

- ##### CustomDecoration ํด๋์ค ๋ง๋ค๊ธฐ

  ```kotlin
  class CustomDecoration(
      private val height: Float,
      private val padding: Float,
      @ColorInt
      private val color: Int
  ):RecyclerView.ItemDecoration() {
      private val paint = Paint()
  
      init{
          paint.color = color
      }
  
      override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
          val left = parent.paddingStart + padding
          val right = parent.width - parent.paddingEnd - padding
  
          for(i in 0 until parent.childCount){
              val child = parent.getChildAt(i)
              val params = child.layoutParams as RecyclerView.LayoutParams
  
              val top = (child.bottom + params.bottomMargin).toFloat()
              val bottom = top+height
  
              c.drawRect(left, top, right, bottom, paint)
          }
      }
  }
  ```

  

- ##### ๋ฐ์ธ๋ฉ์ ํตํด ๋ฆฌ์ฌ์ดํด๋ทฐ์ ์ ์ฉ์ํค๊ธฐ

  ```kotlin
          val decoration = CustomDecoration(1.0f, 0.5f, rgb(246,88,166))
          binding.rvFollower.addItemDecoration(decoration)
  ```

  

### ๐ฆ์์ดํ ์ด๋/์ญ์ 

---

- ##### ItemTouchHelperListener ์ธํฐํ์ด์ค

  ```kotlin
  interface ItemTouchHelperListener {
      fun onItemMove(from_position: Int, to_position: Int):Boolean
      fun onItemSwipe(position: Int)
  }
  ```

- ##### ItemTouchHelperCallback ํด๋์ค

  ```kotlin
  class ItemTouchHelperCallback(val listener: ItemTouchHelperListener): ItemTouchHelper.Callback() {
      override fun getMovementFlags(
          recyclerView: RecyclerView,
          viewHolder: RecyclerView.ViewHolder
      ): Int {
          val drag_flags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
          val swipe_falgs = ItemTouchHelper.START or ItemTouchHelper.END
          return makeMovementFlags(drag_flags, swipe_falgs)
      }
  
      override fun isLongPressDragEnabled(): Boolean {
          return true
      }
  
      override fun onMove(
          recyclerView: RecyclerView,
          viewHolder: RecyclerView.ViewHolder,
          target: RecyclerView.ViewHolder
      ): Boolean {
          return listener.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
      }
  
      override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
          listener.onItemSwipe(viewHolder.adapterPosition)
      }
  }
  ```

  - ItemTouchHelper.Callback์ ์์๋ฐ์ ๊ตฌํํ๋ค.
  - isLongPressEnabled๋ฅผ ํญ์ true๋ฅผ ๋ฐํํ๋๋ก ๊ตฌํํ์ฌ ๋๋๊ทธ๋ฅผ ํ  ์ ์๋๋ก ํ๋ค.
  - onMove๋ onSwiped์ ๊ฒฝ์ฐ ํ๋กํผํฐ์ ์์ ์ธํฐํ์ด์ค๋ฅผ ๊ตฌํํ ๋ฆฌ์ค๋๊ฐ ์ฒ๋ฆฌํ๋ค.

- ##### FollowerViewAdapter์์ ItemTouchHelperListener ์ธํฐํ์ด์ค ๊ตฌํํ๊ธฐ

  ```kotlin
  class FollowerViewAdapter: RecyclerView.Adapter<FollowerViewAdapter.FollowerViewHolder>(), ItemTouchHelperListener {
  ...
      override fun onItemMove(from_position: Int, to_position: Int): Boolean {
          val item = datalist[from_position]
          datalist.removeAt(from_position)
          datalist.add(to_position, item)
  
          notifyDataSetChanged()
          return true
      }
  
      override fun onItemSwipe(position: Int) {
          datalist.removeAt(position)
          notifyItemRemoved(position)
      }
  }
  ```

  ItemTouchHelperListener๊ฐ ๊ตฌํํด์ผํ๋ ๋ฉ์๋์ธ onItemMove์ onItemSwipe๋ฅผ ๊ตฌํํ๋ค.

  move์ ๊ฒฝ์ฐ ๋ฐ์ดํฐ๋ฅผ ์ญ์ ํ๊ณ  ์ด๋ํ  ์์น์ ์๋ก ์ถ๊ฐํ๋ค.

- ##### RecyclerView์ Helper ๋ถ์ด๊ธฐ

  ```kotlin
  ItemTouchHelper(ItemTouchHelperCallback(followerViewAdapter)).attachToRecyclerView(binding.rvFollower)
  ```

  - FollowerFragment์์ RecyclerView์ ์๋ก ์์ฑํ Helper ๊ฐ์ฒด๋ฅผ ๋ถ์ธ๋ค.



[์ฐธ๊ณ  : RecyclerView, ItemTouchHelper](https://everyshare.tistory.com/27)



## ๐ขLEVEL 3

- #### notifyDataSetChanged์ ๋ฌธ์ ์ 

  notifyDataSetChanged๋ ํ๋ฉด์ ๋ณด์ด๋ ์ ์ฒด ๋ฆฌ์คํธ๋ฅผ ๊ฐฑ์ ํ๊ธฐ ๋๋ฌธ์ ๋นํจ์จ์ ์ด๋ค.

  ๋จ์ํ ํจ์จ์ด ๋จ์ด์ง๋ ๊ฒ๋ฟ๋ง ์๋๋ผ ์์ดํ์ ์ด๋ํ๋ ๊ฒ์ ๊ตฌํํ์ ๋ ์์ฐ์ค๋ฝ๊ฒ ๊ต์ฒด๋๋ ๊ฒ์ด ์๋๋ผ

  ์๋ก์ด ํ๋ฉด์ด ๊ตฌ์ฑ๋๋ ๊ฒ์ด ๋ณด์ด๊ฒ ๋๋ค. (์กํฐ๋นํฐ๊ฐ ์ ํ๋๋ ๊ฒ์ฒ๋ผ)

  ๋ฐ๋ผ์, ์์ดํ์ swipeํ  ๋๋ notifyItemRemoved(position)์ ์ฌ์ฉํ๊ณ 

  ์์ดํ์ ์ด๋ํ  ๋๋ notifyItemMoved(from_position, to_position)์ ์ฌ์ฉํ๋ฉด ํด๊ฒฐ์ด ๋๋ค.

  

  ๋ํ, headerview๋ฅผ ์ฌ์ฉํ๋ฉด์ notifyDataSetChanged๋ฅผ ํธ์ถํ๋ฉด ํฌ์ปค์ค๊ฐ ์ฌ๋ผ์ง๋ ๋ฌธ์ ๊ฐ ์๋ค๊ณ  ํ๋๋ฐ, ์ด๋ onBindViewHolder์์ 0๋ฒ ์์ดํ์ผ ๋ ํฌ์ปค์ค๋ฅผ ์ค ๋ทฐ์ requestFocus๋ฅผ ํธ์ถํ์ฌ ํด๊ฒฐํ  ์ ์๋ค๊ณ  ํ๋ค.





## ๐ข๊ณผ์ ๋ฅผ ํตํด ์ฑ์ฅํ ๋ด์ฉ

1. FragmentManager๋ฅผ ์ด์ฉํด ํธ๋์ญ์์ ์์ฑํ๊ณ  ์ปค๋ฐํ์ฌ ํ๋๊ทธ๋จผํธ๋ฅผ ์ถ๊ฐ/๊ต์ฒด
2. Fragment์์์ ๋ทฐ ๋ฐ์ธ๋ฉ
3. Intent๋ฅผ ์ฌ์ฉํด Fragment์์ Activity ์ด๋ ๋ฐ ๋ฐ์ดํฐ ์ ๋ฌ
4. Data Class๋ฅผ ์ด์ฉํด ๋ฆฌ์คํธ๋ฅผ ๊ตฌ์ฑํ๋ ๋ฐ์ดํฐ ๋ง๋ค๊ธฐ
5. RecyclerView๋ฅผ ์ฌ์ฉํด ํ๋์ ์์ดํ ๋ ์ด์์์ ๋ฐ๋ณตํด์ ์ฌ์ฉ
6. ItemDecoration์ ์์ํ์ฌ CustomDecoration์ ๋ง๋ค๊ณ , RecyclerView์ ์ ์ฉํ๊ธฐ
7. ItemTouchHelper๋ฅผ ์ด์ฉํ ๋ฆฌ์คํธ ์์ดํ ์ญ์ ์ ์ด๋



