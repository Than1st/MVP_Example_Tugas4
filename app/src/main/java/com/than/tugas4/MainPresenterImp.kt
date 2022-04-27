package com.than.tugas4

import android.text.TextUtils

class MainPresenterImp(private val view: MainView): MainPresenter {
    private val HASIL = mutableListOf<Hasil>()
    override fun tambahHasil(number1: String, number2: String) {
        if (TextUtils.isEmpty(number1) || TextUtils.isEmpty(number2)){
            view.showMessage("Field tidak boleh Kosong")
        } else {
            val jumlah = number1.toInt() + number2.toInt()
            HASIL.run {
                add(Hasil(jumlah))
            }
            view.showMessage("Hasil Perhitungan : $jumlah")
            view.clearField()
        }
    }

    override fun clearHasil() {
        if(HASIL.size != 0){
            HASIL.clear()
            view.showMessage("Berhasil Dihapus")
        } else {
            view.showMessage("Data Emang Kosong Goblog!!!")
        }
    }


    override fun loadHasil() {
        if(HASIL.size == 0){
            view.showMessage("Data Kosong")
        } else {
            var allData = ""

            for(i in 0 until HASIL.size){
                allData += "Hasil : " + HASIL[i].hasilHitung + "\n\n"
            }

            allData += "Total : " + HASIL.size

            view.showData(allData)
        }
    }
}