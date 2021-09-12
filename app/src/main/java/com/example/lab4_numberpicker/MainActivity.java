package com.example.lab4_numberpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int codeOfCastle = 533; // Код от замка
    TextView textView;
    NumberPicker numberPicker1;
    NumberPicker numberPicker2;
    NumberPicker numberPicker3;
    Button button;

    @Override
    // Метод, который вызывается, когда приложение создает и отображает Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //  вызов метода родительского класса
        setContentView(R.layout.activity_main); // устанавливаем содержимое Activity из layout-файла
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // вертикальная ориентация смартфона

        // Определяем необходимые элементы управления
        textView = (TextView) findViewById(R.id.textView);
        numberPicker1 = (NumberPicker) findViewById(R.id.numberPicker1);
        numberPicker2 = (NumberPicker) findViewById(R.id.numberPicker2);
        numberPicker3 = (NumberPicker) findViewById(R.id.numberPicker3);
        button = (Button) findViewById(R.id.button);
        ImageView imageView = findViewById(R.id.imageView);

        // Устанавливаем минимальные и максимальные значения
        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(9);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(9);
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(9);

        // Обрабатываем изменение значения в numberPicker
        numberPicker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                // Изменяем первую цифру в textView
                String currentNumber = textView.getText().toString();
                currentNumber = currentNumber.substring(0, 0) + newValue + currentNumber.substring(0 + 1);
                textView.setText(currentNumber);
            }
        });

        // Обрабатываем изменение значения в numberPicker
        numberPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                // Изменяем вторую цифру в textView
                String currentNumber = textView.getText().toString();
                currentNumber = currentNumber.substring(0, 1) + newValue + currentNumber.substring(1 + 1);
                textView.setText(currentNumber);
            }
        });

        // Обрабатываем изменение значения в numberPicker
        numberPicker3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                // Изменяем третью цифру в textView
                String currentNumber = textView.getText().toString();
                currentNumber = currentNumber.substring(0, 2) + newValue + currentNumber.substring(2 + 1);
                textView.setText(currentNumber);
            }
        });

        // Обработка нажатия на кнопку
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Проверяем введенное пользователем число с кодом
                if (Integer.parseInt(textView.getText().toString()) == codeOfCastle) {

                    // Устанавливаем изображение зеленой лампочки
                    imageView.setImageBitmap(BitmapFactory.decodeResource(MainActivity.this.getResources(), R.drawable.green_lamp));

                    // Устанавливаем текст кнопки
                    if (button.getText() == "Закрыть") {
                        button.setText("Открыть");
                    } else button.setText("Закрыть");
                }

                // Устанавливаем изображение красной лампочки
                else imageView.setImageBitmap(BitmapFactory.decodeResource(MainActivity.this.getResources(), R.drawable.red_lamp));
            }
        });
    }
}