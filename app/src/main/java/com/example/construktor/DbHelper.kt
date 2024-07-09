package com.example.construktor;

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.BufferedWriter
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStreamWriter


class DbHelper(val context : Context, val factory:SQLiteDatabase.CursorFactory?)
    : SQLiteOpenHelper(context, "app", factory, 1){

    override fun onCreate(db: SQLiteDatabase?) {
        val querySet = "CREATE TABLE sets (id INT primary key,  image TEXT, tittle TEXT, count INT, result TEXT)"
        val queryDetail = "CREATE TABLE detail (id INT primary key,  image TEXT, tittle TEXT, count INT)"
        db!!.execSQL(querySet)
        db.execSQL(queryDetail)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS sets")
        db.execSQL("DROP TABLE IF EXISTS detail")
        onCreate(db)
    }



    fun addSet(set: Set){
        val values = ContentValues()
        values.put("id", set.id)
        values.put("image", set.image)
        values.put("tittle", set.tittle)
        values.put("count", set.count)
        values.put("result", set.result)

        val db = this.writableDatabase
        db.insert("sets", null, values)

        db.close()

    }

    fun addDetail(detail: Detail){
        val values = ContentValues()
        values.put("id", detail.id)
        values.put("image", detail.image)
        values.put("tittle", detail.tittle)
        values.put("count", detail.count)

        val db = this.writableDatabase
        db.insert("detail", null, values)
        db.close()
    }

    fun getSets(): List<Set> {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM sets", null)
        val sets = mutableListOf<Set>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val image = cursor.getString(cursor.getColumnIndexOrThrow("image"))
                val tittle = cursor.getString(cursor.getColumnIndexOrThrow("tittle"))
                val count = cursor.getInt(cursor.getColumnIndexOrThrow("count"))
                val result = cursor.getString(cursor.getColumnIndexOrThrow("result"))

                sets.add(Set(id, image, tittle, count, result))
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return sets
    }

    fun updateSets(sets: List<Set>) {
        val db = this.writableDatabase
        for (set in sets) {
            val values = ContentValues()
            values.put("image", set.image)
            values.put("tittle", set.tittle)
            values.put("count", set.count)
            values.put("result", set.result)

            db.update("sets", values, "id = ?", arrayOf(set.id.toString()))
        }

        db.close()
    }

    fun deleteAndCreateNewDatabase() {
        val db = this.writableDatabase
        db.execSQL("DROP TABLE IF EXISTS sets")
        db.execSQL("DROP TABLE IF EXISTS detail")
        onCreate(db)
        db.close()
    }

    fun checkSetsCount(): Int {
        val db = this.readableDatabase
        val countQuery = "SELECT COUNT(*) FROM sets"
        val cursor = db.rawQuery(countQuery, null)

        if (cursor.moveToFirst()) {
            return cursor.getInt(0)
        }

        cursor.close()
        db.close()

        return 0
    }

    fun printDetailsWithCount() {
        val db = this.writableDatabase
        val query = "SELECT id, count FROM detail"
        val cursor = db.rawQuery(query, null)
        var set1 = 0
        var set2 = 0
        var set3 = 0

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val count =  cursor.getInt(cursor.getColumnIndexOrThrow("count"))
                println("ID: $id, Count: $count")
                if (id == 1 && count>= 6 || set1 > 0){
                    if(set1 == 0) set1 = 1
                    if (id == 2 && count>= 4 || set1 > 1){
                        if(set1 == 1) set1 = 2
                        if (id == 4 && count>= 10){
                            val setDb = Set(1, "set_1","Set_1", 1, "Хватает деталей")
                            val db = DbHelper(context, null)
                            db.addSet(setDb)
                        }
                    }
                }
                if (id == 2 && count>= 12 || set2 > 0){
                    if(set2 == 0) set2 = 1
                    if (id == 3 && count>= 4){
                        val setDb = Set(2, "set_2","Set_2", 1, "Хватает деталей")
                        val db = DbHelper(context, null)
                        db.addSet(setDb)
                    }
                }

                if (id == 1 && count>= 8 || set3 > 0){
                    if(set3 == 0) set3 = 1
                    if (id == 4 && count>= 12){
                        val setDb = Set(3, "set_3","Set_3", 1, "Хватает деталей")
                        val db = DbHelper(context, null)
                        db.addSet(setDb)
                    }
                }

            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
    }



}
