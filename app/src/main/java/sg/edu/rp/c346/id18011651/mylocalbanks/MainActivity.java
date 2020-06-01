package sg.edu.rp.c346.id18011651.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.dbsView);
        tvOCBC = findViewById(R.id.ocbcView);
        tvUOB = findViewById(R.id.uobView);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId()==R.id.dbsView){
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Contact the bank");
        }
        if(v.getId()==R.id.uobView){
            menu.add(0,2,0,"Website");
            menu.add(0,3,1,"Contact the bank");
        }
        if(v.getId()==R.id.ocbcView){
            menu.add(0,4,0,"Website");
            menu.add(0,5,1,"Contact the bank");
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            //code for action
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.dbslink)));
            startActivity(intent);


            return true; //menu item successfully handled
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +R.string.dbsnumber));
            startActivity(intentCall);

            return true;  //menu item successfully handled
        }
        else if(item.getItemId()==2) { //check if the selected menu item ID is 2
            //code for action
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.uoblink)));
            startActivity(intent);

            return true;  //menu item successfully handled
        }
        else if(item.getItemId()==3) { //check if the selected menu item ID is 3
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +R.string.uobnumber));
            startActivity(intentCall);

            return true;  //menu item successfully handled
        }
        else if(item.getItemId()==4) { //check if the selected menu item ID is 3
            //code for action
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.ocbclink)));
            startActivity(intent);
            return true;  //menu item successfully handled
        }
        else if(item.getItemId()==5) { //check if the selected menu item ID is 3
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +R.string.ocbcnumber));
            startActivity(intentCall);

            return true;  //menu item successfully handled
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(R.string.dbsbank);
            tvUOB.setText(R.string.uobbank);
            tvOCBC.setText(R.string.ocbcbank);
            return true;
        } else if (id == R.id.italianSelection) {
            tvDBS.setText(R.string.chidbs);
            tvOCBC.setText(R.string.chiOCBC);
            tvUOB.setText(R.string.chiuob);
            return true;
        } else {
            tvDBS.setText(R.string.error);
        }

        return super.onOptionsItemSelected(item);
    }



}
