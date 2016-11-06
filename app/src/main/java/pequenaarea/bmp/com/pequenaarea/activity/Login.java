package pequenaarea.bmp.com.pequenaarea.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pequenaarea.bmp.com.pequenaarea.R;

public class Login extends AppCompatActivity {

    private TextView txtCadastrar = null;
    private Button btnEntrar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtCadastrar = (TextView)findViewById(R.id.txtCadastrar);
        btnEntrar = (Button)findViewById(R.id.btnEntrar);

        txtCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Login.this, CriaUsuario.class);
                startActivity(intent );
                finish();
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                Intent intent = new Intent(Login.this, TelaPrincipal.class);
                startActivity(intent);
                finish();
            }});
    }
}