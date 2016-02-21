package com.savinglives;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    /* ALL IMAGES drawable-hdpi folder path with image name.
    Integer[] DisplayImagesList = {
            R.drawable.artichokedanish, R.drawable.bostock, R.drawable.briochebomb, R.drawable.californiacroissant, R.drawable.chocolatecroissant, R.drawable.cookie,
            R.drawable.cranberrypecandanish, R.drawable.croissant, R.drawable.cruffin, R.drawable.kouignamann, R.drawable.ledonut,
            R.drawable.peardanish, R.drawable.pumpkinappledanish, R.drawable.reubendanish, R.drawable.stollen, R.drawable.sweetoniondanish, R.drawable.ubepuff};
    */
    ListView lv;
    String cattitle;
    ArrayList<FoodDish> dsn = null;
    MiniCart mc = null;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.one_tap_order_activity);

         lv = (ListView) findViewById(R.id.categorylv);
         Bundle extras = getIntent().getExtras();
         if (extras != null) {
             cattitle = extras.getString("cattitle");
         }
         dataInit();
         // Setting up Image adapter on gridview.
         lv.setAdapter(new CategoryRowAdapter(this));
         lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Toast.makeText(CategoryActivity.this, "Shelf item was clicked at " + position, Toast.LENGTH_SHORT).show();
             }
         });

     }

    public void dataInit() {
        // Fetch Category data - hardwired for now!
        ArrayList<FoodDish> ds = new ArrayList<>();
        ds.add(new FoodDish("1","Savory Brioche Bomb",4,"Thai pumpkin curry","BriocheBomb.png",  R.drawable.briochebomb));
        ds.add(new FoodDish("2","Cruffin",4.5,"Flavor varies daily","Cruffin.png",  R.drawable.cruffin));
        ds.add(new FoodDish("3","Pear Danish",4,"Pt. Reyes Blue Cheese","PearDanish.png",  R.drawable.peardanish));
        ds.add(new FoodDish("4","Ube Puff",4.5,"Prickly pear icing","UbePuff.png",  R.drawable.ubepuff));
        ds.add(new FoodDish("5","Cranberry Pecan Danish",4,"Pastry cream","CranberryPecanDanish.png",  R.drawable.cranberrypecandanish));
        ds.add(new FoodDish("6","Croissant",3.5,"No filling","Croissant.png",  R.drawable.croissant));
        ds.add(new FoodDish("7","Artichoke Danish",4.5,"Flavors: feta, bechamel","ArtichokeDanish.png", R.drawable.artichokedanish));
        ds.add(new FoodDish("8","California Croissant",5,"Flavors: Smoked salmon, Ginger, Wasabi, Nori","CaliforniaCroissant.png", R.drawable.californiacroissant));
        ds.add(new FoodDish("9","Reuben Danish",4.5,"Flavors: Pastrami, Sauerkraut, Thousand island","ReubenDanish.png", R.drawable.reubendanish));
        ds.add(new FoodDish("10","Le Donut Small",1,"Chef's Choice","LeDonut.png", R.drawable.ledonut));
        ds.add(new FoodDish("11","Chocolate Croissant",4,"No filling","ChocolateCroissant.png", R.drawable.chocolatecroissant));
        ds.add(new FoodDish("12","Stollen",3.5,"Flavors: Dried fruit, Chocolate","Stollen.png", R.drawable.stollen));
        ds.add(new FoodDish("13","Sweet Onion Danish",4.5,"Flavors: Nigella seed, Béchamel","SweetOnionDanish.png", R.drawable.sweetoniondanish));
        ds.add(new FoodDish("14","Cookie",3,"Flavors: Chocolate, Sea salt","Cookie.png", R.drawable.cookie));
        ds.add(new FoodDish("15","Pumpkin Apple Danish",4,"Spiced pumpkin cream","PumpkinAppleDanish.png", R.drawable.pumpkinappledanish));
        ds.add(new FoodDish("16","Kouign Amann",3.5,"Flavors: Pistachio, Rose","KouignAmann.png", R.drawable.kouignamann));
        ds.add(new FoodDish("17","Bostock",4.5,"Maple oat clusters","Bostock.png", R.drawable.bostock));
        ds.add(new FoodDish("18","Le Donut Big",3.5,"Flavor varies daily","LeDonut.png", R.drawable.ledonut));
        dsn = ds;
        // Initialize MiniCart, Checkout
        mc = new MiniCart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(CategoryActivity.this, "Settings TODO", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_checkout) {
            Toast.makeText(CategoryActivity.this, "Checkout TODO", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private class CategoryRowAdapter extends BaseAdapter {
        Context context;
        public class ViewHolder {
            ImageView img;
            TextView title;
            TextView description;
            Button incrbut;
            TextView q;
            Button decrbut;
        };
        ViewHolder vh = null;

        public CategoryRowAdapter(Context context ) {
            this.context = context;
        }

         @Override
         public int getCount()
         {
             return dsn.size();
         }

         @Override
         public Object getItem(int position)
         {
             return dsn.get(position);
         }

         @Override
         public long getItemId(int position)
         {
             return position;
         }

         @Override
         public View getView(final int position, View convertView, ViewGroup parent) {
             if (convertView == null) {
                 LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                 convertView = inflater.inflate(R.layout.category_row, null, true);
                 ViewHolder mvh = new ViewHolder();
                 mvh.title = (TextView) convertView.findViewById(R.id.title);
                 mvh.description = (TextView) convertView.findViewById(R.id.description1);
                 mvh.img = (ImageView) convertView.findViewById(R.id.productImg);
                 mvh.incrbut = (Button) convertView.findViewById(R.id.incrbutton);
                 mvh.q = (TextView) convertView.findViewById(R.id.quantitytv );
                 mvh.decrbut = (Button) convertView.findViewById(R.id.decrbutton);

                 mvh.incrbut.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         //Toast.makeText(context, "IncrButton clicked for pos="+ position, Toast.LENGTH_SHORT).show();
                         FoodDish f = dsn.get(position);
                         int newq = mc.incrItem(new CartItem(f.getProductId(), f.getPrice(),
                                 f.getDescription(), f.getImgrint()));
                         ViewGroup vg = (ViewGroup) v.getParent();
                         TextView q = (TextView)   vg.findViewById(R.id.quantitytv);
                         q.setText( String.valueOf(newq));
                     }
                 });
                 mvh.decrbut.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         //Toast.makeText(context, "Decr Button clicked for pos="+ position, Toast.LENGTH_SHORT).show();
                         FoodDish f = dsn.get(position);
                         int newq = mc.decrItem(new CartItem(f.getProductId(), f.getPrice(),
                                 f.getDescription(), f.getImgrint()));
                         ViewGroup vg = (ViewGroup) v.getParent();
                         TextView q = (TextView)   vg.findViewById(R.id.quantitytv);
                         q.setText( String.valueOf(newq));
                     }
                 });
                 convertView.setTag(mvh);
             }
             vh = (ViewHolder) convertView.getTag();
             FoodDish d = dsn.get(position);

             vh.title.setText(d.getName());
             vh.description.setText(d.getDescription());
             vh.img.setImageResource(d.getImgrint());
             //CAN SIZE IT TOO> imageView.setLayoutParams(new GridView.LayoutParams(200, 150));

             return convertView;
         }
     }

    }