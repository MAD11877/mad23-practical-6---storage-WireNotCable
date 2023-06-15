package sg.edu.np.mad.madpractical;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = new User ("XinYin", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua bfhewjdqwfbehqdwnkjbfehdwkdjbcqdwnjbfhewjdqwfbehqdwnkjbfehdwkdjbcqdwnjbfhewjdqwfbehqdwnkjbfehdwkdjbcqdwnjbfhewjdqwfbehqdwnkjbfehdwkdjbcqdwnjbfhewjdqwfbehqdwnkjbfehdwkdjbcqdwnjbfhewjdqwfbehqdwnkjbfehdwkdjbcqdwnj.", 1, true);

        // get name
        TextView name = findViewById(R.id.textView2);
        Intent receivingEnd = getIntent();
        String name1 = receivingEnd.getStringExtra("name");
        name.setText(name1);

        // get desc
        TextView desc = findViewById(R.id.textView);
        String desc1 = receivingEnd.getStringExtra("desc");
        desc.setText(desc1);

        // toggle follow & unfollow button
        Button followBtn = findViewById(R.id.button);
        followBtn.setOnClickListener(v -> {
            user.followed = !user.followed;
            followBtn.setText(user.followed ? "UNFOLLOW" : "FOLLOW");
        });

        // start message group activity
        Button msgBtn = findViewById(R.id.button2);
        msgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MessageGroup = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(MessageGroup);
            }
        });
    }
}