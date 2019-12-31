package com.example.investmentschemeeligibilitycalculator

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dob.setOnClickListener(){
            val c:Calendar = Calendar.getInstance();
            val currentDay = c.get(Calendar.DAY_OF_MONTH);
            val currentMonth = c.get(Calendar.MONTH);
            val currentYear = c.get(Calendar.YEAR);

            val datePick = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, day -> dob.setText(day.toString() + "/" + (month + 1).toString() + "/" + year.toString())
                    val myAge = currentYear - year
                    val min = getSaving(myAge)
                    val invest = min * 0.30
                    age.setText(myAge.toString())
                    salary.setText("RM " + min.toString())
                    allowance.setText("RM " + invest.toString())
                },currentYear,currentMonth,currentDay)
            datePick.show()
        }
    }

    fun getSaving(age:Int):Double{
        val saving:Double
        when(age){
            in 16..20->return (5000.0)
            in 21..25->return (14000.0)
            in 26..30->return (29000.0)
            in 31..35->return (50000.0)
            in 36..40->return (78000.0)
            in 41..45->return (116000.0)
            in 46..50->return (165000.0)
            in 51..55->return (228000.0)
            else ->return (0.0)
        }
    }
}
