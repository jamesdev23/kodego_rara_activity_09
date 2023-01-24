package ph.kodego.rara.jamesnico.kodegoraraactivity9.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteException
import ph.kodego.rara.jamesnico.kodegoraraactivity9.model.Login
import ph.kodego.rara.jamesnico.kodegoraraactivity9.model.Student

interface LoginDAO {
    fun addLogin(login: Login)
}

class LoginDAOSQLImpl(var context: Context): LoginDAO{
    override fun addLogin(login: Login) {
        val databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(DatabaseHandler.loginUsername, login.username)
        contentValues.put(DatabaseHandler.loginPassword, login.password)

        val success = db.insert(DatabaseHandler.tableLogin,null,contentValues)
        db.close()
    }
}