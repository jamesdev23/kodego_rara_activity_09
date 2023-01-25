package ph.kodego.rara.jamesnico.kodegoraraactivity9.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteException
import ph.kodego.rara.jamesnico.kodegoraraactivity9.model.User

interface UserDAO {
    fun addUser(user: User)
    
    fun getUser() : ArrayList<User>
    fun updateUser(user: User,emailAddress: String)
    fun checkUser(username: String) : Boolean
    fun checkPass(password: String) : Boolean



}

class UserDAOSQLImpl(var context: Context): UserDAO{
    override fun addUser(user: User) {
        val databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(DatabaseHandler.userUsername, user.username)
        contentValues.put(DatabaseHandler.userPassword, user.password)
        contentValues.put(DatabaseHandler.userEmail, user.email)

        val success = db.insert(DatabaseHandler.tableUser,null,contentValues)
        db.close()
    }

    override fun getUser(): ArrayList<User> {
        val userList: ArrayList<User> = ArrayList()

        val selectQuery = "SELECT ${DatabaseHandler.userPassword}, " +
                "${DatabaseHandler.userUsername}, " +
                "${DatabaseHandler.userId} " +
                "FROM ${DatabaseHandler.tableUser}"

        var databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.readableDatabase
        var cursor: Cursor? = null

        try{
            cursor = db.rawQuery(selectQuery,null)
        } catch (e: SQLiteException) {
            db.close()
            return ArrayList()
        }

        var user = User()
        if(cursor.moveToFirst()) {
            do {
                user = User()
                user.id = cursor.getInt(2)
                user.password = cursor.getString(0)
                user.username = cursor.getString(1)

                userList.add(user)
            }while(cursor.moveToNext())
        }
        cursor?.close()
        db.close()
        return userList
    }
    override fun updateUser(user: User, emailAddress: String) {
        TODO("Not yet implemented")
    }

    override fun checkUser(username:String): Boolean {
        val selectQuery = "SELECT ${DatabaseHandler.userUsername} " +
                "FROM ${DatabaseHandler.tableUser} " +
                "WHERE ${DatabaseHandler.userUsername} = '${username}'"

        var databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.readableDatabase
        var cursor: Cursor? = null

        try{
            cursor = db.rawQuery(selectQuery,null)

        } catch (e: SQLiteException) {
            db.close()
            return false
        }

        var cursorCount = cursor.count
        cursor?.close()
        db.close()

        if (cursorCount > 0) {
            return true
        }
        return false
    }

    override fun checkPass(password: String): Boolean {
        val selectQuery = "SELECT ${DatabaseHandler.userPassword} " +
                "FROM ${DatabaseHandler.tableUser} " +
                "WHERE ${DatabaseHandler.userPassword} = '${password}'"

        var databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.readableDatabase
        var cursor: Cursor? = null

        try{
            cursor = db.rawQuery(selectQuery,null)

        } catch (e: SQLiteException) {
            db.close()
            return false
        }

        var cursorCount = cursor.count
        cursor?.close()
        db.close()

        if (cursorCount > 0) {
            return true
        }
        return false
    }
}