package com.example.recycleviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewexample.data.StudentDB
import com.example.recycleviewexample.data.StudentEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    //lateinit = assign data later
   // lateinit var RecList: Array<StudentEntity>
    lateinit var RecList: Array<StudentEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn:Button = findViewById(R.id.btnAdd)

        btn.setOnClickListener(){
            val aStudent: StudentEntity = StudentEntity(0, "John","RSD")
            //val aStudent: Student = Student(R.drawable.ic_face, "John","RSD")

            val stdDAO = StudentDB.getDatabase(applicationContext).studentDAO()

            //allow statement run in bg
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

        val btnGet:Button = findViewById(R.id.btnGet)
        btnGet.setOnClickListener(){
            //take from db
            val stdDAO = StudentDB.getDatabase(applicationContext).studentDAO()
            var studentList = ArrayList<Student>()

            //use main because relate to UI
            CoroutineScope(Main).launch {
                RecList = stdDAO.getAll()


                for (s in RecList) {
                    studentList.add(Student(R.drawable.ic_face, s.name, s.programme))
                }


                val recyclerView: RecyclerView = findViewById(R.id.rvStudent)

                //adapt the data into the recycleview
                recyclerView.adapter = MyAdapter(studentList)
                recyclerView.layoutManager = LinearLayoutManager(application)
                recyclerView.setHasFixedSize(true)
            }
        }
    }
}