package com.example.lab2_ph30897

import java.util.Scanner

class Student(
    var name: String,
    var mssv: String,
    var diemTB: Float,
    var daTotNghiep: Boolean?,
    var tuoi: Int?
)

class StudentManager {
    public val students = mutableListOf<Student>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun updateStudent(index: Int, student: Student) {
        students[index] = student
    }

    fun deleteStudent(index: Int) {
        students.removeAt(index)
    }

    fun displayStudents() {
        if (students.isEmpty()) {
            println("Danh sách sinh viên trống.")
            return
        }
        println("Danh sách sinh viên:")
        students.forEachIndexed { index, student ->
            println("${index + 1}. Tên: ${student.name}, MSSV: ${student.mssv}, Điểm TB: ${student.diemTB}, Đã tốt nghiệp: ${student.daTotNghiep}, Tuổi: ${student.tuoi}")
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val studentManager = StudentManager()

    while (true) {
        println("\n----- MENU -----")
        println("1. Thêm sinh viên")
        println("2. Sửa thông tin sinh viên")
        println("3. Xóa sinh viên")
        println("4. Xem danh sách sinh viên")
        println("5. Thoát")
        print("Chọn chức năng: ")
        when (scanner.nextInt()) {
            1 -> {
                println("\n----- Thêm sinh viên -----")
                print("Nhập tên sinh viên: ")
                val name = readLine() ?: ""
                print("Nhập MSSV: ")
                val mssv = readLine() ?: ""
                print("Nhập điểm TB: ")
                val diemTB = scanner.nextFloat()
                print("Đã tốt nghiệp? (true/false): ")
                val daTotNghiep = scanner.nextBoolean()
                print("Nhập tuổi: ")
                val tuoi = scanner.nextInt()

                studentManager.addStudent(Student(name, mssv, diemTB, daTotNghiep, tuoi))
                println("Sinh viên đã được thêm vào danh sách.")
            }
            2 -> {
                println("\n----- Sửa thông tin sinh viên -----")
                print("Nhập vị trí sinh viên cần sửa: ")
                val index = scanner.nextInt() - 1
                if (index >= 0 && index < studentManager.students.size) {
                    print("Nhập tên sinh viên mới: ")
                    val name = readLine() ?: ""
                    print("Nhập MSSV mới: ")
                    val mssv = readLine() ?: ""
                    print("Nhập điểm TB mới: ")
                    val diemTB = scanner.nextFloat()
                    print("Đã tốt nghiệp mới? (true/false): ")
                    val daTotNghiep = scanner.nextBoolean()
                    print("Nhập tuổi mới: ")
                    val tuoi = scanner.nextInt()
                    studentManager.updateStudent(index, Student(name, mssv, diemTB, daTotNghiep, tuoi))
                    println("Thông tin sinh viên đã được cập nhật.")
                } else {
                    println("Vị trí không hợp lệ.")
                }
            }
            3 -> {
                println("\n----- Xóa sinh viên -----")
                print("Nhập vị trí sinh viên cần xóa: ")
                val index = scanner.nextInt() - 1
                if (index >= 0 && index < studentManager.students.size) {
                    studentManager.deleteStudent(index)
                    println("Sinh viên đã được xóa khỏi danh sách.")
                } else {
                    println("Vị trí không hợp lệ.")
                }
            }
            4 -> {
                println("\n----- Danh sách sinh viên -----")
                studentManager.displayStudents()
            }
            5 -> {
                println("Thoát chương trình.")
                return
            }
            else -> println("Chức năng không hợp lệ.")
        }
    }
}