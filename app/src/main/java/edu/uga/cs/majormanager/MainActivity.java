/*
This program was programmed by:
Preston Lowry
Kochut CSCI4060
21 February 2019
 */

//Import packages and such
package edu.uga.cs.majormanager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    //Define all the objects; set each major to a certain integer
    //This makes it easier to pass majors through to the other pages
    TextView text;
    Button buttonInfo, buttonJobs;
    Intent chemJobsPage, chemInfoPage;
    private Spinner spinner;
    public static final String MESSAGE_TYPE = "edu.uga.cs.MainActivity.MESSAGE_TYPE";
    public static final int CHEMISTRY = 1;
    public static final int CSCI = 2;
    public static final int FORESTRY = 3;
    public static final int BIOLOGY = 4;
    public static final int IA = 5;
    public static final int UB = 6;
    //DEFAULTS TO CHEMISTRY ON RELOAD
    public static int MajorSelection = CHEMISTRY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DEFINE OBJECTS
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinnerOptions);
        buttonInfo = findViewById(R.id.jobs);
        buttonJobs = findViewById(R.id.info);
        text = findViewById(R.id.text);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            /*
            When you pick a selection on the spinner, it sets the pass-through integer to the major you picked
            I used to have a little popup button with the Toast object, but it was annoying and unnecessary
            I like this much better, as it lets the pages have more control if I needed the jobs and info pages
            to be significantly different.
             */
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                // Determines which major info/jobs are loaded. Defaults to
                if( ((String) parent.getItemAtPosition(pos)).equals( "Chemistry" ) )
                {
                    MajorSelection = CHEMISTRY;

                }
                else if( ((String) parent.getItemAtPosition(pos)).equals( "Computer Science" ) )
                {
                    MajorSelection = CSCI;

                }
                else if( ((String) parent.getItemAtPosition(pos)).equals( "Forestry" ) )
                {
                    MajorSelection = FORESTRY;

                }
                else if( ((String) parent.getItemAtPosition(pos)).equals( "Biology" ) )
                {
                    MajorSelection = BIOLOGY;

                }
                else if( ((String) parent.getItemAtPosition(pos)).equals( "International Affairs" ) )
                {
                    MajorSelection = IA;

                }
                //I don't think UGA has an Underwater Basketweaving major but it seemed important to add
                else if( ((String) parent.getItemAtPosition(pos)).equals( "Underwater Basketweaving" ) )
                {
                    MajorSelection = UB;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // This is here because when I removed it the program broke. It doesn't do anything otherwise.
            }
        });

    }

        /*
        These two methods control the buttons' actions, and are linked to directly in the XML file activity_main.
        Linked directly so as to prevent issues with overlapping Button Listeners (which took a while to untangle, and
        did not respond nearly as fast >_> )
        */
        public void onClickJobs(View view) {
            Intent intent = new Intent(view.getContext(), ChemistryJobs.class);
            intent.putExtra(MESSAGE_TYPE, MajorSelection);
            view.getContext().startActivity(intent);
        }
        public void onClickInfo(View view) {
            Intent intent = new Intent(view.getContext(), ChemistryInfo.class);
            intent.putExtra(MESSAGE_TYPE, MajorSelection);
            view.getContext().startActivity(intent);
        }
}

