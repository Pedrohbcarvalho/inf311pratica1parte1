package phbcarvalho.inf311.pratica1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void acaoBotao(View v){

        String operacao = v.getTag().toString();

        TextView mensagemResultado = (TextView) findViewById(R.id.resultado);

        EditText edt1 = (EditText) findViewById(R.id.editText1);
        EditText edt2 = (EditText) findViewById(R.id.editText2);

        String strValor1 = edt1.getText().toString();
        Double valor1 = Double.parseDouble(strValor1);

        String strValor2 = edt2.getText().toString();
        Double valor2 = Double.parseDouble(strValor2);

        Double resultado;

        if (operacao.equals("+")) {
            resultado = valor1 + valor2;
            String resultStr = resultado.toString();
            mensagemResultado.setText("O resultado é: " + resultStr);
        }

        else if (operacao.equals("-")) {
            resultado = valor1 - valor2;
            String resultStr = resultado.toString();
            mensagemResultado.setText("O resultado é: " + resultStr);
        }

        else if (operacao.equals("*")) {
            resultado = valor1 * valor2;
            String resultStr = resultado.toString();
            mensagemResultado.setText("O resultado é: " + resultStr);
        }

        else {
            if (valor2 != 0) {
                resultado = valor1 / valor2;
                String resultStr = resultado.toString();
                mensagemResultado.setText("O resultado é: " + resultStr);
            }
            else {
                mensagemResultado.setText("Não é possível realizar divisão por zero!");
            }
        }
    }
}