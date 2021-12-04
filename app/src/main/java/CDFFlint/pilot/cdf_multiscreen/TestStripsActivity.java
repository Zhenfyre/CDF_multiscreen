package CDFFlint.pilot.cdf_multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class TestStripsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_strips);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitTestStripsResults(View view) {

        // Get Total Hardness
        EditText hardnessField = (EditText) findViewById(R.id.enter_hardness);
        Editable hardnessEditable = hardnessField.getText();
        String hardness = hardnessEditable.toString();

        // Get Total Chlorine
        EditText chlorineField = (EditText) findViewById(R.id.enter_chlorine);
        Editable chlorineEditable = chlorineField.getText();
        String chlorine = chlorineEditable.toString();

        // Get Alkalinity
        EditText alkalinityField = (EditText) findViewById(R.id.enter_alkalinity);
        Editable alkalinityEditable = alkalinityField.getText();
        String alkalinity = alkalinityEditable.toString();

        // Get Copper
        EditText copperField = (EditText) findViewById(R.id.enter_copper);
        Editable copperEditable = copperField.getText();
        String copper = copperEditable.toString();

        // Get Iron
        EditText ironField = (EditText) findViewById(R.id.enter_iron);
        Editable ironEditable = ironField.getText();
        String iron = ironEditable.toString();

        // Get pH
        EditText phField = (EditText) findViewById(R.id.enter_pH);
        Editable phEditable = phField.getText();
        String pH = phEditable.toString();

        // Get Pesticide
        boolean pesticide = false;
        RadioButton pesticideButton = (RadioButton) findViewById(R.id.positive_pesticide_radio_button);
        boolean ifPesticide = pesticideButton.isChecked();
        if (ifPesticide)
        {pesticide = true;}

        // Get Lead
        boolean lead = false;
        RadioButton leadButton = (RadioButton) findViewById(R.id.positive_lead_radio_button);
        boolean ifLead = leadButton.isChecked();
        if (ifLead)
        {lead = true;}

        // Get Nitrite
        boolean nitrite = false;
        RadioButton nitriteButton = (RadioButton) findViewById(R.id.unsafe_nitrite_radio_button);
        boolean ifNitrite = nitriteButton.isChecked();
        if (ifNitrite)
        {nitrite = true;}

        // Get Nitrate
        boolean nitrate = false;
        RadioButton nitrateButton = (RadioButton) findViewById(R.id.unsafe_nitrate_radio_button);
        boolean ifNitrate = nitrateButton.isChecked();
        if (ifNitrate)
        {nitrate = true;}

        // Display the results summary
        String message = createResultsSummary(hardness, chlorine, alkalinity, copper, iron, pH, pesticide, lead,
                nitrite, nitrate);

        String subject = getString(R.string.email_subject);
        String email_address = getString(R.string.email_address);

        display(message);
    }

    /**
     * Create summary of the results.
     * @return text summary
     */
    private String createResultsSummary(String hardness, String chlorine, String alkalinity,
                                        String copper, String iron, String pH, Boolean pesticide,
                                        Boolean lead, Boolean nitrite, Boolean nitrate) {

        String summaryMessage = "\n " + getString(R.string.total_hardness) + ": "
                                + hardness + " " + getString(R.string.concentration_ppm);
        summaryMessage += "\n " + getString(R.string.total_chlorine) + ": " + chlorine
                                + " " + getString(R.string.concentration_ppm);
        summaryMessage += "\n " + getString(R.string.alkalinity) + ": " + alkalinity + " "
                                + getString(R.string.concentration_ppm);
        summaryMessage += "\n " + getString(R.string.copper) + ": " + copper + " "
                                + getString(R.string.concentration_ppm);
        summaryMessage += "\n " + getString(R.string.iron) + ": " + iron + " "
                                + getString(R.string.concentration_ppm) + "\n";

        summaryMessage += "\n " + getString(R.string.ph) + " " + pH + "\n";

        summaryMessage += "\n " + getString(R.string.pesticide) + ": " + pesticide;
        summaryMessage += "\n " + getString(R.string.lead) + ": " + lead + "\n";

        summaryMessage += "\n " + getString(R.string.nitrite) + ": " + nitrite;
        summaryMessage += "\n " + getString(R.string.nitrate) + ": " + nitrate;
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