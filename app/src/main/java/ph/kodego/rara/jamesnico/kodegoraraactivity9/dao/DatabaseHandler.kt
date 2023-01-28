package ph.kodego.rara.jamesnico.kodegoraraactivity9.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler (context: Context) : SQLiteOpenHelper(context,DATABASENAME,null,DATABASEVERSION){

    companion object {
        private val DATABASEVERSION = 3
        private val DATABASENAME = "studentdatabase"

        // student table
        
        val tableStudents = "student_table"
        val studentId = "id"
        val studentFirstName = "firstname"
        val studentLastName = "lastname"
        val yearstarted = "year_started"
        val course = "course"
        
        // user table
        
        val tableUser = "user_table"
        val userId = "user_id"
        val userUsername = "username"
        val userPassword = "password"
        val userEmail = "email"
        val userStatus = "user_status"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        
        // creating student table
        
        val CREATESTUDENTSTABLE = "CREATE TABLE $tableStudents " +
                "($studentId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$studentFirstName TEXT, " +
                "$studentLastName TEXT, " +
                "$yearstarted INTEGER, " +
                "$course TEXT)"

        db?.execSQL(CREATESTUDENTSTABLE)

        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Rara', 'James Nico')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Navor', 'Dave')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Aragon', 'Janreign')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Balais', 'John Rey')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('James', 'Joni')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Soriano', 'JP')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Mottos', 'Matthew')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Palma', 'Rene')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Yu', 'Victor')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Bradley', 'Nicole')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Watkins', 'Dana')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Mullins', 'Kathryn')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Thompson', 'Courtney')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Tapia', 'James')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Wade', 'Robert')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Spencer', 'Teresa')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Mullen', 'Jasmine')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Parks', 'Dawn')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Howard', 'Amanda')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Vaughan', 'Nathaniel')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Tate', 'Caroline')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Ford', 'Sarah')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Nelson', 'Jerome')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Costa', 'Ryan')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Mccarty', 'Scott')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Young', 'Maria')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Frost', 'Sarah')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Davis', 'Pamela')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('Miller', 'Renee')")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName) values ('James', 'Christina')")

        // creating user table
        
        val CREATEUSERTABLE = "CREATE TABLE ${tableUser} " +
                "(${userId} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${userUsername} TEXT, " +
                "${userPassword} TEXT, " +
                "${userEmail} TEXT, " +
                "${userStatus} TEXT)"

        db?.execSQL(CREATEUSERTABLE)

        db?.execSQL("Insert into ${tableUser} (${userUsername}, ${userPassword}) values ('admin', 'admin')")
        db?.execSQL("Insert into ${tableUser} (${userUsername}, ${userPassword}) values ('1234', '1234')")
        db?.execSQL("Insert into ${tableUser} (${userUsername}, ${userPassword}) values ('user', 'pass')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $tableStudents")
        db!!.execSQL("DROP TABLE IF EXISTS $tableUser")
        onCreate(db)
    }

}