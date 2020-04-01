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
import com.google.android.gms.common.SignInButton;
import com.google.android.material.textfield.TextInputLayout;

import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.util.AppUtil;

public class LoginFragment extends Fragment {

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button btnLogin;
    private Button btnLoginFacebook;
    private SignInButton btnLoginGoogle;
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

        initViews(view);

        btnLogin.setOnClickListener(view1 -> {
            loginEmail();
        });

        textViewGotoRegister.setOnClickListener(v -> {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_loginFragment_to_registerFragment);
        });
    }

    private void initViews(View view) {
        btnLogin = view.findViewById(R.id.btn_login);
        btnLoginFacebook = view.findViewById(R.id.btn_login_facebook);
        textInputLayoutEmail = view.findViewById(R.id.textinput_email);
        textInputLayoutPassword = view.findViewById(R.id.textinput_password);
        textViewGotoRegister = view.findViewById(R.id.textViewGotoRegister);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    public void loginEmail() {
        String email = textInputLayoutEmail.getEditText().getText().toString();
        String password = textInputLayoutPassword.getEditText().getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(getContext(), "Campos não podem ser vazios :(", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(getContext(), "Login com email :D", Toast.LENGTH_SHORT).show();
    }

    public void loginFacebook() {
        Toast.makeText(getContext(), "Login com facebook", Toast.LENGTH_SHORT).show();
    }

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
