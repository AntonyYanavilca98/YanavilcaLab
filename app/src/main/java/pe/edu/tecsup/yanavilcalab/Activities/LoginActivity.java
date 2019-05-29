package pe.edu.tecsup.yanavilcalab.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.tecsup.yanavilcalab.Modelos.User;
import pe.edu.tecsup.yanavilcalab.R;
import pe.edu.tecsup.yanavilcalab.Repositories.UserRepository;

public class LoginActivity extends AppCompatActivity {

    private EditText correoInput,claveInput;
    private Button loginBoton,registerBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        correoInput = findViewById(R.id.correo_input);
        claveInput = findViewById(R.id.clave_input);

        loginBoton = findViewById(R.id.login_boton);
        loginBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLogin();
            }
        });

        registerBoton = findViewById(R.id.register_boton);
        registerBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegister();
            }
        });
    }
    private void showRegister(){
        startActivity(new Intent(this, RegisterActivity.class));
    }

    private void callLogin(){
        String email = correoInput.getText().toString();
        String password = claveInput.getText().toString();

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Rellenar campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Login process
        User user = UserRepository.login(email, password);

        if(user == null) {
            Toast.makeText(this, "Correo o password inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        // Go to main
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
