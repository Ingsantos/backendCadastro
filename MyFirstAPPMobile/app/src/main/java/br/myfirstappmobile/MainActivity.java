package br.myfirstappmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout nome;
    private TextInputLayout email;
    private FloatingActionButton bntConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        bntConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String vNome = nome.getEditText().getText().toString();
                String vEmail = email.getEditText().getText().toString();

                if (nomeVazio(vNome) || emailVazio(vEmail))
                    notificacao();
                else if (!emailValido(vEmail))
                    notificacaoInvalido();
                else
                    notificacaoPositiva();
            }
        });

    }

    protected void initViews(){
        nome = findViewById(R.id.textInputLayout);
        email = findViewById(R.id.textInputLayout2);
        bntConfirmar = findViewById(R.id.floatingActionButton);
    }

    protected boolean nomeVazio (String nome) {

        if (nome.isEmpty())
            return true;
        else
            return false;
    }

    protected boolean emailVazio (String email){
        if (email.isEmpty())
            return true;
        else
            return false;
    }

    protected void notificacao (){
        Context contexto = getApplicationContext();
        String textoNotificacao = "Por favor, preencha todos os campos";
        int duracaoNotifacao = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(contexto, textoNotificacao, duracaoNotifacao);
        toast.show();
    }

    protected void notificacaoInvalido (){
        Context contexto = getApplicationContext();
        String textoNotificacao = "E-mail invalido, por favor, verifique e preencha novamente";
        int duracaoNotifacao = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(contexto, textoNotificacao, duracaoNotifacao);
        toast.show();
    }

    protected void notificacaoPositiva (){
        Context contexto = getApplicationContext();
        String textoNotificacao = "Parabéns você digitou os dados corretamente";
        int duracaoNotifacao = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(contexto, textoNotificacao, duracaoNotifacao);
        toast.show();
    }

    private boolean emailValido (String email){
        if (email.contains("@") && email.contains(".com"))
            return true;
        else
            return false;
    }

}
