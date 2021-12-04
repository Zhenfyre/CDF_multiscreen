package CDFFlint.pilot.cdf_multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitCollectionResults(View view) {

        // Get date of collection
        EditText dateField = (EditText) findViewById(R.id.collectionDate);
        Editable dateEditable = dateField.getText();
        String dateCollection = dateEditable.toString();

        // Get time of collection
        EditText timeField = (EditText) findViewById(R.id.time_of_day);
        Editable timeEditable = timeField.getText();
        String timeCollection = timeEditable.toString();

        // Get participant ID number
        EditText tabletNumberField = (EditText) findViewById(R.id.tablet_number);
        Editable tabletNumberEditable = tabletNumberField.getText();
        String tabletNumber = tabletNumberEditable.toString();

        // Get time water running
        EditText timeRunningField = (EditText) findViewById(R.id.time_running_water);
        Editable timeRunningEditable = timeRunningField.getText();
        String timeRunning = timeRunningEditable.toString();

        // Get status of water used for drinking checkbox
        CheckBox drinkingCheckbox = (CheckBox) findViewById(R.id.checkBoxDrinking);
        boolean usedForDrinking = drinkingCheckbox.isChecked();
        Log.v("CollectionActivity", "Used for drinking: " + usedForDrinking);

        // Get status of water used for brushing checkbox
        CheckBox brushingCheckbox = (CheckBox) findViewById(R.id.checkBoxBrushingTeeth);
        boolean usedForBrushing = brushingCheckbox.isChecked();
        Log.v("CollectionActivity", "Used for brushing: " + usedForBrushing);

        // Get status of water used for handwashing checkbox
        CheckBox handwashingCheckbox = (CheckBox) findViewById(R.id.checkBoxHandwashing);
        boolean usedForHandwashing = handwashingCheckbox.isChecked();
        Log.v("CollectionActivity", "Used for handwashing: " + usedForHandwashing);

        // Get status of water used for none checkbox
        CheckBox noneCheckbox = (CheckBox) findViewById(R.id.checkBoxNone);
        boolean usedForNone = noneCheckbox.isChecked();
        Log.v("CollectionActivity", "Used for None: " + usedForNone);

        boolean noneDrinking = usedForDrinking;
        boolean noneHandwashing = usedForHandwashing;
        boolean noneBrushing = usedForBrushing;

        if (usedForNone) {
            noneDrinking = false;
            noneHandwashing = false;
            noneBrushing = false;
        }

        Log.v("CollectionActivity", "Used for drinking: " + noneDrinking);
        Log.v("CollectionActivity", "Used for brushing: " + noneBrushing);
        Log.v("CollectionActivity", "Used for handwashing: " + noneHandwashing);

        // Get water temperature at time of collection
        String waterTemperature;

        RadioButton coldRadioButton = (RadioButton) findViewById(R.id.cold_radio_button);
        boolean ifTempCold = coldRadioButton.isChecked();
        RadioButton coolRadioButton = (RadioButton) findViewById(R.id.cool_radio_button);
        boolean ifTempCool = coolRadioButton.isChecked();
        RadioButton tepidRadioButton = (RadioButton) findViewById(R.id.tepid_radio_button);
        boolean ifTempTepid = tepidRadioButton.isChecked();
        RadioButton warmRadioButton = (RadioButton) findViewById(R.id.warm_radio_button);
        boolean ifTempWarm = warmRadioButton.isChecked();
        RadioButton hotRadioButton = (RadioButton) findViewById(R.id.hot_radio_button);
        boolean ifTempHot = hotRadioButton.isChecked();
        RadioButton scaldingRadioButton = (RadioButton) findViewById(R.id.scalding_radio_button);
        boolean ifTempScalding = scaldingRadioButton.isChecked();

        if (ifTempCold)
        {waterTemperature = "Cold";}
        else if (ifTempCool)
        {waterTemperature = "Cool";}
        else if (ifTempTepid)
        {waterTemperature = "Tepid";}
        else if (ifTempWarm)
        {waterTemperature = "Warm";}
        else if (ifTempHot)
        {waterTemperature = "Hot";}
        else if (ifTempScalding)
        {waterTemperature = "Scalding";}
        else
        {waterTemperature = "";}

        // Display the results summary
        String message = createResultsSummary(dateCollection, timeCollection, tabletNumber,
                timeRunning, waterTemperature, noneDrinking, noneBrushing, noneHandwashing,
                usedForNone);

        String subject = getString(R.string.email_subject);
        String email_address = getString(R.string.email_address);

        // Use an intent to launch an email app.
        // Send the results summary in the email body.
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:"));
//        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email_address});
//        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//        intent.putExtra(Intent.EXTRA_TEXT, message);
//        startActivity(intent);

//        Toast toast = Toast.makeText(this, getString(R.string.thank_you), Toast.LENGTH_LONG);
//        toast.show();

        display(message);
    }

    /**
     * Create summary of the results.
     *
     * @param participantID            on the order
     * @return text summary
     */
    private String createResultsSummary(String dateCollection, String timeCollection,
                                        String participantID, String timeRunning, String waterTemperature, Boolean drinking,
                                        Boolean brushing, Boolean handwashing, Boolean none) {

        String summaryMessage = "\n " + getString(R.string.tablet_number) + ": " + participantID;
        summaryMessage += "\n " + getString(R.string.date_of_collection) + ": " + dateCollection;
        summaryMessage += "\n " + getString(R.string.time_of_collection) + ": " + timeCollection;
        summaryMessage += "\n " + getString(R.string.running_time_short) + ": " + timeRunning;
        summaryMessage += "\n " + getString(R.string.water_temp_short) + ": " + waterTemperature + "\n";

        summaryMessage += "\n " + getString(R.string.drinking) + ": " + drinking;
        summaryMessage += "\n " + getString(R.string.brushing_teeth) + ": " + brushing;
        summaryMessage += "\n " + getString(R.string.handwashing) + ": " + handwashing;
        summaryMessage += "\n " + getString(R.string.none) + ": " + none + "\n";

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