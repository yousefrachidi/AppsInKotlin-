package com.example.firstapp.Classes

class MyThread : Thread {

    var nameThread:String?= null

    constructor(nameThread:String):super(){
        this.nameThread = nameThread
    }

    override fun run() {
        super.run()

        var count :Int=0

        while (count<10){
            println(" ${this.nameThread} have count : $count")
            count++
        }
    }
}