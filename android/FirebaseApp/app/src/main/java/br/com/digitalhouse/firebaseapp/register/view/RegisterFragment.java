package br.com.digitalhouse.firebaseapp.register.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.util.AppUtil;
import de.hdodenhof.circleimageview.CircleImageView;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

import static android.content.Context.MODE_PRIVATE;

public class RegisterFragment extends Fragment {
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button btnRegister;
    private Toolbar toolbar;
    private ProgressBar progressBar;
    private CircleImageView imageViewUser;
    private static final int PERMISSION_CODE = 100;
    private InputStream stream = null;

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
        imageViewUser = view.findViewById(R.id.imageview_user_login);

        btnRegister.setOnClickListener(v -> {
            String email = textInputLayoutEmail.getEditText().getText().toString();
            String password = textInputLayoutPassword.getEditText().getText().toString();

            // Se email e senha são validos tentamos o registro no firebase
            if (validar(email, password)) {
                registrarUsuario(email, password);
            }
        });

        imageViewUser.setOnClickListener(v -> {
            captureImage();
        });
    }

    private void captureImage() {
        int permissionCamera = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA);
        int permissionStorage = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionCamera == PackageManager.PERMISSION_GRANTED && permissionStorage == PackageManager.PERMISSION_GRANTED) {
            EasyImage.openCameraForImage(this, MODE_PRIVATE);
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_CODE);
        }
    }

    private void registrarUsuario(String email, String password) {
        progressBar.setVisibility(View.VISIBLE);

        // seta o loading para true para dar feedback ao uauário, que terminou o cadastro
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {

                        // Salvar id do usuário para pegar os dados depois
                        AppUtil.salvarIdUsuario(getContext(), FirebaseAuth.getInstance().getCurrentUser().getUid());

                        //Salvamos a imagem do usuário no firebase storage
                        salvarImagemFirebase(stream, "imagem-perfil" /*+ file.getName()*/);
                    } else {
                        // Se deu algum erro mostramos para o usuário a mensagem
                        Snackbar.make(btnRegister, "Erro ao cadastrar usuário -> " + task.getException().getMessage(), Snackbar.LENGTH_SHORT).show();
                    }

                    progressBar.setVisibility(View.GONE);
                });
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        captureImage();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, getActivity(), new DefaultCallback() {
            @Override
            public void onImagesPicked(@NonNull List<File> imageFiles, EasyImage.ImageSource source, int type) {

                for (File file : imageFiles) {
                    try {
                        // Aqui podemos modificar o tamnho do arquivo antes de enviar
                        // file.getTotalSpace();
                        stream = new FileInputStream(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void salvarImagemFirebase(InputStream stream, String name) {

        // Pegamos a referencia do storage para salvar a imagem usando o ID do usuário
        StorageReference storage = FirebaseStorage
                .getInstance()
                .getReference()
                .child(AppUtil.getIdUsuario(getContext()) + "/image/profile/" + name);

        // Se a imagem estiver nula vamos para a tela da home
        if (stream == null) {
            NavHostFragment.findNavController(this).navigate(R.id.action_registerFragment_to_homeFragment);
            return;
        }

        // Subimos a imagem com ums task para o firebase
        UploadTask uploadTask = storage.putStream(stream);

        // Observamos se deu suvesso ou erro
        uploadTask.addOnSuccessListener(taskSnapshot -> {
            // Se conseguiu se registrar com sucesso vamos para a home
            NavHostFragment.findNavController(this).navigate(R.id.action_registerFragment_to_homeFragment);

        }).addOnFailureListener(e -> {

            // Se deu erro no upload mostramos uma mensagem para o usuário
            Snackbar snackbar = Snackbar.make(imageViewUser, e.getMessage(), Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(Color.RED);
            snackbar.show();
        });
    }
}
