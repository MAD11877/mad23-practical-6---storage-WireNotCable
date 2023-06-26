package sg.edu.np.mad.madpractical;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        Button login = findViewById(R.id.loginBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("Users").child("mad").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot snapshot = task.getResult();
                            String correctUsername = snapshot.child("username").getValue().toString();
                            String correctPassword = snapshot.child("password").getValue().toString();

                            EditText usernameEt = findViewById(R.id.username);
                            EditText passwordEt = findViewById(R.id.password);
                            String username = usernameEt.getText().toString();
                            String password = passwordEt.getText().toString();

                            if (correctUsername.equals(username)&&correctPassword.equals(password)){
                                Toast.makeText(LoginActivity.this, "Log In Successful!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(LoginActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Error retrieving data", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}