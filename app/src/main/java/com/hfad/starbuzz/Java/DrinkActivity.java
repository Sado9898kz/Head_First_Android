package com.hfad.starbuzz.Java;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hfad.starbuzz.R;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKID = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        //Получить напитки из данных интента
        int drinkId = (Integer) getIntent().getExtras().get(EXTRA_DRINKID);

        //Создать курсор
        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
        try {
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("DRINK",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id = ?",
                    new String[]{Integer.toString(drinkId)},
                    null, null, null);


            //Переход к первой записи в курсоре
            if (cursor.moveToFirst()) {

                //Получение данных напитка из курсора
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);


                //Заполнение названия напитка
                TextView name = (TextView) findViewById(R.id.name);
                name.setText(nameText);

                //Заполнение описания напитка
                TextView description = (TextView) findViewById(R.id.description);
                description.setText(descriptionText);

                //Заполнение изоброжения напитка
                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "База данных недоступна", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
