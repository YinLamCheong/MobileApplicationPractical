package com.example.recycleviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewexample.data.StudentDB
import com.example.recycleviewexample.data.StudentEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    //store list of student
    //val studentList = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn:Button = findViewById(R.id.btnAdd)

        btn.setOnClickListener(){
            val aStudent: StudentEntity = StudentEntity(0, "John","RSD")
            //val aStudent: Student = Student(R.drawable.ic_face, "John","RSD")

            val stdDAO = StudentDB.getDatabase(applicationContext).studentDAO()


            CoroutineScope(IO).launch{
                stdDAO.addStudent(aStudent)
            }



            /* //when use list
            studentList.add(aStudent)
            val recyclerView:RecyclerView = findViewById(R.id.rvStudent)

            //adapt the data into the recycleview
            recyclerView.adapter = MyAdapter(studentList)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)

             */
        }
    }
}