package com.progra.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private EditText display;
    private TextView history;
    private ImageButton buton_menu;

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.input);
        imageView=findViewById(R.id.imageView2);
        history = findViewById(R.id.history);
        buton_menu=findViewById(R.id.button_menu);
        display.setShowSoftInputOnFocus(false);
        history.setShowSoftInputOnFocus(false);

    }

    public void mostrarPopUp(View v){
        PopupMenu pp=new PopupMenu(this,buton_menu);
        pp.getMenuInflater().inflate(R.menu.menupopup,pp.getMenu());

        pp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.historial:
                        imageView.setImageResource(R.drawable.image4);
                        return  true;
                    case R.id.eliminar:
                        imageView.setImageResource(R.drawable.image5);
                        return  true;

                }
                return false;
            }

        });
        pp.show();
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void button_zero(View view){
        updateText(getResources().getString(R.string.zero));
    }
    public void button_one(View view){
        updateText(getResources().getString(R.string.one));
    }
    public void button_two(View view){
        updateText(getResources().getString(R.string.two));
    }
    public void button_three(View view){
        updateText(getResources().getString(R.string.three));
    }
    public void button_four(View view){
        updateText(getResources().getString(R.string.four));
    }
    public void button_five(View view){
        updateText(getResources().getString(R.string.five));
    }
    public void button_six(View view){
        updateText(getResources().getString(R.string.six));
    }
    public void button_seven(View view){
        updateText(getResources().getString(R.string.seven));
    }
    public void button_eight(View view){
        updateText(getResources().getString(R.string.eight));
    }
    public void button_nine(View view){
        updateText(getResources().getString(R.string.nine));
    }

    public void button_clean(View view){
        display.setText("");
        history.setText("");
    }
    public void button_positive_negative(View view){
        updateText("-");
    }
    public void button_exponent(View view){
        updateText(getResources().getString(R.string.exponent));
    }
    public void button_division(View view){
        updateText(getResources().getString(R.string.division));
    }
    public void button_multiplication(View view){
        updateText(getResources().getString(R.string.multiplication));
    }
    public void button_minus(View view){
        updateText(getResources().getString(R.string.minus));
    }
    public void button_plus(View view){
        updateText(getResources().getString(R.string.plus));
    }
    public void button_equal(View view){
        String userExp = display.getText().toString();

        history.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.division), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplication), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);

        display.setSelection(result.length());

    }
    public void button_delete(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }
    public void button_decimal(View view){
        updateText(getResources().getString(R.string.decimal));
    }


}