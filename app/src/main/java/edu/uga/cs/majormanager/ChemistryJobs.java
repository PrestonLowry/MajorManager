/*
This program was programmed by:
Preston Lowry
Kochut CSCI4060
21 February 2019
*/
//Import packages and such
package edu.uga.cs.majormanager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class ChemistryJobs extends Activity {
    TextView title;
    ImageView picture;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        title = findViewById(R.id.blankJobs);
        picture = findViewById(R.id.Picture);
        description = findViewById(R.id.description);
        Intent intent = getIntent();
        int majorType = intent.getIntExtra(MainActivity.MESSAGE_TYPE, MainActivity.MajorSelection);
        /*
        This next bit is the crux of both the info and jobs pages. It works by determining which
        integer was passed through by the spinner to the page it's on, and changing the title, picture, and
        description all at once. It loads the photo and description from raw resources.
        There is no formatting issue despite being six totally separate sized
        text areas, as the XML modifications for the text box make the text auto-wrap without issue.
         */
        if(majorType == MainActivity.CHEMISTRY)
        {
            title.setText("Chemistry Jobs");
            Resources res = getResources();
            InputStream pictureStream = res.openRawResource(R.raw.chem);
            picture.setImageBitmap(BitmapFactory.decodeStream(pictureStream));
            try{
                InputStream inputDesc = res.openRawResource(R.raw.chemjobs);
                byte[] byteArray = new byte[inputDesc.available()];
                inputDesc.read(byteArray);
                description.setText(new String(byteArray));
            }
            catch (Exception e)
            {
                description.setText("ERROR: TEXT MACHINE MESSED UP");
            }
        }
        else if(majorType == MainActivity.CSCI)
        {
            title.setText("Computer Science Jobs");
            Resources res = getResources();
            InputStream pictureStream = res.openRawResource(R.raw.csci);
            picture.setImageBitmap(BitmapFactory.decodeStream(pictureStream));
            try{
                InputStream inputDesc = res.openRawResource(R.raw.cscijobs);
                byte[] byteArray = new byte[inputDesc.available()];
                inputDesc.read(byteArray);
                description.setText(new String(byteArray));
            }
            catch (Exception e)
            {
                description.setText("ERROR: TEXT MACHINE MESSED UP");
            }
        }
        else if(majorType == MainActivity.FORESTRY)
        {
            title.setText("Forestry Jobs");
            Resources res = getResources();
            InputStream pictureStream = res.openRawResource(R.raw.forestry);
            picture.setImageBitmap(BitmapFactory.decodeStream(pictureStream));
            try{
                InputStream inputDesc = res.openRawResource(R.raw.forestryjobs);
                byte[] byteArray = new byte[inputDesc.available()];
                inputDesc.read(byteArray);
                description.setText(new String(byteArray));
            }
            catch (Exception e)
            {
                description.setText("ERROR: TEXT MACHINE MESSED UP");
            }
        }
        else if(majorType == MainActivity.BIOLOGY)
        {
            title.setText("Biology Jobs");
            Resources res = getResources();
            InputStream pictureStream = res.openRawResource(R.raw.biology);
            picture.setImageBitmap(BitmapFactory.decodeStream(pictureStream));
            try{
                InputStream inputDesc = res.openRawResource(R.raw.biojobs);
                byte[] byteArray = new byte[inputDesc.available()];
                inputDesc.read(byteArray);
                description.setText(new String(byteArray));
            }
            catch (Exception e)
            {
                description.setText("ERROR: TEXT MACHINE MESSED UP");
            }
        }
        else if(majorType == MainActivity.IA)
        {
            title.setText("International Affairs Jobs");
            Resources res = getResources();
            InputStream pictureStream = res.openRawResource(R.raw.ia);
            picture.setImageBitmap(BitmapFactory.decodeStream(pictureStream));
            try{
                InputStream inputDesc = res.openRawResource(R.raw.iajobs);
                byte[] byteArray = new byte[inputDesc.available()];
                inputDesc.read(byteArray);
                description.setText(new String(byteArray));
            }
            catch (Exception e)
            {
                description.setText("ERROR: TEXT MACHINE MESSED UP");
            }
        }
        else if(majorType == MainActivity.UB)
        {
            title.setText("Underwater Basketweaving Jobs");
            Resources res = getResources();
            InputStream pictureStream = res.openRawResource(R.raw.ubw);
            picture.setImageBitmap(BitmapFactory.decodeStream(pictureStream));
            try{
                InputStream inputDesc = res.openRawResource(R.raw.ubwjobs);
                byte[] byteArray = new byte[inputDesc.available()];
                inputDesc.read(byteArray);
                description.setText(new String(byteArray));
            }
            catch (Exception e)
            {
                description.setText("ERROR: TEXT MACHINE MESSED UP");
            }
        }
    }
    //This method controls the back button. It's identical for both info and jobs pages.
    public void onClickReturn(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        view.getContext().startActivity(intent);
    }
}
