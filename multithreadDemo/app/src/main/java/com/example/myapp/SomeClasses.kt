package com.example.myapp

import android.util.Log
val TAG = "multithread"
public class ClassA: Thread(), Runnable {
    lateinit var objectD: ClassD
    override fun run() {
        super.run()
        Log.i(TAG, "\nStart A")
        for(i in 1..1000000) {
            //print("$i,")
        }
        Log.i(TAG,"\nFinish A")
        objectD.finishTask(this)

    }
}
public class ClassB: Thread(), Runnable {
    lateinit var objectD: ClassD
    override fun run() {
        super.run()
        Log.i(TAG,"\nStart B")
        for(i in 1..2000000) {
            //print("$i,")
        }
        Log.i(TAG,"\nFinish B")
        objectD.finishTask(this)
    }
}
public class ClassC: Thread(), Runnable {
    lateinit var objectD: ClassD
    override fun run() {
        super.run()
        Log.i(TAG,"\nStart C")
        for(i in 1..1500000) {
            //print("$i,")
        }
        println("\nFinish C")
        objectD.finishTask(this)
    }
}
public class ClassD: Thread(), Runnable {
    var myEmployees:ArrayList<Any> = ArrayList()
    override fun run() {
        super.run()
        Log.i(TAG,"\nStart D")
        for(i in 1..3000000) {
            //print("$i,")
        }
        Log.i(TAG,"\nFinish D")
        //clear
        myEmployees.clear()
    }
    fun finishTask(objectX: Any) {
        if(objectX is ClassA || objectX is ClassB || objectX is ClassC) {
            myEmployees.add(objectX)
            if(myEmployees.size == 3) {
                this.start()
            }
        }

    }
}