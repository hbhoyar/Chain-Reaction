package warrior.himanshu.chainreaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        String[] list_items={"Select Grid Size","9 * 6"};
        Spinner drop_down = findViewById(R.id.dropdown);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,list_items);
        drop_down.setAdapter(adapter);

        Button start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(getApplicationContext(),GamePage.class);
                startActivity(game);
            }
        });

    }
}
