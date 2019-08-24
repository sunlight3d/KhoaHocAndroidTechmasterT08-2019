package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testMultiThreads2()
    }
    fun testMultiThreads() {
        val objectA = ClassA()
        val objectB = ClassB()
        val objectC = ClassC()
        val objectD = ClassD()
        //relations
        objectA.objectD = objectD
        objectB.objectD = objectD
        objectC.objectD = objectD

        objectA.start()
        objectB.start()
        objectC.start()

    }
    fun testMultiThreads2() {
        var counter = 0
        var threadD = Thread(object: Runnable{
            override fun run() {
                Log.i(TAG, "\nStart D")
                for(i in 1..1000000) {
                    //print("$i,")
                }
                Log.i(TAG,"\nFinish D")
            }
        })
        var threadA = Thread(object: Runnable{
            override fun run() {
                Log.i(TAG, "\nStart A")
                for(i in 1..2000000) {
                    //print("$i,")
                }
                Log.i(TAG,"\nFinish A")
                counter++
                if(counter == 3) {
                    threadD.start()
                }
            }
        })
        var threadB = Thread(object: Runnable{
            override fun run() {
                Log.i(TAG, "\nStart B")
                for(i in 1..3000000) {
                    //print("$i,")
                }
                Log.i(TAG,"\nFinish B")
                counter++
                if(counter == 3) {
                    threadD.start()
                }
            }
        })

        var threadC = Thread(object: Runnable{
            override fun run() {
                Log.i(TAG, "\nStart C")
                for(i in 1..4000000) {
                    //print("$i,")
                }
                Log.i(TAG,"\nFinish C")
                counter++
                if(counter == 3) {
                    threadD.start()
                }
            }
        })

        threadA.start()
        threadB.start()
        threadC.start()

    }

}
