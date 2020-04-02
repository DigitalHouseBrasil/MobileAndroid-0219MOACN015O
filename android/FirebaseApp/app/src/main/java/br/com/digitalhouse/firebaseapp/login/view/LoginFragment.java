package br.com.digitalhouse.firebaseapp.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.util.AppUtil;

public class LoginFragment extends Fragment {

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button btnLogin;
    private Button btnLoginFacebook;
    private TextView textViewGotoRegister;
    private CallbackManager callbackManager;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Inicializa as views linkando xml e java
        initViews(view);

        // Login com Firebase email e senha
        btnLogin.setOnClickListener(view1 -> {
            loginEmail();
        });

        // Redireciona para a tela de cadastro
        textViewGotoRegister.setOnClickListener(v -> {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_loginFragment_to_registerFragment);
        });

        // Login com facebook
        btnLoginFacebook.setOnClickListener(v -> {
            loginFacebook();
        });
    }

    private void initViews(View view) {
        btnLogin = view.findViewById(R.id.btn_login);
        btnLoginFacebook = view.findViewById(R.id.btn_login_facebook);
        textInputLayoutEmail = view.findViewById(R.id.textinput_email);
        textInputLayoutPassword = view.findViewById(R.id.textinput_password);
        textViewGotoRegister = view.findViewById(R.id.textViewGotoRegister);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        callbackManager = CallbackManager.Factory.create();
    }

    public void loginEmail() {
        String email = textInputLayoutEmail.getEditText().getText().toString();
        String password = textInputLayoutPassword.getEditText().getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(getContext(), "Campos não podem ser vazios :(", Toast.LENGTH_SHORT).show();
            return;
        }

        // tentamos fazer o login com o email e senha no firebase
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    // Caso login com sucesso vamos para tela  Home
                    if (task.isSuccessful()) {
                        irParaHome(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    } else {
                        // Se deu algum erro mostramos para o usuário a mensagem
                        Snackbar.make(btnLogin, "Erro ao tentar logar" + task.getException().getMessage(), Snackbar.LENGTH_SHORT).show();
                    }
                });
    }

    public void loginFacebook() {

        //Seta as permissões para login com facebook
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));

        // REgistra o callback para quando retornar do app do facebook
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        irParaHome(loginResult.getAccessToken().getUserId());
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getContext(), "Cancelado pelo usuário", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Snackbar.make(btnLoginFacebook, "Erro ao logar com facebook -> " + exception.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }
                });
    }

    // Redireciona para home, e salva o id do usuário que fez o login
    private void irParaHome(String uiid) {
        AppUtil.salvarIdUsuario(getContext(), uiid);
        NavHostFragment.findNavController(this)
                .navigate(R.id.action_loginFragment_to_homeFragment);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
