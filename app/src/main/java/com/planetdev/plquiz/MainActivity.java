package com.planetdev.plquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar mToolbar;
    DrawerLayout mNavDrawer;
    ActionBarDrawerToggle mToggleNav;
    NavigationView navigationView;
    FragmentTransaction useThisFragment;

    public static MainActivity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        self = this;
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mNavDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggleNav = new ActionBarDrawerToggle(
                this, mNavDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mNavDrawer.setDrawerListener(mToggleNav);
        mToggleNav.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        useThisFragment = getSupportFragmentManager().beginTransaction();
        useThisFragment.replace(R.id.main_content, new StartQuiz());
        useThisFragment.commit();
        getSupportActionBar().setTitle("PL Quiz");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.html) {
            useThisFragment = getSupportFragmentManager().beginTransaction();
            useThisFragment.replace(R.id.main_content, new HtmlFragment());
            useThisFragment.commit();
            getSupportActionBar().setTitle("HTML 5");
            item.setChecked(true);

        } else if (id == R.id.css) {

            useThisFragment = getSupportFragmentManager().beginTransaction();
            useThisFragment.replace(R.id.main_content, new CssFragment());
            useThisFragment.commit();
            getSupportActionBar().setTitle("CSS 3");
            item.setChecked(true);

        } else if (id == R.id.js) {
            useThisFragment = getSupportFragmentManager().beginTransaction();
            useThisFragment.replace(R.id.main_content, new JsFragment());
            useThisFragment.commit();
            getSupportActionBar().setTitle("JavaScript");
            item.setChecked(true);

        } else if (id == R.id.java) {
            useThisFragment = getSupportFragmentManager().beginTransaction();
            useThisFragment.replace(R.id.main_content, new JavaFragment());
            useThisFragment.commit();
            getSupportActionBar().setTitle("Java");
            item.setChecked(true);

        } else if (id == R.id.share_question) {
                String[] TO = {"dev.elmonest@gmail.com"};
                String[] CC = {""};
                Intent intent = new Intent(Intent.ACTION_SENDTO);

                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, TO);
                intent.putExtra(Intent.EXTRA_CC, CC);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Pl Quiz Question Share");
                intent.putExtra(Intent.EXTRA_TEXT, "Hey Folks" +
                        "\nI hope you find the app interesting" +
                        "\nYou can attach document file of your questions on the following languages or more:" +
                        "\nHtml 5" +
                        "\nCss 3" +
                        "\nJavaScript" +
                        "\nJava" +
                        "\nPython" +
                        "\n" +
                        "\nQuestion Format:" +
                        "\nAny number of questions is accepted, each question with 3 multi choice option, and the correct answer can be styled probably in bold, italic, or coloured" +
                        "\nBe a part of this Ben Cares and loves you." +
                        "\n" +
                        "\nFor more enquiries, questions and comments feel free to type it here" +
                        "\n" +
                        "\nEnquiries...:" +
                        "\n" +
                        "\nYou can as well contact me on +2348168678931" +
                        "\nI love you, have fun Cheers!");
            if(intent.resolveActivity(getPackageManager())!=null){
                startActivity(intent);
            }

        } else if (id == R.id.admin_login) {
            Toast.makeText(MainActivity.this, "The Admin login is currently in development Process", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
