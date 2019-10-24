package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ArrayList myData = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        String[] strs = new String[]{ "abc", "123", "aaa"};
        for (String s : strs) // Goes through all entries of strs in ascending index order (foreach over array)
            myData.add(s);

        ArrayList<Integer> myimage = new ArrayList<Integer>(Arrays.asList(R.drawable.d,R.drawable.d1,R.drawable.d3,R.drawable.download,R.drawable.image));

        myData.addAll(myimage);*/

       MyData[] myData = new MyData[]{
                new MyData("Dhara", R.drawable.d),
                new MyData("Abc", R.drawable.download),
                new MyData("pqr", R.drawable.d3),
                new MyData("Xyz", R.drawable.download),
        };




        /* ArrayList<MyData> data=new ArrayList<MyData>();

         for(int i=0; i<= MyArray.nameArray.length; i++)
         {
            data.add(new MyData(MyArray.nameArray[i],MyArray.drawableArray[i]));
         }*/

        RecyclerView re = (RecyclerView) findViewById(R.id.recycle);
                CustomAdapter adapter = new CustomAdapter(myData);
                re.setLayoutManager(new LinearLayoutManager(this));
                 re.setAdapter(adapter);
        }
    }


    /*int i;
    ArrayList letter = new ArrayList<>(Arrays.asList("dhara", "pqr", "xyz", "opq", "rst"));

    ArrayList<Integer> myimage = new ArrayList<Integer>();

            *//*(Arrays.asList(R.drawable.d,R.drawable.d1,R.drawable.d3,R.drawable.download,R.drawable.image));*//*
 */

       /* RecyclerView rview = (RecyclerView) findViewById(R.id.recycle);

        LinearLayoutManager ll= new LinearLayoutManager(getApplicationContext());
        rview.setLayoutManager(ll);

        for(i=0;i<3;i++){

            myimage.add(getResources().getIdentifier("d"+i, "drawable", getApplicationContext().getPackageName()));
        }
      // myimage.add(R.drawable.d);

        CustomAdapter ca = new CustomAdapter(MainActivity.this,letter);
        rview.setAdapter(ca);
*/
