package ajiet.cse.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button one,two,three,four,five,six,seven,eight,nine,zero;
    Button add,sub,mul,div;
    Button equal,dot,clear;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = findViewById(R.id.one);
        one.setOnClickListener(this);
        two = findViewById(R.id.two);
        two.setOnClickListener(this);

        three = findViewById(R.id.three);
        three.setOnClickListener(this);

        four = findViewById(R.id.four);
        four.setOnClickListener(this);

        five= findViewById(R.id.five);
        five.setOnClickListener(this);

        six = findViewById(R.id.six);
        six.setOnClickListener(this);

        seven = findViewById(R.id.seven);
        seven.setOnClickListener(this);

        eight = findViewById(R.id.eight);
        eight.setOnClickListener(this);

        nine = findViewById(R.id.nine);
        nine.setOnClickListener(this);

        zero = findViewById(R.id.zero);
        zero.setOnClickListener(this);

        sub = findViewById(R.id.sub);
        sub.setOnClickListener(this);

        mul = findViewById(R.id.mul);
        mul.setOnClickListener(this);

        div = findViewById(R.id.div);
        div.setOnClickListener(this);

        add = findViewById(R.id.add);
        add.setOnClickListener(this);

        equal= findViewById(R.id.equal);
        equal.setOnClickListener(this);

        dot = findViewById(R.id.dot);
        dot.setOnClickListener(this);

        clear = findViewById(R.id.clear);
        clear.setOnClickListener(this);

        editText = findViewById(R.id.texteditor);
        editText.setText("");


    }

    @Override
    public void onClick(View v) {
        if(v.equals(one))
        {
            editText.append("1");
        }if(v.equals(two))
        {
            editText.append("2");
        }if(v.equals(three))
        {
            editText.append("3");
        }if(v.equals(four))
        {
            editText.append("4");
        }if(v.equals(five))
        {
            editText.append("5");
        }if(v.equals(six))
        {
            editText.append("6");
        }if(v.equals(seven))
        {
            editText.append("7");
        }if(v.equals(eight))
        {
            editText.append("8");
        }if(v.equals(nine))
        {
            editText.append("9");
        }if(v.equals(zero))
        {
            editText.append("0");
        }if(v.equals(dot))
        {
            editText.append(".");
        }if(v.equals(add))
        {
            editText.append("+");
        }if(v.equals(sub))
        {
            editText.append("-");
        }if(v.equals(div))
        {
            editText.append("/");
        }if(v.equals(mul))
        {
            editText.append("*");
        }if(v.equals(clear))
        {
            editText.setText("");
        }
        if(v.equals(equal))
        {
            try {
                String data = editText.getText().toString();
                if(data.contains("+"))
                {
                    String[] operends = data.split(Pattern.quote("+"));
                    if(operends.length==2)
                    {
                        double operand1 = Double.parseDouble(operends[0]);
                        double operand2 = Double.parseDouble(operends[1]);
                        double Result = operand1+operand2;
                        editText.setText(String.valueOf(Result));
                    }else {
                        Toast.makeText(this,"Invalide Input",Toast.LENGTH_LONG).show();
                    }
                } else if(data.contains("-"))
                {
                    String[] operends = data.split(Pattern.quote("-"));
                    if(operends.length==2)
                    {
                        double operand1 = Double.parseDouble(operends[0]);
                        double operand2 = Double.parseDouble(operends[1]);
                        double Result = operand1-operand2;
                        editText.setText(String.valueOf(Result));
                    }else {
                        Toast.makeText(this,"Invalide Input",Toast.LENGTH_LONG).show();
                    }
                }
                else if(data.contains("/"))
                {
                    String[] operends = data.split(Pattern.quote("/"));
                    if(operends.length==2)
                    {
                        double operand1 = Double.parseDouble(operends[0]);
                        double operand2 = Double.parseDouble(operends[1]);
                        double Result = operand1/operand2;
                        editText.setText(String.valueOf(Result));
                    }else {
                        Toast.makeText(this,"Invalide Input",Toast.LENGTH_LONG).show();
                    }
                }
                else if(data.contains("*"))
                {
                    String[] operends = data.split(Pattern.quote("*"));
                    if(operends.length==2)
                    {
                        double operand1 = Double.parseDouble(operends[0]);
                        double operand2 = Double.parseDouble(operends[1]);
                        double Result = operand1*operand2;
                        editText.setText(String.valueOf(Result));
                    }else {
                        Toast.makeText(this,"Invalide Input",Toast.LENGTH_LONG).show();
                    }
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this,"ivalide input",Toast.LENGTH_LONG).show();
            }
        }
    }
}