package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnVirgule;
    private Button btnAddition;
    private Button btnSubstratct;
    private Button btnMultiple;
    private Button btnDivide;
    private Button btnModulo;
    private Button btnEqual;
    private Button btnDelete;
    private Button btnDeleteAll;
    private TextView txtResults;
    private double firstNumber = 0, secondNumber = 0;
    private char operatorType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associate Button to private attribute
        this.btn0 = findViewById(R.id.btn_0);
        this.btn1 = findViewById(R.id.btn_1);
        this.btn2 = findViewById(R.id.btn_2);
        this.btn3 = findViewById(R.id.btn_3);
        this.btn4 = findViewById(R.id.btn_4);
        this.btn5 = findViewById(R.id.btn_5);
        this.btn6 = findViewById(R.id.btn_6);
        this.btn7 = findViewById(R.id.btn_7);
        this.btn8 = findViewById(R.id.btn_8);
        this.btn9 = findViewById(R.id.btn_9);
        this.btnVirgule = findViewById(R.id.btn_virgule);
        this.btnAddition = findViewById(R.id.btn_addition);
        this.btnSubstratct = findViewById(R.id.btn_substract);
        this.btnMultiple = findViewById(R.id.btn_multiple);
        this.btnDivide = findViewById(R.id.btn_divide);
        this.btnEqual = findViewById(R.id.btn_equal);
        this.btnModulo = findViewById(R.id.btn_modulo);
        this.btnDelete = findViewById(R.id.btn_delete);
        this.btnDeleteAll = findViewById(R.id.btn_delete_all);
        this.txtResults = findViewById(R.id.txt_results);

        // Set event listener
        this.btn0.setOnClickListener(this);
        this.btn1.setOnClickListener(this);
        this.btn2.setOnClickListener(this);
        this.btn3.setOnClickListener(this);
        this.btn4.setOnClickListener(this);
        this.btn5.setOnClickListener(this);
        this.btn6.setOnClickListener(this);
        this.btn7.setOnClickListener(this);
        this.btn8.setOnClickListener(this);
        this.btn9.setOnClickListener(this);
        this.btnVirgule.setOnClickListener(this);
        this.btnAddition.setOnClickListener(this);
        this.btnSubstratct.setOnClickListener(this);
        this.btnMultiple.setOnClickListener(this);
        this.btnDivide.setOnClickListener(this);
        this.btnEqual.setOnClickListener(this);
        this.btnModulo.setOnClickListener(this);
        this.btnDelete.setOnClickListener(this);
        this.btnDeleteAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(this.btn1 == view) {
            this.txtResults.setText(this.addButtonText(this.btn1));
        } else if(this.btn2 == view) {
            this.txtResults.setText(this.addButtonText(this.btn2));
        } else if(this.btn3 == view) {
            this.txtResults.setText(this.addButtonText(this.btn3));
        } else if(this.btn4 == view) {
            this.txtResults.setText(this.addButtonText(this.btn4));
        } else if(this.btn5 == view) {
            this.txtResults.setText(this.addButtonText(this.btn5));
        } else if(this.btn6 == view) {
            this.txtResults.setText(this.addButtonText(this.btn6));
        } else if(this.btn7 == view) {
            this.txtResults.setText(this.addButtonText(this.btn7));
        } else if(this.btn8 == view) {
            this.txtResults.setText(this.addButtonText(this.btn8));
        } else if(this.btn9 == view) {
            this.txtResults.setText(this.addButtonText(this.btn9));
        } else if(this.btn0 == view) {
            this.txtResults.setText(this.addButtonText(this.btn0));
        } else if(this.btnVirgule == view) {
            this.txtResults.setText(this.addButtonText(this.btnVirgule));
        } else if(this.btnAddition == view) {
            this.operatorType = '+';
            this.addToFirstNumber(this.txtResults.getText().toString());
            this.txtResults.setText("0");
        } else if(this.btnSubstratct == view) {
            this.operatorType = '-';
            this.addToFirstNumber(this.txtResults.getText().toString());
            this.txtResults.setText("0");
        } else if(this.btnMultiple == view) {
            this.operatorType = 'x';
            this.addToFirstNumber(this.txtResults.getText().toString());
            this.txtResults.setText("0");
        } else if(this.btnDivide == view) {
            this.operatorType = '/';
            this.addToFirstNumber(this.txtResults.getText().toString());
            this.txtResults.setText("0");
        } else if(this.btnModulo== view) {
            this.operatorType = '%';
            this.addToFirstNumber(this.txtResults.getText().toString());
            this.txtResults.setText("0");
        } else if(this.btnEqual == view) {
            this.secondNumber = Double.parseDouble(this.txtResults.getText().toString());
            this.txtResults.setText("" + this.doCalcul());
        } else if(this.btnDelete == view) {
            this.txtResults.setText(this.txtResults.getText().toString().substring(0, this.txtResults.getText().length() - 1));
        } else if(this.btnDeleteAll == view) {
            this.txtResults.setText("0");
            this.firstNumber = 0.0;
            this.secondNumber = 0.0;
        }
    }

    private String addButtonText(Button b) {
        String txtResultsText = "";

        if(!this.txtResults.getText().toString().equals("0")) {
            txtResultsText = this.txtResults.getText().toString();
        }

        return txtResultsText + b.getText();
    }

    private void addToFirstNumber(String stringToConvert) {
        if(this.firstNumber == 0) {
            this.firstNumber = Double.parseDouble(stringToConvert);
        } else {
            if(this.operatorType == '+') {
                this.firstNumber += Double.parseDouble(stringToConvert);
            } else if(this.operatorType == '-') {
                this.firstNumber -= Double.parseDouble(stringToConvert);
            } else if(this.operatorType == '/') {
                this.firstNumber /= Double.parseDouble(stringToConvert);
            } else if(this.operatorType == 'x') {
                this.firstNumber *= Double.parseDouble(stringToConvert);
            } else if(this.operatorType == '%') {
                this.firstNumber %= Double.parseDouble(stringToConvert);
            }
        }
    }

    private double doCalcul() {

        double result = 0.0;

        switch (this.operatorType) {
            case '+':
                result = this.firstNumber + this.secondNumber;
                break;

            case '-':
                result = this.firstNumber - this.secondNumber;
                break;

            case 'x':
                result = this.firstNumber * this.secondNumber;
                break;

            case '/':
                result = this.firstNumber / this.secondNumber;
                break;

            case '%':
                result = this.firstNumber % this.secondNumber;
                break;

            default:
                this.txtResults.setText("Error");
                break;
        }

        return result;
    }
}
