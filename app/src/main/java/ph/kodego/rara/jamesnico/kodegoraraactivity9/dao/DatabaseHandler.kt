package ph.kodego.rara.jamesnico.kodegoraraactivity9.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler (context: Context) : SQLiteOpenHelper(context,DATABASENAME,null,DATABASEVERSION){

    companion object {
        private val DATABASEVERSION = 7
        private val DATABASENAME = "studentdatabase"

        // student table
        
        val tableStudents = "student_table"
        val studentId = "id"
        val studentFirstName = "firstname"
        val studentLastName = "lastname"
        val yearstarted = "year_started"
        val course = "course"
        val studentImage = "image"
        
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
                "$studentImage INTEGER, " +
                "$yearstarted INTEGER, " +
                "$course TEXT)"

        

        db?.execSQL(CREATESTUDENTSTABLE)

        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Rara', 'James Nico', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Navor', 'Dave', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Aragon', 'Janreign', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Balais', 'John Rey', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('James', 'Joni', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Soriano', 'JP', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Mottos', 'Matthew', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Palma', 'Rene', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Yu', 'Victor', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Leones', 'Pat Ivee', 2)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Watkins', 'Dana', 2)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Mullins', 'Kathryn', 2)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Thompson', 'Courtney', 2)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Tapia', 'James', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Wade', 'Robert', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Spencer', 'Teresa', 2)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Mullen', 'Jasmine', 2)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Parks', 'Dawn', 2)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Howard', 'Amanda', 2)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Vaughan', 'Nathaniel', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Tate', 'Caroline', 2)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Ford', 'Sarah', 2)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Nelson', 'Jerome', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Costa', 'Ryan', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Mccarty', 'Scott', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Young', 'Maria', 2)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Frost', 'Sarah', 2)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Davis', 'Pamela', 2)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Miller', 'Rene', 1)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('James', 'Christina', 2)")

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