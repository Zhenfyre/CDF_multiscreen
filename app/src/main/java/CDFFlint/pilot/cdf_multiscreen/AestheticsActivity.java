package CDFFlint.pilot.cdf_multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class AestheticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aesthetics);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitAestheticsResults(View view) {

        // Get appearance of water
        EditText appearanceField = (EditText) findViewById(R.id.water_appearance_description);
        Editable appearanceEditable = appearanceField.getText();
        String appearance = appearanceEditable.toString();

        // Get smell of water
        EditText smellField = (EditText) findViewById(R.id.water_smell_description);
        Editable smellEditable = smellField.getText();
        String smell = smellEditable.toString();

        // Get taste of water
        EditText tasteField = (EditText) findViewById(R.id.water_taste_description);
        Editable tasteEditable = tasteField.getText();
        String taste = tasteEditable.toString();

        // Display the results summary
        String message = createResultsSummary(appearance, smell, taste);

        String subject = getString(R.string.email_subject);
        String email_address = getString(R.string.email_address);

        display(message);
    }

    /**
     * Create summary of the results.
     * @return text summary
     */
    private String createResultsSummary(String appearance, String smell,String taste) {

        String summaryMessage = "\n " + getString(R.string.appearance_short) + ": " + appearance + "\n";
        summaryMessage += "\n " + getString(R.string.smell_short) + ": " + smell + "\n";
        summaryMessage += "\n " + getString(R.string.taste_short) + ": " + taste;

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