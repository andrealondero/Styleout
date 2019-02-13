package com.example.mytutorial;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class SecondActivity extends AppCompatActivity {

        private TextView mTextView; /* riferito al viewpager dei model */
        private Context context;

    // spinner dei colori con immagini e text colore con dropdown menu
    public static final String[] titles = new String[] {"Apricot", "AshGray", "Azure", "Beige", "Black", "Blue", "BlueGray", "BlueJeans",
            "BottleGreen", "Celeste", "Coral", "DarkGreen", "Gold", "Gray", "Green",
            "GreenBlue", "Lavender", "LightBlue", "Magenta", "MidnightBlue", "MintGreen",
            "NavyBlue", "OceanBlue", "OceanGreen", "Olive", "Orange", "Pink", "Red", "Rose",
            "Sand", "Scarlet", "Silver", "Tangerine", "Turquoise", "Violet", "White", "Yellow"};

    public static final Integer[] images = {
            R.drawable.apricot, R.drawable.ashgray, R.drawable.azure, R.drawable.beige,
            R.drawable.black, R.drawable.blue, R.drawable.bluegray, R.drawable.bluejeans,
            R.drawable.bottlegreen, R.drawable.celeste, R.drawable.coral, R.drawable.darkgreen,
            R.drawable.gold, R.drawable.gray, R.drawable.green, R.drawable.greenblue,
            R.drawable.lavender, R.drawable.lightblue, R.drawable.magenta, R.drawable.midnightblue,
            R.drawable.mintgreen, R.drawable.navyblue, R.drawable.oceanblue, R.drawable.oceangreen,
            R.drawable.olive, R.drawable.orange, R.drawable.pink, R.drawable.red,
            R.drawable.rose, R.drawable.sand, R.drawable.scarlet, R.drawable.silver,
            R.drawable.tangerine, R.drawable.turquoise, R.drawable.violet, R.drawable.white,
            R.drawable.yellow};

    Spinner spinner; /* spinner per selezione colore */
    List<RowItem> rowItems;  /* riferito a spinner per selezione colori */
    Spinner fabricSelect; /* spinner per selezione fabric */

    //spinner selezione colori
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {

            RowItem item = new RowItem( titles[i], images[i] );
            rowItems.add( item );
        }

        spinner = (Spinner)findViewById(R.id.colourSpinner);
        ColourSelectorAdapter adapter = new ColourSelectorAdapter(SecondActivity.this,
                R.layout.colourselectorlist, R.id.title, rowItems);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String itemvalue = parent.getItemAtPosition(position).toString();

                Toast.makeText(SecondActivity.this, "Selected" + itemvalue, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        } );

            // spinner materiali/fabrics con solo txt e toast on selected
            fabricSelect = (Spinner) findViewById(R.id.fabricSpinner);

            List<String> list = new ArrayList<>();
            // lightweight fabrics
            list.add("Cotton"); list.add("Silk");
            // mesh fabrics
            list.add("Cape"); list.add("Lace"); list.add("Tarlatan");
            // medium weight fabrics
            list.add("Cashmere"); list.add("Crepe");list.add("Flannel"); list.add("Poplin"); list.add("RawSilk"); list.add("Sateen");
            // piled fabrics
            list.add("BrushDenim");list.add("Fur"); list.add("Microfiber"); list.add("Suede"); list.add("Velvet");
            // heavy weight fabrics
            list.add("Canvas"); list.add("Denim"); list.add("Tartan"); list.add("Upholstery");
            // Shiny glossy fabrics
            list.add("Satin"); list.add("Silk"); list.add("PolishedCotton");

            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            fabricSelect.setAdapter(adapter1);

            fabricSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    String itemvalue = parent.getItemAtPosition(position).toString();

                    Toast.makeText(SecondActivity.this, "Selected" + itemvalue, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

        // slider di immaginni per selezione model
            ViewPager viewPager;

            mTextView = (TextView) findViewById(R.id.text);

            viewPager = (ViewPager) findViewById(R.id.modelSelector);

            ImageAdapter imageAdapter = new ImageAdapter(this);
            viewPager.setAdapter(imageAdapter);


        }

    }
