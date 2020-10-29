package com.example.proyek2aplikasivalidasilogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import java.io.File;
import java.io.FileOutputStream;

public class RegisterActivity extends AppCompatActivity {
EditText editUsername, editPassword, editEmail, editNamaLengkap, editAsalSekolah, editAlamat;
Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar = findViewById(R.id.toolbar_register);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("Register");
        editUsername = findViewById(R.id.edtUsername);
        editPassword = findViewById(R.id.edtPassword);
        editEmail = findViewById(R.id.edtEmail);
        editNamaLengkap = findViewById(R.id.edtNamaLengkap);
        editAsalSekolah = findViewById(R.id.edtAsalSekolah);
        editAlamat = findViewById(R.id.edtAlamatTinggal);
        btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidation()) {
                    simpanFileData();
                }else{
                    Toast.makeText(RegisterActivity.this, "Mohon Lengkapi Seluruh Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
boolean isValidation() {
    if (editUsername.getText().toString().equals("")||
    editPassword.getText().toString().equals("") ||
            editEmail.getText().toString().equals("") ||
            editNamaLengkap.getText().toString().equals("")||
            editAsalSekolah.getText().toString().equals("")||
            editAlamat.getText().toString().equals("")){
        return false;
    } else{
        return true;
    }
}
      void simpanFileData() {
        String isiFile = editUsername.getText().toString() + ";" +
                editPassword.getText().toString() +";" +
                editEmail.getText().toString() +";" +
                editNamaLengkap.getText().toString() +";" +
                editAsalSekolah.getText().toString() +";" +
                editAlamat.getText().toString();
          File file = new File(getFilesDir(),
                  editUsername.getText().toString());
          FileOutputStream outputStream = null;
          try {
              file.createNewFile();
              outputStream = new FileOutputStream(file, false);
              outputStream.write(isiFile.getBytes());
              outputStream.flush();
              outputStream.close();
          } catch (Exception e) {
              e.printStackTrace();
          }
          Toast.makeText(this, "Register Berhasil",
                  Toast.LENGTH_SHORT).show();
          onBackPressed();
      }


      }

