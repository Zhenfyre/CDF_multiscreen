package CDFFlint.pilot.cdf_multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCollection (View view) {
        Intent i = new Intent(this, CollectionActivity.class);
        startActivity(i);
    }

    public void openAesthetics (View view) {
        Intent i = new Intent(this, AestheticsActivity.class);
        startActivity(i);
    }

    public void openBacteria (View view) {
        Intent i = new Intent(this, BacteriaActivity.class);
        startActivity(i);
    }

    public void openTestStrips (View view) {
        Intent i = new Intent(this, TestStripsActivity.class);
        startActivity(i);
    }
}