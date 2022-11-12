package com.example.firestoretest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val db= Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //레퍼런스 가져오기
        val md= db.collection("items").document("melon")
        val col =db.collection("items")

        col.addSnapshotListener { value, error ->
            for(d in value!!.documentChanges){
                println("${d.type}, ${d. document.id}, ${d.document.data["price"]}")
            }
        }

        //접근하기
        md.get().addOnSuccessListener {
           // println("######## ${it.id}, ${it["price"]}")
        }

        col.get().addOnSuccessListener {
            for(d in it) {
             //  println("-------${d.id}, ${d["price"]}")
            }
        }

        val itemMap =hashMapOf(
            "price" to 100
        )

        col.add(itemMap)

       // col.document("apple").set(itemMap)

        col.whereGreaterThan("price",50).get()
            .addOnSuccessListener {
                for(d in it) {
                   // println("QQQQQQQQQQq${d.id}, ${d["price"]}")
                }
            }

    }
}