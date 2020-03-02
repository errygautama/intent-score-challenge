package id.putraprima.skorbola;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText homeTeamText, awayTeamText;
    private ImageView homeImage, awayImage;
    private Bitmap homeBitmap, awayBitmap;
    private Uri homeUri, awayUri;
    private String homeTeam, awayTeam;
    private boolean homeStatus, awayStatus, homeBitmapStatus, awayBitmapStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeTeamText = findViewById(R.id.home_team);
        awayTeamText = findViewById(R.id.away_team);
        homeImage = findViewById(R.id.home_logo);
        awayImage = findViewById(R.id.away_logo);
        //TODO
        //Fitur Main Activity
        //1. Validasi Input Home Team
        //2. Validasi Input Away Team
        //3. Ganti Logo Home Team
        //4. Ganti Logo Away Team
        //5. Next Button Pindah Ke MatchActivity

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0) {
            return;
        }
        if (requestCode == 1) {
            if (data != null) {
                try {
                    homeUri = data.getData();
                    homeBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), homeUri);
                    homeImage.setImageBitmap(homeBitmap);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                }
            }
        }else if (requestCode == 2){
            if (data != null) {
                try {
                    awayUri = data.getData();
                    awayBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), awayUri);
                    awayImage.setImageBitmap(awayBitmap);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    public void handleNext(View view) {
        homeTeam = homeTeamText.getText().toString();
        awayTeam = awayTeamText.getText().toString();

        if ((awayTeam).equals("Away Team") || (awayTeam).equals("")) {
            Toast.makeText(this, "Please enter away team name", Toast.LENGTH_SHORT).show();
            awayStatus = false;
        } else {
            awayStatus = true;
        }

        if (awayBitmap == null){
            Toast.makeText(this, "Please select away team image", Toast.LENGTH_SHORT).show();
            awayBitmapStatus = false;
        } else {
            awayBitmapStatus = true;
        }

        if (homeBitmap == null){
            Toast.makeText(this, "Please select home team image", Toast.LENGTH_SHORT).show();
            homeBitmapStatus = false;
        } else {
            homeBitmapStatus = true;
        }

        if ((homeTeam).equals("Home Team") || (homeTeam).equals("")) {
            Toast.makeText(this, "Please enter home team name", Toast.LENGTH_SHORT).show();
            homeStatus = false;
        } else {
            homeStatus = true;
        }

        if (homeStatus == true && awayStatus == true && homeBitmapStatus == true && awayBitmapStatus == true){
            DataScore dataScore = new DataScore(homeTeam, awayTeam, 0, 0, homeUri, awayUri);
            Intent intent = new Intent(this, MatchActivity.class);
            intent.putExtra("DATA_KEY", dataScore);
            startActivity(intent);
        }
    }

    public void handleHomeTeamImage(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    public void handleAwayTeamImage(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 2);
    }
}
