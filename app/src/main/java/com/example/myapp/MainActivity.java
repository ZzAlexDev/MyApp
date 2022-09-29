package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapp.adapter.CategoryAdapter;
import com.example.myapp.adapter.CourseAdapter;
import com.example.myapp.model.Category;
import com.example.myapp.model.Course;

import org.intellij.lang.annotations.JdkConstants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCoursesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,  "Игры"));
        categoryList.add(new Category( 2, "Сайты"));
        categoryList.add(new Category( 3, "Языки"));
        categoryList.add(new Category( 4, "Прочее"));

        setCategoryRecycler(categoryList);



        courseList.add(new Course(1, "java_2","Профессия Java\nразработчик", "1 января","начальный","#424345","Test text Игры", 1));
        courseList.add(new Course(2, "python_3","Профессия Python\nразработчик", "10 января","начальный","#9FA52D","Test text Сайты",2));
        courseList.add(new Course(3, "python_3","Профессия Python\nразработчик", "10 января","начальный","#9FA52D","Test text Языки",3));
        courseList.add(new Course(4, "python_3","Профессия Python\nразработчик", "10 января","начальный","#9FA52D","Test text Прочее",4));

        fullCoursesList.addAll(courseList);

        setCourseRecycler(courseList);


    }

    public void openShoppingCart(View view){
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    };

    private void setCourseRecycler(List<Course> courseList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( this, RecyclerView.HORIZONTAL, false);
        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }


    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);



    }

    public static void showCoursesByCategory(int category){

        courseList.clear();
        courseList.addAll(fullCoursesList);


        List<Course> filterCourses = new ArrayList<>();

        for(Course c : courseList){
             if(c.getCategory() == category)
                filterCourses.add(c);

        }

        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();



    }





}