package pe.edu.tecsup.yanavilcalab.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.tecsup.yanavilcalab.R;
import pe.edu.tecsup.yanavilcalab.Repositories.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    private EditText usuarioInput,nombreInput,correoInput,claveInput;
    private Button registerBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usuarioInput = findViewById(R.id.username_input);
        nombreInput = findViewById(R.id.fullname_input);
        correoInput = findViewById(R.id.email_input);
        claveInput = findViewById(R.id.password_input);
        registerBoton = findViewById(R.id.register_button);
        registerBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRegister();
            }
        });

    }
    private void callRegister(){
        try {
            String username = usuarioInput.getText().toString();
            String fullname = nombreInput.getText().toString();
            String email = correoInput.getText().toString();
            String password = claveInput.getText().toString();

            if (username.isEmpty() || fullname.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            UserRepository.create(username, fullname, email, password);

            Toast.makeText(this, "Registro satisfactorio", Toast.LENGTH_SHORT).show();

            finish();

        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
