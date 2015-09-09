package com.arthlimchiu.expandablerecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Item> data = new ArrayList<>();

        data.add(new Header(ListAdapter.HEADER, "Fruits"));
        data.add(new Header(ListAdapter.HEADER, "Cars"));
        data.add(new Header(ListAdapter.HEADER, "Places"));
        //data.add(new Child(ListAdapter.CHILD, "Apple", "Fruits"));

        populateHeaderWithChildren(data);

        mRecyclerView.setAdapter(new ListAdapter(data));
    }

    private void populateHeaderWithChildren(List<Item> data) {

        Header fruits = (Header) data.get(0);
        List<Child> fruitChildren = fruits.getChildren();
        fruitChildren.add(new Child(ListAdapter.CHILD, "Apple", "Fruits"));
        fruitChildren.add(new Child(ListAdapter.CHILD, "Orange", "Fruits"));
        fruitChildren.add(new Child(ListAdapter.CHILD, "Banana", "Fruits"));

        Header cars = (Header) data.get(1);
        List<Child> carChildren = cars.getChildren();
        carChildren.add(new Child(ListAdapter.CHILD, "Audi", "Cars"));
        carChildren.add(new Child(ListAdapter.CHILD, "Aston Martin", "Cars"));
        carChildren.add(new Child(ListAdapter.CHILD, "BMW", "Cars"));
        carChildren.add(new Child(ListAdapter.CHILD, "Cadillac", "Cars"));

        Header places = (Header) data.get(2);
        List<Child> placeChildren = places.getChildren();
        placeChildren.add(new Child(ListAdapter.CHILD, "Cebu", "Places"));
        placeChildren.add(new Child(ListAdapter.CHILD, "Bohol", "Places"));
        placeChildren.add(new Child(ListAdapter.CHILD, "Manila", "Places"));
        placeChildren.add(new Child(ListAdapter.CHILD, "Davao", "Places"));

    }

}
