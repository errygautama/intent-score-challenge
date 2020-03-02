package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ScorerActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mButton;
    private int request;
    private String scorerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorer);

        mEditText = findViewById(R.id.scorerName);
        mButton = findViewById(R.id.button);

        Bundle bundle = getIntent().getExtras();
        if (bundle !=null){
            request = bundle.getInt("REQUEST_KEY");
        }
    }

    public void handleSubmitScorer(View view) {
        scorerName = mEditText.getText().toString();
        if ((scorerName).equals("")){
            Toast.makeText(this, "Please enter scorer name", Toast.LENGTH_SHORT).show();
        }else{
            if (request == 1){
                scorerName = mEditText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("HOME_SCORER_KEY", scorerName + ",");
                setResult(1, intent);
                finish();
            }else if (request == 2){
                scorerName = mEditText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("AWAY_SCORER_KEY", scorerName + ",");
                setResult(1, intent);
                finish();
            }
        }
    }
}
