package app.net.km.and.tdeeforals

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.round
import android.widget.ArrayAdapter as ArrayAdapter1


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spiSex = findViewById<Spinner>(R.id.spinnerSex)
        val spiFRS1 = findViewById<Spinner>(R.id.spinnerFR1)
        val spiFRS2 = findViewById<Spinner>(R.id.spinnerFR2)
        val spiFRS3 = findViewById<Spinner>(R.id.spinnerFR3)
        val spiFRS4 = findViewById<Spinner>(R.id.spinnerFR4)
        val spiFRS5 = findViewById<Spinner>(R.id.spinnerFR5)
        val spiFRS6 = findViewById<Spinner>(R.id.spinnerFR6)

        val adpSex = ArrayAdapter1.createFromResource(this, R.array.spiSexItems, R.layout.spinner_item)
        val adpFRS1 = ArrayAdapter1.createFromResource(this, R.array.spiFRS1Items, R.layout.spinner_item)
        val adpFRS2 = ArrayAdapter1.createFromResource(this, R.array.spiFRS2Items, R.layout.spinner_item)
        val adpFRS3 = ArrayAdapter1.createFromResource(this, R.array.spiFRS3Items, R.layout.spinner_item)
        val adpFRS4 = ArrayAdapter1.createFromResource(this, R.array.spiFRS4Items, R.layout.spinner_item)
        val adpFRS5 = ArrayAdapter1.createFromResource(this, R.array.spiFRS5Items, R.layout.spinner_item)
        val adpFRS6 = ArrayAdapter1.createFromResource(this, R.array.spiFRS6Items, R.layout.spinner_item)
        var intAge: Int?
        var dbBH: Double?
        var dbBW: Double?
        var intSumOfFRS = 24

        adpSex.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adpFRS1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adpFRS2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adpFRS3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adpFRS4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adpFRS5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adpFRS6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spiSex.adapter = adpSex
        spiFRS1.adapter = adpFRS1
        spiFRS2.adapter = adpFRS2
        spiFRS3.adapter = adpFRS3
        spiFRS4.adapter = adpFRS4
        spiFRS5.adapter = adpFRS5
        spiFRS6.adapter = adpFRS6

        // 0: M, 1: F
        val idxSex: Int = spiSex.getSelectedItemPosition()

        fun calcFRS (){
            // 選択されているアイテムのIndexを取得
            val idxSpinner = 24 - spiFRS1.getSelectedItemPosition() - spiFRS2.getSelectedItemPosition() - spiFRS3.getSelectedItemPosition() - spiFRS4.getSelectedItemPosition() - spiFRS5.getSelectedItemPosition() - spiFRS6.getSelectedItemPosition()
            val txtSumOfFRS = findViewById<TextView>(R.id.txtSumOfFRS)
            txtSumOfFRS.text = idxSpinner.toString()
            intSumOfFRS = idxSpinner
        }

        //スピナーのセレクトイベント設定
        //onItemSelectedの引数はNull対応が必要
        spiFRS1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //選択されたアイテムをテキストビューに設定
                calcFRS()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        spiFRS2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //選択されたアイテムをテキストビューに設定
                calcFRS()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        spiFRS3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //選択されたアイテムをテキストビューに設定
                calcFRS()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        spiFRS4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //選択されたアイテムをテキストビューに設定
                calcFRS()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        spiFRS5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //選択されたアイテムをテキストビューに設定
                calcFRS()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        spiFRS6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //選択されたアイテムをテキストビューに設定
                calcFRS()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

        fun popCalculation (dbBEE: Double, dbTDEE: Double) {

            val builder = AlertDialog.Builder(this)

            builder.setTitle("計算結果")
            builder.setMessage("BEE: " + round(dbBEE).toString() + "kcal\n" + "TDEE: " + round(dbTDEE).toString() + "kcal")
            builder.setPositiveButton("閉じる", null)
            val dialog: AlertDialog = builder.create()

            dialog.show()
            val textView = dialog.findViewById<View>(android.R.id.message) as TextView?
            textView!!.textSize = 20.0f

        }
        // メッセージテキストを変更する。
        // メッセージテキストを変更する。


        val etAge = findViewById<EditText>(R.id.etAge)
        val etBH = findViewById<EditText>(R.id.etBH)
        val etBW = findViewById<EditText>(R.id.etBW)

        etAge.setOnKeyListener {
                view, keyCode, _ -> handleKeyEvent(view, keyCode)
        }
        etBH.setOnKeyListener {
                view, keyCode, _ -> handleKeyEvent(view, keyCode)
        }
        etBW.setOnKeyListener {
                view, keyCode, _ -> handleKeyEvent(view, keyCode)
        }

        val btnCalc = findViewById<Button>(R.id.btnCalc)
        btnCalc.setOnClickListener {
            intAge = etAge.text.toString().toIntOrNull()
            dbBH = etBH.text.toString().toDoubleOrNull()
            dbBW = etBW.text.toString().toDoubleOrNull()

            if ((dbBW is Double) && (dbBH is Double) && (intAge is Int)) {
                if (idxSex != 0) {
                    //F
                    val dbBEE = 66.5 + (13.75 * dbBW!!) + (5.003 * dbBH!!) - (6.775 * intAge!!)
                    val dbTDEE = dbBEE + (55.96 * intSumOfFRS)
                    popCalculation(dbBEE, dbTDEE)
                } else {
                    //M
                    val dbBEE = 66.5 + (13.75 * dbBW!!) + (5.003 * dbBH!!) - (6.775 * intAge!!)
                    val dbTDEE = dbBEE + (55.96 * intSumOfFRS)
                    popCalculation(dbBEE, dbTDEE)
                }
            }



        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        // InputMethodManagerを取得
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        //背景のlinearLayoutを取得
        val linearLayout = findViewById<LinearLayout>(R.id.container)
        // キーボードを閉じる
        inputMethodManager.hideSoftInputFromWindow(
            linearLayout.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )

        return false
    }
    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }

}