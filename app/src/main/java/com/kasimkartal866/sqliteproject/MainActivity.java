package com.kasimkartal866.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Musicians", MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY, name VARCHAR, age INT)");

            //database.execSQL("INSERT INTO musicians (name, age) VALUES('James', 50) ");
            //database.execSQL("INSERT INTO musicians (name, age) VALUES('Lars', 60) ");
            //database.execSQL("INSERT INTO musicians (name, age) VALUES('Kirk', 55) ");
           // database.execSQL("UPDATE musicians SET name = 'Kirk Hammett' WHERE id = 3");
           // database.execSQL("DELETE FROM musicians WHERE id = 5");
            //database.execSQL("INSERT INTO musicians (name, age) VALUES('Ubeyd', 23) ");
            //database.execSQL("UPDATE musicians SET name = 'Ubeyd Civelek' WHERE id = 4");
            //database.execSQL("INSERT INTO musicians (name, age) VALUES ('Muhammed',22)");
            //database.execSQL("INSERT INTO musicians (name, age) VALUES ('Omer Ozdiyar',28)");
            //database.execSQL("INSERT INTO musicians (name, age) VALUES ('Cagrı Yalniz',22)");
           // database.execSQL("UPDATE musicians SET age = 26 WHERE id = 7");
           // database.execSQL("INSERT INTO musicians (name, age) VALUES ('Kasim Ceylan',23)");
           // database.execSQL("UPDATE musicians SET name = 'KASIM CEYLAN' WHERE id = 8");
         //database.execSQL("DELETE FROM musicians WHERE id = 3");
            //database.execSQL("UPDATE  musicians SET id = 1 WHERE id = 8");
            //database.execSQL("UPDATE  musicians SET id = 2 WHERE id = 6");
           // database.execSQL("UPDATE  musicians SET id = 3 WHERE id = 5");
            //database.execSQL("UPDATE musicians SET name = 'Muhammed Unal' WHERE id =3");
            //database.execSQL("INSERT INTO musicians (name,age) VALUES ('Adem Hatay',19)");
           // Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name LIKE 'O%'",null);



           Cursor cursor = database.rawQuery("SELECT * FROM musicians",null);

            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");
            int idIx = cursor.getColumnIndex("id");

            while(cursor.moveToNext()){
                System.out.println("Name: "+ cursor.getString(nameIx));
                System.out.println("Age: " + cursor.getInt(ageIx));
                System.out.println("Id: " + cursor.getInt(idIx));
            }
            cursor.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}