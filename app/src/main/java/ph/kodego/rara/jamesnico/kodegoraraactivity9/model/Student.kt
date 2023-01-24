package ph.kodego.rara.jamesnico.kodegoraraactivity9.model

import ph.kodego.rara.jamesnico.kodegoraraactivity9.R

class Student (var firstName:String = "Unknown", var lastName:String = "Unknown", var img:Int){
    var id : Int = 0
    var yearStarted : Int = 0
    constructor(): this("","", R.drawable.placeholder) {}
}
