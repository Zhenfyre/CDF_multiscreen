package CDFFlint.pilot.cdf_multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView landingView = (TextView) findViewById(R.id.landing);
        landingView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the landing category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link landing}
                Intent landingIntent = new Intent(MainActivity.this, landing.class);
                // Start the new activity
                startActivity(landingIntent);
            }
        });

        TextView collectionView = (TextView) findViewById(R.id.collection);
        collectionView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the collection category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link CollectionActivity}
                Intent collectionIntent = new Intent(MainActivity.this, CollectionActivity.class);
                // Start the new activity
                startActivity(collectionIntent);
            }
        });

        TextView aestheticsView = (TextView) findViewById(R.id.aesthetics);
        aestheticsView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the aesthetics category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link AestheticsActivity}
                Intent aestheticsIntent = new Intent(MainActivity.this, AestheticsActivity.class);
                // Start the new activity
                startActivity(aestheticsIntent);
            }
        });

        TextView bacteriaView = (TextView) findViewById(R.id.bacteria);
        bacteriaView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the bacteria category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link BacteriaActivity}
                Intent bacteriaIntent = new Intent(MainActivity.this, BacteriaActivity.class);
                // Start the new activity
                startActivity(bacteriaIntent);
            }
        });

        TextView testStripsView = (TextView) findViewById(R.id.testStrips);
        testStripsView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the test strips category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link TestStripsActivity}
                Intent testStripsIntent = new Intent(MainActivity.this, TestStripsActivity.class);
                // Start the new activity
                startActivity(testStripsIntent);
            }
        });

    }
}