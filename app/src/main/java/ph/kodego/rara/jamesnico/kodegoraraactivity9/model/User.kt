package ph.kodego.rara.jamesnico.kodegoraraactivity9.model

class User (var username:String = "Unknown", var password:String = "Unknown") {
    var id:Int = 0
    var email:String = ""
    var confirmPassword:String = ""
    var loginStatus:String = ""
    constructor(): this("","") {}
}