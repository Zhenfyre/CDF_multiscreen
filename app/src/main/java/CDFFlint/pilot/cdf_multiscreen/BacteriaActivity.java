package CDFFlint.pilot.cdf_multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class BacteriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacteria);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitBacteriaResults(View view) {

        // Get rotten egg smell
        boolean rottenEgg = false;
        RadioButton rottenEggButton = (RadioButton) findViewById(R.id.rottenEgg_yes_radio_button);
        boolean ifRottenEgg = rottenEggButton.isChecked();
        if (ifRottenEgg)
        {rottenEgg = true;}

        // Get sediment
        boolean sediment = false;
        RadioButton sedimentButton = (RadioButton) findViewById(R.id.sediment_yes_radio_button);
        boolean ifSediment = sedimentButton.isChecked();
        if (ifSediment)
        {sediment = true;}

        // Get feathery
        boolean feathery = false;
        RadioButton featheryButton = (RadioButton) findViewById(R.id.feathery_yes_radio_button);
        boolean ifFeathery = featheryButton.isChecked();
        if (ifFeathery)
        {feathery = true;}

        // Get Bacteria
        boolean bacteria = false;
        RadioButton bacteriaButton = (RadioButton) findViewById(R.id.positive_bacteria_radio_button);
        boolean ifBacteria = bacteriaButton.isChecked();
        if (ifBacteria)
        {bacteria = true;}

        // Display the results summary
        String message = createResultsSummary(rottenEgg, sediment, feathery, bacteria);

        String subject = getString(R.string.email_subject);
        String email_address = getString(R.string.email_address);

        display(message);
    }

    /**
     * Create summary of the results.
     * @return text summary
     */
    private String createResultsSummary(Boolean rottenEgg, Boolean sediment, Boolean feathery,
                                        Boolean bacteria) {

        String summaryMessage = "\n " + getString(R.string.rotten_egg_short) + ": " + rottenEgg;
        summaryMessage += "\n " + getString(R.string.sediment_short) + ": " + sediment;
        summaryMessage += "\n " + getString(R.string.feathery_short) + ": " + feathery;
        summaryMessage += "\n " + getString(R.string.bacteria) + ": " + bacteria;

        return summaryMessage;
    }

    /**
     * This method displays the summary to the screen.
     */
    private void display(String summary) {
        TextView summaryTextView = (TextView) findViewById(R.id.summary);
        summaryTextView.setText("Summary: \n" + summary);
        summaryTextView.setVisibility(View.VISIBLE);

    }
}