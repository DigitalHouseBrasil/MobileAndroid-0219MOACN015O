package br.com.digitalhouse.firebaseapp.register.view;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.textfield.TextInputLayout;

import br.com.digitalhouse.firebaseapp.R;

public class RegisterFragment extends Fragment {
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button btnRegister;
    private Toolbar toolbar;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnRegister = view.findViewById(R.id.btn_register);
        textInputLayoutName = view.findViewById(R.id.textinput_name);
        textInputLayoutEmail = view.findViewById(R.id.textinput_email);
        textInputLayoutPassword = view.findViewById(R.id.textinput_password);
        progressBar = view.findViewById(R.id.progressBar);

        btnRegister.setOnClickListener(v -> {
            String email = textInputLayoutEmail.getEditText().getText().toString();
            String password = textInputLayoutPassword.getEditText().getText().toString();

            // Se email e senha são validos tentamos o registro no firebase
            if (validar(email, password)) {
                registrarUsuario(email, password);
            }
        });
    }

    private void registrarUsuario(String email, String password) {
        progressBar.setVisibility(View.VISIBLE);

        //Fazer registro do usuátio no firebase
        NavHostFragment.findNavController(this)
                .navigate(R.id.action_registerFragment_to_homeFragment);
    }

    // Essa validação pode ficar na view em vez do viewmodel, pois ela trata os elementos da tela
    private boolean validar(String email, String password) {
        if (email.isEmpty()) {
            textInputLayoutEmail.setError("Email não pode ser vazio");
            textInputLayoutEmail.requestFocus();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            textInputLayoutEmail.setError("Email inválido");
            textInputLayoutEmail.requestFocus();
            return false;
        }

        if (password.isEmpty()) {
            textInputLayoutPassword.setError("Senha não pode ser vazio");
            textInputLayoutPassword.requestFocus();
            return false;
        }

        if (password.length() < 6) {
            textInputLayoutPassword.setError("Senha deve ser maior qeu 6 caracters");
            textInputLayoutPassword.requestFocus();
            return false;
        }

        return true;
    }
}
