package com.savinglives;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Map;

public class GoalsActivity extends ActionBarActivity {

    EditText nameEt, heightEt, weightStartEt, weightCurEt, ageEt, weightChgPerWeekEt;
    RadioGroup radioGrp; RadioButton genderRbut;
    Button goRajCalcBut;

    //---------------- MVC Support Data Variables, Methods ---------------------------------------------------
    //STATE variables got from invoking intent or stored on activating an intent
    //TODO AboutPersonHealth curRec;
    String Op=""; //either Edit or Add
    long id=0L; //if valid should be non-zero

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goals_activity);
        initExtraParmsForTypeAndCategory();

        //TODO initOrDefaultGuiVarsBeforeData();
        //TODO initOrDefaultDataVars(); //This interprets op, id, and fetches curRec..
        //TODO initOrDefaultGuiVarsAfterData();

        /**** XXX  NOW IT IS PURELY BY op/Id basis .. Get Data in form from database
         int cAboutMe = AboutPersonHealth.count();
         if (cAboutMe > 0) {
         List<AboutPersonHealth> ameRg = AboutPersonHealth.getAll();
         // TODO BUG: Instead of 0, do the .. "PRIMARY PERSON" i.e. Me! ???
         AboutPersonHealth curRec = ameRg.get(0); //get first one only ..

         //we have a valid curRec .. use that!
         initOrDefaultGuiVarsAfterData();
         } else { //set default values in form (use from XML layout only ..
         //TODO: You need to handle .. this as error .. give feedback - modal dialog btter
         Toast.makeText(this,"ERROR: Could not inititialize data", Toast.LENGTH_SHORT).show();
         finish(); //cannot work ..
         // fAboutMeExists = false; aboutMeId = 0L; //<-- nothing to do .. defaults ..
         // curRec <-- nothing to do ..
         //x aboutMeId = AboutPersonHealth.insert(curRec);
         }
         ****/
    }
    // extraParmsStr is a string like -> "Op=PrimaryId!id=0" or Op=Add!id=0 or Op=Edit!id=32
    // This is used to extract type, category. Also build up the category picking list for end user ..
    //validate typeStr, and  while opCategoryStr is the category, but opCategoryStrRg fills a spinner to set it!
    // opCategoryStr is the category, but opCategoryStrRg fills a spinner to set it!
    public void initExtraParmsForTypeAndCategory() {
        /*
        Bundle b = getIntent().getExtras();
        String extraParmsStr = b.getString(MenuActivity.EXTRA_PARMSTR);
        Map<String,String> extraParmsMap = MenuActivity.parseExtraParms(extraParmsStr);
        for (String key : extraParmsMap.keySet()) {
            if (StringUtils.equals(key, "Op")) {
                Op = extraParmsMap.get(key);
            } else if (StringUtils.equals(key,"id")){
                String idStr = extraParmsMap.get(key);
                id = Long.parseLong(idStr);
            }
        }
        */
    }
/* TODO
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.aboutme_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initOrDefaultGuiVarsBeforeData() {
        nameEt = (EditText) findViewById(R.id.nameEt);
        heightEt = (EditText) findViewById(R.id.heightEt);
        weightStartEt = (EditText) findViewById(R.id.weightEt);
        weightCurEt = (EditText) findViewById(R.id.weightCurEt);
        weightChgPerWeekEt = (EditText) findViewById(R.id.weightChgPerWeekEt);
        ageEt = (EditText) findViewById(R.id.ageEt);
        radioGrp = (RadioGroup) findViewById(R.id.radioGrp);
        goRajCalcBut = (Button) findViewById(R.id.goRajCalcBut);
    }
    private void initOrDefaultDataVars() {
        Log.d("AboutPersonHealth", "Intent incoming op=" + Op + ", id=" + String.valueOf(id));
        switch (Op) {
        case "PrimaryId":
            //TODO: Avoid this hack .. have ONE contact as THIS IS MY CONTACT INFO.. and store that there!
            curRec = AboutPersonHealth.getForPrimaryId();
            if (curRec == null) { // treat as Add
                Op = "Add";
                curRec = new AboutPersonHealth();
            }
            break;
        case "Edit":
            if (id != 0L) {
                curRec = AboutPersonHealth.getById(id);
            } else { // treat same as an add
                Log.d("AboutPersonHealth", "ERROR: Intent incoming Edit op but id is invalid");
            }
            break;
        default:
        case "Add":
            curRec = new AboutPersonHealth();
            break;
        }
    }
    private void initOrDefaultGuiVarsAfterData() {
        if (curRec == null) {
            Toast.makeText(this, "ERROR: Could not inititialize data - curRec invalid", Toast.LENGTH_SHORT).show();
            return; //don't even try!
        }
        //Set Data in form
        nameEt.setText(curRec.getName());
        heightEt.setText(Float.toString(curRec.getHeight()));
        weightStartEt.setText(Float.toString(curRec.getWeightStart()));
        weightCurEt.setText(Float.toString(curRec.getWeightCur()));
        weightChgPerWeekEt.setText(Float.toString(curRec.getWeightChangePerWeek()));
        ageEt.setText(Float.toString(curRec.getAge()));
        int selectedId = (curRec.isMale()?(R.id.radioM):(R.id.radioF));
        radioGrp.check(selectedId);
    }
    private void readGuiVarsIntoData() {
        // get selected radio button from radioGroup
        int selectedId = radioGrp.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        RadioButton genderRbut = (RadioButton) findViewById(selectedId);
        //PKJ> This is just a toast better to compare selectedId with Radio button Ids e.g R.id.radioM or R.id.radioF
        curRec.setName(nameEt.getText().toString());
        curRec.setHeight(Float.parseFloat(heightEt.getText().toString()) );
        curRec.setWeightStart(Float.parseFloat(weightStartEt.getText().toString()));
        curRec.setWeightCur(Float.parseFloat(weightCurEt.getText().toString()));
        curRec.setWeightChangePerWeek(Float.parseFloat(weightChgPerWeekEt.getText().toString()));
        curRec.setAge(Float.parseFloat(ageEt.getText().toString()));
        curRec.setMale(selectedId==R.id.radioM);
    }
    //------- State Variables, DB load,save support functions -----------
    public void saveToDb() {
        readGuiVarsIntoData();
        if (StringUtils.equals(Op,"Edit")) { //update it
            AboutPersonHealth.update(id, curRec);
        } else if (StringUtils.equals(Op,"Add")) { //insert it ..
            id = AboutPersonHealth.insert(curRec);
            Op = "Edit";
        }
        //Toast.makeText(AboutMeActivity.this, "id="+String.valueOf(id)+"butLbl="+genderRbut.getText(), Toast.LENGTH_SHORT).show();
    }
*/
    //SUBMIT EXPLICIT BUTTON When pressed, this updates or inserts data into database ..
    public void calcMe(View v) {
        //TODO saveToDb();
        finish();
    }
    //CANCEL EXPLICIT BUTTON
    public void cancelBtn(View view) {
        finish();
    }

    //IMPLICIT RETURN FROM ACTIVITY ..
    @Override
    protected void onPause() {
        super.onPause();
        //Call Save also here - in case user DID NOT press save .. Only cancel will NOT save!
        //TODO saveToDb();
    }
}
