package com.example.lab7_1;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Integer[] Things = {R.drawable.cats, R.drawable.bakura, R.drawable.coffee, R.drawable.bones,
            R.drawable.deadpool, R.drawable.memes, R.drawable.raikou, R.drawable.normal, R.drawable.roots};

    int[] ThingsNames = {R.string.thing_cats, R.string.thing_bakura, R.string.thing_coffee,
            R.string.thing_bones, R.string.thing_deadpool, R.string.thing_memes, R.string.thing_raikou,
            R.string.thing_normal, R.string.thing_roots};

    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        GridView grid = findViewById(R.id.gvThings);
        final ImageView pic = findViewById(R.id.ivLarge);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), (position + 1) + ": " + getString(ThingsNames[position]), Toast.LENGTH_LONG).show();
                pic.setImageResource(Things[position]);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
public class ImageAdapter extends BaseAdapter {
    private Context context;
    public ImageAdapter (Context c) {
        context = c;
    }
    @Override
    public int getCount() {
        return Things.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        pic = new ImageView(context);
        pic.setImageResource(Things[position]);
        pic.setScaleType(ImageView.ScaleType.CENTER_CROP);
        pic.setLayoutParams(new GridView.LayoutParams(330,300));
        return pic;
    }
}
}