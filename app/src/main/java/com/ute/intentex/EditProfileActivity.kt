package com.ute.intentex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.intentex.databinding.ActivityEditProfileBinding
import com.ute.intentex.model.Student

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Nhận dữ liệu chuỗi (cung cấp chuỗi rỗng nếu bị null)
        val id = intent.getStringExtra("EXTRA_STUDENT_ID") ?: "Chưa có"
        val name = intent.getStringExtra("EXTRA_STUDENT_NAME") ?: ""

        // Nhận số thực (bắt buộc có defaultValue)
        val gpa = intent.getDoubleExtra("EXTRA_STUDENT_GPA", 0.0)

        // Nhận đối tượng Serializable (ép kiểu an toàn với as?)
        val student = intent.getSerializableExtra("EXTRA_STUDENT_OBJECT") as? Student

        // Hiển thị dữ liệu nhận được lên EditText
        binding.edtName.setText(name)
        binding.edtGpa.setText(gpa.toString())
    }
}