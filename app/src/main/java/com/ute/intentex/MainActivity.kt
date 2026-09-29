package com.ute.intentex

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.intentex.databinding.ActivityMainBinding
import com.ute.intentex.model.Student

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Khởi tạo một dữ liệu mẫu
    private val sampleStudent = Student("22505120005", "Nguyen Van An", 3.8)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEditProfile.setOnClickListener {
            // Khởi tạo Intent và gom nhóm đóng gói dữ liệu
            val intent = Intent(this, EditProfileActivity::class.java).apply {
                // Truyền kiểu nguyên thủy
                putExtra("EXTRA_STUDENT_ID", sampleStudent.id)
                putExtra("EXTRA_STUDENT_NAME", sampleStudent.name)
                putExtra("EXTRA_STUDENT_GPA", sampleStudent.gpa)
                putExtra("EXTRA_IS_ACTIVE", true)

                // Truyền toàn bộ đối tượng Serializable
                putExtra("EXTRA_STUDENT_OBJECT", sampleStudent)
            }
            // Kích hoạt chuyển màn hình
            startActivity(intent)
        }
    }
}