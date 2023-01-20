package ph.kodego.rara.jamesnico.kodegoraraactivity9.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler (context: Context) : SQLiteOpenHelper(context,DATABASENAME,null,DATABASEVERSION){

    companion object {
        private val DATABASEVERSION = 1
        private val DATABASENAME = "studentdatabase"

        val tableStudents = "student_table"
        val studentId = "id"
        val studentFirstName = "firstname"
        val studentLastName = "lastname"
        val studentImage = "img"
        val studentMiddleName = "middlename"
        val studentAddress = "address"
        val studentBirthday = "birthday"
        val studentYearEntered = "year_entered"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATESTUDENTSTABLE = "CREATE TABLE $tableStudents " +
                "($studentId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$studentFirstName TEXT, " +
                "$studentLastName TEXT, " +
                "$studentMiddleName TEXT, " +
                "$studentImage INTEGER, " +
                "$studentAddress TEXT, " +
                "$studentBirthday TEXT, " +
                "$studentYearEntered TEXT)"

        db?.execSQL(CREATESTUDENTSTABLE)

        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Rara', 'James Nico', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Navor', 'Dave', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Aragon', 'Janreign', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Balais', 'John Rey', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('James', 'Joni', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Soriano', 'JP', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Mottos', 'Matthew', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Palma', 'Rene', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Yu', 'Victor', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Bradley', 'Nicole', icon_male)")

        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Watkins', 'Dana', icon_female)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Mullins', 'Kathryn', icon_female)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Thompson', 'Courtney', icon_female)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Tapia', 'James', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Wade', 'Robert', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Spencer', 'Teresa', icon_female)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Mullen', 'Jasmine', icon_female)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Parks', 'Dawn', icon_female)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Howard', 'Amanda', icon_female)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Vaughan', 'Nathaniel', icon_male)")

        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Tate', 'Caroline', icon_female)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Ford', 'Sarah', icon_female)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Nelson', 'Jerome', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Costa', 'Ryan', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Mccarty', 'Scott', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Young', 'Maria', icon_female)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Frost', 'Sarah', icon_female)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Davis', 'Pamela', icon_female)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('Miller', 'Renee', icon_male)")
        db?.execSQL("Insert into $tableStudents ($studentLastName, $studentFirstName, $studentImage) values ('James', 'Christina', icon_female)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $tableStudents")
        onCreate(db)
    }

}